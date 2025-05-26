package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import javax.swing.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;

@Feature("Sepet Sayfası Testleri")
public class BasketPageTest {

    int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_16_Daily Needs ekranında sepet UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_16(ITestContext context) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("dailyneedspage_url"));
        Allure.step("Daily Needs Page sayfası açıldı");

        page.basketPage().clickBasketButtonInDailyNeeds();
        Allure.step("Daily Needs ekranında  sepet paneli açıldı");

        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(page.basketPage().getCheckoutButton()));
        Allure.step("Checkout butonunun görünürlüğü doğrulandı");

        softAssert.assertTrue(ReusableMethods.waitForClickability(page.basketPage().getCheckoutButton()));
        Allure.step("Checkout butonunun tıklanılabilirliği doğrulandı");


        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_15_Daily Needs ekranında sepet UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_15(ITestContext context) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("dailyneedspage_url"));
        Allure.step("Daily Needs Page sayfası açıldı");

        page.dailyNeedsPage().openBasketPanel();
        Allure.step("Daily Needs ekranında  sepet ikonuna tıkandı");

        softAssert.assertTrue(page.basketPage().isVisibleBasketPanel());
        Allure.step("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı, sayfanın açıldığı doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_14_Daily Needs ekranında sepet UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_14(ITestContext context) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("dailyneedspage_url"));
        Allure.step("Daily Needs Page sayfası açıldı");

        softAssert.assertTrue(page.dailyNeedsPage().isVisibleBasketIcon());
        Allure.step("Daily Needs ekranında basket ikonunun görünürlüğü doğrulandı ");

        softAssert.assertTrue(page.dailyNeedsPage().isClickableBasketIcon(), "");
        Allure.step("Daily Needs ekranında basket ikonunun tıklanılabilirliği doğrulandı ");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_13_Sepet ekranında login olarak sepet UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_13(ITestContext context) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        Allure.step("Makeup Page sayfası açıldı");

        page.loginPage().logIn(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
        page.basketPage().openBasketPanel();
        ReusableMethods.waitForSeconds(5);
        Allure.step("Makeup ekranında  sepet paneli açıldı");
        page.basketPage().clickCheckoutButton();
        Allure.step("Checkout butonuna tıklandı");

        softAssert.assertTrue(ReusableMethods.waitForUrlContains("checkout"), "");
        Allure.step("Checkout sayfasının açıldığı doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_12_Sepet ekranında login olmadan önceki sepet UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_12(ITestContext context) {

        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        Allure.step("Makeup Page sayfası açıldı");

        //logout olma durumu kontrolü edilip, Teste devam edilir
        page.basketPage().isLoggedOut();

        page.basketPage().openBasketPanel();
        Allure.step("Makeup ekranında  sepet paneli açıldı");
        page.basketPage().clickCheckoutButton();
        Allure.step("Checkout butonuna tıklandı");

        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(page.loginPage().getLogInButton()), "");
        Allure.step("Login sayfasının açıldığı doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_11_Sepet ekranında ilk üründe (x) işaretine tıklanarak silme testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_11(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        Allure.step("Makeup Page sayfası açıldı");

        int times = 3;  //aynı üründen kaç tane eklensin

        page.makeUpPage().addProductIntoBasketwithJS(page, indexofList, times);
        Allure.step("Precondition şartı için Sepete ilgili indexteki üründen " + times + " adet eklendi.");

        page.makeUpPage().addProductIntoBasketwithJS(page, 1, 2);
        Allure.step("Precondition şartı için Sepete ilgili indexteki üründen 2 adet eklendi.");

        String nameOfIndexedProduct = page.basketPage().getProductNameInBasket(indexofList);  //silmeden önce ilgili indexteki ürün adı depolanır
        boolean isProductDeleted = page.basketPage().deleteAProductFromBasketXButton(indexofList);
        Allure.step("Açılan sepet ekranında,ilgili indexteki ürünü silmek için 'X' butonuna tıklandı. ");

        try {
            softAssert.assertTrue(isProductDeleted, "");
            Allure.step("Ürün silindi. Silinen ürün = " + nameOfIndexedProduct);
        } catch (Exception e) {
            Allure.step("ürün X butonu ile silinemedi.");
        }

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_10_Sepet ekranında ilk üründe (-) işaretine tıklanarak silme-tutar testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_10(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        Allure.step("Makeup Page sayfası açıldı");

        int times = 3;  //aynı üründen kaç tane eklensin
        page.makeUpPage().addProductIntoBasketwithJS(page, indexofList, times);
        Allure.step("Precondition şartı için Sepete ilgili indexteki üründen " + times + " adet eklendi.");

        page.basketPage().openBasketPanel();
        Allure.step("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");


        int expectedNumberOfOneProductNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList) - 1;  //beklenen ürün sayısı
        page.basketPage().deleteAProductFromBasketWithMinusIcon(indexofList);
        Allure.step("Açılan sepet ekranında,ürün eksiltmek eklemek için  (-) işaretine tıklandı");

        int actualNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);  //şuan varolan ürün sayısı
        int priceOfOneProduct = page.basketPage().getPriceOfOneProduct(indexofList);  //bir ürünün 1 adet sayısınca hesaplanan tutarı


        softAssert.assertEquals(page.basketPage().getTotalPriceOfOneProduct(indexofList), priceOfOneProduct * actualNumberOfOneProduct, "");
        Allure.step("Sepetteki ürün tutarı hesaplanan tutar ile eşleşiyor . Hesaplanan tutar = " + priceOfOneProduct * actualNumberOfOneProduct);

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_09_Sepet ekranında ilk üründe (-) işaretine tıklanarak silme-adet testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_09(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        Allure.step("Makeup Page sayfası açılır");

        int times = 3;  //aynı üründen kaç tane eklensin

        page.makeUpPage().addProductIntoBasketwithJS(page, indexofList, times);
        Allure.step("Precondition şartı için Sepete ilgili indexteki üründen " + times + " adet eklendi.");

        page.basketPage().openBasketPanel();
        Allure.step("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");

        int expectedNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList) - 1;  //beklenen şuan varolan ürün sayısının 1 eksilmesi

        page.basketPage().deleteAProductFromBasketWithMinusIcon(indexofList);
        Allure.step("Açılan sepet ekranında,ürün eksiltmek eklemek için (-) işaretine tıklandı");

        int actualNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);

        softAssert.assertEquals(actualNumberOfOneProduct, expectedNumberOfOneProduct, "");
        Allure.step("Sepetteki ürün adeti sayısı 1 eksildi -> ürün adeti 1 olduğu doğrulandı");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_08_Sepet ekranında ilk üründe (+) işaretine tıklanarak eklenme-tutar testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_08(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        Allure.step("Makeup Page sayfası açılır");


        page.makeUpPage().addProductIntoBasket(page, indexofList);
        Allure.step("Sepete precondition şartı için bir ürün eklendi.");

        page.basketPage().openBasketPanel();
        Allure.step("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");

        page.basketPage().addAProductIntoBasketWithPlusIcon(indexofList);
        Allure.step("Açılan sepet ekranında, ürün sepete eklemek için " + " işaretine tıklandı");

        int expectedPriceOfOneProduct = page.basketPage().getPriceOfOneProduct(indexofList);  //bir ürünün tutarı
        int expectedNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);  //bir üründen alınan adet sayısı

        softAssert.assertEquals(page.basketPage().getTotalPriceOfOneProduct(indexofList), expectedPriceOfOneProduct * expectedNumberOfOneProduct, "");
        Allure.step("Sepetteki ürün tutarı hesaplanan tutar ile eşleşiyor . Hesaplanan tutar = " + expectedPriceOfOneProduct * expectedNumberOfOneProduct);

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_07_Sepet ekranında ilk üründe (+) işaretine tıklanarak eklenme-adet testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_07(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        Allure.step("Makeup Page sayfası açılır");

        page.makeUpPage().addProductIntoBasket(page, indexofList);
        Allure.step("Sepete precondition şartı için bir ürün eklendi.");
        page.basketPage().openBasketPanel();
        Allure.step("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");
        int expectedNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList) + 1;  //beklenen şuan varolan ürün sayısına 1 eklenmesi
        page.basketPage().addAProductIntoBasketWithPlusIcon(indexofList);
        int actualNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);
        Allure.step("Açılan sepet ekranında, ürün sepete eklemek için " + " işaretine tıklanır");

        softAssert.assertEquals(actualNumberOfOneProduct, expectedNumberOfOneProduct, "");
        Allure.step("Sepetteki ürün adeti sayısı 1 arttı -> ürün adeti 2 olduğu doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_06_Sepet ekranında Items satırındaki x işareti testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_06(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        page.basketPage().openBasketPanel();
        page.basketPage().closeBasketPage();
        softAssert.assertTrue(page.basketPage().isBasketPanelClosed(), "Sepet paneli kapanmadı!");
        Allure.step("Basket paneli kapandı");


        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_05_Anasayfada kücük ekranda sepet bilgisi gelmesi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_05(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        page.basketPage().openBasketPanel();
        softAssert.assertTrue(page.basketPage().isNoProductFoundTextVisible(), "");
        Allure.step(page.basketPage().getNoProductFoundHeader() + " metninin görünürlüğü doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_04_Anasayfada kücük ekranda sepet bilgisi gelmesi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_04(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        page.basketPage().openBasketPanel();
        softAssert.assertTrue(page.basketPage().isVisibleBasketPanel(), "Basket Paneli açılmadı.");
        Allure.step("Basket Paneli açıldığı doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_03_Ürün Listesi ekranında sepete ürün ekleme UI testi")
    @Description("Ürün Listesi ekranında sepete aynı ürün 2 tane eklendiğinde sepet butoundaki sayı 1 olarak kalıyor. Bug kaydı mevcut  Jira -> TC_018_03_BUG")
    @Severity(SeverityLevel.CRITICAL)   //bug kaydı mevcut  Jira -> TC_018_03_BUG
    public void TC_018_03(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        page.makeUpPage().addProductIntoBasket(page, indexofList);//preconditon şartı için 1 ürün eklenir.
        page.makeUpPage().addAProductIntoBasketWithPlusIcon(page, indexofList);
        int numberOfItemsInBasketButton = page.basketPage().getNumberOfItemsInBasketButton();
        int numberOfItemsInProductFrame = page.makeUpPage().getNumberOfProductAddedToBasket(indexofList);
        System.out.println("numberOfItemsInBasketButton = " + numberOfItemsInBasketButton);
        System.out.println("numberOfItemsInProductFrame = " + numberOfItemsInProductFrame);
        softAssert.assertTrue(numberOfItemsInBasketButton == numberOfItemsInProductFrame, "");
        Allure.step("Sepete eklenen ürün sayısı ile total sepete eklenen ürün sayısı eşleşmeli");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_02_Ürün Listesi ekranında sepete ürün ekleme UI testi")
    @Severity(SeverityLevel.NORMAL)
    public void TC_018_02(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        String addedProductName = page.makeUpPage().addProductIntoEmptyBasket(page, indexofList);
        //page.basketPage().openBasketPanel(); // basketpage sectionını aç
        page.makeUpPage().deleteProductWithMinusButton(indexofList);
        softAssert.assertTrue(page.basketPage().verfiyDeletedProductFromBasket(), "Ürün silinemedi");
        Allure.step("Sepet ekranında (-) butonu ile adet sayısı 1 olan ürün, sepetten silindi ");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke", "US_018"})
    @Owner("Fatma")
    @Story("TC_018_01_Ürün Listesi ekranında sepete ürün ekleme UI testi ")
    @Severity(SeverityLevel.NORMAL)
        public void TC_018_01(ITestContext context) {
            setupBrowser(context);
            AllPages page = new AllPages();
            SoftAssert softAssert = new SoftAssert();
            Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
            Allure.step("Test çalıştırılma zamanı: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            softAssert.assertTrue(page.pickBazarHomePage().isProductFrameVisible(), "Ürünlerin varolduğu frame ekranda görüntülenemedi");
            Allure.step("Ürünlerin varolduğu frame ekranda görüntülendi");

            String expectedProduct = page.makeUpPage().addProductIntoEmptyBasket(page, indexofList);

            page.basketPage().getProductNameInBasket(0);

            softAssert.assertTrue(page.basketPage().verifyProductNameInBasket(expectedProduct), expectedProduct + " adlı ürün sepette bulunamadı");
            Allure.step(expectedProduct + " adlı ürünün sepete eklendiği doğrulandı");

            softAssert.assertAll();
            Driver.closeDriver();
        }




    }

