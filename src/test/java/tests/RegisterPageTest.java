package tests;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.setupBrowser;

public class RegisterPageTest {


    @Test(groups = {"smoke", "regression"})
    @Owner("Sengul")
    @Description("Register Page mandontary fields test")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_016_01(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        allPages.pickBazarHomePage().clickJoinButton();
        Allure.step("Join Button is clicked");
        allPages.registerPage().registerLinkClick();
        Allure.step("Register Link is clicked");
        allPages.registerPage().registerButtonClick();
        Allure.step("register Button is Click");
        softAssert.assertTrue(allPages.registerPage().nameFieldMissingMessageIsDisplayed());
        Allure.step("name Field Missing Message Is Displayed");
        softAssert.assertTrue(allPages.registerPage().emailMissingMessageIsDisplayed());
        Allure.step("email Missing Message Is Displayed");
        softAssert.assertTrue(allPages.registerPage().passwordMissingMessageIsDisplayed());
        Allure.step("password Missing Message IsD isplayed");
        softAssert.assertTrue(allPages.registerPage().alreadyHaveAnAccountMessageIsDisplayed());
        Allure.step("already Have An Account Message Is Displayed");

        softAssert.assertAll();
        Driver.closeDriver();
    }
}