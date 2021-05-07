package keys;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeysTests extends BaseTest {

    @Test
    public void testBackspace(){
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("Hello World!" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE", "Result is wrong");
    }

    @Test void testShortcuts(){
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("Hello World!" + Keys.chord(Keys.CONTROL, "z"));
        Assert.assertEquals(keyPressesPage.getTargetValue(), "Hello World", "Wrong value");
    }
}
