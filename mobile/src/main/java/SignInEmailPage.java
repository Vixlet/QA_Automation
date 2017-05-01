import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Jing Zhao on 4/28/17.
 */
public class SignInEmailPage extends Vixlet<SignInEmailPage> {  //TODO update all elements

    private static final By NONE_OF_ABOVE_BY = By.id("com.google.android.gms:id/cancel");
    private static final By BACK_BY = By.id("com.vixlet.atp.debug:id/up_arrow");
    private static final By ENTER_EMAIL_PROMPT_BY = By.id("com.vixlet.atp.debug:id/email_title");
    private static final By USER_NAME_FIELD_BY = By.id("com.vixlet.atp.debug:id/username_edit");
    private static final By NEXT_BTN_BY = By.id("com.vixlet.atp.debug:id/email_next_button");
    private static final By ARROW_NEXT_BY = By.id("com.vixlet.atp.debug:id/right_arrow");
    private static final By INVALID_EMAIL_BY = By.id("com.vixlet.atp.debug:id/username_validation");
    private static final By BACK_TN_BY = By.id("headerButtonBack");
    private static final By ENTER_EMAIL_HEADER_BY = By.id("Enter email to get started");
    private static final By EMAIL_BY = By.id("Email");
    private static final By USERNAME_FIELD_BY = By.id("emailTextField");
    private static final By NEXT_BY = By.id("nextPage");
    private static final By INVALID_EMAIL_ERROR_BY = By.id("Please enter a valid email address");

    
    public SignInEmailPage(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.ANDROID, "DISMISS_HELPER_BY", NONE_OF_ABOVE_BY);
        setIdentifier(Platform.ANDROID, "BACK_BY", BACK_BY);
        setIdentifier(Platform.ANDROID, "ENTER_EMAIL_PROMPT_BY", ENTER_EMAIL_PROMPT_BY);
        setIdentifier(Platform.ANDROID, "USER_NAME_FIELD_BY", USER_NAME_FIELD_BY);
        setIdentifier(Platform.ANDROID, "NEXT_BTN_BY", NEXT_BTN_BY);
        setIdentifier(Platform.ANDROID, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        setIdentifier(Platform.ANDROID, "INVALID_EMAIL_BY", INVALID_EMAIL_BY);
        setIdentifier(Platform.IOS, "BACK_BY", BACK_TN_BY);
        setIdentifier(Platform.IOS, "ENTER_EMAIL_PROMPT_BY", ENTER_EMAIL_HEADER_BY);
        setIdentifier(Platform.IOS, "EMAIL_BY", EMAIL_BY);
        setIdentifier(Platform.IOS, "USER_NAME_FIELD_BY", USERNAME_FIELD_BY);
        setIdentifier(Platform.IOS, "NEXT_BTN_BY", NEXT_BY);
        setIdentifier(Platform.IOS, "INVALID_EMAIL_BY", INVALID_EMAIL_ERROR_BY);
        println("Coming into SignUp Email Page.");
    }

    public SignInEmailPage waitUntilLoaded() {
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
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("USER_NAME_FIELD_BY")));
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(getIdentifier("INVALID_EMAIL_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BTN_BY")));
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ARROW_NEXT_BY")));
        } else {
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("EMAIL_BY")));
        }

        return this;
    }
    
    SignInEmailPage trySignUpEmailInvalid() {
    	fillSignUpEmail("invalid.email_addr_vixlet..com");  //TODO: reverse to invalid.email_addr@vixlet..com upon fix of VIX-4167 (iOS)
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("INVALID_EMAIL_BY")));
        return this;
    }
    
    SignUpPWD_DOB setSignUpEmail() {
    	fillSignUpEmail("frank.vixlet+test" + System.currentTimeMillis() + "@gmail.com");  //epoch time in milliseconds
        return new SignUpPWD_DOB(driver, platform).waitUntilLoaded();
    }
    
    void fillSignUpEmail(String email) {
        WebElement emailElement = driver.findElement(getIdentifier("USER_NAME_FIELD_BY"));
        emailElement.clear();
        emailElement.sendKeys(email);
        clickNext();
    }
    
    SignInEmailPage clickNext() {
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BTN_BY"))).click();
    	return this;
    }
    
}
