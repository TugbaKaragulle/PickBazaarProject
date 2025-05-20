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

public class GroceryTest {

    Logger logger = LogManager.getLogger(GroceryTest.class);

    @Test(groups = "smoke")
    public void TC_008_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        softAssert.assertTrue(allPages.groceryPage().isGroceryClickable(),"The grocery button is not clickable on homepage");
        logger.info("The grocery button is clickable on homepage");
        softAssert.assertTrue(allPages.groceryPage().isGroceryLinkContains(),"The grocery url doesn't contains the word 'grocery'");
        logger.info("The grocery url contains the word 'grocery'");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getH1TagText(),
                "Groceries Delivered in 90 Minute"),"The text 'Groceries Delivered in 90 Minute' is not visible");
        logger.info("The text 'Groceries Delivered in 90 Minute' is visible");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getpTagText(),
                "Get your healthy foods & snacks delivered at your doorsteps all day everyday"),"The text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is not visible");
        logger.info("The text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is visible");
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame()),"The search frame is not displayed");
        logger.info("The search frame is displayed");
        softAssert.assertTrue(allPages.pickBazarHomePage().isSearchButtonDisplayed(),"The search button is not displayed");
        logger.info("The search button is displayed");

        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(dataProvider = "searchFrameData", groups = "smoke")
    public void TC_08_02(ITestContext context, String products){

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        setupBrowser(context);
        try {
            softAssert.assertTrue(allPages.groceryPage().verifyProductsAppearAfterSearch(products));
        } catch (IndexOutOfBoundsException e) {
            softAssert.fail(products+" not found");
        }
        logger.info("Verified that the product {} is displayed. ", products);
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @DataProvider(name = "searchFrameData")
    public Object[][] searchFrameData() {
        return new Object[][] {
                { "Apple" },
                { "Lays" },
                { "Clean" },
                { "Salt" },
                { "Milk" },
                { "Rice" },
                { "Oil" },
                { "Bread" },
                { "Jam" },
                { "Salmon" }
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
        logger.info("Selecting 'Grocery' category from the dropdown menu.");
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        logger.info("Checking if the 'Fruits & Vegetables' menu contains 'Fruits' and 'Vegetables' sub-items.");
        List<String> testData= new ArrayList<>(Arrays.asList("Fruits","Vegetables"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Fruits & Vegetables",testData),"The 'Fruits & Vegetables' menu does not contain 'Fruits' and 'Vegetables' sub-items.");
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
        logger.info("Selecting 'Grocery' category from the dropdown menu.");
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");

        List<String> testData= new ArrayList<>(Arrays.asList("Fresh Fish","Meat"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Meat & Fish", testData));
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
        List<String> testData= new ArrayList<>(Arrays.asList("Nuts & Biscuits","Chocolates", "Crisps","Noodles & Pasta","Sauce","Soup"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Snacks", testData));
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
        List<String> testData= new ArrayList<>(Arrays.asList("Cat Food","Dog Food", "Accessories"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Pet Care", testData));
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
        List<String> testData= new ArrayList<>(Arrays.asList("Air Freshner","Cleaning Products", "Kitchen Accessories","Laundry"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Home & Cleaning", testData));
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
        List<String> testData= new ArrayList<>(Arrays.asList("Milk","Butter", "Egg","Yogurt"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Dairy", testData));
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
        List<String> testData= new ArrayList<>(Arrays.asList("Oil","Rice", "Salt & Sugar","Spices"));
        softAssert.assertTrue(allPages.groceryPage().VerifyIfScrollDownMenuContainsSubMenu("Cooking", testData));
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
        softAssert.assertTrue(allPages.groceryPage().VerifyproductCount());
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
        softAssert.assertTrue(allPages.groceryPage().verifyReadMoreButtonIsClickable());
        String longText= "An apple is a sweet, edible fruit produced by an apple tree (Malus domestica). " +
                "Apple trees are ... The skin of ripe apples is generally red, yellow, green, pink, or russetted, " +
                "though many bi- or tri-colored cultivars may be found.Less";
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforLongText(longText));
        String shortText= "An apple is a sweet, edible fruit produced by an apple tree (Malus domestica). Apple trees are ... " +
                "The skin of ripe apples is generally red, yellow, g...Read more";
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforShortText(shortText));
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
        softAssert.assertTrue(allPages.groceryPage().areSmallPhotosVisible());

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
