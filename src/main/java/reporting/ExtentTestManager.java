package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static ExtentReports extent = ExtentManager.createExtentReports();

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public synchronized static ExtentTest createTest(String name, String description, String category) {
        ExtentTest test = extent.createTest(name, description);

        if (category != null && !category.isEmpty())
            test.assignCategory(category);

        extentTest.set(test);

        return getTest();
    }
}
