package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static config.DriverManager.getDriver;

public class WaitStrategy {

    private static final int DEFAULT_TIMEOUT = 30;
    /**examples
     *
     */
    //implicit wait

    //explicit wait
    public void explicitWait() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleIs("emag"));
    }

    //fluent wait
    public void fluentWait() {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(getDriver(), Duration.ofSeconds(30))
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
    }

    /**
     * Fluent wait
     */
    protected static Wait<WebDriver> fluentWait(Duration timeOutDuration) {
        return new FluentWait<>(getDriver())
                .withTimeout(timeOutDuration)
                .pollingEvery(Duration.ofMillis(50))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);
    }
    public void waitForElement(ExpectedCondition<?> condition, Duration timeoutDuration) {
        try {
            fluentWait(timeoutDuration).until(condition);
        } catch (TimeoutException e) {
//            LOG.error(e.getMessage());
            throw e;
        }
    }

    public void waitForElementVisibility(By by, Duration timeoutDuration) {
        waitForElement(ExpectedConditions.visibilityOfElementLocated(by), timeoutDuration);
    }

    public void waitForElementVisibility(By by) {
        waitForElementVisibility(by, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public void waitForElementVisibility(WebElement elem) {
        waitForElement(ExpectedConditions.visibilityOf(elem), Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public void waitFor(Duration intervalMs) {
        try {
//            LOG.info("Waiting for {} ms", intervalMs.toMillis());
            Thread.sleep(intervalMs.toMillis());
        } catch (InterruptedException | StaleElementReferenceException e) {
//            LOG.error(e.getLocalizedMessage(), e);
            Thread.currentThread().interrupt();
        }
    }

    public boolean isElementClickable(By by, int timeout) {
//        LOG.info("Fluent waiting for element at by {} with timeout={}", by, timeout);
//        ExecutionTimer.start();
        try {
            fluentWait(Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
//            LOG.warn("Element located using locator: {} is not displayed after: {} seconds", by, timeout);
            return false;
        }
//        ExecutionTimer.stop();
//        LOG.info("Element is clickable after {} seconds", ExecutionTimer.exactDuration());
        return true;
    }


    public void waitForElementToBeSelected(By by, Duration timeoutDuration) {
        waitForElement(ExpectedConditions.elementToBeSelected(by), timeoutDuration);
    }

    public void waitForElementToBeClickable(By by, Duration timeoutDuration) {
        waitForElement(ExpectedConditions.elementToBeClickable(by), timeoutDuration);
    }

    //TODO add more methods
}
