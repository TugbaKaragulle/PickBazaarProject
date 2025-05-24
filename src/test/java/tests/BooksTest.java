package tests;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.Driver;
import static utilities.Driver.setupBrowser;
//***

public class BooksTest {

    @Test(groups = "regression")
    @Owner("Tugba")
    @Description("TC_23_01_Books Page-Banner test")
    @Severity(SeverityLevel.NORMAL)
    public void TC_23_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that the banner with 'Sale UP TO 20% OFF' and 'Shop Now' is visible.", () -> {
            softAssert.assertTrue(allPages.booksPage().isBannerDisplayed(), "Banner with 'Sale UP TO 20% OFF' is not visible."); });
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_23_02_Books Page – Test of the \"Best Selling Products\" section")
    @Severity(SeverityLevel.NORMAL)
    public void TC_23_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that the 'Best Selling Products' section is visible.", () -> {
            softAssert.assertTrue(allPages.booksPage().bestSellingProductsField(allPages.booksPage().getBestSellingtitle()),
                    "'Best Selling Products' section is not visible."); });
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_023_03_Books Page – Test of the \"Popular Products\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that product images are visible.", () -> {
            softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularProductImages(),
                    allPages.booksPage().getPopularProductTitle(), "product images"),"Product images are not visible."); });
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_023_04_Books Page – Test of the \"Popular Products\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that product names are visible.", () -> {
            softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularProductBookNames(),
                    allPages.booksPage().getPopularProductTitle(), "product names"), "Product names are not visible."); });
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_023_05_Books Page – Test of the \"Popular Products\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_05(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that product prices are visible.");
            softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularPruductPrice(),
                    allPages.booksPage().getPopularProductTitle(), "product prices"),"Product prices are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "regression")
    @Owner("Tugba")
    @Description("TC_023_06_Books Page – Test of the \"Which Books You Like To See?\" section")
    @Severity(SeverityLevel.NORMAL)
    public void TC_23_06(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that the section title is visible.");
            softAssert.assertTrue(allPages.booksPage().isTitleVisible(allPages.booksPage().getWhichBookTitle()),
                    "'Which Books You Like To See?' title is not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_23_07_Books Page – Test of the \"Which Books You Like To See?\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_07(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that the book images are displayed.");
            softAssert.assertTrue(allPages.booksPage().isWhichBookSectionDisplayed(allPages.booksPage().getWhichBookImages(),
                    allPages.booksPage().getWhichBookTitle(), "images"), "Book images are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_023_08_Books Page – Visibility test of the titles under the \"Which Books You Like To See?\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_08(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that the book titles are displayed.");
            softAssert.assertTrue(allPages.booksPage().isWhichBookSectionDisplayed(allPages.booksPage().getWhichBookNames(),
                    allPages.booksPage().getWhichBookTitle(), "names"), "Book names are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    //TODO---> 23_09 isimli @Test MANUEL BUG

    @Test(groups ={"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_023_10_Books Page – Test of the \"New Arrival Books\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_10(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that new book images are visible.");
            softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBooksImg(),
                    allPages.booksPage().getNewArrivalTitle(), "new book images"), "New book images are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_023_11 Books Page – Test of the \"New Arrival Books\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_11(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that new book titles are visible.");
            softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBookNames(),
                    allPages.booksPage().getNewArrivalTitle(), "new book titles"),"New book titles are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression","smoke"})
    @Owner("Tugba")
    @Description("TC_023_12 Books Page – Test of the \"New Arrival Books\" section")
    @Severity(SeverityLevel.CRITICAL)
    public void TC_23_12(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that new book prices are visible.");
            softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBooksPrice(),
                    allPages.booksPage().getNewArrivalTitle(), "new book prices"), "New book prices are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "regression")
    @Owner("Tugba")
    @Description("TC_023_13_Books Page – Test of the \"Top Authors\" section")
    @Severity(SeverityLevel.NORMAL)
    public void TC_23_13(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that author photos are visible.");
            softAssert.assertTrue(allPages.booksPage().areAuthorPhotosDisplayed(),"Author photos are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "regression")
    @Owner("Tugba")
    @Description("TC_023_14_Books Page – Test of the \"Top Authors\" section")
    @Severity(SeverityLevel.NORMAL)
    public void TC_23_14(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        Allure.step("Verifying that author names are visible.");
            softAssert.assertTrue(allPages.booksPage().areAuthorNamesDisplayed(),"Author names are not visible.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
