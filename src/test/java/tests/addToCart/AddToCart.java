package tests.addToCart;

import actions.WaitStrategy;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.time.Duration;

public class AddToCart extends BaseTest {

    @Test(description = "Add Products To Cart")
    public void addProducts() {
        homePage
                .ProduseButton()
                .TelefoaneTableteButton()
                .TelefoaneButton()
                .ProduseButton();

        WaitStrategy.waitFor(Duration.ofSeconds('4'));

    }
}

