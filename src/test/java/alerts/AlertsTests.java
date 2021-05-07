package alerts;

import base.BaseTest;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTests extends BaseTest {

    @Test
    public void testAlert(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickAlertButton();
        alertsPage.acceptPopUp();
        assertEquals(alertsPage.getResultText(), "You successfully clicked an alert", "Wrong result text");
    }

    @Test
    public void testConfirm(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickConfirmButton();
        String confirmText = alertsPage.getConfirmText();
        alertsPage.dismissPopUp();
        assertEquals(confirmText, "I am a JS Confirm", "Wrong confirm text");
        assertEquals(alertsPage.getResultText(), "You clicked: Cancel", "Wrong confirm text");
    }

    @Test
    public void testPrompt(){
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickPromptButton();
        String text = "Hey there!";
        alertsPage.setPromptInput(text);
        alertsPage.acceptPopUp();
        assertEquals(alertsPage.getResultText(), "You entered: " + text, "Wrong prompt text");
    }


}
