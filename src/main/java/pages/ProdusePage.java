package pages;

import actions.Actions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import util.CustomLogger;

public class ProdusePage extends Actions {

    private static final Logger LOG = CustomLogger.INSTANCE.getLogger(ProdusePage.class);

    private final By ProduseButton = By.xpath("//div[2]/main[1]/div[3]/div[1]/div[1]/div[3]/div[2]/ol[1]/li[1]/div[1]/div[3]/div[3]/div[1]/div[1]/form[1]/button[1]");
    private final By PriceFilterButton = By.xpath("//body[1]/div[2]/main[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/ul[1]/li[3]/a[1]/label[1]");
    private final By BrandFilterButton = By.xpath("//body[1]/div[2]/main[1]/div[3]/div[2]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]/label[1]");
    public ProdusePage ProduseButton() {
        LOG.info("add phone to cart");
        mouseActions.clickOn(ProduseButton);
        return this;
    }

    public ProdusePage FilterProducts() {
        LOG.info("filter products");
        mouseActions.clickOn(PriceFilterButton);
        mouseActions.clickOn(BrandFilterButton);
        return this;
    }

}
