package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;
import static utilities.ReusableMethods.*;

public class HomePageTest {

    Logger logger = LogManager.getLogger(HomePageTest.class);


    //--------------------------------US_003-------------------------------------------------------------------------//
    @Test( dataProvider = "dropDownMenuOptionsData", groups = {"smoke","US_003"})
    @Owner("Fatma")
    @Description("TC_003_03_Ana ekranda Shelf dropdown menudeki seçeneklerden ilgili sayfaların açılma testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_003_03(ITestContext context,String  optionData) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        page.pickBazarHomePage().clickDropDownMenuOption(optionData);
        softAssert.assertTrue(waitForVisibilityOfTitle(optionData),optionData +" sayfası açılamadı");
        logger.info( "Menuden "+ optionData + " seçeneğine tıklandı, "+ getDriver().getTitle() +" title ile doğrulama yapıldı ");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test( dataProvider = "dropDownMenuOptionsData", groups = {"smoke","US_003"})
    @Owner("Fatma")
    @Description("TC_003_02_Ana ekranda  Shelf dropdown menudeki seceneklerin tıklanabilirlik testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_003_02(ITestContext context,String  optionData) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuOptionClickable(optionData)," "+optionData+" tıklanamadı ");
        logger.info( optionData + " seçeneğinin tıklanabilirliği doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @DataProvider(name = "dropDownMenuOptionsData")
    public Object[][] dropDownMenuOptionsData() {
        return new Object[][] {
                { "Grocery" },
                { "Bakery" },
                { "Makeup" },
                { "Bags" },
                { "Clothing" },
                { "Furniture" },
                { "Daily Needs" },
                { "Books" }
        };
    }
    @Test( dataProvider = "dropDownMenuOptionsData", groups = {"smoke","US_003"})
    @Owner("Fatma")
    @Description("TC_003_01_Ana ekranda  Shelf dropdown menu testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_003_01(ITestContext context,String  optionData) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isGrocerySelectedDropDownValue(),"Grocery seçili gelmedi");
        logger.info("Dropdown menüde Grocery seçili olduğu doğrulandı");
        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuOptionDisplayed(optionData),optionData+" görüntülenemedi");
        logger.info("Dropdown menüde " +optionData+" görüntülendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }

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


    //--------------------------------US_002-------------------------------------------------------------------------//
    @Test( dataProvider = "urlData", groups = {"smoke","US_002"})
    @Owner("Fatma")
    @Description("TC_002_01_PickBazar butonu görüntülenip, calistigi görülmelidir")
    @Severity(SeverityLevel.NORMAL)
    public void TC_002_01(ITestContext context,String data) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty(data));

        page.pickBazarHomePage().clickPickBazarLogo();
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl= ConfigReader.getProperty("pickbazar_url");
        softAssert.assertTrue(waitForUrlContains(expectedUrl)," "+data+" ekranından Homepage ekranına gidilemedi");
        logger.info(data +" sayfasında PickBazar butonu tıklandı ve Home Page ekrani açıldı. ");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    //--------------------------------US_001-------------------------------------------------------------------------//

    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Description("TC_001_03_Home page ekraninda Scroll down yapıldığında Grocery ürünleri ve menü testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_03(ITestContext context){

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        softAssert.assertTrue( page.pickBazarHomePage().isGroceryProductFrameDisplayed() ,"Grocery ürünleri olduğu frame görüntülenemedi");
        logger.info("Ekranin Sag tarafinda Grocery ürünleri olduğu frame görüntülenir");
        softAssert.assertTrue( page.pickBazarHomePage().isGroceryMenuFrameDisplayed() ,"Grocery menü frame görüntülenemedi");
        logger.info("Ekranin Sol tarafinda Grocery menü listesinin olduğu frame görüntülenir");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Description("TC_001_02_Home page ekraninda frame testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_02(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isExpressDeliveryImageDisplayed()  ,"Express Delivery frame görüntülenemedi");
        logger.info("Express Delivery frame, Save Now button sekilde geldiği görüntülendi" );

        softAssert.assertTrue(page.pickBazarHomePage().isCashOnDeliveryImageDeliveryImageDisplayed() , "Cash On Delivery frame görüntülenemedi");
        logger.info("Cash On Delivery frame, Save Now button sekilde geldigi görüntülendi");

        softAssert.assertTrue(page.pickBazarHomePage().isGiftVoucherImageDeliveryImageDisplayed(), "Gift Voucher frame görüntülenemedi" );
        logger.info("Gift Voucher frame, Shop Cuopons button sekilde geldigi görüntülendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Description("TC_001_01_Home page ekraninda UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_01(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isPickBazarLogoDisplayed(), "Logo görüntülenemedi");
        logger.info("PickBazar logosu görüntülendi");

        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuDisplayed(), "Drop down menu görüntülenemedi.");
        logger.info("Sol üstte dropdown menü görüntülendi");

        softAssert.assertTrue(page.pickBazarHomePage().isGrocerySelectedDropDownValue(), "Grocery seçili olarak görüntülenemedi");
        logger.info("Sol üstte dropdown menü otomatik olarak Grocery secili geldiği görüntülendi");

        softAssert.assertTrue(page.pickBazarHomePage().isShopsButtonDisplayed(),"Shop butonu görüntülenemedi");
        logger.info("Shops button dogru sekilde geldigi görüntülendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
}
