package tests;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.Driver;

import static utilities.Driver.setupBrowser;
//***

public class LoginProfileTest {


    @Test(groups = "regression")
    @Owner("Tugba")
    @Description("User sees their points after login.")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_021_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that the user sees their points after login.");
            softAssert.assertTrue(allPages.loginProfilePage().profilePoints(),
                    "Customer cannot see their points on the profile page.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(dataProvider = "urlData", groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Test of opening the page after clicking each profile menu item.")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_021_(ITestContext context, String data, String testCaseNo) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        try {
            Allure.step("Verifying that clicking on the '" + data + "' menu item opens the correct page.");
                softAssert.assertTrue(
                        allPages.loginProfilePage().profileDropDownMenu(data),
                        testCaseNo + " FAILED: The page '" + data + "' could not be opened");
        } catch (Exception e) {
            softAssert.fail(testCaseNo + " is failed due to an " + e.getMessage() + " exception.");
        } finally {
            Driver.closeDriver();
            softAssert.assertAll();
        }
    }
    @DataProvider(name = "urlData")
    public Object[][] urlData() {
        return new Object[][]{
                {"profile", "TC_021_02"},
                {"orders", "TC_021_03"},
                {"wishlists", "TC_021_04"},
                {"checkout", " TC_021_05"}
        };
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Test of logout")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_021_06(ITestContext context) {
        setupBrowser(context);
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Allure.step("Verifying that the user is logged out and the 'Join' button is visible.");
            softAssert.assertTrue(allPages.loginProfilePage().verifyLogoutWorks(),
                    "'Join' button is not visible after logging out.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
