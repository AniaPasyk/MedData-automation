package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static final Duration implicitTimeout = Duration.ofSeconds(10);

    public static WebDriver getDriver() {

        ChromeOptions chromeOptions = new ChromeOptions(); //tworze opcje przeglądarki za pomocą kontruktora ChromeOption

        chromeOptions.addArguments(
                "--window-size=2048,1536",
                "--no-default-browser-check",
                "--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--disable-dev-shm-usage",
                "--no-sandbox");

        return new ChromeDriver(chromeOptions);


    }
}
