package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class LoginPageTest {

    @Test(groups = {"smoke", "regression"})
    @Owner("Sengul")
    @Description("LoginPage Test")
    @Severity(SeverityLevel.CRITICAL)



    public void TC_017_01(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        Allure.step("URL");
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        allPages.loginPage().logIn(ConfigReader.getProperty("loginEmail"), ConfigReader.getProperty("loginPassword"));
        softAssert.assertTrue(allPages.loginPage().isProfileImageDisplayed());
        softAssert.assertAll();


        Driver.closeDriver();

    }

    @Test
    public void TC_017_02(ITestContext context) throws InterruptedException {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        allPages.pickBazarHomePage().clickJoinButton();
        Allure.step("JoinButton is clicked ");
        allPages.loginPage().forgotPasswordClick();
        Allure.step("forgotPassword is clicked");
        allPages.loginPage().sendEmail();
        Allure.step("Email sent");
        allPages.loginPage().submitEmailClick();

        softAssert.assertTrue(allPages.loginPage().passwordChangeSuccessfully());

        softAssert.assertAll();
        Driver.closeDriver();


    }

    @Test
    public void TC_017_03(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        allPages.pickBazarHomePage().clickJoinButton();
        allPages.loginPage().sendPassword();
        allPages.loginPage().isEyeImageDisplayed();
        softAssert.assertTrue(allPages.loginPage().isEyeImageDisplayed());
        softAssert.assertAll();
        Allure.step("password is invisible");

        Driver.closeDriver();
    }

    @Test
    public void TC_017_04(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        allPages.pickBazarHomePage().clickJoinButton();
        allPages.loginPage().googleLoginClick();
        softAssert.assertFalse(allPages.loginPage().googleErrorMessageIsdisplayed(), "Login olunamadi");
        Allure.step("Google Error Message is displayed  ");
        softAssert.assertAll();
        Driver.closeDriver();

    }
    @Test
    public void TC_017_05(ITestContext context){
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        allPages.pickBazarHomePage().clickJoinButton();
        allPages.loginPage().loginWithMobileButtonClick();
        allPages.loginPage().sendTelNumber();
        allPages.loginPage().sendOPTClick();
        allPages.loginPage().sendOPTCode();
        allPages.loginPage().verifyCodeButtonClick();
        softAssert.assertTrue(allPages.loginPage().isProfileImageDisplayed());
        Allure.step("Profile Image is Displayed");
        softAssert.assertAll();


        Driver.closeDriver();
    }







}









