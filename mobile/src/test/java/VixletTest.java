import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

public class VixletTest extends AppiumTest {

    @Category({SignUp.class, Android_only.class}) 
    @Test
    public void appLoads() {
        VixletWelcomePage welcomePage = new VixletWelcomePage(driver, platform).waitUntilLoaded();
    }
	
    @Category({SignUp.class, Android_only.class}) 
    @Test
    public void getStarted() {
        VixletWelcomePage wp = new VixletWelcomePage(driver, platform).waitUntilLoaded();
        wp.getStarted();
    }

}
