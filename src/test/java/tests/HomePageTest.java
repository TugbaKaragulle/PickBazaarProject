package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;

public class HomePageTest {

    Logger logger = LogManager.getLogger(HomePageTest.class);
    WebDriver driver;




    @DataProvider(name = "urlData")
    public Object[][] urlData() {
        return new Object[][] {
                { "grocerypage_url" },
                { "bakerypage_url" },
                { "makeuppage_url" },
                {"bagspage_url" },
                { "clothingpage_url" },
                { "furniturepage_url" },
                { "dailyneedspage_url" },
                { "bookspage_url" }
        };
    }

    @Test(dataProvider = "urlData", groups = {"smoke","US_002"})
    public void TC_002_01(ITestContext context) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("http://shop.clarusway.net/   sayfası açıldı");

        logger.info("Ana ekranda PickBazar butonuna basilir ve Home Page ekranina gidilir. ");
        page.pickBazarHomePage().getPickBazarLogo().click();


        // Tüm soft assertion'ları kontrol eder
        softAssert.assertAll();


        Driver.closeDriver();
    }
    @Test(groups = {"US_001"})
    public void TC_001_03(ITestContext context){

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));


        softAssert.assertTrue( page.pickBazarHomePage().isGroceryProductFrameDisplayed() );
        softAssert.assertTrue( page.pickBazarHomePage().isGroceryMenuFrameDisplayed() );

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_001"})
    public void TC_001_02(ITestContext context) throws InterruptedException {

        setupBrowser(context);

        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??

        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        driver=Driver.getDriver();
        logger.info("http://shop.clarusway.net/   sayfası açıldı");

        softAssert.assertTrue(page.pickBazarHomePage().isExpressDeliveryImageDisplayed());
        logger.info("Express Delivery frame, Save Now button sekilde geldigi görüntülendi\n");

        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuDisplayed(), "Drop down menu görüntülenemedi.");
        logger.info("Cash On Delivery frame, Save Now button sekilde geldigi görüntülenmelidir");

        softAssert.assertTrue(page.pickBazarHomePage().isGrocerySelectedDropDownValue(), "Grocery seçili olarak görüntülenemedi");
        logger.info("Gift Voucher frame, Shop Cuopons button sekilde geldigi görüntülenmelidir");

        softAssert.assertTrue(page.pickBazarHomePage().isShopsButtonDisplayed(),"Shop butonu görüntülenemedi");
        logger.info("Shops button dogru sekilde geldigi görüntülendi");


        // Tüm soft assertion'ları kontrol eder
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(groups = {"US_001"})
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

        // Tüm soft assertion'ları kontrol eder
        softAssert.assertAll();


        Driver.closeDriver();
    }











    @Test(priority = 1, groups = "US_001")
    public void TC_001_DropdownMenuOptionClick(ITestContext context) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        String optionName="Grocery";
        page.pickBazarHomePage().clickDropDownMenuOption(optionName);
        //ReusableMethods. Driver.getDriver().getTitle()
        softAssert.assertTrue(Driver.getDriver().getTitle().contains(optionName));

        softAssert.assertAll();
        Driver.closeDriver();
    }
}
