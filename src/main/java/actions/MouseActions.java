package actions;

import config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static config.DriverManager.getDriver;

public class MouseActions {
    private static final int DEFAULT_TIMEOUT = 30;
    private final WaitStrategy wait = new WaitStrategy();

    JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) DriverManager.getDriver();
    }

    public void clickOn(By by) {
        wait.isElementClickable(by, DEFAULT_TIMEOUT);
        getDriver().findElement(by).click();
    }

    public void clickOn(final WebElement element) {
        wait.isElementClickable((By) element, DEFAULT_TIMEOUT);
        element.click();
    }

    public void clickOnUsingJsExec(WebElement element) {
        getJsExecutor().executeScript("arguments[0].click();", element);
    }

    //TODO add more methods : double click, right click, click and hold, etc
    //TODO add methods with JavaScriptExecutor
}
