package tests;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class LoginProfileTest {

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
        setupBrowser(context);
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();

   softAssert.assertTrue(allPages.loginProfilePage().profileDropDownMenu(data));
   Driver.closeDriver();
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
        Driver.closeDriver();
    }

}
