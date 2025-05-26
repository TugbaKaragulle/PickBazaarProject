package tests;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;

import static utilities.Driver.*;
//***

public class GroceryTest {

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Description("Verify that the grocery button is clickable on homepage")
    @Severity(SeverityLevel.NORMAL)
    public void TC_08_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying if the grocery button is clickable on homepage");
        softAssert.assertTrue(allPages.groceryPage().isGroceryClickable(),
                "The grocery button is not clickable on homepage");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Description("Verify that the grocery URL contains the word 'grocery'")
    @Severity(SeverityLevel.NORMAL)
    public void TC_08_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying if the URL contains 'grocery'?");
        softAssert.assertTrue(allPages.groceryPage().isGroceryLinkContains(),
                "The grocery url doesn't contain the word 'grocery'");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Description("Verify that the text 'Groceries Delivered in 90 Minute' is visible")
    @Severity(SeverityLevel.NORMAL)
    public void TC_08_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying if the text 'Groceries Delivered in 90 Minute' is visible");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getH1TagText(),
                        "Groceries Delivered in 90 Minute", "'Groceries Delivered in 90 Minute'"),
                "The text 'Groceries Delivered in 90 Minute' is not visible");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Description("Verify that the text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is visible")
    @Severity(SeverityLevel.NORMAL)
    public void TC_08_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying if the text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is visible");
        softAssert.assertTrue(allPages.groceryPage().isElementTextEquals(allPages.pickBazarHomePage().getpTagText(),
                        "Get your healthy foods & snacks delivered at your doorsteps all day everyday",
                        "'Get your healthy foods & snacks delivered at your doorsteps all day everyday'"),
                "The text 'Get your healthy foods & snacks delivered at your doorsteps all day everyday' is not visible");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Verify that the search frame is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08_05(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying if the search frame is visible");
        softAssert.assertTrue(allPages.groceryPage().isSearchFrameDisplayed(), "The search frame is not displayed");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = "regression")
    @Owner("Tugba")
    @Description("Verify that the search button is visible on grocery page")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08_06(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying if the search button is visible ");
        softAssert.assertTrue(allPages.groceryPage().isSearchButtonDisplayedOnGroceryPage(), "The search button is not visible");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(dataProvider = "searchFrameData", groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Verify searched products appear in the grocery search results")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08(ITestContext context, String products, String testCaseNo) {

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verified that the product " + products + " is displayed");
        try {
            softAssert.assertTrue(allPages.groceryPage().isProductVisibleAfterSearch(products),testCaseNo + " : " + products + " not found");
        } catch (Exception e) {
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

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Description("Checks if the image in 'Express Delivery' frame is visible")
    @Severity(SeverityLevel.NORMAL)
    public void TC_08_17(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Checking if the image in 'Express Delivery' frame is visible");
        softAssert.assertTrue(allPages.groceryPage().isImageDisplayed(allPages.pickBazarHomePage().getExpressDeliveryImage(), "Express Delivery"), "The Image in Express Delivery frame is not visible");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Description("Checks if the image in 'Cash On Delivery' frame is visible")
    @Severity(SeverityLevel.NORMAL)
    public void TC_08_18(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Checking if the image in 'Cash On Delivery' frame is visible");
        softAssert.assertTrue(allPages.groceryPage().isImageDisplayed(allPages.pickBazarHomePage().getCashOnDeliveryImage(), "Cash On Delivery"), "The Image in Cash On Delivery frame is not visible");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Description("Checks if the image in Gift Voucher frame is visible")
    @Severity(SeverityLevel.NORMAL)
    public void TC_08_19(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Checking if the image in Gift Voucher frame is visible");
        softAssert.assertTrue(allPages.groceryPage().isImageDisplayed(allPages.pickBazarHomePage().getGiftVoucherImage(), "Gift Voucher"), "The Image in Gift Voucher frame is not visible");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Checks if grocery products are visible on the right side of the page")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08_20(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that grocery products are visible on the right side of the page.");
        softAssert.assertTrue(allPages.groceryPage().verifyElementsInListVisible(allPages.groceryPage().getProductsList(),
                        "grocery products are visible on the right side of the page."),
                "Grocery products aren't visible on the right side of the page.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Checks if prices are visible under the grocery products")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08_21(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that prices are visible under the grocery products.");
        softAssert.assertTrue(allPages.groceryPage().verifyElementsInListVisible(allPages.groceryPage().getProductPriceList(),
                        "prices are visible under the grocery products."),
                "Prices aren't visible under the grocery products.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Verifies that 'Fruits & Vegetables' menu has 'Fruits' and 'Vegetables' sub-items")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08_22(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Checking if the 'Fruits & Vegetables' menu contains 'Fruits' and 'Vegetables' sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Fruits & Vegetables", allPages.groceryPage().getData1(),
                "Fruits & Vegetables"), "The 'Fruits & Vegetables' menu doesn't contain 'Fruits' and 'Vegetables' sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Verifies that 'Meat & Fish' menu has 'Fresh Fish' and 'Meat' sub-items")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08_23(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Meat & Fish' menu contains 'Fresh Fish' and 'Meat' sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Meat & Fish", allPages.groceryPage().getData2(), "Meat & Fish"), "The 'Meat & Fish' menu doesn't contains 'Fresh Fish' and 'Meat' sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Description("Verifies that 'Snacks' menu has all expected sub-items")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_08_24(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Snacks' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Snacks", allPages.groceryPage().getData3(), "Snacks"), "'Snacks' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify 'Pet Care' menu contains expected sub-items")
    public void TC_08_25(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Pet Care' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Pet Care", allPages.groceryPage().getData4(), "Pet Care"), "'Pet Care' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify 'Home & Cleaning' menu contains expected sub-items")
    public void TC_08_26(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Home & Cleaning' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Home & Cleaning", allPages.groceryPage().getData5(), "Home & Cleaning"), "'Home & Cleaning' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify 'Dairy' menu contains expected sub-items")
    public void TC_08_27(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Dairy' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Dairy", allPages.groceryPage().getData6(), "Dairy"), "'Dairy' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify 'Cooking' menu contains expected sub-items")
    public void TC_08_28(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Cooking' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Cooking", allPages.groceryPage().getData7(), "Cooking"), "'Cooking' menu does not contain all expected sub-items.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify 'Breakfast' menu contains expected sub-items")
    public void TC_08_29(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Breakfast' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Breakfast", allPages.groceryPage().getData8(), "Breakfast"));
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify 'Health & Beauty' menu contains expected sub-items")
    public void TC_08_30(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that 'Health & Beauty' menu contains all expected sub-items.");
        softAssert.assertTrue(allPages.groceryPage().verifySubmenuInMainMenu("Health & Beauty", allPages.groceryPage().getData9(), "Health & Beauty"));
        softAssert.assertAll();
        closeDriver();
    }


    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify there are max 30 products before clicking 'Load More'")
    public void TC_08_31(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Checking if there are max 30 products before clicking 'Load More'.");
        softAssert.assertTrue(allPages.groceryPage().VerifyproductCount());
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression", "smoke"})
    @Owner("Tugba")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Click 'Load More' and check product count increases")
    public void TC_08_32(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Clicking 'Load More' button and checking if product count increases.");
        softAssert.assertTrue(allPages.groceryPage().countOfProductWithLoadMoreButton());
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check if 'Read More' button is clickable")
    public void TC_08_33(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Checking if 'Read More' button is clickable.");
        softAssert.assertTrue(allPages.groceryPage().verifyReadMoreButtonIsClickable(), "The 'Read More' button is not clickable.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify long product description appears after clicking 'Read More'")
    public void TC_08_34(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying the long product description appears.");
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforLongText(ConfigReader.getProperty("LongDiscriptionApple")), "The long product description is not displayed.");
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Severity(SeverityLevel.NORMAL)
    @Description("Click 'Less' and verify short description appears again")
    public void TC_08_35(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);

        Allure.step("Checking if 'Less' button is clickable and short text appears again.");
        softAssert.assertTrue(allPages.groceryPage().productDescriptionforShortText(ConfigReader.getProperty("shortDiscriptionApple")));
        softAssert.assertAll();
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify small images under product are visible")
    public void TC_08_36_verifySmallImagesAreVisible(ITestContext context) {
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        AllPages allPages = new AllPages();
        setupBrowser(context);
        Allure.step("Checking if small images under the product are visible.");
        softAssert.assertTrue(
                allPages.groceryPage().areSmallImagesVisible(),
                "Small images under the product are not visible."
        );
        closeDriver();
    }

    @Test(groups = {"regression"})
    @Owner("Tugba")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify small images match big image when clicked")
    public void TC_08_37_verifySmallImagesMatchBigPhotos(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Clicking small images and checking if they match the big image.");
        softAssert.assertTrue(allPages.groceryPage().isProductPhotoFunctionalityWorking(), "Not all small photos match their corresponding big photo.");
        closeDriver();
    }
}
