package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JavascriptUtils;

import static utilities.Driver.setupBrowser;

public class BasketPageTest {

    @Test(groups = {"US_018"})
    public void TC_018_01(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        JavascriptUtils.scrollIntoViewJS(page.pickBazarHomePage().getProductFrame());


        softAssert.assertAll();
        Driver.closeDriver();
    }
}

