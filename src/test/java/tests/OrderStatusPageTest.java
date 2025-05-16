package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import pages.OrderStatusPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class OrderStatusPageTest {
    SoftAssert softAssert = new SoftAssert();
    AllPages allPages = new AllPages();

    @Test(groups = {"smoke"})
    public void deneme(ITestContext context) {
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarOrderStatusPage_url"));

        softAssert.assertTrue(allPages.orderStatusPage().First5PiecesOrderStatus(),
                "First 5 order status text is not same compare to the real one");

        softAssert.assertAll();
        Driver.closeDriver();
    }
}
