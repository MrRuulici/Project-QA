package tests.filteredSearch;

import actions.WaitStrategy;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

import java.time.Duration;

public class FilteredSearchPhones extends BaseTest {

    @Test(description = "Filter search")
    public void addProducts() {
        homePage
                .ProduseButton()
                .TelefoaneTableteButton()
                .TelefoaneButton()
                .FilterProducts();

        WaitStrategy.waitFor(Duration.ofSeconds('4'));

    }
}
