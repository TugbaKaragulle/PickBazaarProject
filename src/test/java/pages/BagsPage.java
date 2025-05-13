package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BagsPage {

    public BagsPage() {
        PageFactory.initElements(Driver.getDriver(), this);  }


}
