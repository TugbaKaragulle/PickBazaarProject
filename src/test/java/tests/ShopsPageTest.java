package tests;

import static utilities.Driver.setupBrowser;
import static utilities.ReusableMethods.waitForClickability;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class ShopsPageTest {



    @Test(dataProvider = "shopsData")

    public void testNavigateToShop(ITestContext context,WebElement shopLink, WebElement shopTitle, String expectedUrl, int testNumber) {
        setupBrowser(context);

        AllPages allPages = new AllPages();
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));
        allPages.pickBazarHomePage().clickShopsButton();

        //shopLink.click();
        ReusableMethods.clickElement(shopLink);
        waitForClickability(shopTitle, 10);

        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "URL dogrulanamadi");
        softAssert.assertTrue(shopTitle.isDisplayed(), "Sayfa basligi görünür degil");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @DataProvider(name = "shopsData")
    public Object[][] shopsData() {
        AllPages allPages = new AllPages();
        return new Object[][] {
                { allPages.shopsPage().furnitureShopLink, allPages.shopsPage().furnitureShopTitle, "https://shop.clarusway.net/shops/furniture-shop", 1 },
                { allPages.shopsPage().clothingShopLink, allPages.shopsPage().clothingShopTitle, "https://shop.clarusway.net/shops/clothing-shop", 2 },
                { allPages.shopsPage().bagsShopLink, allPages.shopsPage().bagsShopTitle, "https://shop.clarusway.net/shops/bags-shop", 3 },
                { allPages.shopsPage().makeupShopLink, allPages.shopsPage().makeupShopTitle, "https://shop.clarusway.net/shops/makeup-shop", 4 },
                { allPages.shopsPage().bakeryShopLink, allPages.shopsPage().bakeryShopTitle, "https://shop.clarusway.net/shops/bakery-shop", 5 },
                { allPages.shopsPage().groceryShopLink, allPages.shopsPage().groceryShopTitle, "https://shop.clarusway.net/shops/grocery-shop", 6 },
                { allPages.shopsPage().booksShopLink, allPages.shopsPage().booksShopTitle, "https://shop.clarusway.net/shops/books-shop", 7 }
        };
    }

}