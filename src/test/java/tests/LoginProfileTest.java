package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;

public class LoginProfileTest {
    Logger logger = LogManager.getLogger(LoginProfileTest.class);

    @Test(priority = 1, groups = "smoke")
    public void TC_021_01(ITestContext context) {

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        setupBrowser(context);
        logger.info("Müsteri Points yazan yerde puanini görüntülüyor");
        softAssert.assertTrue(allPages.loginProfilePage().profilePoints());
        logger.info("Müsteri Points yazan yerde puanini görüntüledi");
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(dataProvider = "urlData")
    public void TC_021_02_03_04_05(ITestContext context, String data){

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
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
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Logout'a tiklaninca join butonunun görünür oldugu dogrulaniyor");
        softAssert.assertTrue(allPages.loginProfilePage().verifyLogoutWorks());
        logger.info("Logout'a tiklaninca join butonunun görünür oldugu dogrulandi");
        softAssert.assertAll();
        Driver.closeDriver();
    }

}
