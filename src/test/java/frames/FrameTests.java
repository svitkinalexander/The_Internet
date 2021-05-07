package frames;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

public class FrameTests extends BaseTest {

    @Test
    public void testEditor(){
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();
        wysiwygEditorPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "world!";

        wysiwygEditorPage.setTextToTextArea(text1);
        wysiwygEditorPage.increaseIndent();
        wysiwygEditorPage.setTextToTextArea(text2);

        Assert.assertEquals(wysiwygEditorPage.getTextAreaContent(), text1 + text2, "Wrong text in text area");
    }
}
