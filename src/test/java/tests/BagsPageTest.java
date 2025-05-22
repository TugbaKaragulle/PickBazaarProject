package tests;


import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;
import static utilities.ReusableMethods.log;

@Feature("Bags Sayfası Testleri")
public class BagsPageTest {

    @Test(groups = {"regression"})
    @Story("Dropdown menüden çanta sayfasına erişim")
    @Description("Kullanıcı bags sayfasına ulaştığında belirli text alanlarının görünürlüğü kontrol edilir.")
    @Severity(SeverityLevel.CRITICAL)
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
    @Story("Anasayfa arama alanı ve buton kontrolü")
    @Description("Text input ve search butonunun görünür olup olmadığı kontrol edilir.")
    @Severity(SeverityLevel.NORMAL)
    public void TC_011_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarBagPage_url"));
        System.out.println();
        log("Sayfada textinput görünür olduğunu doğrulanıyor..");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchTextInputDisplayed(),
                "Text input didn't seeing");
        log("Sayfada textinput görünür olduğunu doğrulandı..");
        System.out.println();
        log("Sayfada SearchButtonDisplayed görünür olduğunu doğrulanıyor..");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchButtonDisplayed()
                , "Search Button didn't seeing");
        log("Sayfada SearchButtonDisplayed görünür olduğunu doğrulandı..");
        softAssert.assertTrue(allPages.bagsPage().WhenYouSearchTextAboutBagCheckVerifyTrue()
                , "gucciHandbagImage didn't seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(groups = {"regression"})
    @Story("Teslimat seçeneklerinin kontrolü")
    @Description("Çanta sayfasındaki 3 teslimat yöntemi çerçevesinin görünür olduğu doğrulanır.")
    @Severity(SeverityLevel.MINOR)
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
    @Story("Tüm çanta ve menü elemanlarının görünürlüğü")
    @Description("Sayfadaki tüm çantaların ve menülerin eksiksiz göründüğü kontrol edilir.")
    @Severity(SeverityLevel.NORMAL)
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
