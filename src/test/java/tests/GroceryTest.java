package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;
//***

public class GroceryTest {

    Logger logger = LogManager.getLogger(GroceryTest.class);


    @Test(groups = "smoke")
    public void TC_008_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying if the grocery button is clickable on homepage");
        softAssert.assertTrue(allPages.groceryPage().isGroceryClickable(),"The grocery button is not clickable on homepage");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying if the grocery url contains the word 'grocery");
        softAssert.assertTrue(allPages.groceryPage().isGroceryLinkContains(),"The grocery url doesn't contains the word 'grocery'");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying if the text 'Groceries Delivered in 90 Minute' is visible");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getH1TagText(),
                "Groceries Delivered in 90 Minute"),"The text 'Groceries Delivered in 90 Minute' is not visible");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying if the text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is visible");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getpTagText(),
                "Get your healthy foods & snacks delivered at your doorsteps all day everyday"),"The text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is not visible");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_05(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying if the search frame is visible");
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame()),"The search frame is not displayed");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_008_06(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying if the search button is visible ");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchButtonDisplayed(),"The search button is not visible");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(dataProvider = "searchFrameData", groups = "smoke")
    public void TC_08(ITestContext context, String products,String testCaseNo){

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        setupBrowser(context);
        try {
            softAssert.assertTrue(allPages.groceryPage().verifyProductsAppearAfterSearch(products));
        } catch (IndexOutOfBoundsException e) {
            softAssert.fail(testCaseNo+" : "+products+" not found");
        }
        logger.info("Verified that the product {} is displayed. ", products);
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @DataProvider(name = "searchFrameData")
    public Object[][] searchFrameData() {
        return new Object[][] {
                { "Apple","Test Case 08_07 " },
                { "Lays" ,"Test Case 08_08 "},
                { "Clean","Test Case 08_09 " },
                { "Salt","Test Case 08_10 " },
                { "Milk","Test Case 08_11 " },
                { "Rice","Test Case 08_12 " },
                { "Oil" ,"Test Case 08_13 "},
                { "Bread","Test Case 08_14 " },
                { "Jam","Test Case 08_15 " },
                { "Salmon","Test Case 08_16 " }
        };
    }

    @Test(groups = "smoke")
    public void TC_08_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Selecting 'Grocery' category from the dropdown menu.");
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getExpressDeliveryImage()),"The Image in Express Delivery frame is not visible");
        logger.info("The Image in Express Delivery frame is visible");
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getCashOnDeliveryImage()),"The Image in Cash On Delivery frame is not visible");
        logger.info("The Image in Cash On Delivery frame is visible");
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getGiftVoucherImage()),"The Image in Gift Voucher frame is not visible");
        logger.info("The Image in Gift Voucher frame is visible");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Selecting 'Grocery' category from the dropdown menu.");
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        logger.info("Verifying that grocery products are visible on the right side of the page.");
        softAssert.assertTrue(allPages.groceryPage().verifyElementsInListVisible(allPages.groceryPage().getProductsList()),"Grocery products aren't visible on the right side of the page.");
        logger.info("Verifying that prices are visible under the grocery products.");
        softAssert.assertTrue(allPages.groceryPage().verifyElementsInListVisible(allPages.groceryPage().getProductPriceList()),"Prices aren't visible under the grocery products.");
        softAssert.assertAll();
        Driver.closeDriver();

    }


    @Test(groups = "smoke")
    public void TC_08_05(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Checking if the 'Fruits & Vegetables' menu contains 'Fruits' and 'Vegetables' sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Fruits","Vegetables"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Fruits & Vegetables",testData),"The 'Fruits & Vegetables' menu doesn't contain 'Fruits' and 'Vegetables' sub-items.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_06(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Meat & Fish' menu contains 'Fresh Fish' and 'Meat' sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Fresh Fish","Meat"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Meat & Fish", testData),"The 'Meat & Fish' menu doesn't contains 'Fresh Fish' and 'Meat' sub-items.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_07(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Snacks' menu contains all expected sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Nuts & Biscuits","Chocolates", "Crisps","Noodles & Pasta","Sauce","Soup"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Snacks", testData),"'Snacks' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_08(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Pet Care' menu contains all expected sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Cat Food","Dog Food", "Accessories"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Pet Care", testData),"'Pet Care' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_09(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Home & Cleaning' menu contains all expected sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Air Freshner","Cleaning Products", "Kitchen Accessories","Laundry"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Home & Cleaning", testData),"'Home & Cleaning' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_10(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Dairy' menu contains all expected sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Milk","Butter", "Egg","Yogurt"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Dairy", testData),"'Dairy' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_11(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Cooking' menu contains all expected sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Oil","Rice", "Salt & Sugar","Spices"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Cooking", testData),"'Cooking' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_12(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Breakfast' menu contains all expected sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Bread","Cereal","Jam"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Breakfast", testData));
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_13(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Verifying that 'Health & Beauty' menu contains all expected sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Bath","Cream", "Deodorant","Face Care","Oral Care", "Shaving Needs"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Health & Beauty", testData));
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(groups = "smoke")
    public void TC_08_14(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Checking if there are max 30 products before clicking 'Load More'.");
        softAssert.assertTrue(allPages.groceryPage().VerifyproductCount());
        logger.info("Clicking 'Load More' button and checking if product count increases.");
        softAssert.assertTrue(allPages.groceryPage().countOfProductWithLoadMoreButton());
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_08_15(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Checking if 'Read More' button is clickable.");
        softAssert.assertTrue(allPages.groceryPage().verifyReadMoreButtonIsClickable(),"The 'Read More' button is not clickable.");
        logger.info("Verifying the long product description appears.");
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforLongText(ConfigReader.getProperty("LongDiscriptionApple")),"The long product description is not displayed.");
        logger.info("Checking if 'Less' button is clickable and short text appears again.");
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforShortText(ConfigReader.getProperty("shortDiscriptionApple")));
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(groups = "smoke")
    public void TC_08_16(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        logger.info("Checking if small images under the product are visible.");
        softAssert.assertTrue(allPages.groceryPage().areSmallImagesVisible(),"small images under the product are not visible.");

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
        Driver.closeDriver();
    }

}
