import java.util.HashMap;
import java.util.TreeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.AppiumDriver;

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
    private static final By SIGNUP_BTN_BY = By.id("com.vixlet.atp.debug:id/email_next_button");
    private static final By ARROW_NEXT_BY = By.id("com.vixlet.atp.debug:id/right_arrow");
    private static final String DOB_DAY[][] = { {"DELETE", "67"}, {"DELETE", "67"}, {"1", "8"}, {"4", "11"}, {"ENTER", "66"} }; 
    private static final String[][] DOB_MON = { {"DELETE", "67"}, {"DELETE", "67"}, {"DELETE", "67"}, {"J", "38"}, {"u", "49"}, {"n", "42"}, {"ENTER", "66"} };
    private static final String[][] DOB_MO2 = { {"DELETE", "67"}, {"DELETE", "67"}, {"DELETE", "67"}, {"A", "29"}, {"p", "44"}, {"r", "46"}, {"ENTER", "66"} }; 
    private static final String[][] DOB_YR = { {"DELETE", "67"}, {"1", "8"},{"9", "16"}, {"8", "15"}, {"5", "12"}, {"ENTER", "66"} };
    private static final String[][] DOB_YR2 = { {"DELETE", "67"}, {"2", "9"},{"0", "7"}, {"1", "8"}, {"7", "14"}, {"ENTER", "66"} };
    private static final TreeMap<String, String[][]> hm = new TreeMap<String, String[][]>() {{
        put("DOB_YEAR_BY",  DOB_YR);
        put("DOB_MONTH_BY", DOB_MON);
        put("DOB_DAY_BY",   DOB_DAY);
    }};
    private static final TreeMap<String, String[][]> hm2 = new TreeMap<String, String[][]>() {{
        put("DOB_YEAR_BY",  DOB_YR2);
        put("DOB_DAY_BY",   DOB_DAY);
        put("DOB_MONTH_BY", DOB_MO2);
    }};
    private static final By DOB_TITLE_BY = By.id("android:id/alertTitle");
    private static final By DOB_TITLE_DIVIDER_BY = By.id("android:id/titleDivider");
    private static final String base = 
    		"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.DatePicker[1]/";
    private static final String dobXp = base + "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.NumberPicker[";
    private static final By DOB_MONTH_BY = By.xpath(dobXp + "1]"); 
    private static final By DOB_DAY_BY = By.xpath(dobXp + "2]"); 
    private static final By DOB_YEAR_BY = By.xpath(dobXp + "3]");
    private static final By DOB_BTN_PANEL_BY = By.id("android:id/buttonPanel");
	private static final By DOB_OK_BY = By.id("android:id/button1");
	private static final By DOB_CANCEL_BY = By.id("android:id/button2");
	private static final By NAVIGATE_BACK_BY = By.id("Navigate up");
	private static final By NEED_DOB_PROMPT_BY = By.id("com.vixlet.atp.debug:id/birthday_validation");
	private static final By NEED_PWD_PROMPT_BY = By.id("com.vixlet.atp.debug:id/password_validation");
	private static final By MINOR_NOT_QUALIFY_PANEL_BY = By.id("android:id/contentPanel");
	private static final By MINOR_NOT_QUALIFY_MSG_BY = By.id("android:id/message");
	private static final By MINOR_NOT_QUALIFY_OK_BY = By.id("android:id/buttonPanel");
    private static final String xp3 = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[";
    private static final String xp2 = xp3 + "1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/";
    private static final String xp = xp2 + "XCUIElementTypeOther[1]/XCUIElementTypeOther[";
	private static final By BACK_ID_BY = By.id("headerButtonBack");
	private static final By SIGNUP_PROMPT_BY = By.id("Sign up for MyATP");
	private static final By SIGNUP_MSG_BY = By.xpath(xp + "1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]");
	private static final By PWD_BY = By.id("Password");
	private static final By PWD_FIELD_XPATH_BY = By.xpath(xp + "2]/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[1]");
	private static final By DOB_BY = By.id("Birthday (Not Shown)");
	private static final By DOB_FIELD_XPATH_BY = By.xpath(xp + "2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]");
	private static final By TERM_PRIVACY_ID_BY = By.id("By creating this account, you agree to the terms and you have read the privacy policy.");
	private static final By SIGNUP_BY = By.id("Sign Up");
	private static final By NEED_PWD_BY = By.id("Password must be at least 6 characters.");
	private static final By NEED_DOB_PROMPT_ID_BY = By.id("Please enter a birth date");
	private static final By PWD_VISIBLE_HIDE_ID_BY = By.xpath(xp2 + "XCUIElementTypeButton[1]"); //By.id("vx 02 indicator visibility on");
    private static final HashMap<Integer, String> hmIos = new HashMap<Integer, String>() {{
        put(0, "October");		put(1,   "30");			put(2,  "1958");
    }};
    private static final HashMap<Integer, String> hmIos2 = new HashMap<Integer, String>() {{
        put(0, "April");		put(1,   "26");			put(2,  "2017");
    }};
	private static final By NO_MINOR_QUALIFY_PANEL_BY = By.xpath(xp3 + "2]/XCUIElementTypeAlert[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]");
	private static final By NO_MINOR_QUALIFY_MSG_BY = By.id("Sorry you do not qualify to join MyATP. Please come back later.");
	private static final By NO_MINOR_QUALIFY_OK_BY = By.id("OK");
	private static final By HEADER_CLOSE_BY = By.id("headerButtonClose");
	private static final By TERMS_PRIVACY_HEADER_BY = By.id("Vixlet Community Guidelines");
	
	
	
    public SignUpPWD_DOB(AppiumDriver webDriver, Platform platform) {
        super(webDriver, platform);
        setIdentifier(Platform.IOS, "BACK_BY", BACK_ID_BY);
        setIdentifier(Platform.IOS, "SIGNUP_PROMPT_TITLE_BY", SIGNUP_PROMPT_BY);
        setIdentifier(Platform.IOS, "SIGNUP_PROMPT_MSG_BY", SIGNUP_MSG_BY);
        setIdentifier(Platform.IOS, "PWD_BY", PWD_BY);
        setIdentifier(Platform.IOS, "PWD_FIELD_BY", PWD_FIELD_XPATH_BY);
        setIdentifier(Platform.IOS, "PWD_VISIBLE_HIDE_BY", PWD_VISIBLE_HIDE_ID_BY);
        setIdentifier(Platform.IOS, "DOB_BY", DOB_BY);
        setIdentifier(Platform.IOS, "DOB_FIELD_BY", DOB_FIELD_XPATH_BY);
        setIdentifier(Platform.IOS, "TERM_PRIVACY_BY", TERM_PRIVACY_ID_BY);
        setIdentifier(Platform.IOS, "SIGNUP_BTN_BY", SIGNUP_BY);
        setIdentifier(Platform.IOS, "NAVIGATE_BACK_BY", HEADER_CLOSE_BY);
        setIdentifier(Platform.IOS, "TERMS_PRIVACY_HEADER_BY", TERMS_PRIVACY_HEADER_BY);
        setIdentifier(Platform.IOS, "NEED_DOB_PROMPT_BY", NEED_DOB_PROMPT_ID_BY);
        setIdentifier(Platform.IOS, "NEED_PWD_PROMPT_BY", NEED_PWD_BY);
        setIdentifier(Platform.IOS, "MINOR_NOT_QUALIFY_PANEL_BY", NO_MINOR_QUALIFY_PANEL_BY);
        setIdentifier(Platform.IOS, "MINOR_NOT_QUALIFY_BY", NO_MINOR_QUALIFY_MSG_BY);
        setIdentifier(Platform.IOS, "MINOR_NOT_QUALIFY_OK_BY", NO_MINOR_QUALIFY_OK_BY);
        setIdentifier(Platform.IOS, "ARROW_NEXT_BY", ARROW_NEXT_BY);
        setIdentifier(Platform.ANDROID, "BACK_BY", BACK_BY);
        setIdentifier(Platform.ANDROID, "SIGNUP_PROMPT_TITLE_BY", SIGNUP_PROMPT_TITLE_BY);
        setIdentifier(Platform.ANDROID, "SIGNUP_PROMPT_MSG_BY", SIGNUP_PROMPT_MSG_BY);
        setIdentifier(Platform.ANDROID, "PWD_FIELD_BY", PWD_FIELD_BY);
        setIdentifier(Platform.ANDROID, "PWD_VISIBLE_HIDE_BY", PWD_VISIBLE_HIDE_BY);
        setIdentifier(Platform.ANDROID, "DOB_FIELD_BY", DOB_FIELD_BY);
        setIdentifier(Platform.ANDROID, "TERM_PRIVACY_BY", TERM_PRIVACY_BY);
        setIdentifier(Platform.ANDROID, "SIGNUP_BTN_BY", SIGNUP_BTN_BY);
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
        setIdentifier(Platform.ANDROID, "NEED_DOB_PROMPT_BY", NEED_DOB_PROMPT_BY);
        setIdentifier(Platform.ANDROID, "NEED_PWD_PROMPT_BY", NEED_PWD_PROMPT_BY);
        setIdentifier(Platform.ANDROID, "MINOR_NOT_QUALIFY_PANEL_BY", MINOR_NOT_QUALIFY_PANEL_BY);
        setIdentifier(Platform.ANDROID, "MINOR_NOT_QUALIFY_BY", MINOR_NOT_QUALIFY_MSG_BY);
        setIdentifier(Platform.ANDROID, "MINOR_NOT_QUALIFY_OK_BY", MINOR_NOT_QUALIFY_OK_BY);
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
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(getIdentifier("NEED_DOB_PROMPT_BY")));
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(getIdentifier("NEED_PWD_PROMPT_BY")));
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
        	driver.hideKeyboard();
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("ARROW_NEXT_BY")));
        } else {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PWD_BY")));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_BY")));
        }
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGNUP_BTN_BY")));
        return this;
    }

    SignUpPWD_DOB fillSignUpPWD() {
        WebElement pwdElement = driver.findElement(getIdentifier("PWD_FIELD_BY"));
        pwdElement.click();
        pwdElement.sendKeys("Welcome1!");
        showHidePWD();
        return this;
    }
    
    SignUpPWD_DOB fillSignUpPWDOnly() {
    	fillSignUpPWD();
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGNUP_BTN_BY"))).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEED_DOB_PROMPT_BY")));
        return this;
    }
    
    void showHidePWD() {
    	for(int i=0; i<2; i++) {
        	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("PWD_VISIBLE_HIDE_BY"))).click();
        	pause(2);
    	}
    }
    
    SignUpPWD_DOB setDOBOnly() {
    	setDOBminor();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NEED_PWD_PROMPT_BY")));
        return this;
    }
    
    SignUpPWD_DOB setDOBminorVerify() {
    	setDOBminor();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("MINOR_NOT_QUALIFY_PANEL_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("MINOR_NOT_QUALIFY_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("MINOR_NOT_QUALIFY_OK_BY")));
        return this;
    }
    
    void setDOBminor() {
    	driver.findElement(getIdentifier("DOB_FIELD_BY")).click();
    	println("Set User's DOB: Apr/26/2017");
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
            setDOBandroid(hm2);
        } else {
        	setDOBiOS(hmIos2);
        }
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGNUP_BTN_BY"))).click();
    }
    
    SignUpPWD_DOB setDOB() {
    	println("Set User's DOB: Jun/14/1985 on Android & October/30/1958 on iOS");
    	driver.findElement(getIdentifier("DOB_FIELD_BY")).click();
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
            return setDOBandroid(hm);
        } else {
        	return setDOBiOS(hmIos);
        }
    }
    
    SignUpPWD_DOB setDOBiOS(HashMap<Integer, String> dOB) {
    	driver.findElement(getIdentifier("DOB_BY")).click();
        for (Integer i : dOB.keySet() ) {
        	((WebElement) driver.findElements(By.className("UIAPickerWheel")).get(i)).sendKeys(dOB.get(i));
        }
        return this;
    }
    
    SignUpPWD_DOB setDOBandroid(TreeMap<String, String[][]> dOB) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_TITLE_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_TITLE_DIVIDER_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_DAY_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_MONTH_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_YEAR_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_BTN_PANEL_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_CANCEL_BY")));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("DOB_OK_BY")));
