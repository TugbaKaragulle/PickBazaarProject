package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BooksPage {

    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);  }
}
