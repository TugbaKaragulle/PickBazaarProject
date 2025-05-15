package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.Driver.setupBrowser;

public class LoginProfileTest {

    SoftAssert softAssert = new SoftAssert();


    @Test(priority = 1, groups = "smoke")
    public void TC_021_01(ITestContext context) {

        setupBrowser(context);
        AllPages allPages = new AllPages();
        softAssert.assertTrue(allPages.loginProfilePage().profilePoints());
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
