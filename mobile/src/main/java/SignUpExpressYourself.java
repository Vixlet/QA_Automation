import io.appium.java_client.AppiumDriver;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    
    public SignUpExpressYourself(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.ANDROID, "PAGE_PROMPT_BY", PAGE_PROMPT_BY);
        setIdentifier(Platform.ANDROID, "PAGE_ANNOTATION_BY", PAGE_ANNOTATION_BY);
        setIdentifier(Platform.ANDROID, "USER_NAME_BY", USER_NAME_BY);
        setIdentifier(Platform.ANDROID, "TEXTINPUT_COUNTER_BY", TEXTINPUT_COUNTER_BY);
        setIdentifier(Platform.ANDROID, "NEXT_BTN_BY", NEXT_BTN_BY);
        setIdentifier(Platform.ANDROID, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        setIdentifier(Platform.IOS, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        println("Coming into SignUp Express Yourself page.");
    }

    public SignUpExpressYourself waitUntilLoaded() {
        println("Waiting for expected elements to be loaded");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PAGE_PROMPT_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PAGE_ANNOTATION_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("USER_NAME_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("TEXTINPUT_COUNTER_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BTN_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ARROW_NEXT_BY")));
        return this;
    }
    
    SignUpExpressYourself setUserName() {
        int ri = new Random().nextInt(999989999);
        String uname = "frank.zhao_test" + ri;	
        WebElement emailElement = driver.findElement(getIdentifier("USER_NAME_BY"));
        emailElement.click();
        emailElement.sendKeys(uname);
        return this;
    }
    
    SignUpExpressYourself clickNext() {
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEXT_BTN_BY"))).click();
    	return this;
//        return new SignUpPWD_DOB(driver, platform).waitUntilLoaded();
    }
    
}
