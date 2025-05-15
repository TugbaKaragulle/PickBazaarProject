package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasketPage {


    public BasketPage() {      PageFactory.initElements(Driver.getDriver(), this);  }

    //-------------------------------BasketPage Locates--------------------------------------------------------------//

    @FindBy(css = "div.flex.font-semibold.text-accent>span")
    private WebElement numberOfItems;

}
