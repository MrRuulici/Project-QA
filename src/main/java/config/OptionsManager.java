package config;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

    public static ChromeOptions getChromeOptions() {
        var options = new ChromeOptions();
        options.addArguments("--no-headless");
        options.addArguments("--window-size=1900,1600");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.setCapability("browserName", "chrome");
        return options;
    }


    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserName", "firefox");
        options.addArguments("--headless");
        options.addArguments("--width=1900");
        options.addArguments("--height=1600");
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        return options;
    }
}
