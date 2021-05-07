package fileupload;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTest {

    @Test
    public void testFileUpload(){
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile
                ("C:\\Users\\asvitkin\\IdeaProjects\\The Internet\\src\\test\\resources\\chromedriver.exe");
        Assert.assertEquals(fileUploadPage.getUploadFiles(), "chromedriver.exe", "Wrong upload");
    }
}
