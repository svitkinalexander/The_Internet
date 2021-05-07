package hover;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoverTests extends BaseTest {

    @Test
    public void testHoverUser1(){
        HoversPage hoversPage = homePage.clickHovers();
        HoversPage.PictureCaption caption = hoversPage.hoverOverPicture(0);
        Assert.assertTrue(caption.captionIsDisplayed());
        Assert.assertEquals(caption.getHeaderText(),"name: user1", "Wrong user header");
        Assert.assertEquals(caption.getLinkText(),"View profile", "Wrong user footer");
        Assert.assertEquals(caption.getLinkHref(),"http://the-internet.herokuapp.com/users/1", "Wrong link href attribute");
    }
}
