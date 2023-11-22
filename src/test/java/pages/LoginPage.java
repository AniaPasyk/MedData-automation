package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.TestArguments;

public class LoginPage extends BasePageObject {

    private String pageUrl = "xxxxxxxx";

    private By userNameInput = By.id("mat-input-0");
    private By passwordInput = By.id("mat-input-1");
    private By loginButton = By.xpath("//button[@class='mat-focus-indicator login__button mat-raised-button mat-button-base']");


    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    public void openPage() {
        log.info("Opening page " + pageUrl);
        openUrl(pageUrl);

    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    public WelcomePage logIn() {
        TestArguments.getUsername();
        type(TestArguments.getUsername(), userNameInput);
        type(TestArguments.getPassword(), passwordInput);
        click(loginButton);
        log.info("Login successfully executed");
        return new WelcomePage(this.driver, this.log);

    }




    }



