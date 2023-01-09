package config;

import com.google.common.base.CaseFormat;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * HANDLING DRIVER INITIALIZATION
 */
public class DriverManager {

    private static RemoteWebDriver driver;

    private static ChromeDriver startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(OptionsManager.getChromeOptions());
    }

    private static FirefoxDriver startFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(OptionsManager.getFirefoxOptions());
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

    public static String getDriverName() {
        Capabilities cap = driver.getCapabilities();
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, cap.getBrowserName());
    }
}
