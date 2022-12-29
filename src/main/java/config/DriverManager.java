package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * HANDLING DRIVER INITIALIZATION
 */
public class DriverManager {

    private static WebDriver driver;

    private static ChromeDriver startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static FirefoxDriver startFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static EdgeDriver startEdgeBrowser() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static SafariDriver startSafariBrowser() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    public static WebDriver setDriver(String browser) {
        switch (browser) {
            case "chrome":
                driver = startChromeBrowser();
                break;
            case "firefox":
                driver = startFirefoxBrowser();
                break;
            case "safari":
                driver = startSafariBrowser();
                break;
            case "edge":
                driver = startEdgeBrowser();
                break;
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
