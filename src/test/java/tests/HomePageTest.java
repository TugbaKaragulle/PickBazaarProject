package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class HomePageTest {

    Logger logger = LogManager.getLogger(HomePageTest.class);
    WebDriver driver;


    @Test(priority = 1, groups = "smoke")
    public void TC_001_01(ITestContext context) throws InterruptedException {

        setupBrowser(context);

        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??

        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        driver=Driver.getDriver();
        logger.info("http://shop.clarusway.net/   sayfası açıldı");

        softAssert.assertTrue(page.pickBazarHomePage().isPickBazarLogoDisplayed(driver), "Logo görüntülenemedi");
        logger.info("PickBazar logosu görüntülendi");

        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuDisplayed(), "Drop down menu görüntülenemedi.");
        logger.info("Sol üstte dropdown menü görüntülendi");

        softAssert.assertTrue(page.pickBazarHomePage().isGrocerySelectedDropDownValue(), "Grocery seçili olarak görüntülenemedi");
        logger.info("Sol üstte dropdown menü otomatik olarak \"Grocery\" secili sekilde geldigi görüntülendi");

        softAssert.assertTrue(page.pickBazarHomePage().isShopsButtonDisplayed(),"Shop butonu görüntülenemedi");
        logger.info("Shops button dogru sekilde geldigi görüntülendi");


        Thread.sleep(3000);

        // Tüm soft assertion'ları kontrol eder
        softAssert.assertAll();


        Driver.closeDriver();
    }

    @Test(priority = 1, groups = "smoke")
    public void TC_001_02(ITestContext context) {

        setupBrowser(context);

        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("http://shop.clarusway.net/   sayfası açıldı");

        logger.info("Ana ekranda PickBazar butonuna basilir ve Home Page ekranina gidilir. ");
        page.pickBazarHomePage().getPickBazarLogo().click();

    }
}
