package tests.searchShop;

import actions.WaitStrategy;
import config.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.dataProviders.DataProviders;

import java.time.Duration;

public class ShopSearchSM extends BaseTest {

    @Test(description = "Shearch Shops", dataProvider = "shops", dataProviderClass = DataProviders.class,
            groups = {"Shops", "smoke"})
    public void searchShop(String shops) {
        homePage
                .MagazineButton()
                .searchShop(shops);
                Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(shops));
        WaitStrategy.waitFor(Duration.ofSeconds('9'));

    }
}
