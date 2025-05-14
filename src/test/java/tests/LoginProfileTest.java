package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.Driver.setupBrowser;

public class LoginProfileTest {



    @Test(priority = 1, groups = "smoke")
    public void deneme(ITestContext context) {

        setupBrowser(context);
        AllPages allPages = new AllPages();
        allPages.loginProfilePage().loginMethod(ConfigReader.getProperty("loginPageEmail"),ConfigReader.getProperty("loginPagePassword"));
        Driver.closeDriver();
    }
}
