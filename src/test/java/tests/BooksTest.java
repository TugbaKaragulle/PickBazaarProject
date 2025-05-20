package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;
import static utilities.Driver.setupBrowser;

public class BooksTest {

    @Test(groups = "smoke")
    public void TC_23_01(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        softAssert.assertTrue(allPages.booksPage().isBannerDisplayed());
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke") //TODO ----> BUG
    public void TC_23_02(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        String title ="Best Selling Products";
        softAssert.assertTrue(allPages.booksPage().bestSellingProductsField(title));
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_03(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getPopularProductTitle());
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularProductImages());
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularProductBookNames());
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getPopularPruductPrice());
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(groups = "smoke")
    public void TC_23_04(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getWhichBookTitle());
        softAssert.assertTrue(ReusableMethods.isWebElementDisplayed(allPages.booksPage().getWhichBookTitle()));
        allPages.booksPage().clickAsMuchAsYouWant(allPages.booksPage().getWhichBookScrollArrow(),1);
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getWhichBookImages()));
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_05(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getWhichBookTitle());
        allPages.booksPage().clickAsMuchAsYouWant(allPages.booksPage().getWhichBookScrollArrow(),1);
        softAssert.assertTrue(allPages.booksPage().areElementsDisplayed(allPages.booksPage().getWhichBookNames()));
        softAssert.assertAll();
        Driver.closeDriver();
    }

    //TODO---> 23_07 isimli @Test MANUEL BUG


    @Test(groups = "smoke")
    public void TC_23_07(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getNewArrivalTitle());
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBooksImg());
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBookNames());
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getNewArrivalBooksPrice());
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void TC_23_08(ITestContext context) {
        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        setupBrowser(context);
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        allPages.booksPage().scrollToElementOnBookPage(allPages.booksPage().getTopAuthorsTitle());
        allPages.booksPage().clickAsMuchAsYouWant(allPages.booksPage().getAuthorScrollArrow(),3);
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getAuthorPhotos());
        allPages.booksPage().areElementsDisplayed(allPages.booksPage().getWhichBookNames());
        softAssert.assertAll();
        Driver.closeDriver();
    }



}
