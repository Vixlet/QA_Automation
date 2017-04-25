import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

public class VixletTest extends AppiumTest {

    @Category({SignUp.class}) 
    @Test
    public void appLoads() {
        VixletWelcomePage welcomePage = new VixletWelcomePage(driver, platform).waitUntilLoaded();
    }

    @Category({SignUp.class}) 
    @Test
    public void getStarted_Email() {
        VixletWelcomePage wp = new VixletWelcomePage(driver, platform).waitUntilLoaded();
        wp.getStarted()
       .trySignUpEmailInvalid();
    }

    @Category({SignUp.class, Android_only.class}) 
    @Test
    public void getStarted_PWD_DOB() {
        VixletWelcomePage wp = new VixletWelcomePage(driver, platform).waitUntilLoaded();
        wp.getStarted()
        .setSignUpEmail()
        .fillSignUpPWDOnly()
        .setDOBJunior();
    }

    @Category({SignUp.class, Android_only.class}) 
    @Test
    public void getStarted_DOB() {
        VixletWelcomePage wp = new VixletWelcomePage(driver, platform).waitUntilLoaded();
        wp.getStarted()
        .setSignUpEmail()
        .setDOBOnly();
    }
    
    @Category({SignUp.class, Android_only.class}) 
    @Test
    public void getStarted_UserName() {
        VixletWelcomePage wp = new VixletWelcomePage(driver, platform).waitUntilLoaded();
        wp.getStarted()
        .setSignUpEmail()
        .fillSignUpPWD()
        .setDOB()
        .checkTermsAndPrivacy()
        .signUp()
        .setUserName();
    }
	
}
