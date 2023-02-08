package pages;

import actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import reporting.ExtentManager;
import util.CustomLogger;

public class HomePage extends Actions {

    private static final Logger LOG = CustomLogger.INSTANCE.getLogger(HomePage.class);
    private final By searchBar = By.xpath("//input[@id='searchingfield']");

    private final By ProduseButton = By.xpath("//header/div[1]/div[1]/div[6]/button[1]");
    private final By MagazineButton = By.xpath("//body/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    private final By TelefoaneTableteButton = By.xpath("//body/div[2]/section[2]/div[1]/nav[1]/ul[1]/li[1]/a[1]/figure[2]");
    private final By TelefoaneButton = By.xpath("//body/div[2]/section[2]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
    private final By Login = By.xpath("//span[contains(text(),'Contul meu')]");
    private final By EmailInput = By.xpath("//header/div[1]/div[1]/div[5]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]");
    private final By PasswordInput = By.xpath("//input[@id='pass2']");
    private final By EnterLogin = By.xpath("//button[@id='sendd']");

    public HomePage ProduseButton() {
        LOG.info("Navigate to laptops");
        mouseActions.clickOn(ProduseButton);
        return this;
    }

    public MagazinePage MagazineButton() {
        LOG.info("Navigate to magazine");
        mouseActions.clickOn(MagazineButton);
        return new MagazinePage();
    }

    public HomePage TelefoaneTableteButton() {
        LOG.info("Navigate to laptops");
        mouseActions.clickOn(TelefoaneTableteButton);
        return this;
    }

    public ProdusePage TelefoaneButton() {
        LOG.info("Navigate to laptops");
        mouseActions.clickOn(TelefoaneButton);
        return new ProdusePage();
    }

    public HomePage Login() {
        LOG.info("Logare pe flanco");
        mouseActions.clickOn(Login);
        return this;
    }

    public HomePage credentialsInput(String credentials) {
        LOG.info("Input", credentials);
        keyboardActions.typeText(EmailInput, credentials);
        keyboardActions.typeText(PasswordInput, credentials);
        mouseActions.clickOn(EnterLogin);
        return this;
    }

    public HomePage searchProduct(String product) {
        LOG.info("Search product: {}", product);
        keyboardActions.clearTheText(searchBar);
        keyboardActions.typeText(searchBar, product);
        keyboardActions.typeText(searchBar, String.valueOf(Keys.ENTER));
        return this;
    }




}
