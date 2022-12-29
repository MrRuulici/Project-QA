package tests.products;

import config.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class Products extends BaseTest {

    @Test
    public void searchProduct() {
        DriverManager.getDriver().findElement(By.xpath("//input[@id='searchboxTrigger']")).sendKeys("iPhone13 Pro Max");
        DriverManager.getDriver().findElement(By.xpath("//input[@id='searchboxTrigger']")).sendKeys(Keys.ENTER);
        Assert.assertTrue( DriverManager.getDriver().getCurrentUrl().contains("iPhone"));
    }
}
