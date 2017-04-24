import io.appium.java_client.AppiumDriver;

import java.util.Random;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jing Zhao on 4/24/17.
 */
public class SignUpPWD_DOB extends Vixlet<SignUpPWD_DOB> {
    private static final By BACK_BY = By.id("com.vixlet.atp.debug:id/up_arrow");
    private static final By SIGNUP_PROMPT_TITLE_BY = By.id("com.vixlet.atp.debug:id/title_text");
    private static final By SIGNUP_PROMPT_MSG_BY = By.id("com.vixlet.atp.debug:id/message_text");
    private static final By PWD_FIELD_BY = By.id("com.vixlet.atp.debug:id/password_edit");
    private static final By PWD_VISIBLE_HIDE_BY = By.id("com.vixlet.atp.debug:id/text_input_password_toggle");
    private static final By DOB_FIELD_BY = By.id("com.vixlet.atp.debug:id/birthday_edit");
    private static final By TERM_PRIVACY_BY = By.id("com.vixlet.atp.debug:id/tos_text");
    private static final By SIGUP_BTN_BY = By.id("com.vixlet.atp.debug:id/email_next_button");
    private static final By ARROW_NEXT_BY = By.id("com.vixlet.atp.debug:id/right_arrow");
    private static final String DOB_DAY[][] = { {"DELETE", "67"}, {"DELETE", "67"}, {"1", "8"}, {"4", "11"}, {"ENTER", "66"} }; 
    private static final String[][] DOB_MON = { {"DELETE", "67"}, {"DELETE", "67"}, {"DELETE", "67"}, {"J", "38"}, {"u", "49"}, {"n", "42"}, {"ENTER", "66"} }; 
    private static final String[][] DOB_YR = { {"DELETE", "67"}, {"1", "8"},{"9", "16"}, {"8", "15"}, {"6", "13"}, {"ENTER", "66"} };
    private static final TreeMap<String, String[][]> hm = new TreeMap<String, String[][]>() {{
        put("DOB_YEAR_BY",  DOB_YR);
        put("DOB_MONTH_BY", DOB_MON);
        put("DOB_DAY_BY",   DOB_DAY);
    }};
    private static final By DOB_TITLE_BY = By.id("android:id/alertTitle");
    private static final By DOB_TITLE_DIVIDER_BY = By.id("android:id/titleDivider");
    private static final String base = 
    		"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/";
    private static final String dobXp = base + "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[";
    private static final By DOB_DAY_BY = By.xpath(dobXp + "1]"); 
    private static final By DOB_MONTH_BY = By.xpath(dobXp + "2]"); 
    private static final By DOB_YEAR_BY = By.xpath(dobXp + "3]");
    private static final By DOB_BTN_PANEL_BY = By.id("android:id/buttonPanel");
	private static final By DOB_OK_BY = By.id("android:id/button1");
	private static final By DOB_CANCEL_BY = By.id("android:id/button2");
	private static final By NAVIGATE_BACK_BY = By.id("Navigate up");

