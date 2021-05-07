package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindows {
    private WebDriver driver;
    private By clickHereLink = By.linkText("Click Here");
    private By newWindow = By.className("example h3");

    public MultipleWindows(WebDriver driver) {
        this.driver = driver;
    }

    public void setClickHereLink(){
        driver.findElement(clickHereLink).click();
    }
}
