package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;


import static utilities.Driver.setupBrowser;

public class OffersPageTest {
    Logger logger = LogManager.getLogger(OffersPageTest.class);

    // ============================================================
    // Kupon Copy- Copied testi
    // ============================================================

    @DataProvider(name = "offersData")
    public Object[][] offersData() {
        return new Object[][]{
                {"TC_005_01", "EID2"},
                {"TC_005_02", "FOO"},
                {"TC_005_03", "EID12"},
                {"TC_005_04", "HELLO15"},
                {"TC_005_05", "BAZAR18"},
                {"TC_005_06", "BAZAR20"},
                {"TC_005_07", "BAZAR10"},
                {"TC_005_08", "OFF6"},
                {"TC_005_09", "5OFF"},
                {"TC_005_10", "4OFF"},
        };
    }

    @Test(dataProvider = "offersData")
    public void testOfferCopyButton(String testCaseId, String couponCode, ITestContext context) {
        SoftAssert softAssert = new SoftAssert();
        AllPages allPages = new AllPages();

        logger.info("Test başladı: " + testCaseId);

        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));

        logger.info(testCaseId + ": Anasayfada Offers butonuna tıklanıyor.");
        allPages.pickBazarHomePage().clickOffersButton();

        logger.info(testCaseId + ": Kupon kodu '" + couponCode + "' için Copy butonuna tıklanıyor.");
        allPages.offersPage().clickCopyButtonByCouponCode(couponCode);

        String bodyText = Driver.getDriver().findElement(org.openqa.selenium.By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Copied!"), "'Copied!' mesajı metin içinde yok.");

        softAssert.assertAll();
        Driver.closeDriver();
    }


    /*
    // ============================================================
    // Furniture Shop Apply valid coupon testi
    // ============================================================

    @DataProvider(name = "couponCopyData")
    public Object[][] couponCopyData() {
        return new Object[][]{
                //{"TC_005_11", "EID2"},
                // Diğer test case'ler yorumda bekliyor
                //{"TC_005_12", "FOO"},
                //{"TC_005_13", "EID12"},
                //{"TC_005_14", "HELLO15"},
                //{"TC_005_15", "BAZAR18"},
                //{"TC_005_16", "BAZAR20"},
                //{"TC_005_17", "BAZAR10"},
                //{"TC_005_18", "OFF6"},
                //{"TC_005_19", "5OFF"},
                //{"TC_005_20", "4OFF"},
        };
    }


    @Test(dataProvider = "couponCopyData")
    public void testCouponCopyAndApplyWithoutIframe(String testCaseId, String couponCode, ITestContext context) {
        setupBrowser(context);
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();

        logger.info("Test başladı: " + testCaseId);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));


        allPages.loginPage().logIn("TesterMht@example.com", "1234");
        softAssert.assertTrue(allPages.loginPage().isProfileImageDisplayed(), testCaseId + ": Giriş başarısız!");


        allPages.pickBazarHomePage().clickOffersButton();
        logger.info(testCaseId + ": Kupon kodu '" + couponCode + "' için Copy butonuna tıklanıyor.");
        allPages.offersPage().clickCopyButtonByCouponCode(couponCode);
        boolean isCopied = allPages.offersPage().isCopiedMessageVisible(couponCode);
        softAssert.assertTrue(isCopied, testCaseId + ": Kupon kopyalanamadı!");


        allPages.pickBazarHomePage().clickShopsButton();
        ReusableMethods.clickElement(allPages.offersPage().getFurnitureShopTitle());

        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("furniture-shop"));


        ReusableMethods.clickElement(allPages.offersPage().getAshDoubleBedTitle());
        allPages.shopsPage().clickAddToCartOnProductPageDynamic();
        allPages.shopsPage().clickCartButton();
        softAssert.assertTrue(allPages.shopsPage().getCartItemCount() > 0, testCaseId + ": Sepette ürün yok!");


        ReusableMethods.clickElement(allPages.shopsPage().getCheckoutSpan());
        ReusableMethods.clickElement(allPages.shopsPage().getCheckAvailabilityButton());


        WebElement couponButton = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Do you have coupon?']")));
        couponButton.click();
        logger.info(testCaseId + ": Kupon inputu açıldı.");


        allPages.offersPage().applyCouponCode(couponCode);


        double subTotal = allPages.offersPage().getSubTotalAmount();
        double total = allPages.offersPage().getTotalAmount();
        double discount = allPages.offersPage().getDiscountAmount();
        double expectedCouponValue = allPages.offersPage().getCouponValue(couponCode);

        double calculatedDiscount = subTotal - total;

        if (calculatedDiscount > 0 && calculatedDiscount == discount && calculatedDiscount == expectedCouponValue) {
            logger.info(testCaseId + ": Kupon geçerli. Kupon indirimi başarıyla uygulandı. Sub Total: " + subTotal + ", Total: " + total + ", İndirim: " + discount + ", Beklenen Kupon Değeri: " + expectedCouponValue);
        } else {
            logger.warn(testCaseId + ": Kupon geçersiz. İndirim uygulanmadı veya beklenen değerle uyuşmuyor. Sub Total: " + subTotal + ", Total: " + total + ", İndirim: " + discount + ", Beklenen Kupon Değeri: " + expectedCouponValue);
            softAssert.fail(testCaseId + ": Kupon indirimi doğru uygulanmadı! Beklenen indirim: " + expectedCouponValue + ", Gerçekleşen indirim: " + calculatedDiscount + ", Sayfadaki indirim: " + discount);
        }


        allPages.offersPage().clickCheckoutWithWait(allPages);

        softAssert.assertAll();
        Driver.closeDriver();
        logger.info("Test tamamlandı: " + testCaseId);
    }

    private void setupBrowser(ITestContext context) {
        Driver.getDriver().manage().window().maximize();
    } */
    }
