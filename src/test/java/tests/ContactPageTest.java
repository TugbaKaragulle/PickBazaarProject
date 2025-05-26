package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.DriverManager;

public class ContactPageTest {

    @DataProvider(name = "contactPageTestsData")
    public Object[][] contactPageTestsData() {
        return new Object[][] {
                // testCaseId, testType,         param1,                      param2,                    param3,                      param4,                                              expectedText
                {"TC_007_01",  "formSubmit",     "Mehmet",                    "TesterMht@example.com",   "Indirim kuponlar hakkinda", "Indirim kuponlari birden fazla kullanilmaktadir",   "Thank you for contacting us. We will get back to you soon."},
                {"TC_007_02",  "checkAddress",   "NY, United States",          null,                      null,                         null,                                              "NY, United States"},
                {"TC_007_03",  "checkPhone",     "+129290122122",              null,                      null,                         null,                                              "+129290122122"},
                {"TC_007_04",  "checkWebsite",   "https://redq.io",            null,                      null,                         null,                                              "https://redq.io"},
                {"TC_007_05",  "checkFacebook",  "https://www.facebook.com/",  null,                      null,                         null,                                              "https://www.facebook.com/"},
                {"TC_007_06",  "checkTwitter",   "https://x.com/home",         null,                      null,                         null,                                              "https://x.com/home"},
                {"TC_007_07",  "checkInstagram", "https://www.instagram.com/", null,                      null,                         null,                                              "https://www.instagram.com/"}
        };
    }

    @Test(dataProvider = "contactPageTestsData")
    public void testContactPage(String testCaseId, String testType, String param1, String param2, String param3, String param4, String expectedText, ITestContext context) {
        Logger logger = LogManager.getLogger(ContactPageTest.class);
        SoftAssert softAssert = new SoftAssert();

        logger.info("🟡 Test başladı: " + testCaseId);


        Driver.setupBrowser(context);
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("pickbazar_url"));

        ContactPage contactPage = new ContactPage();
        contactPage.goToContactPage();

        switch (testType) {
            case "formSubmit":
                contactPage.fillContactForm(param1, param2, param3, param4);
                contactPage.submitForm();
                softAssert.assertEquals(contactPage.getSuccessMessageText(), expectedText, "[" + testCaseId + "] Başarı mesajı uyuşmuyor");
                break;

            case "checkAddress":
                softAssert.assertEquals(contactPage.getAddressText(), expectedText, "[" + testCaseId + "] Adres metni uyuşmuyor");
                break;

            case "checkPhone":
                softAssert.assertEquals(contactPage.getPhoneText(), expectedText, "[" + testCaseId + "] Telefon metni uyuşmuyor");
                break;

            case "checkWebsite":
                softAssert.assertEquals(contactPage.getWebsiteText(), expectedText, "[" + testCaseId + "] Web sitesi metni uyuşmuyor");
                break;

            case "checkFacebook":
                softAssert.assertTrue(contactPage.isFacebookLinkVisibleOnHover(), "[" + testCaseId + "] Facebook linki görünmeli ve doğru olmalı");
                break;

            case "checkTwitter":
                softAssert.assertTrue(contactPage.isTwitterLinkVisibleOnHover(), "[" + testCaseId + "] Twitter linki görünmeli ve doğru olmalı");
                break;

            case "checkInstagram":
                softAssert.assertTrue(contactPage.isInstagramLinkVisibleOnHover(), "[" + testCaseId + "] Instagram linki görünmeli ve doğru olmalı");
                break;

            default:
                softAssert.fail("Bilinmeyen test tipi: " + testType);
        }

        softAssert.assertAll();

        Driver.closeDriver();
    }
}