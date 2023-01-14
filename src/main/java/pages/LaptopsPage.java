package pages;

import actions.Actions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import util.CustomLogger;

import java.time.Duration;

public class LaptopsPage extends Actions {

    private static final Logger LOG = CustomLogger.INSTANCE.getLogger(LaptopsPage.class);

    private final By addToCart = By.xpath("//body/div[@id='mainWrapper']/div[2]/div[2]/div[2]/div[4]/div[1]/div[2]/div[1]/a[1]/span[1]");

    public CartPage addLaptopToCart(){
        LOG.info("Add laptop to cart");
        mouseActions.clickOn(addToCart);
        wait.waitFor(Duration.ofSeconds(3));
        return new CartPage();
    }
}
