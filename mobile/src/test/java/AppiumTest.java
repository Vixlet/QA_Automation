import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import io.appium.java_client.AppiumDriver;

public class AppiumTest {

    static {
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    @Rule
    public TestRule printTests = new TestWatcher() {
        protected void starting(Description description) {
            System.out.print("  test: " + description.getMethodName());
        }

        protected void finished(Description description) {
            System.out.println();
        }
    };

    @Rule
    public TestName name = new TestName();
    
    private String sessionId, conf, group; //env, 
    protected AppiumDriver driver;
    public Platform platform;
    

    /**
     * Keep the same date prefix to identify job sets.
     **/
    private static Date date = new Date();

    /**
     * Run before each test
     **/
    @Before
    public void setUp() throws Exception {
        String p = System.getProperty("platform"), pf;
        conf = System.getProperty("configFile");
//        env = System.getProperty("env");
//        group = System.getProperty("group");
        System.out.println("  Platform: '" + p + "',   Configuration File: '" + conf + "' - Config file overwrites platform value if both present"); //"',   environment: '" + env + 
        if (null != conf) {
        	JSONObject obj = null;
        	try {
        		String config = new String(Files.readAllBytes(Paths.get("./config/" + conf)), StandardCharsets.UTF_8);
        		obj = (JSONObject) new JSONParser().parse( config );
        	} catch (ParseException | IOException  e) {  //
        		System.out.println("json config file can not be opened or parsed: ./config/" + conf);
        		e.printStackTrace();
        	}
        	pf = (String) obj.get("platformName");
        	System.out.println("getDriver( '" + pf + "', '" + (String) obj.get("deviceName") + "', '" + (String) obj.get("platformVersion") + "', '" + (String) obj.get("app") + "')" );
        	setPlatform(pf);
        	driver = new DriverProvider().getDriver(pf, (String) obj.get("deviceName"), (String) obj.get("platformVersion"), (String) obj.get("app") );
        } else if (p != null) {
        	setPlatform(p);
        	driver = getDriver(platform);
        } else {
            throw new IllegalStateException("Please provide either platform or configuration File.  e.g -Dplatform=ios or -D -DconfigFile=iOS_default.json");
        }
        
        sessionId = driver.getSessionId().toString();

        maybeCloseGooglePlayServicesUpgradeModal();
        maybeCloseIOSNotificationsModal();
    }
    
    private void setPlatform(String pform) {
    	if (pform.toLowerCase().contentEquals("ios")) {
    		platform = Platform.IOS;
    	} else if (pform.toLowerCase().contentEquals("android")) {
    		platform = Platform.ANDROID;
    	} else {
            throw new IllegalStateException("Could not determine testing platform.  Please set it as -Dplatform=ios");
        }
    }
    
    private AppiumDriver getDriver(Platform platform) throws Exception {
        switch (platform) {
            case ANDROID:
                return new DriverProvider().getDriver("Android", "Galaxy_5s", "6.0.1", "/Applications/Vixlet/Android/ATP/parent-app-template-atp-debug.apk"); 
            case IOS:
            	return new DriverProvider().getDriver("iOS", "iPhone 6", "10.3", "/Applications/Vixlet/iOS/ATP/ATPDEV.app"); //iPhone 6 Plus
            default:
                return null;
        }
    }
    
    private void maybeCloseGooglePlayServicesUpgradeModal() {
        if (driver.findElements(By.id("alertTitle")).size() > 0) {
            driver.findElement(By.id("button1")).click();
        }
    }

    private void maybeCloseIOSNotificationsModal() {
        if (driver.findElements(By.id("OK")).size() > 0) {
            driver.findElement(By.id("OK")).click();
        }
    }
    
    @Rule
    public OnlyFailedTestTakeScreenShotRule screenshotRule = new OnlyFailedTestTakeScreenShotRule();
    
    public class OnlyFailedTestTakeScreenShotRule implements MethodRule {
        @Override
        public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        statement.evaluate();
                    } catch (Throwable t) {
                    	takeScreenshot(date.toString().replaceAll(" ", "_"));
                        throw t;
                    }finally{
                    	Thread.sleep(1000);
                        tearDown();
                    }
                }
     
                public void takeScreenshot(String identifier) throws Exception {
                    try {
                        System.out.println("\tTaking screenshot for failed test case");
                      WebDriver driver1 = new Augmenter().augment(driver);
                      File file = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
                      FileUtils.copyFile(file,
                    		  new File(String.format("screenshots/%s_%s_%s.png", platform.name(), name.getMethodName(), identifier)));
                    } catch (IOException e) {
                        System.out.println("Error when taking screenshot.");
                    }
                }
                
                /**
                 * Run after each test
                 **/
                public void tearDown() throws Exception {
              	  if (driver != null) {
//              		  driver.closeApp();
              		  driver.quit();
              	  }
                }
            };
        }
    }
    
}