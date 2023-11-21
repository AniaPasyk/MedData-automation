package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Devices extends BasePageObject {

    private By searchButton = By.xpath("//span[text()=' Search ']");

    public Devices(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickOnTheSearchButton() {
        click(searchButton);
        log.info("Search button has been clicked");
    }






}
