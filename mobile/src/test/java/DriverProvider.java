
import java.net.URL;

import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverProvider {

    protected AppiumDriver driver;

    public  AppiumDriver getDriver() throws Exception { return null; };
    
    protected AppiumDriver getDriver(String platform, String devicceName, String pVersion, String appAbsPath) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("appium-version", "1.4.8");
//        capabilities.setCapability("appActivity", "com.vixlet.atp.debug.com.vixlet.parent.activity.EntryActivity");
        capabilities.setCapability("platformName", platform);
        capabilities.setCapability("deviceName", devicceName);
        capabilities.setCapability("platformVersion", pVersion);
//        capabilities.setCapability("noSign", true);
//        capabilities.setCapability("noReset", true);
//        capabilities.setCapability("automationName", "XCUITest"); http://stackoverflow.com/questions/41243661/does-appium-1-6-works-with-xcode-8-2

        capabilities.setCapability("app", appAbsPath);
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        if ( platform.toLowerCase().contentEquals("android") ) {
            driver = new AndroidDriver(serverAddress, capabilities);
        } else if ( platform.toLowerCase().contentEquals("ios") ) {
        	driver = new IOSDriver(serverAddress, capabilities);
        }
        return driver;
    }
    
    public AppiumDriver getDriver(JSONObject conf) throws Exception {
    	return getDriver((String) conf.get("platformName"), (String) conf.get("deviceName"), (String) conf.get("platformVersion"), (String) conf.get("app") );
    }
    
}