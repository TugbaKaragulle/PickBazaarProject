package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class ClothingPageTest {





    @Test()
   public void TC_012_01 (ITestContext context){
    setupBrowser(context);
        Driver.getDriver().get(ConfigReader.getProperty("pickbazar_url"));








    }





    }

