package modals;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntryAdPage;
import pages.HomePage;

public class ModalTests extends BaseTest {

    @Test
    public void testModal(){
        EntryAdPage entryAdPage = homePage.clickEntryAd();
        Assert.assertEquals(entryAdPage.getTitle(), "THIS IS A MODAL WINDOW", "Wrong modal title");
    }
}
