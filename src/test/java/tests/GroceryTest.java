package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;

public class GroceryTest {

    Logger logger = LogManager.getLogger(GroceryTest.class);

    @Test(groups = "smoke")
    public void TC_021_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        softAssert.assertTrue(allPages.groceryPage().isGroceryClickable(),"The grocery button is not clickable on homepage");
        logger.info("The grocery button is clickable on homepage");
        softAssert.assertTrue(allPages.groceryPage().isGroceryLinkContains(),"The grocery url doesn't contains the word 'grocery'");
        logger.info("The grocery url contains the word 'grocery'");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getH1TagText(),
                allPages.pickBazarHomePage().getH1TagText().getText(),"Groceries Delivered in 90 Minute"),"The text 'Groceries Delivered in 90 Minute' is not visible");
        logger.info("The text 'Groceries Delivered in 90 Minute' is visible");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getpTagText(),
                allPages.pickBazarHomePage().getpTagText().getText()
                ,"Get your healthy foods & snacks delivered at your doorsteps all day everyday"),"The text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is not visible");
        logger.info("The text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is visible");
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame()),"The search frame is not displayed");
        logger.info("The search frame is displayed");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchButtonDisplayed(),"The search button is not displayed");
        logger.info("The search button is displayed");

        softAssert.assertAll();
        Driver.closeDriver();


    }

    @Test(groups = "smoke")
    public void TC_021_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));


        softAssert.assertAll();
        Driver.closeDriver();

    }
}
