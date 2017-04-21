import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jing Zhao on 4/20/17.
 */
public abstract class Vixlet<T extends Vixlet<?>> {

    protected final AppiumDriver driver;
    protected final WebDriverWait driverWait;
    protected Map<String, By> elementIdentifiers;
    protected final Platform platform;
    protected static final String loginUid = "frank.zhao+9@vixlet.com";
    protected static final String loginPwd = "Welcome1!";
    
    public Vixlet(AppiumDriver webDriver, Platform platform) {
        driver = webDriver;
        this.platform = platform;
        int timeoutInSeconds = 45;
        driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
        elementIdentifiers = new HashMap<>();
    }

    public abstract T waitUntilLoaded();

    protected By getIdentifier(String identifierConstant) {
        return elementIdentifiers.get(getIdentifierKey(platform, identifierConstant));
    }

    protected void setIdentifier(Platform platform, String identifierConstant, By value) {
        elementIdentifiers.put(getIdentifierKey(platform, identifierConstant), value);
    }

    private String getIdentifierKey(Platform platform, String identifierConstant) {
//        System.out.println(this.getClass().getName());
//        System.out.println(platform.name());
//        System.out.println(identifierConstant);
        return String.format("%s:%s", platform.name(), identifierConstant);
    }
    
    void pause (int seconds) {
        try {
            Thread.sleep(seconds * 500);
        } catch (Exception e) {}
    }
    
    void println(Object line) {
    	final StackTraceElement[] ste = Thread.currentThread().getStackTrace();    // 3rd line in the call stack includes the caller method name
        System.out.printf("\t%-80s:: in %-26s, by method %s()\n", line, this.getClass().getName(), ste[2].getMethodName()); 
    }
    
}
