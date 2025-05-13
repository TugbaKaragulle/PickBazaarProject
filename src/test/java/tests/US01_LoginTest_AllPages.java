package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.AllPages;
import pages.ContactListHomePage;
import pages.ContactListPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class US01_LoginTest_AllPages {

    AllPages allPages;

    //Happy Path
    @Test(priority = 1, groups = "smoke")
    void tc01_happyPath(ITestContext context){
        setupBrowser(context);

        allPages = new AllPages();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        allPages.contactListHomePage().email.sendKeys(ConfigReader.getProperty("email"));
        allPages.contactListHomePage().password.sendKeys(ConfigReader.getProperty("password"));
        allPages.contactListHomePage().submit.click();
        assert allPages.contactListPage().addContact.isDisplayed();//Java Assertion

        Driver.closeDriver();

    }

}
