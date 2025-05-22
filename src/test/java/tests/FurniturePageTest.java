package tests;

import io.qameta.allure.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.Driver.setupBrowser;

@Feature("Furniture Page Tests")
public class FurniturePageTest {


    @Test(groups = {"regression"})
    @Description ("Verify that all menu types are displayed on the left side")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Furniture menu visibility")
    @Owner("Mertay Gürel")
    public void TC_013_01(ITestContext context){
        AllPages allPages = new AllPages();
        SoftAssert softAssert=new SoftAssert();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarFurniturePage_url"));
        softAssert.assertTrue(allPages.furniturePage().inFurniturePageAllMenuTypeIsDisplay(),
                "left furniture menu some menu not seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression"})
    @Description("Verify that exclusive furniture frame is visible")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Exclusive furniture frame visibility")
    @Owner("Mertay Gürel")
    public void TC_013_02(ITestContext context){
        AllPages allPages = new AllPages();
        SoftAssert softAssert=new SoftAssert();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarFurniturePage_url"));
        softAssert.assertTrue(allPages.furniturePage().isExclusiveFurnituresMadeOnlyForYouFrameImageDisplay(),
                "Exclusive Furnitures Made Only For You FrameImageDisplay not seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression"})
    @Description("Verify that all 30 furniture items are displayed properly")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Furniture product list completeness")
    @Owner("Mertay Gürel")
    //Duration is 5.12 Minutes for this loop sometimes duration time getting high as 10 minutes
    public void TC_013_03(ITestContext context){
        AllPages allPages = new AllPages();
        SoftAssert softAssert=new SoftAssert();
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarFurniturePage_url"));
        softAssert.assertTrue(allPages.furniturePage().isallFurnitureProduct30PiecesImgAndPrice(),
                "Some Furniture images,product names or prices did'nt Seeing in the loop");
        softAssert.assertAll();
        Driver.closeDriver();
    }

}
