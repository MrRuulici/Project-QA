package tests.products;

import config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.dataProviders.DataProviders;

public class Products extends BaseTest {

    @Test(description = "search Product", dataProvider = "products", dataProviderClass = DataProviders.class,
            groups = {"Products", "smoke"})
    public void searchProduct(String product) {
        homePage
                .searchProduct(product);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(product));
    }
}
