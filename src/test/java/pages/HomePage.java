package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

import static utilities.ReusableMethods.clickElement;
import static utilities.ReusableMethods.isWebElementDisplayed;


public class HomePage {


    public HomePage() {      PageFactory.initElements(Driver.getDriver(), this);  }

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
    @FindBy(xpath ="//div[@class='relative flex rounded md:rounded-lg h-14 shadow-900']")
    private WebElement searhAreaFrame;
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

    public WebElement getSearhAreaFrame() {
        return searhAreaFrame;
    }

    public boolean isPickBazarLogoDisplayed(WebDriver driver){
        return isWebElementDisplayed(pickBazarLogo);
    }

    public void clickShopsButton(){
        clickElement(shopsButton);
    }
    public void clickFAQButton(){
        clickElement(FAQButton);
    }
    public void clickOffersButton(){
        clickElement(offersButton);
    }
    public void clickContactButton(){
        clickElement(contactButton);
    }
    public void clickJoinButton(){
        clickElement(joinButton);
    }
    public void clickDropDownMenu(){
        clickElement(dropDownMenu);
    }
    public void clickPickBazarLogo(){
        clickElement(pickBazarLogo);
    }
    public void clickSearchButton(){
        clickElement(searchButton);
    }
    public void sendKeysSearchTextArea(String text){
        searchTextInput.sendKeys(text);
    }


    public boolean isSearchTextInputDisplayed(WebDriver driver){
        return  isWebElementDisplayed(searchTextInput);
    }
    public boolean isSearchButtonDisplayed(WebDriver driver){
        return isWebElementDisplayed(searchButton);
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


    public WebElement getOffersButton() {
        return offersButton;
    }

    public WebElement getFAQButton() {
        return FAQButton;
    }

    public WebElement getContactButton() {
        return contactButton;
    }

    public WebElement getBecomeASellerButton() {
        return becomeASellerButton;
    }

    public WebElement getJoinButton() {
        return joinButton;
    }

    public WebElement getH1TagText() {
        return h1TagText;
    }

    public WebElement getpTagText() {
        return pTagText;
    }

    public WebElement getSearchTextInput() {
        return searchTextInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getExpressDeliveryImage() {
        return expressDeliveryImage;
    }

    public WebElement getCashOnDeliveryImage() {
        return cashOnDeliveryImage;
    }

    public List<WebElement> getDeliveryImagesList() {
        return deliveryImagesList;
    }

    public WebElement getShopsButton() {
        return shopsButton;
    }
}
