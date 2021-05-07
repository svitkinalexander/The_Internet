package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    private EventFiringWebDriver driver;
    //private WebDriver driver;
    private String link = "http://the-internet.herokuapp.com/";
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.manage().window().maximize();
        //driver.manage().timeouts().
        goHome();
        setCookie();
        homePage = new HomePage(driver);
        /*driver.get(link);
        System.out.println("Page title is " + driver.getTitle());
        driver.navigate().to(link);
        Thread.sleep(1000);
        homePage = new HomePage(driver);
        List<WebElement> aLinks = driver.findElements(By.tagName("a"));
        System.out.println("Количество ссылок: " + aLinks.size());
        Assert.assertEquals(aLinks.size(),46,"Неправильное количество ссылок");
        List<WebElement> listItems = driver.findElements(By.cssSelector("li a"));
        System.out.println("Количество пунктов списка: " + listItems.size());*/
    }

    @BeforeMethod
    public void goHome() {
        driver.get(link);
    }

    ;

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /*public static void main(String[] args) throws InterruptedException {
        BaseTest test = new BaseTest();
        test.setUp();
        test.tearDown();
    }*/

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    public void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        //System.out.println(screenshot.getAbsoluteFile());

        Files.move
                (screenshot, new File("src/test/resources/screenshots/screenshot_" + result.getName() + ".png"));
    }
    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE){
            takeScreenshot(result);
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //chromeOptions.setHeadless(true);
        return chromeOptions;
    }

    private void setCookie(){
        Cookie cookie = new Cookie
                .Builder("Stormnet", "1234")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
        driver.manage().deleteCookieNamed("optimizelyBuckets");
        //
    }
}