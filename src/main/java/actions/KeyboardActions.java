package actions;

import config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static config.DriverManager.getDriver;

public class KeyboardActions {

    private final WaitStrategy wait = new WaitStrategy();

    JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) DriverManager.getDriver();
    }

    public void typeText(By by, String text) {
        wait.waitForElementVisibility(by);
//        clearTheText(by);
        getDriver().findElement(by).sendKeys(text);
    }

    public void typeText(WebElement elem, String text) {
        clearTheText(elem);
        elem.sendKeys(text);
    }

    public void clearTheText(By by) {
        wait.waitForElementVisibility(by);
        getDriver().findElement(by).clear();
    }

    public void clearTheText(WebElement elem) {
        wait.waitForElementVisibility(elem);
        elem.clear();
    }
}
