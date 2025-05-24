package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;

import static utilities.Driver.*;
//***

public class GroceryTest {

    Logger logger = LogManager.getLogger(GroceryTest.class);

    @Test(groups = "smoke")
    public void TC_008_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        softAssert.assertTrue(allPages.groceryPage().isGroceryClickable(),
                "The grocery button is not clickable on homepage");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        softAssert.assertTrue(allPages.groceryPage().isGroceryLinkContains(),
                "The grocery url doesn't contains the word 'grocery'");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getH1TagText(),
                        "Groceries Delivered in 90 Minute", "'Groceries Delivered in 90 Minute'"),
                "The text 'Groceries Delivered in 90 Minute' is not visible");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getpTagText(),
                        "Get your healthy foods & snacks delivered at your doorsteps all day everyday",
                        "'Get your healthy foods & snacks delivered at your doorsteps all day everyday'"),
                "The text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is not visible");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke") //TODO -->Düzenle
    public void TC_008_05(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        // logger.info("Verifying if the search frame is visible");
        softAssert.assertTrue(allPages.groceryPage().isSearchFrameDisplayed(), "The search frame is not displayed");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_06(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        softAssert.assertTrue(allPages.groceryPage().isSearchButtonDisplayedOnGroceryPage(), "The search button is not visible");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(dataProvider = "searchFrameData", groups = "smoke")
    public void TC_08(ITestContext context, String products, String testCaseNo) {

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        try {
            softAssert.assertTrue(allPages.groceryPage().verifyProductsAppearAfterSearch(products));
        } catch (IndexOutOfBoundsException e) {
            softAssert.fail(testCaseNo + " : " + products + " not found");
        }
        softAssert.assertAll();
        closeDriver();
    }

    @DataProvider(name = "searchFrameData")
    public Object[][] searchFrameData() {
        return new Object[][]{
                {"Apple", "Test Case 08_07 "},
                {"Lays", "Test Case 08_08 "},
                {"Clean", "Test Case 08_09 "},
                {"Salt", "Test Case 08_10 "},
                {"Milk", "Test Case 08_11 "},
                {"Rice", "Test Case 08_12 "},
                {"Oil", "Test Case 08_13 "},
                {"Bread", "Test Case 08_14 "},
                {"Jam", "Test Case 08_15 "},
                {"Salmon", "Test Case 08_16 "}
        };
    }

    @Test(groups = "smoke")
    public void TC_08_17_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Checking if the image in " + logMessage + " frame is visible...");
        softAssert.assertTrue(allPages.groceryPage().isImageDisplayed(allPages.pickBazarHomePage().getExpressDeliveryImage(), "Express Delivery"), "The Image in Express Delivery frame is not visible");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_17_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Checking if the image in " + logMessage + " frame is visible...");
        softAssert.assertTrue(allPages.groceryPage().isImageDisplayed(allPages.pickBazarHomePage().getCashOnDeliveryImage(), "Cash On Delivery"), "The Image in Cash On Delivery frame is not visible");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_17_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Checking if the image in " + logMessage + " frame is visible...");
        softAssert.assertTrue(allPages.groceryPage().isImageDisplayed(allPages.pickBazarHomePage().getGiftVoucherImage(), "Gift Voucher"), "The Image in Gift Voucher frame is not visible");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_18_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        softAssert.assertTrue(allPages.groceryPage().verifyElementsInListVisible(allPages.groceryPage().getProductsList(),
                        "grocery products are visible on the right side of the page."),
                "Grocery products aren't visible on the right side of the page.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_18_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        softAssert.assertTrue(allPages.groceryPage().verifyElementsInListVisible(allPages.groceryPage().getProductPriceList(),
                        "prices are visible under the grocery products."),
                "Prices aren't visible under the grocery products.");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_19(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Checking if the 'Fruits & Vegetables' menu contains 'Fruits' and 'Vegetables' sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Fruits & Vegetables", allPages.groceryPage().getData1(),
                "Fruits & Vegetables"), "The 'Fruits & Vegetables' menu doesn't contain 'Fruits' and 'Vegetables' sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_20(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        // logger.info("Verifying that 'Meat & Fish' menu contains 'Fresh Fish' and 'Meat' sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Meat & Fish", allPages.groceryPage().getData2(), "Meat & Fish"), "The 'Meat & Fish' menu doesn't contains 'Fresh Fish' and 'Meat' sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_21(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Verifying that 'Snacks' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Snacks", allPages.groceryPage().getData3(), "Snacks"), "'Snacks' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_22(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Verifying that 'Pet Care' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Pet Care", allPages.groceryPage().getData4(), "Pet Care"), "'Pet Care' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_23(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Verifying that 'Home & Cleaning' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Home & Cleaning", allPages.groceryPage().getData5(), "Home & Cleaning"), "'Home & Cleaning' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_24(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Verifying that 'Dairy' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Dairy", allPages.groceryPage().getData6(), "Dairy"), "'Dairy' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_25(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Verifying that 'Cooking' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Cooking", allPages.groceryPage().getData7(), "Cooking"), "'Cooking' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_26(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Verifying that 'Breakfast' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Breakfast", allPages.groceryPage().getData8(), "Breakfast"));
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_27(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Verifying that 'Health & Beauty' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Health & Beauty", allPages.groceryPage().getData9(), "Health & Beauty"));
        softAssert.assertAll();
        closeDriver();
    }


    @Test(groups = "smoke")
    public void TC_08_28_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Checking if there are max 30 products before clicking 'Load More'.");
        softAssert.assertTrue(allPages.groceryPage().VerifyproductCount());
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_28_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Clicking 'Load More' button and checking if product count increases.");
        softAssert.assertTrue(allPages.groceryPage().countOfProductWithLoadMoreButton());
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_29_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Checking if 'Read More' button is clickable.");
        softAssert.assertTrue(allPages.groceryPage().verifyReadMoreButtonIsClickable(), "The 'Read More' button is not clickable.");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_29_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        //logger.info("Verifying the long product description appears.");
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforLongText(ConfigReader.getProperty("LongDiscriptionApple")), "The long product description is not displayed.");
        softAssert.assertAll();
        closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_29_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);

        //logger.info("Checking if 'Less' button is clickable and short text appears again.");
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforShortText(ConfigReader.getProperty("shortDiscriptionApple")));
        softAssert.assertAll();
        closeDriver();

    }


    @Test(groups = "smoke")
    public void TC_08_30(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Checking if small images under the product are visible.");
        softAssert.assertTrue(allPages.groceryPage().areSmallImagesVisible(), "small images under the product are not visible.");

        logger.info("Clicking small images and checking if they match the big image.");
        softAssert.assertTrue(
                allPages.groceryPage().verifyIfPhotosAreEquals(
                        allPages.groceryPage().getProductBigFotoIndex1(),
                        allPages.groceryPage().getProductSmallfotos(),
                        1
                ));
        softAssert.assertTrue(
                allPages.groceryPage().verifyIfPhotosAreEquals(
                        allPages.groceryPage().getProductBigFotoIndex2(),
                        allPages.groceryPage().getProductSmallfotos(),
                        2
                ));
        softAssert.assertTrue(
                allPages.groceryPage().verifyIfPhotosAreEquals(
                        allPages.groceryPage().getProductBigFotoIndex3(),
                        allPages.groceryPage().getProductSmallfotos(),
                        3
                ));

        softAssert.assertAll();
        closeDriver();
    }

}
