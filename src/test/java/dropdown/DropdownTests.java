package dropdown;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

public class DropdownTests extends BaseTest {

    @Test
    public void testSelectOption(){
        DropdownPage dropdownPage = homePage.clickDropDown();

        String option = "Option 1";
        dropdownPage.selectFromDropDown(option);

        List<String> selectedOptions = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOptions.size(), 1, "Wrong number of selection");
        Assert.assertTrue(selectedOptions.contains(option), "Option doesn't selected");
    }
}
