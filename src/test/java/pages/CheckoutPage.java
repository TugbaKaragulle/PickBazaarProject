package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckoutPage {

    public CheckoutPage() {      PageFactory.initElements(Driver.getDriver(), this);  }

}
