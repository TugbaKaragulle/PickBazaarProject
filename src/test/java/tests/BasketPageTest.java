package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import static utilities.Driver.setupBrowser;

public class BasketPageTest {

    Logger logger = LogManager.getLogger(BasketPageTest.class);

    @Test(groups = {"US_018"})    // bu testin bug kaydı açıldı
    public void TC_018_10(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        logger.info("Makeup Page sayfası açılır");

        int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.

        JavascriptUtils.clickElementByJS( page.makeUpPage().addProductIntoBasketwithJS(page,indexofList) );
        JavascriptUtils.clickElementByJS( page.makeUpPage().addProductIntoBasketwithJS(page,indexofList) );
        logger.info("Sepete precondition şartı için 2 ürün eklendi.");

        page.basketPage().openBasketPage();
        logger.info("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");

        page.basketPage().deleteAProductFromBasketWithMinusIcon(page, indexofList);
        logger.info("Açılan sepet ekranında,ürün eksiltmek eklemek için  (-) işaretine tıklandı");

        int expectedPriceOfOneProduct = page.basketPage().getPriceOfOneProduct(indexofList);  //bir ürünün tutarı
        int expectedNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);  //bir üründen alınan adet sayısı

        softAssert.assertEquals(page.basketPage().getTotalPriceOfOneProduct(indexofList), expectedPriceOfOneProduct * expectedNumberOfOneProduct);
        logger.info("Sepetteki ürün tutarı hesaplanan tutar ile eşleşiyor . Hesaplanan tutar = " + expectedPriceOfOneProduct * expectedNumberOfOneProduct);

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})    // bu testin bug kaydı açıldı
    public void TC_018_09(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        logger.info("Makeup Page sayfası açılır");

        int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.


        JavascriptUtils.clickElementByJS( page.makeUpPage().addProductIntoBasketwithJS(page,indexofList) );
        JavascriptUtils.clickElementByJS( page.makeUpPage().addProductIntoBasketwithJS(page,indexofList) );
        logger.info("Sepete precondition şartı için 2 ürün eklendi.");

        page.basketPage().openBasketPage();
        logger.info("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");

        int expectedNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList) - 1;  //beklenen şuan varolan ürün sayısının 1 eksilmesi

        page.basketPage().deleteAProductFromBasketWithMinusIcon(page, indexofList);
        logger.info("Açılan sepet ekranında,ürün eksiltmek eklemek için (-) işaretine tıklandı");

         int actualNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);

        softAssert.assertEquals(actualNumberOfOneProduct, expectedNumberOfOneProduct);
        logger.info("Sepetteki ürün adeti sayısı 1 eksildi -> ürün adeti 1 olduğu doğrulandı");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})    // bu testin bug kaydı açıldı
    public void TC_018_08(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        logger.info("Makeup Page sayfası açılır");

        int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.

        page.makeUpPage().addProductIntoBasket(page, indexofList);
        logger.info("Sepete precondition şartı için bir ürün eklendi.");

        page.basketPage().openBasketPage();
        logger.info("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");

        page.basketPage().addAProductIntoBasketWithPlusIcon(page, indexofList);
        logger.info("Açılan sepet ekranında, ürün sepete eklemek için " + " işaretine tıklandı");

        int expectedPriceOfOneProduct = page.basketPage().getPriceOfOneProduct(indexofList);  //bir ürünün tutarı
        int expectedNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);  //bir üründen alınan adet sayısı

        softAssert.assertEquals(page.basketPage().getTotalPriceOfOneProduct(indexofList), expectedPriceOfOneProduct * expectedNumberOfOneProduct);
        logger.info("Sepetteki ürün tutarı hesaplanan tutar ile eşleşiyor . Hesaplanan tutar = " + expectedPriceOfOneProduct * expectedNumberOfOneProduct);

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})    // bu testin bug kaydı açıldı
    public void TC_018_07(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
        logger.info("Makeup Page sayfası açılır");

        int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.
        page.makeUpPage().addProductIntoBasket(page, indexofList);
        logger.info("Sepete precondition şartı için bir ürün eklendi.");
        page.basketPage().openBasketPage();
        logger.info("Ürün ekranında/ana ekranda sağ taraftaki sepet ekranı açıldı");
        int expectedNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList) + 1;  //beklenen şuan varolan ürün sayısına 1 eklenmesi
        page.basketPage().addAProductIntoBasketWithPlusIcon(page, indexofList);
        int actualNumberOfOneProduct = page.basketPage().getNumberofItemsOfOneProduct(page, indexofList);
        logger.info("Açılan sepet ekranında, ürün sepete eklemek için " + " işaretine tıklanır");

        softAssert.assertEquals(actualNumberOfOneProduct, expectedNumberOfOneProduct);
        logger.info("Sepetteki ürün adeti sayısı 1 arttı -> ürün adeti 2 olduğu doğrulandı");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})    //
    public void TC_018_06(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));
//bu testcase boş
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})    // bu testin bug kaydı açıldı
    public void TC_018_05(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        page.basketPage().openBasketPage();
        softAssert.assertTrue(page.basketPage().isNoProductFoundTextVisible());
        logger.info(page.basketPage().getNoProductFoundHeader() + " metninin görünürlüğü doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})    // bu testin bug kaydı açıldı
    public void TC_018_04(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        page.basketPage().openBasketPage();
        softAssert.assertTrue(page.basketPage().isBasketSectionVisible());
        logger.info("Basket sayfası açıldığı doğrulandı");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})    // bu testin bug kaydı açıldı
    public void TC_018_03(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.
        page.makeUpPage().addProductIntoBasket(page, indexofList);//preconditon şartı için 1 ürün eklenir.
        page.makeUpPage().addAProductIntoBasketWithPlusIcon(page, indexofList);
        int numberOfItemsInBasketButton = ReusableMethods.convertElementTextIntoInteger(page.basketPage().getNumberOfItemsInBasketButton());
        int numberOfItemsInProductFrame = ReusableMethods.convertElementTextIntoInteger(page.makeUpPage().getNumberOfProductAddedToBasket(0));
        System.out.println("numberOfItemsInBasketButton = " + numberOfItemsInBasketButton);
        System.out.println("numberOfItemsInProductFrame = " + numberOfItemsInProductFrame);
        softAssert.assertTrue(numberOfItemsInBasketButton == numberOfItemsInProductFrame);

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})
    public void TC_018_02(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.
        String addedProductName = page.makeUpPage().addProductIntoEmptyBasket(page, indexofList);
        //page.basketPage().openBasketPage(); // basketpage sectionını aç
        page.makeUpPage().deleteProductWithMinusButton(indexofList);
        softAssert.assertTrue(page.basketPage().verfiyDeletedProductFromBasket());

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"US_018"})
    public void TC_018_01(ITestContext context) {
        setupBrowser(context);
        AllPages page = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("makeuppage_url"));

        int indexofList = 0;  //sepetteki ürün listesinden ilk ürününün testi yapılacak.
        JavascriptUtils.scrollIntoViewJS(page.pickBazarHomePage().getProductFrame());
        softAssert.assertTrue(page.pickBazarHomePage().isProductFrameVisible());

        String addedProductName = page.makeUpPage().addProductIntoEmptyBasket(page, indexofList);
        logger.info(addedProductName);
        // System.out.println("page.basketPage().getProductNameInBasket(0) = " + page.basketPage().getProductNameInBasket(0));
        //todo bu hata alıyor?? neden olduğunu çözemedim hocaya sor
        softAssert.assertTrue(page.basketPage().verifyProductNameInBasket(addedProductName));

        softAssert.assertAll();
        Driver.closeDriver();
    }


}

