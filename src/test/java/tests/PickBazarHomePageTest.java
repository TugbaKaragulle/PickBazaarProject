package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

public class PickBazarHomePageTest {

    Logger logger = LogManager.getLogger(PickBazarHomePageTest.class);

    @Test
    public void TC_001_01() throws InterruptedException {

        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("http://shop.clarusway.net/   sayfası açıldı");

        softAssert.assertTrue(page.pickBazarHomePage().isPickBazarLogoDisplayed(), "Logo görüntülenemedi");
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

    @Test
    public void TC_001_02() {
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("http://shop.clarusway.net/   sayfası açıldı");

        logger.info("Ana ekranda PickBazar butonuna basilir ve Home Page ekranina gidilir. ");
        page.pickBazarHomePage().getPickBazarLogo().click();

    }
}
