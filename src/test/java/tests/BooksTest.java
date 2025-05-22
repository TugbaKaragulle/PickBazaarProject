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
//***

public class BooksTest {

    Logger logger = LogManager.getLogger(BooksTest.class);

    @Test(groups = "smoke")
    public void TC_23_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that the banner with 'Sale UP TO 20% OFF' and 'Shop Now' is visible.");
        softAssert.assertTrue(allPages.booksPage().isBannerDisplayed(),"Banner with 'Sale UP TO 20% OFF' is not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke") //TODO ----> BUG
    public void TC_23_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        String title ="Best Selling Products";
        logger.info("Verifying that the 'Best Selling Products' section is visible.");
        softAssert.assertTrue(allPages.booksPage().bestSellingProductsField(title),"'Best Selling Products' section is not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Popular Products' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getPopularProductTitle());
        logger.info("Verifying that product images are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularProductImages()),"Product images are not visible");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Popular Products' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getPopularProductTitle());
        logger.info("Verifying that product names are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularProductBookNames()),"Product names are visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_05(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Popular Products' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getPopularProductTitle());
        logger.info("Verifying that product prices are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularPruductPrice()),"Product prices are visible");
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(groups = "smoke")
    public void TC_23_06(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Which Books You Like To See?' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getWhichBookTitle());
        logger.info("Verifying that the section title is visible.");
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.booksPage().getWhichBookTitle()),"'Which Books You Like To See?' title is not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_07(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Which Books You Like To See?' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getWhichBookTitle());
        logger.info("Clicking on the scroll arrow.");
        allPages.booksPage().clickAsMuchAsYouWant(allPages.booksPage().getWhichBookScrollArrow(),1);
        logger.info("Verifying that the book images are displayed.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getWhichBookImages()),"Book images are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    //*********************************************


    @Test(groups = "smoke")
    public void TC_23_08(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Which Books You Like To See?' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getWhichBookTitle());
        logger.info("Clicking on the scroll arrow.");
        allPages.booksPage().clickAsMuchAsYouWant(allPages.booksPage().getWhichBookScrollArrow(),1);
        logger.info("Verifying that the book titles are displayed.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getWhichBookNames()),"Book titles are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    //TODO---> 23_09 isimli @Test MANUEL BUG



    @Test(groups = "smoke")
    public void TC_23_10(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'New Arrival Books' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getNewArrivalTitle());
        logger.info("Verifying that new book images are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBooksImg()),"New book images are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_11(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'New Arrival Books' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getNewArrivalTitle());
        logger.info("Verifying that new book titles are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBookNames()), "New book titles are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_12(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'New Arrival Books' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getNewArrivalTitle());
        logger.info("Verifying that new book prices are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBooksPrice()), "New book prices are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    //**********************************************************************

    @Test(groups = "smoke")
    public void TC_23_13(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Top Authors' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getTopAuthorsTitle());
        logger.info("Clicking the scroll arrow 3 times.");
        logger.info("Verifying that author photos are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getFirst5AuthorPhotos()),"Author photos are not visible.");
        allPages.booksPage().clickAsMuchAsYouWant(allPages.booksPage().getAuthorScrollArrowRight(),3);
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getLast5AuthorPhotos()),"Author photos are not visible.");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_14(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Scrolling to 'Top Authors' section.");
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getTopAuthorsTitle());
        logger.info("Verifying that author names are visible.");
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getFirst5AuthorNames()),"Author names are not visible.");
        allPages.booksPage().clickAsMuchAsYouWant(allPages.booksPage().getAuthorScrollArrowRight(),3);
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getLast5AuthorNames()),"Author names are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }



}
