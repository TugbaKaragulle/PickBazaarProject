package tests;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.Driver.*;
import static utilities.ReusableMethods.*;

@Feature("Home Page Testleri")
public class HomePageTest {

    //--------------------------------US_003-------------------------------------------------------------------------//
    @Test( dataProvider = "dropDownMenuOptionsData", groups = {"regression","US_003"})
    @Owner("Fatma")
    @Story("TC_003_04_DataProvider Testi - Ana ekranda Shelf dropdown menudeki seçeneklerden ilgili sayfaların açılma testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_003_04_DataProvider(ITestContext context,String  optionData) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        page.pickBazarHomePage().clickDropDownMenuOption(optionData);
        softAssert.assertTrue(waitForVisibilityOfTitle(optionData),optionData +" sayfası açılamadı");
        Allure.step( "Menuden "+ optionData + " seçeneğine tıklandı, "+ getDriver().getTitle() +" title ile doğrulama yapıldı ");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test( dataProvider = "dropDownMenuOptionsData", groups = {"regression","US_003"})
    @Owner("Fatma")
    @Story("TC_003_03_DataProvider Testi - Ana ekranda  Shelf dropdown menudeki seceneklerin tıklanabilirlik testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_003_03_DataProvider(ITestContext context,String  optionData) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuOptionClickable(optionData)," "+optionData+" tıklanamadı ");
        Allure.step( optionData + " seçeneğinin tıklanabilirliği doğrulandı");

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
    @Test( dataProvider = "dropDownMenuOptionsData", groups = {"regression","US_003"})
    @Owner("Fatma")
    @Story("TC_003_02_DataProvider Testi - Ana ekranda  Shelf dropdown menu testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_003_02_DataProvider(ITestContext context,String  optionData) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuOptionDisplayed(optionData),optionData+" goruntulenemedi");
        Allure.step("Dropdown menüde " +optionData+" goruntulendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test( dataProvider = "dropDownMenuOptionsData", groups = {"regression","US_003"})
    @Owner("Fatma")
    @Story("TC_003_01_DataProvider Testi - Ana ekranda  Shelf dropdown menu testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_003_01_DataProvider(ITestContext context,String  optionData) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isGrocerySelectedDropDownValue(),"Grocery seçili gelmedi");
        Allure.step("Dropdown menüde Grocery seçili olduğu doğrulandı");

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
    @Test( dataProvider = "urlData", groups = {"regression","US_002"})
    @Owner("Fatma")
    @Story("TC_002_01_DataProvider Testi - PickBazar butonu görüntülenip, calistigi görülmelidir")
    @Severity(SeverityLevel.NORMAL)
    public void TC_002_01_DataProvider(ITestContext context,String data) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty(data));

        page.pickBazarHomePage().clickPickBazarLogo();
        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl= ConfigReader.getProperty("pickbazar_url");
        softAssert.assertTrue( page.pickBazarHomePage().isPickbazarButtonNavitages(expectedUrl, data) ," "+data+" ekranından Homepage ekranına gidilemedi" );

        Allure.step(data +" sayfasında PickBazar butonu tıklandı ve Home Page ekrani açıldı. ");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    //--------------------------------US_001-------------------------------------------------------------------------//
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_09_Home page ekraninda Scroll down yapıldığında Grocery ürünleri ve menü testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_09(ITestContext context){

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue( page.pickBazarHomePage().isGroceryMenuFrameDisplayed() ,"Grocery menü frame goruntulenemedi");
        Allure.step("Ekranin Sol tarafinda Grocery menü listesinin olduğu frame görüntülenir");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_08_Home page ekraninda Scroll down yapıldığında Grocery ürünleri ve menü testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_08(ITestContext context){

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue( page.pickBazarHomePage().isGroceryProductFrameDisplayed() ,"Grocery ürünleri olduğu frame goruntulenemedi");
        Allure.step( "Ekranin Sag tarafinda Grocery ürünleri olduğu frame görüntülenir");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_07_Home page ekraninda frame testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_07(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isGiftVoucherImageDeliveryImageDisplayed(), "Gift Voucher frame goruntulenemedi" );
        Allure.step("Gift Voucher frame, Shop Cuopons button sekilde geldigi goruntulendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_06_Home page ekraninda frame testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_06(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isCashOnDeliveryImageDeliveryImageDisplayed() , "Cash On Delivery frame goruntulenemedi");
        Allure.step("Cash On Delivery frame, Save Now button sekilde geldigi goruntulendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_05_Home page ekraninda frame testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_05(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isExpressDeliveryImageDisplayed()  ,"Express Delivery frame goruntulenemedi");
        Allure.step("Express Delivery frame, Save Now button sekilde geldiği goruntulendi" );

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_04_Home page ekraninda UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_04(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isShopsButtonDisplayed(),"Shop butonu goruntulenemedi");
        Allure.step("Shops button dogru sekilde geldigi goruntulendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_03_Home page ekraninda UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_03(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isGrocerySelectedDropDownValue(), "Grocery seçili olarak goruntulenemedi");
        Allure.step("Sol üstte dropdown menü otomatik olarak Grocery secili geldiği goruntulendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_02_Home page ekraninda UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_02(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isDropDownMenuDisplayed(), "Drop down menu goruntulenemedi.");
        Allure.step("Sol üstte dropdown menü goruntulendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test(groups = {"smoke","US_001"})
    @Owner("Fatma")
    @Story("TC_001_01_Home page ekraninda UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_001_01(ITestContext context) throws InterruptedException {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();//??
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        softAssert.assertTrue(page.pickBazarHomePage().isPickBazarLogoDisplayed(), "Logo goruntulenemedi");
        Allure.step("PickBazar logosu goruntulendi");

        softAssert.assertAll();
        Driver.closeDriver();
    }
}