//        driver.scrollTo("Sep");
        for (String s : dOB.keySet() ) {
            spinWheelValues(s, dOB.get(s));
        }
        dismissAndroidPopUp(2, getIdentifier("DOB_CANCEL_BY"), getIdentifier("DOB_OK_BY"), "Set Date of Birth");
        return this;
    }
    
    void spinWheelValues(String id, String[][] aOa) {
        driverWait.until(ExpectedConditions.elementToBeClickable(getIdentifier(id))).sendKeys("");
        for( int i=0; i<aOa.length; i++) {
            pressKeyByAdbShell(aOa[i][0], aOa[i][1]);
        }
    }
    
    SignUpPWD_DOB checkTermsAndPrivacy() {
    	checkLegalDocuments("terms");
    	checkLegalDocuments("privacy");
    	return this;
    }
    
    void checkLegalDocuments(String docName) {
    	println("check Legal Documents : " + docName);
		if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
			if (docName.equals("terms")) {
    	    	driver.tap(1, 835, 1015, 1000);
    		} else {
    			driver.tap(1, 450, 1079, 1000);
    		}
	    	pause(6);
    	} else {
			if (docName.equals("terms")) {
				driver.tap(1, 290, 372, 1000);
			} else {
				driver.tap(1, 154, 386, 1000);
    		}
	        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("TERMS_PRIVACY_HEADER_BY")));
    	}
    	for(int i=0; i<3; i++) {
    		scrollPageDown();
    	}
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("NAVIGATE_BACK_BY"))).click();
    	pause(2);
    }
    
    void scrollPageDown() {
        if ( ((String) driver.getCapabilities().getCapability("platformName")).equals("Android") ) {
        	int screenBottom = (int) (driver.manage().window().getSize().getHeight()); // almost-full-screen scrolling
        	driver.swipe(0, screenBottom-10, 0, 9, 2000);
        } else {
        	driver.executeScript("mobile: scroll", new HashMap<String, String>() {{ put("direction", "down"); }});
        }
    }
    
    SignUpExpressYourself signUp() {
    	driverWait.until(ExpectedConditions.visibilityOfElementLocated(getIdentifier("SIGNUP_BTN_BY"))).click();
        return new SignUpExpressYourself(driver, platform).waitUntilLoaded();
    }
    
}
