package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class PickBazarHomePage {


    public PickBazarHomePage() {      PageFactory.initElements(Driver.getDriver(), this);  }

    //------------top left side of homepage------------
    @FindBy(css = "a.inline-flex.mx-auto.lg\\:mx-0")
    private WebElement pickBazarLogo;
    @FindBy(id = "headlessui-menu-button-1")
    private WebElement dropDownMenu;

    //------------top right side of homepage------------
    @FindBy(css = "div>ul>li>a[href='/shops']")
    private WebElement shopsButton;
    @FindBy(css = "div>ul>li>a[href='/offers']")
    private WebElement offersButton;
    @FindBy(css = "div>ul>li>a[href='/help']")
    private WebElement FAQButton;
    @FindBy(css = "div>ul>li>a[href='/contact']")
    private WebElement contactButton;
    @FindBy(css = "div>a[href='undefined/register']")
    private WebElement becomeASellerButton;
    @FindBy(css = "div>li>button[data-variant='normal']")
    private WebElement joinButton;



    //------------middle of homepage------------
    @FindBy(css = "div>h1.text-2xl.font-bold.tracking-tight.text-heading")
    private WebElement h1TagText;    //Groceries Delivered in 90 Minute
    @FindBy(css = "div>p.text-sm.text-heading")
    private WebElement pTagText;    //Get your healthy foods & snacks delivered at your doorsteps all day everyday
    @FindBy(css = "div>input.search")
    private WebElement searchTextInput;
    @FindBy(xpath = "//div/button[text()=\"Search\"]")
    private WebElement searchButton;
    @FindBy(css = "div.swiper-slide.swiper-slide-active>span>img")
    private WebElement expressDeliveryImage;
    @FindBy(css = "div.swiper-slide.swiper-slide-next>span>img")
    private WebElement cashOnDeliveryImage;
    @FindBy(css = "div.swiper-wrapper>div>span>img")
    private List<WebElement> deliveryImagesList;

    public WebElement getPickBazarLogo() {
        return pickBazarLogo;
    }

    public WebElement getDropDownMenu() {
        return dropDownMenu;
    }


    public boolean isPickBazarLogoDisplayed(){

        return isWebElementDisplayed(pickBazarLogo);

    }

    public boolean isDropDownMenuDisplayed() {
        return isWebElementDisplayed(dropDownMenu);
    }

    public boolean isGrocerySelectedDropDownValue() {
        return dropDownMenu.getText().equals("Grocery");
    }

    public boolean isShopsButtonDisplayed() {
        return shopsButton.isDisplayed();
    }

    public void clickElement(WebElement element) {
        element.click();
    }


    public boolean isWebElementDisplayed(WebElement element) {
        return ReusableMethods.waitForVisibility(Driver.getDriver(), element, 10).isDisplayed();
    }

    public boolean waitForClickability(WebElement element) {
        try {
            ReusableMethods.waitForClickability(Driver.getDriver(), element, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
