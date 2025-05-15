package tests;



public class ShopsPageTest {


import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

public class ShopsPageTest {

    @DataProvider(name = "shopData")
    public Object[][] shopDataProvider() {
        return new Object[][]{
                {"Furniture Shop", "furniture-shop"},
                {"Clothing Shop", "clothing-shop"},
                {"Bags Shop", "bags-shop"},
                {"Makeup Shop", "makeup-shop"},
                {"Bakery Shop", "bakery-shop"},
                {"Grocery Shop", "grocery-shop"},
                {"Books Shop", "books-shop"}
        };
    }

    @Test(dataProvider = "shopData", groups = "smoke")
    public void testShopVisibilityAndUrl(String shopName, String slug, ITestContext context) {
        SoftAssert softAssert = new SoftAssert();


        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));


        AllPages allPages = new AllPages();


        allPages.homePage.goToShopsPage();


        softAssert.assertTrue(allPages.shopsPage.isShopVisible(shopName), shopName + " görünmedi!");


        allPages.shopsPage.clickShopByName(shopName);


        String expectedUrl = "https://shop.clarusway.net/shops/" + slug;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "URL yanlış!");


        softAssert.assertAll();


        Driver.closeDriver();
    }

}