package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GroceryPage {


    public GroceryPage() {
        PageFactory.initElements(Driver.getDriver(), this);  }


}
