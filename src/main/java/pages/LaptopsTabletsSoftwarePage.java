package pages;

import actions.Actions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import util.CustomLogger;

public class LaptopsTabletsSoftwarePage extends Actions {

    private static final Logger LOG = CustomLogger.INSTANCE.getLogger(LaptopsTabletsSoftwarePage.class);

    private final By laptopsLaptopsButton = By.xpath("//div[contains(text(),'Laptop laptopuri')]");

    public LaptopsPage navigateToLaptopsLaptops() {
        LOG.info("Navigate to laptops");
        mouseActions.clickOn(laptopsLaptopsButton);
        return new LaptopsPage();
    }
}
