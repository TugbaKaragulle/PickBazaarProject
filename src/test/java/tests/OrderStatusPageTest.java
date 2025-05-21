package tests;


import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.Driver.setupBrowser;
public class OrderStatusPageTest {


    @Test(groups = {"smoke"})
    public void TC_020_01(ITestContext context) {
        SoftAssert softAssert = new SoftAssert();
        AllPages allPages = new AllPages();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarOrderStatusPage_url"));

        softAssert.assertTrue(allPages.orderStatusPage().First5PiecesOrderStatus(),
                "First 5 order status text is not same compare to the real one");
        allPages.orderStatusPage().slideToright();
        softAssert.assertTrue(allPages.orderStatusPage().Last6PiecesOrderStatus(),
                "Last 6 order status text is not same compare to the real one");
        softAssert.assertTrue(allPages.orderStatusPage().orderStatusAreaChecking(),
                "orderStatusAreaChecking area not seeing..");
        softAssert.assertTrue(allPages.orderStatusPage().all4StatusType_OrderNumber_Date_Total_PaymentMethod(),
                "there was something wrong about top of the page in orderstatus page these 4 value");

        softAssert.assertAll();

        Driver.closeDriver();
    }

    @Test(groups = {"smoke"})
    public void TC_020_02(ITestContext context) {
        SoftAssert softAssert = new SoftAssert();
        AllPages allPages = new AllPages();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarOrderStatusPage_url"));

        softAssert.assertTrue(allPages.orderStatusPage().isTotalAmountAreaPricesDiplay(),
                "in total amount area some prices not seeing");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke"})
    public void TC_020_03(ITestContext context) {
        SoftAssert softAssert = new SoftAssert();
        AllPages allPages = new AllPages();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarOrderStatusPage_url"));

        softAssert.assertTrue(allPages.orderStatusPage().verifyAllRequiredFieldsExist(),
                "orderStatusAreaChecking area not seeing..");

        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"smoke"})
    public void TC_020_04(ITestContext context) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        AllPages allPages = new AllPages();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarOrderStatusPage_url"));
        allPages.orderStatusPage().pageScrollDown();


        softAssert.assertTrue(allPages.orderStatusPage().aboutItemQuantityImageAndPriceIsDisplay(),
                "Order status page look button of the page something is not seeing (price,quantity or image");
        softAssert.assertTrue(allPages.orderStatusPage().writeReviewAndUpdateReview(),
                "Order status page look button of the page something is not seeing (write review or update review");


        softAssert.assertAll();
        Driver.closeDriver();
    }


}
