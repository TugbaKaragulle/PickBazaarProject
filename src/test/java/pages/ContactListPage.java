package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactListPage {

    public ContactListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "add-contact")
    public WebElement addContact;







}
