package tests;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JavascriptUtils;

import static utilities.Driver.setupBrowser;

public class ClothingPageTest {


    @Test(groups = {"smoke", "regression"})
    @Owner("Sengul")
    @Description("Clothing Page Test")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_012_01(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        allPages.pickBazarHomePage().clickDropDownMenuOption("Clothing");
        softAssert.assertTrue(allPages.clothingPage().isClothingHeaderDisplayed());
        softAssert.assertTrue(allPages.clothingPage().isClothingSubHeaderDisplayed());
        allPages.clothingPage().searchFieldSendKey("Dress");
        allPages.clothingPage().searchButtonClick();
        softAssert.assertTrue(allPages.clothingPage().productControl("Dress"));
        Allure.step("Clothing page is working");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test
    public void TC_012_02(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        allPages.pickBazarHomePage().clickDropDownMenuOption("Clothing");
        softAssert.assertTrue(allPages.clothingPage().swiperListControl());
        Allure.step("Clothing Page list control");
        Driver.closeDriver();

    }

    @Test
    public void TC_012_03(ITestContext context) throws InterruptedException {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        allPages.pickBazarHomePage().clickDropDownMenuOption("Clothing");

        Thread.sleep(3000);
        JavascriptUtils.scrollDownByJS();
        Thread.sleep(3000);
        softAssert.assertTrue(allPages.clothingPage().clothTypeListControl("Women Dress"));
        softAssert.assertTrue(allPages.clothingPage().clothTypeListControl("Outer Wear"));
        softAssert.assertTrue(allPages.clothingPage().clothTypeListControl("Pants"));
        softAssert.assertTrue(allPages.clothingPage().clothTypeListControl("Tops"));
        softAssert.assertTrue(allPages.clothingPage().clothTypeListControl("Skirts"));
        softAssert.assertTrue(allPages.clothingPage().clothTypeListControl("Shirts"));
        Allure.step("Clothing Type List is working");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}

