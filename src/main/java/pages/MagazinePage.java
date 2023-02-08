package pages;

import actions.Actions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import util.CustomLogger;

public class MagazinePage extends Actions {

    private static final Logger LOG = CustomLogger.INSTANCE.getLogger(ProdusePage.class);

    private final By searchBarMagazine = By.xpath("//input[@id='filter']");
    private final By enterShop = By.xpath("//body/div[2]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[118]/a[1]");

    public MagazinePage searchShop(String shop) {
        keyboardActions.typeText(searchBarMagazine, shop);
        mouseActions.clickOn(enterShop);
        return new MagazinePage();
    }
}
