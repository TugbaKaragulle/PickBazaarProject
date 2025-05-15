package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class LoginPageTest {

    @Test
    public void TC_017_01(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert= new SoftAssert();

        allPages.loginPage().logIn(ConfigReader.getProperty("loginEmail"), ConfigReader.getProperty("loginPassword"));
        softAssert.assertTrue(allPages.loginPage().isProfileImageDisplayed());
        softAssert.assertAll();


        Driver.closeDriver();

    }
@Test
    public void TC_017_02 (ITestContext context) throws InterruptedException {
    setupBrowser(context);
    Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

    AllPages allPages = new AllPages();
    SoftAssert softAssert= new SoftAssert();
    allPages.pickBazarHomePage().clickJoinButton();
    allPages.loginPage().forgotPasswordClick();


}

    }











