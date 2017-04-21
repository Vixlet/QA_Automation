import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jing Zhao on 4/20/17.
 */
public class VixletWelcomePage extends Vixlet<VixletWelcomePage> {

    private static final By GET_STARTED_ID_BY = By.id("com.vixlet.atp.debug:id/sign_up_button");
    private static final By SIGN_IN_ID_BY = By.id("com.vixlet.atp.debug:id/login_button");
    private static final By GET_STARTED_BY = By.id("Get started");
    private static final By SIGN_IN_BY = By.id("Log in"); //By.id("Log in");

    
    public VixletWelcomePage(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.ANDROID, "GET_STARTED_BY", GET_STARTED_ID_BY);
        setIdentifier(Platform.ANDROID, "SIGN_IN_BY", SIGN_IN_ID_BY);
        setIdentifier(Platform.IOS, "GET_STARTED_BY", GET_STARTED_BY);
        setIdentifier(Platform.IOS, "SIGN_IN_BY", SIGN_IN_BY);
        super.println("Coming into HartWelcomePage.");
    }

    public VixletWelcomePage waitUntilLoaded() {
        super.println("Waiting for expected elements to be loaded");
//        dismissAndroidPopUp(1, getIdentifier("DISMISS_BY"), getIdentifier("DISMISS_BY"), "found Warning of 401 – \"Unauthorized\"}, dismissing");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGN_IN_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("GET_STARTED_BY")));
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("iOS") ) {
        	pause(6);
        }
        return this;
    }
    
}
