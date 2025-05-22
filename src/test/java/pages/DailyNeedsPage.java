package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class DailyNeedsPage {

    public DailyNeedsPage() {
        PageFactory.initElements(Driver.getDriver(), this);  }

    @FindBy(css = "button[class='hidden product-cart lg:flex relative']")
    private WebElement basketIcon;

    public void openBasketPanel() {
        ReusableMethods.clickElement(basketIcon);
    }

    public boolean isVisibleBasketIcon(){
        return ReusableMethods.isWebElementDisplayed(basketIcon);
    }

    public boolean isClickableBasketIcon() {
        return ReusableMethods.waitForClickability(basketIcon);
    }
}
