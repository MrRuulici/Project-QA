package tests;

import config.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {


    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser) {
        DriverManager.setDriver(browser);
    }

    @BeforeClass
    public void navigateToUrl() {
        DriverManager.getDriver().navigate().to("https://www.emag.ro");
    }

//    @AfterTest
//    public void closeBrowser() {
//        DriverManager.closeBrowser();
//    }
}