    public SignUpPWD_DOB(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.ANDROID, "BACK_BY", BACK_BY);
        setIdentifier(Platform.ANDROID, "SIGNUP_PROMPT_TITLE_BY", SIGNUP_PROMPT_TITLE_BY);
        setIdentifier(Platform.ANDROID, "SIGNUP_PROMPT_MSG_BY", SIGNUP_PROMPT_MSG_BY);
        setIdentifier(Platform.ANDROID, "PWD_FIELD_BY", PWD_FIELD_BY);
        setIdentifier(Platform.ANDROID, "PWD_VISIBLE_HIDE_BY", PWD_VISIBLE_HIDE_BY);
        setIdentifier(Platform.ANDROID, "DOB_FIELD_BY", DOB_FIELD_BY);
        setIdentifier(Platform.ANDROID, "TERM_PRIVACY_BY", TERM_PRIVACY_BY);
        setIdentifier(Platform.ANDROID, "SIGUP_BTN_BY", SIGUP_BTN_BY);
        setIdentifier(Platform.ANDROID, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        setIdentifier(Platform.ANDROID, "DOB_TITLE_BY", DOB_TITLE_BY);
        setIdentifier(Platform.ANDROID, "DOB_TITLE_DIVIDER_BY", DOB_TITLE_DIVIDER_BY);
        setIdentifier(Platform.ANDROID, "DOB_DAY_BY", DOB_DAY_BY);
        setIdentifier(Platform.ANDROID, "DOB_MONTH_BY", DOB_MONTH_BY);
        setIdentifier(Platform.ANDROID, "DOB_YEAR_BY", DOB_YEAR_BY);
        setIdentifier(Platform.ANDROID, "DOB_BTN_PANEL_BY", DOB_BTN_PANEL_BY);
        setIdentifier(Platform.ANDROID, "DOB_CANCEL_BY", DOB_CANCEL_BY);
        setIdentifier(Platform.ANDROID, "DOB_OK_BY", DOB_OK_BY);
        setIdentifier(Platform.ANDROID, "NAVIGATE_BACK_BY", NAVIGATE_BACK_BY);
        setIdentifier(Platform.IOS, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        println("Coming into SignUp PWD & DOB info page.");
    }

    public SignUpPWD_DOB waitUntilLoaded() {
        println("Waiting for expected elements to be loaded");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("BACK_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGNUP_PROMPT_TITLE_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGNUP_PROMPT_MSG_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PWD_FIELD_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PWD_VISIBLE_HIDE_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_FIELD_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("TERM_PRIVACY_BY")));
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
        	driver.hideKeyboard();
        }
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGUP_BTN_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ARROW_NEXT_BY")));
        return this;
    }

    SignUpPWD_DOB fillSignUpPWD() {
        WebElement pwdElement = driver.findElement(getIdentifier("PWD_FIELD_BY"));
        pwdElement.click();
        pwdElement.sendKeys("Welcome1!");
        showHidePWD();
        return this;
    }
    
    void showHidePWD() {
    	for(int i=0; i<2; i++) {
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PWD_VISIBLE_HIDE_BY"))).click();
        	pause(2);
    	}
    }
    
    SignUpPWD_DOB setDOB() {
    	println("Set User's DOB: Jun/14/1986");
    	driver.findElement(getIdentifier("DOB_FIELD_BY")).click();   pause(1);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_TITLE_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_TITLE_DIVIDER_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_DAY_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_MONTH_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_YEAR_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_BTN_PANEL_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_CANCEL_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_OK_BY")));
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
        	setDOBandroid();
        }
        return this;
    }
    
    void setDOBandroid() {
//        driver.scrollTo("Sep");
        for (String s : hm.descendingKeySet() ) {
        	pause(2);
            spinWheelValues(s, hm.get(s));
        }
        dismissAndroidPopUp(2, getIdentifier("DOB_CANCEL_BY"), getIdentifier("DOB_OK_BY"), "Set Date of Birth");
    }
    
    void spinWheelValues(String id, String[][] aOa) {
        driverWait.until(ExpectedConditions.elementToBeClickable(getIdentifier(id))).sendKeys("");
        for( int i=0; i<aOa.length; i++) {
            pressKeyByAdbShell(aOa[i][0], aOa[i][1]);
        }
    }
    
    SignUpPWD_DOB checkTermsAndPrivacy() {
    	checkLegalDocuments("terms", 835, 1015);
    	checkLegalDocuments("privacy", 450, 1079);
    	return this;
    }
    
    void checkLegalDocuments(String docName, int x, int y) {
    	println("check Legal Documents : " + docName);
    	driver.tap(1, x, y, 1000);
    	pause(6);
    	for(int i = 0; i<8; i++) {
    		androidScrollDown();
    	}
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NAVIGATE_BACK_BY"))).click();
    	pause(6);
    }
    
    void androidScrollDown() {
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
        	int screenBottom = (int) (driver.manage().window().getSize().getHeight()); // almost-full-screen scrolling
        	driver.swipe(0, screenBottom-10, 0, 9, 2000);
        }
    }
    
    SignUpExpressYourself singUp() {
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGUP_BTN_BY"))).click();
        return new SignUpExpressYourself(driver, platform).waitUntilLoaded();
    }
    
}
