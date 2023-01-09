package tests.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "products")
    public Object[][] products() {
        return new Object[][]{
                {"samsung"}, {"iphone"}, {"motorola"}, {"huawei"}
        };
    }
}
