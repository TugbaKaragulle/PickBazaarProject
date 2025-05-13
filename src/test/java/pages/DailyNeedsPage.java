package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DailyNeedsPage {

    public DailyNeedsPage() {
        PageFactory.initElements(Driver.getDriver(), this);  }

}
