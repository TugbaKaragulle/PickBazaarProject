package tests;

import io.qameta.allure.*;
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
//***

public class LoginProfileTest {
    Logger logger = LogManager.getLogger(LoginProfileTest.class);


    @Test(groups = "smoke")
    @Owner("Tugba")
    @Description("Deneme Description")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_021_01(ITestContext context) {

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        setupBrowser(context);
        Allure.step("Müsteri Points yazan yerde puanini görüntülüyor");
        //logger.info("Müsteri Points yazan yerde puanini görüntülüyor");
        softAssert.assertTrue(allPages.loginProfilePage().profilePoints());
        Allure.step("Müsteri Points yazan yerde puanini görüntüledi");
        //logger.info("Müsteri Points yazan yerde puanini görüntüledi");
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(dataProvider = "urlData", groups = "smoke")
    public void TC_021(ITestContext context, String data, String testCaseNo){

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        setupBrowser(context);
        logger.info(testCaseNo+ " is in progress");
        try {
            softAssert.assertTrue(allPages.loginProfilePage().profileDropDownMenu(data));
        } catch (Exception e) {
            Driver.closeDriver();
            softAssert.fail(testCaseNo+" is failed");
        }
        Driver.closeDriver();
        softAssert.assertAll();

    }

    @DataProvider(name = "urlData")
    public Object[][] urlData() {
        return new Object[][] {
                { "profile", "TC_021_02" },
                { "orders", "TC_021_03" },
                { "wishlists", "TC_021_04" },
                { "checkout", " TC_021_05" }
        } ;
    }

    @Test(groups = "smoke")
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
