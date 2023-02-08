package tests.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "products")
    public Object[][] products() {
        return new Object[][]{
                {"S21"}, {"Iphone 14 Pro"}, {"Frigider"}, {"Monitor Gaming"}
        };
    }

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"raululici@yahoo.com"}, {"ParolaSmechera123"}
        };
    }

    @DataProvider(name = "shops")
    public Object[][] shops() {
        return new Object[][]{
                {"Satu Mare"}
        };
    }
}
