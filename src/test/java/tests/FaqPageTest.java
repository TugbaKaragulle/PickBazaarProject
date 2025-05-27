package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import pages.FaqPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class FaqPageTest {

    Logger logger = LogManager.getLogger(FaqPageTest.class);

    @DataProvider(name = "faqData")
    public static Object[][] faqData() {
        return new Object[][]{
                {"TC_006_01", "How to contact with Customer Service?", null},
                {"TC_006_02", "App installation failed, how to update system information?", null},
                {"TC_006_03", "Website response taking time, how to improve?", null},
                {"TC_006_04", "How do I create a account?", null},
                {"TC_006_05", null, "Our Customer Experience Team is available 7 days a week and we offer 2 ways to get in contact.Email and Chat . We try to reply quickly, so you need not to wait too long for a response!."},
                {"TC_006_06", null, "Please read the documentation carefully . We also have some online video tutorials regarding this issue . If the problem remains, Please Open a ticket in the support forum"},
                {"TC_006_07", null, "At first, Please check your internet connection . We also have some online video tutorials regarding this issue . If the problem remains, Please Open a ticket in the support forum."},
                {"TC_006_08", null, "If you want to open an account for personal use you can do it over the phone or online. Opening an account online should only take a few minutes."}
        };
    }

    @Test(dataProvider = "faqData", groups = {"regression"})
    public void testFaqFunctionality(String testCaseId, String expectedQuestionText, String expectedAnswerText, ITestContext context) {
        logger.info("TEST BAŞLADI | ID: {}", testCaseId);
        SoftAssert softAssert = new SoftAssert();


        Driver.setupBrowser(context);
        String url = ConfigReader.getProperty("pickbazar_url");
        Driver.getDriver().get(url);

        AllPages allPages = new AllPages();
        ReusableMethods.clickElement(allPages.pickBazarHomePage().getFAQButton());


        // Index belirleme
        int index = getIndexByTestCaseId(testCaseId);

        // Soru kontrolü
        if (expectedQuestionText != null) {
            String actualQuestion = allPages.faqPage().getQuestionText(index);
            logger.info("Soru başlığı: {}", actualQuestion);
            softAssert.assertEquals(actualQuestion, expectedQuestionText, "Soru başlığı eşleşmeli");

            logger.info("Toggle açılıyor, index: {}", index);
            allPages.faqPage().clickToggle(index);

            boolean isVisibleAfterOpen = allPages.faqPage().isAnswerVisible(index);
            logger.info("Toggle açıldıktan sonra cevap görünürlüğü: {}", isVisibleAfterOpen);
            softAssert.assertTrue(isVisibleAfterOpen, "Toggle açılınca cevap görünmeli");
        }

        // Cevap metni kontrolü
        if (expectedAnswerText != null) {
            logger.info("Toggle açılıyor, index: {}", index);
            allPages.faqPage().clickToggle(index);

            String actualAnswer = allPages.faqPage().getAnswerText(index);
            logger.info("Cevap metni: {}", actualAnswer);
            softAssert.assertEquals(actualAnswer, expectedAnswerText, "Cevap metni eşleşmeli");

            boolean isVisibleAfterOpen = allPages.faqPage().isAnswerVisible(index);
            logger.info("Toggle açıldıktan sonra cevap görünürlüğü: {}", isVisibleAfterOpen);
            softAssert.assertTrue(isVisibleAfterOpen, "Toggle açılınca cevap görünmeli");
        }

        softAssert.assertAll();
        logger.info("TEST BİTTİ | ID: {}", testCaseId);

        Driver.closeDriver();
    }

    private int getIndexByTestCaseId(String testCaseId) {
        switch (testCaseId) {
            case "TC_006_01":
            case "TC_006_05":
                return 0;
            case "TC_006_02":
            case "TC_006_06":
                return 1;
            case "TC_006_03":
            case "TC_006_07":
                return 2;
            case "TC_006_04":
            case "TC_006_08":
                return 3;
            default:
                throw new IllegalArgumentException("Geçersiz test senaryosu ID: " + testCaseId);
        }
    }
}
