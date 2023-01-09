package pages;

import actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends Actions {

    private final By searchBar = By.xpath("//input[@id='keyword']");
    private final By geniusButton = By.xpath("//a[contains(text(),'Genius')]");

    public HomePage searchProduct(String product){
        keyboardActions.clearTheText(searchBar);
        keyboardActions.typeText(searchBar, product);
        keyboardActions.typeText(searchBar, String.valueOf(Keys.ENTER));
        return this;
    }

//    public GeniusPage clickOnGeniusButton(){
//        mouseActions.clickOn(geniusButton);
//        return new GeniusPage();
//    }
}
