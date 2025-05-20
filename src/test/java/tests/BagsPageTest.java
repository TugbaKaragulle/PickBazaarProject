package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;


public class BagsPageTest {
    AllPages allPages = new AllPages();
    SoftAssert softAssert=new SoftAssert();



    @Test(groups = {"smoke"})
    public void TC_011_01(ITestContext context){

        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarBagPage_url"));
        allPages.bagsPage().clickDropdownMenuAndBags();
        softAssert.assertTrue(allPages.bagsPage().isDisplayexclusiveBrandedbagsText(),
                "ExclusiveBrandedbags text is not seeing");
        softAssert.assertTrue(allPages.bagsPage().isDisplaygetYourExclusiveBrandedBagsDeliveredToYouinNoTimeText(),
                "getYourExclusiveBrandedBagsDeliveredToYouinNoTime text is not seeing");
        softAssert.assertTrue(allPages.bagsPage().isSearchAreaFrameDisplayed(),
                "search frame Area is not seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke"})
    public void TC_011_02(ITestContext context){
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarBagPage_url"));
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchTextInputDisplayed(),
                "Text input didn't seeing");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchButtonDisplayed()
                ,"Search Button didn't seeing");
        softAssert.assertTrue(allPages.bagsPage().WhenYouSearchTextAboutBagCheckVerifyTrue()
                ,"gucciHandbagImage didn't seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke"})
    public void TC_011_03(ITestContext context){
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarBagPage_url"));
        allPages.bagsPage().scrollToDeliveryImages();
        softAssert.assertTrue(allPages.bagsPage().is3frames_ExpressDelivery_CashOnDelivery_GiftVoucher_Display(),
                "Express Delivery frame,Cash On Delivery frame,Gift Voucher frame didn't seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke"})
    public void TC_011_04(ITestContext context){
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarBagPage_url"));
        allPages.bagsPage().scrollToButtonOfToBagsPage();

        softAssert.assertTrue(allPages.bagsPage().inBagsPageAllBagsIsDisplay(),
                "in bags page didn't seeing all purse some brand price or bags didnt seein");

        softAssert.assertTrue(allPages.bagsPage().inBagsPageAllMenuTypeIsDisplay(),
                "in bags page didn't seeing all menu type");

        softAssert.assertAll();
        Driver.closeDriver();
    }




}
