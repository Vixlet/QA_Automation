import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.AppiumDriver;

/**
 * Created by Jing Zhao on 4/20/17.
 */
public class VixletWelcomePage extends Vixlet<VixletWelcomePage> {

    private static final By ENV_SPINNER_BY = By.id("com.vixlet.atp.debug:id/change_environment_spinner");
    private static final String base = "//android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.TextView[";
    private static final By ENV_STAGING_BY = By.xpath(base + "1]");
    private static final By ENV_PASSIVE_PROD_BY = By.xpath(base + "2]");
    private static final By ENV_PROD_BY = By.xpath(base + "3]");
    private static final By LOGO_IMAGE_BY = By.id("com.vixlet.atp.debug:id/logo_image_view");
    private static final By ITEM_IMAGE_BY = By.id("com.vixlet.atp.debug:id/item_image");
    private static final By ANNOTATION_BY = By.id("com.vixlet.atp.debug:id/copy_text");
    private static final By INDICATOR_CONTAINER_BY = By.id("com.vixlet.atp.debug:id/indicator_container");
    private static final By GET_STARTED_ID_BY = By.id("com.vixlet.atp.debug:id/sign_up_button");
    private static final By SIGN_IN_ID_BY = By.id("com.vixlet.atp.debug:id/login_button");
    private static final By SETUP_TITLE_BY = By.id("Setup");
    private static final By DONE_BY = By.id("Done");
    private static final By SERVERS_BY = By.id("Servers");
    private static final By ENV_PROD_ID_BY = By.id("Production");
    private static final By ENV_PROD_URI_BY = By.id("https://api.vixlet.com");
    private static final By ENV_STAGING_ID_BY = By.id("Staging");
    private static final By ENV_STAGING_URI_BY = By.id("https://api-s.vixletinternal.com");
    private static final By LOGO_IMAGE_NAME_BY = By.id("SplashLogo");
    private static final String xp = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[";
    private static final String xp2 = xp + "1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[";
    private static final By ITEM_IMAGE_NAME_BY = By.xpath(xp2 + "1]"); //By.id("splashPostIcon");
    private static final By ANNOTATION_XPATH_BY = By.xpath(xp2 + "2]");
    private static final By INDICATOR_CONTAINER_XPATH_BY = By.xpath(xp + "2]/XCUIElementTypePageIndicator[1]");
    private static final By GET_STARTED_BY = By.id("Get Started");
//    private static final By SIGN_IN_BY = By.id("Log in"); 

    
    public VixletWelcomePage(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.ANDROID, "ENV_SPINNER_BY", ENV_SPINNER_BY);
        setIdentifier(Platform.ANDROID, "ENV_STAGING_BY", ENV_STAGING_BY);
        setIdentifier(Platform.ANDROID, "ENV_PASSIVE_PROD_BY", ENV_PASSIVE_PROD_BY);
        setIdentifier(Platform.ANDROID, "ENV_PROD_BY", ENV_PROD_BY);
        setIdentifier(Platform.ANDROID, "LOGO_IMAGE_BY", LOGO_IMAGE_BY);
        setIdentifier(Platform.ANDROID, "ITEM_IMAGE_BY", ITEM_IMAGE_BY);
        setIdentifier(Platform.ANDROID, "ANNOTATION_BY", ANNOTATION_BY);
        setIdentifier(Platform.ANDROID, "INDICATOR_CONTAINER_BY", INDICATOR_CONTAINER_BY);
        setIdentifier(Platform.ANDROID, "GET_STARTED_BY", GET_STARTED_ID_BY);
        setIdentifier(Platform.ANDROID, "SIGN_IN_BY", SIGN_IN_ID_BY);
        setIdentifier(Platform.IOS, "SETUP_TITLE_BY", SETUP_TITLE_BY);
        setIdentifier(Platform.IOS, "DONE_BY", DONE_BY);
        setIdentifier(Platform.IOS, "SERVERS_BY", SERVERS_BY);
        setIdentifier(Platform.IOS, "ENV_PROD_BY", ENV_PROD_ID_BY);
        setIdentifier(Platform.IOS, "ENV_PROD_URI_BY", ENV_PROD_URI_BY);
        setIdentifier(Platform.IOS, "ENV_STAGING_BY", ENV_STAGING_ID_BY);
        setIdentifier(Platform.IOS, "ENV_STAGING_URI_BY", ENV_STAGING_URI_BY);
        setIdentifier(Platform.IOS, "LOGO_IMAGE_BY", LOGO_IMAGE_NAME_BY);
        setIdentifier(Platform.IOS, "ITEM_IMAGE_BY", ITEM_IMAGE_NAME_BY);
        setIdentifier(Platform.IOS, "ANNOTATION_BY", ANNOTATION_XPATH_BY);
        setIdentifier(Platform.IOS, "INDICATOR_CONTAINER_BY", INDICATOR_CONTAINER_XPATH_BY);
        setIdentifier(Platform.IOS, "GET_STARTED_BY", GET_STARTED_BY);
        println("Coming into Vixlet Welcome Page.");
    }

    public VixletWelcomePage waitUntilLoaded() {
        println("Waiting for expected elements to be loaded");
    	pause(6);
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("iOS") ) {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SETUP_TITLE_BY")));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SERVERS_BY")));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_PROD_BY")));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_PROD_URI_BY")));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_STAGING_URI_BY")));
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_STAGING_BY"))).click();
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DONE_BY"))).click();
        } else {
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_SPINNER_BY"))).click();
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_PROD_BY")));
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_PASSIVE_PROD_BY")));
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENV_STAGING_BY"))).click();
        }
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("LOGO_IMAGE_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ITEM_IMAGE_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ANNOTATION_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("INDICATOR_CONTAINER_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("GET_STARTED_BY")));
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGN_IN_BY")));
        }
        return this;
    }
    
    SignUpEmailPage getStarted() {
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("GET_STARTED_BY"))).click();
        return new SignUpEmailPage(driver, platform).waitUntilLoaded();
    }
    
}
