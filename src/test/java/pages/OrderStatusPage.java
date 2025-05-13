package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrderStatusPage {

    public OrderStatusPage() {
        PageFactory.initElements(Driver.getDriver(), this);  }

}
