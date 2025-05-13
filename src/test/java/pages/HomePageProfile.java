package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePageProfile {

    public HomePageProfile() {
        PageFactory.initElements(Driver.getDriver(), this);  }


}
