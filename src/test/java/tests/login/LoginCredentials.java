package tests.login;

import actions.WaitStrategy;
import config.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.dataProviders.DataProviders;

import java.time.Duration;

public class LoginCredentials extends BaseTest {
    @Test(description = "Login", dataProvider = "credentials", dataProviderClass = DataProviders.class,
            groups = {"Credentials", "smoke"})
    public void addProducts(String credentials) {
        homePage
                .Login()
                .credentialsInput(credentials);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(credentials));

        WaitStrategy.waitFor(Duration.ofSeconds('4'));

    }
}
