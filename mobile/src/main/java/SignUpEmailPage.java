import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jing Zhao on 4/21/17.
 */
public class SignUpEmailPage extends Vixlet<SignUpEmailPage> {

    private static final By NONE_OF_ABOVE_BY = By.id("com.google.android.gms:id/cancel");
    private static final By BACK_BY = By.id("com.vixlet.atp.debug:id/up_arrow");
    private static final By ENTER_EMAIL_PROMPT_BY = By.id("com.vixlet.atp.debug:id/email_title");
    private static final By USER_NAME_FILED_BY = By.id("com.vixlet.atp.debug:id/username_edit");
    private static final By NEXT_BTN_BY = By.id("com.vixlet.atp.debug:id/email_next_button");
    private static final By ARROW_NEXT_BY = By.id("com.vixlet.atp.debug:id/right_arrow");

    
    public SignUpEmailPage(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.ANDROID, "DISMISS_HELPER_BY", NONE_OF_ABOVE_BY);
        setIdentifier(Platform.ANDROID, "BACK_BY", BACK_BY);
        setIdentifier(Platform.ANDROID, "ENTER_EMAIL_PROMPT_BY", ENTER_EMAIL_PROMPT_BY);
        setIdentifier(Platform.ANDROID, "USER_NAME_FILED_BY", USER_NAME_FILED_BY);
        setIdentifier(Platform.ANDROID, "NEXT_BTN_BY", NEXT_BTN_BY);
        setIdentifier(Platform.ANDROID, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        setIdentifier(Platform.IOS, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        println("Coming into SignUpEmailPage.");
    }

    public SignUpEmailPage waitUntilLoaded() {
        println("Waiting for expected elements to be loaded");
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
        	println("Dismiss account helper by Google Smart Lock");
        	for(int i=0 ; i<2; i++) {
        		if (driver.findElements(getIdentifier("DISMISS_HELPER_BY")).size() > 0)  {
        	        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DISMISS_HELPER_BY"))).click();
        		}
        		pause(2);	
        	}
        }
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("BACK_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ENTER_EMAIL_PROMPT_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("USER_NAME_FILED_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BTN_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ARROW_NEXT_BY")));
        return this;
    }
    
    SignUpEmailPage clickNext() {
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BY"))).click();
    	return this;
    }
    
}
