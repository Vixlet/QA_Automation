import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.AppiumDriver;

/**
 * Created by Jing Zhao on 4/24/17.
 */
public class SignUpExpressYourself extends Vixlet<SignUpExpressYourself> {
	
    private static final By PAGE_PROMPT_BY = By.id("com.vixlet.atp.debug:id/title");
    private static final By PAGE_ANNOTATION_BY = By.id("com.vixlet.atp.debug:id/sub_label");
    private static final By USER_NAME_BY = By.id("com.vixlet.atp.debug:id/username_edit");
    private static final By TEXTINPUT_COUNTER_BY = By.id("com.vixlet.atp.debug:id/textinput_counter");
    private static final By NEXT_BTN_BY = By.id("com.vixlet.atp.debug:id/email_next_button");
    private static final By ARROW_NEXT_BY = By.id("com.vixlet.atp.debug:id/right_arrow");
    private static final By UNAME_VALIDATE_BY = By.id("com.vixlet.atp.debug:id/username_validation");
    private static final By PROMPT_HEADER_BY = By.id("Express yourself");
    private static final By PAGE_ANNOTATION_ID_BY = By.id("Create a username that represents you on MyATP");
    private static final By USER_BY = By.id("Username");
    private static final String xp1 = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/";
    private static final String xp = xp1 + "XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[";
    private static final By USER_ID_FIELD_BY = By.xpath(xp + "2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]");
    private static final By CLEAR_TEXT_BY = By.xpath(xp + "2]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]/XCUIElementTypeButton[1]"); //By.id("Clear text");
    private static final By NEXT_PAGE_BY = By.xpath(xp + "3]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]"); //By.id("nextPage");
    private static final By UNAME_VALIDATE_ID_BY = By.id("Sorry, that name is already taken. Please try again.");
    private static final By UNAME_VALIDATE_OK_BY = By.id("OK");
    
    public SignUpExpressYourself(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.ANDROID, "PAGE_PROMPT_BY", PAGE_PROMPT_BY);
        setIdentifier(Platform.ANDROID, "PAGE_ANNOTATION_BY", PAGE_ANNOTATION_BY);
        setIdentifier(Platform.ANDROID, "USER_NAME_BY", USER_NAME_BY);
        setIdentifier(Platform.ANDROID, "TEXTINPUT_COUNTER_BY", TEXTINPUT_COUNTER_BY);
        setIdentifier(Platform.ANDROID, "NEXT_BTN_BY", NEXT_BTN_BY);
        setIdentifier(Platform.ANDROID, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        setIdentifier(Platform.ANDROID, "UNAME_VALIDATE_BY", UNAME_VALIDATE_BY);
        setIdentifier(Platform.IOS, "PAGE_PROMPT_BY", PROMPT_HEADER_BY);
        setIdentifier(Platform.IOS, "PAGE_ANNOTATION_BY", PAGE_ANNOTATION_ID_BY);
        setIdentifier(Platform.IOS, "USER_BY", USER_BY);
        setIdentifier(Platform.IOS, "USER_NAME_BY", USER_ID_FIELD_BY);
        setIdentifier(Platform.IOS, "CLEAR_TEXT_BY", CLEAR_TEXT_BY);
        setIdentifier(Platform.IOS, "NEXT_BTN_BY", NEXT_PAGE_BY);
        setIdentifier(Platform.IOS, "UNAME_VALIDATE_BY", UNAME_VALIDATE_ID_BY);
        setIdentifier(Platform.IOS, "UNAME_VALIDATE_OK_BY", UNAME_VALIDATE_OK_BY);
        println("Coming into SignUp Express Yourself page.");
    }

    public SignUpExpressYourself waitUntilLoaded() {
        println("Waiting for expected elements to be loaded");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PAGE_PROMPT_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PAGE_ANNOTATION_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("USER_NAME_BY")));
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(getIdentifier("UNAME_VALIDATE_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BTN_BY")));
		if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
	        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("TEXTINPUT_COUNTER_BY")));
	        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ARROW_NEXT_BY")));
		} else {
	        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("USER_BY")));
	        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(getIdentifier("CLEAR_TEXT_BY")));
		}
        return this;
    }
    
    SignUpExpressYourself setUserName() {
        setUserName("dot.invalid @@$-");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("UNAME_VALIDATE_BY")));
		if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("iOS") ) {
	        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("UNAME_VALIDATE_OK_BY"))).click();
		} 
        setUserName(System.currentTimeMillis() + "this_is_A_Really_Long_User_Name_which_goes_beyond_30_char_limit_"); //"frank_zhao_test"
        pause(6);
        return this;
//      return new SignUpPWD_DOB(driver, platform).waitUntilLoaded();
    }
    
    void setUserName(String userName) {
        WebElement emailElement = driver.findElement(getIdentifier("USER_NAME_BY"));
        emailElement.clear();
        emailElement.sendKeys(userName);
        clickNext();
    }
    
    SignUpExpressYourself clickNext() {
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BTN_BY"))).click();
    	return this;
    }
    
}
