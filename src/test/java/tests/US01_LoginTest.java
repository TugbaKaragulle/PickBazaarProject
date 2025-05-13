package tests;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactListHomePage;
import pages.ContactListPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.setupBrowser;

public class US01_LoginTest {

    ContactListHomePage contactListHomePage;
    ContactListPage contactListPage;

    //Happy Path
    @Test(priority = 1, groups = "smoke")
    void tc01_happyPath(ITestContext context) {
        setupBrowser(context); // context içinden parametre alınıyor

        contactListHomePage = new ContactListHomePage();
        contactListPage = new ContactListPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        contactListHomePage.email.sendKeys(ConfigReader.getProperty("email"));
        contactListHomePage.password.sendKeys(ConfigReader.getProperty("password"));
        contactListHomePage.submit.click();

        assert contactListPage.addContact.isDisplayed();

        Driver.closeDriver();
    }


}
