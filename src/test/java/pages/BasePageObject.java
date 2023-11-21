package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.List;

public class BasePageObject {

    protected WebDriver driver;
    protected static Logger log = LogManager.getLogger();

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }


    protected void openUrl(String url) {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        log.info("Page opened");
    }


    /** Find element using given locator */
    protected WebElement find(By locator) {
        return this.driver.findElement(locator);
    }


    protected List<WebElement> findAll(By locator) {
        return this.driver.findElements(locator);
    }

    /** Click on element with given locator when its visible */
    protected void click(By locator) {
        this.waitForVisibilityOf(locator, Duration.ofSeconds(5));
        this.find(locator).click();
    }


    /** Type given text into element with given locator */
    protected void type(String text, By locator) {
        this.waitForVisibilityOf(locator, Duration.ofSeconds(5));
        this.find(locator).sendKeys(new CharSequence[]{text});
    }


    /** Get URL of current page from browser */
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }


    /** Get title of current page */
    public String getCurrentPageTitle() {
        return this.driver.getTitle();
    }

    /** Get source of current page */
    public String getCurrentPageSource() {
        return this.driver.getPageSource();
    }

    /** Wait for specific ExpectedConditon for the given Duration */
    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(this.driver, timeOut);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Duration... timeOut) {
        int attempts = 0;

        while (attempts < 2) {
            try {
                this.waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOut.length > 0 ? timeOut[0] : null);
                break;
            } catch (StaleElementReferenceException var5) {
                ++attempts;
            }
        }

    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException var4) {
            var4.printStackTrace();

        }
    }

    //Clicks the element - been used when Selenium does not work correctly - like ticks, etc.
    static public void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }
}
