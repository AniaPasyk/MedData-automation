package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePageObject {

    private By logoutButton = By.xpath( "//button[@class='mat-focus-indicator navbar__button mat-stroked-button mat-button-base']/span[text()=' Logout ']");
    private By generalMenuButton = By.xpath("//span[text()=' General ']");
    private By devicesMenuButton = By.xpath("//div[text()='Devices']");


    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public Devices goToDevicesMenu() {
        click(generalMenuButton);
        click(devicesMenuButton);
        log.info("Devices menu successfully opened");
        return new Devices(this.driver, this.log);
    }




//    public WebElement logoutButton() {
//        return logoutButton;
//    }



}
