package pages;

import actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import reporting.ExtentManager;
import util.CustomLogger;

public class HomePage extends Actions {

    private static final Logger LOG = CustomLogger.INSTANCE.getLogger(HomePage.class);
    private final By searchBar = By.xpath("//input[@id='keyword']");

    private final By laptopCategoryButton = By.xpath("//a[contains(text(),'Laptopuri, Tablete & Software')]");

    public HomePage searchProduct(String product) {
        LOG.info("Search product: {}", product);
        keyboardActions.clearTheText(searchBar);
        keyboardActions.typeText(searchBar, product);
        keyboardActions.typeText(searchBar, String.valueOf(Keys.ENTER));
        return this;
    }

    public LaptopsTabletsSoftwarePage navigateToLaptops(){
        LOG.info("Navigate to laptops category");
        mouseActions.clickOn(laptopCategoryButton);
        return new LaptopsTabletsSoftwarePage();
    }
}
