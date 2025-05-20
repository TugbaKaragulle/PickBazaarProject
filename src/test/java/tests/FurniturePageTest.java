package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.Driver.setupBrowser;

public class FurniturePageTest {


    @Test(groups = {"regression"})
    public void TC_013_01(ITestContext context){
        AllPages allPages = new AllPages();
        SoftAssert softAssert=new SoftAssert();
        Logger logger = LogManager.getLogger(FurniturePageTest.class);
        setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazarFurniturePage_url"));
        softAssert.assertTrue(allPages.furniturePage().inFurniturePageAllMenuTypeIsDisplay(),
                "left furniture menu some menu not seeing");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test(groups = {"regression"})
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

    //Duration is 5.12 Minutes for this loop
    @Test(groups = {"regression"})
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
