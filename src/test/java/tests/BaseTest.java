package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import util.ConfigProperties;
import config.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import testng.TestListeners;

import java.lang.reflect.Method;
import java.util.Optional;

@Listeners(TestListeners.class)
public class BaseTest {

    protected ConfigProperties properties;
    protected HomePage homePage;
    private static ExtentReports extent;

    @BeforeSuite(alwaysRun = true)
    public void extentSetup(ITestContext context) {
        extent = ExtentManager.createExtentReports();
    }

    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser) {
        DriverManager.setDriver(browser);
        properties = new ConfigProperties().readConfigProperties();
        homePage = new HomePage();
    }

    @BeforeClass
    public void navigateToUrl() {
        DriverManager.getDriver().navigate().to(properties.getUrl());
    }

    @BeforeMethod(alwaysRun = true)
    public void startExtent(Method method) {
        Test test = method.getAnnotation(Test.class);
        ExtentTestManager.createTest(method.getName(), test.description(), DriverManager.getDriverName());
        ExtentTestManager.getTest().assignAuthor("General_status");
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult result) {
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                ExtentTestManager.getTest().log(Status.PASS, "Test Finished");
                break;
            case ITestResult.FAILURE:
                ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
                break;
            case ITestResult.SKIP:
                java.util.Optional.ofNullable(result.getThrowable())
                        .ifPresentOrElse(
                                throwable -> ExtentTestManager.getTest().log(Status.SKIP,
                                        "Test Skipped due to " + result.getThrowable().getMessage()),
                                () -> ExtentTestManager.getTest().log(Status.SKIP,
                                        "Test Skipped due to failing/skipping in before hooks of tests")
                        );
                break;
            default:
                Optional.ofNullable(result.getThrowable())
                        .ifPresentOrElse(
                                throwable -> ExtentTestManager.getTest().log(Status.WARNING,
                                        "Test status unknown due to " + result.getThrowable().getMessage()),
                                () -> ExtentTestManager.getTest().log(Status.WARNING,
                                        "Test status Unknown due to preconditions or other dependencies")
                        );
        }
        ExtentManager.getInstance().flush();
    }

    @AfterTest
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}
