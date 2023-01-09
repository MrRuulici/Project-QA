package testng;

import com.aventstack.extentreports.Status;
import config.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentTestManager;

import java.util.Objects;

import static reporting.ExtentTestManager.getTest;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("************* TEST START ***************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("************* TEST PASSED ***************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("************* TEST FAILED ***************");

        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(DriverManager.getDriver())).getScreenshotAs(OutputType.BASE64);

        //ExtentReports log and screenshot operations for failed tests.

        ExtentTestManager.getTest().log(Status.SKIP, "Test skipped",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("************* TEST SKIPPED ***************");

        //Take base64Screenshot screenshot for extent reports
        String base64Screenshot =
                "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(DriverManager.getDriver())).getScreenshotAs(OutputType.BASE64);

        //ExtentReports log and screenshot operations for failed tests.
        getTest().log(Status.SKIP, "Test skipped",
                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }


    @Override
    public void onStart(ITestContext context) {
        System.out.println("************* TEST SUITE START ***************");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("************* TEST FINISHED ***************");
    }
}
