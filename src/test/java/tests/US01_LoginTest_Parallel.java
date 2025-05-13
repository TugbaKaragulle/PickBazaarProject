package tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class US01_LoginTest_Parallel {

    AllPages allPages;

    //Happy Path
    @Test(priority = 1)
    void tc01_happyPath(ITestContext context) {

        setupBrowser(context);

        allPages = new AllPages();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        allPages.contactListHomePage().email.sendKeys(ConfigReader.getProperty("email"));
        allPages.contactListHomePage().password.sendKeys(ConfigReader.getProperty("password"));
        allPages.contactListHomePage().submit.click();
        assert allPages.contactListPage().addContact.isDisplayed();//Java Assertion

        Driver.closeDriver();

    }


    @Test(priority = 2)
    void tc02_negative_test(ITestContext context) throws InterruptedException {
        setupBrowser(context);
        allPages = new AllPages();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        //allPages.contactListHomePage().email.sendKeys(ConfigReader.getProperty("email"));
        allPages.contactListHomePage().password.sendKeys(ConfigReader.getProperty("password"));
        allPages.contactListHomePage().submit.click();
        Thread.sleep(500);
        assert allPages.contactListHomePage().errorMessage.getText().equals("Incorrect username or password");//Java Assertion

        Driver.closeDriver();

    }

    @Test(priority = 3, groups = "smoke")
    void tc03_negative_test(ITestContext context) throws InterruptedException {
        setupBrowser(context);
        allPages = new AllPages();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        allPages.contactListHomePage().email.sendKeys(ConfigReader.getProperty("email"));
        //allPages.contactListHomePage().password.sendKeys(ConfigReader.getProperty("password"));
        allPages.contactListHomePage().submit.click();
        Thread.sleep(500);
        assert allPages.contactListHomePage().errorMessage.getText().equals("Incorrect username or password");//Java Assertion

        Driver.closeDriver();

    }

}
