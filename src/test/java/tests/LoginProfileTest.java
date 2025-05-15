package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class LoginProfileTest {
    Logger logger = LogManager.getLogger(LoginProfileTest.class);

    @Test(priority = 1, groups = "smoke")
    public void TC_021_01(ITestContext context) {

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);

        softAssert.assertTrue(allPages.loginProfilePage().profilePoints());
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(dataProvider = "urlData")
    public void TC_021_02_03_04_05(ITestContext context, String data){

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        try {
            setupBrowser(context);
            boolean isVisible = allPages.loginProfilePage().profileDropDownMenu(data);
            logger.info(data + " görünür mü?: " + isVisible);
            softAssert.assertTrue(isVisible, data + " görünür değil!");
        } finally {
            Driver.closeDriver();
        }

        softAssert.assertAll();
    }

    @DataProvider(name = "urlData")
    public Object[][] urlData() {
        return new Object[][] {
                { "profile" },
                { "orders" },
                { "wishlists" },
                { "checkout" }
        };
    }

    @Test()
    public void TC_021_06(ITestContext context) {
        setupBrowser(context);
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(allPages.loginProfilePage().verifyLogoutWorks());
        softAssert.assertAll();
        Driver.closeDriver();
    }

}
