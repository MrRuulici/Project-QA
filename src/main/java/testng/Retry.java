package testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount;
    private static final String RETRY_ENV = System.getProperty("retry");

    private void setMaxRetryCount() {
        if (RETRY_ENV == null) {
            this.maxRetryCount = 0;
        } else {
            this.maxRetryCount = Integer.parseInt(RETRY_ENV);
        }
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        setMaxRetryCount();
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
