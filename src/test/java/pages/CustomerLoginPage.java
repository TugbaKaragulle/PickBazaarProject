package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CustomerLoginPage {

    public CustomerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);  }


}
