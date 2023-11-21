package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePageObject;
import pages.Devices;
import pages.LoginPage;
import pages.WelcomePage;
import utils.TestUtilities;

public class LoginTest extends TestUtilities {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver, log); //deklaruje klae jako atrybut klasy tetsowej, i tworze obiekt strony przekazując instacje webdriver i logger
        loginPage.openPage();
        WelcomePage welcomePage = loginPage.logIn();
        Devices devices = welcomePage.goToDevicesMenu();
        devices.clickOnTheSearchButton();




        //todo zrobić asercje czy jesteśmy na welcom page (czy istnieje przycik logout)





    }
}
