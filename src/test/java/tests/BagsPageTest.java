package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;


public class BagsPageTest {



    @Test(groups = {"regression"})
    public void TC_011_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();

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

    @Test(groups = {"regression"})
    public void TC_011_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Logger logger = LogManager.getLogger(BagsPageTest.class);
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarBagPage_url"));
        System.out.println();
        logger.info("\u001B[31mSayfada textinput görünür olduğunu doğrulanıyor..\u001B[0m");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchTextInputDisplayed(getDriver()),
                "Text input didn't seeing");
        logger.info("\u001B[31mSayfada textinput görünür olduğunu doğrulandı..\u001B[0m");
        System.out.println();
        logger.info("\u001B[31mSayfada SearchButtonDisplayed görünür olduğunu doğrulanıyor..\u001B[0m");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchButtonDisplayed(getDriver())
                , "Search Button didn't seeing");
        logger.info("\u001B[31mSayfada SearchButtonDisplayed görünür olduğunu doğrulandı..\u001B[0m");
        softAssert.assertTrue(allPages.bagsPage().WhenYouSearchTextAboutBagCheckVerifyTrue()
                , "gucciHandbagImage didn't seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression"})
    public void TC_011_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarBagPage_url"));
        allPages.bagsPage().scrollToDeliveryImages();
        softAssert.assertTrue(allPages.bagsPage().is3frames_ExpressDelivery_CashOnDelivery_GiftVoucher_Display(),
                "Express Delivery frame,Cash On Delivery frame,Gift Voucher frame didn't seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression"})
    public void TC_011_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
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
