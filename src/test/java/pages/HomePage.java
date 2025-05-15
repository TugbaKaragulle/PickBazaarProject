package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.JavascriptUtils.clickElementByJS;
import static utilities.ReusableMethods.*;


public class HomePage {


    public HomePage() {      PageFactory.initElements(Driver.getDriver(), this);  }


//-------------------------------HomePage Locates--------------------------------------------------------------//

    //------------top left side of homepage------------
    @FindBy(css = "a.inline-flex.mx-auto.lg\\:mx-0")
    private WebElement pickBazarLogo;
    @FindBy(id = "headlessui-menu-button-1")
    private WebElement dropDownMenu;
    @FindBy(css="div>a[href='/grocery']")
    private WebElement groceryOptionInDropDownMenu;
    @FindBy(css="div>a[href='/bakery']")
    private WebElement bakeryOptionInDropDownMenu;
    @FindBy(css="div>a[href='/makeup']")
    private WebElement makeupOptionInDropDownMenu;
    @FindBy(css="div>a[href='/bags']")
    private WebElement bagsOptionInDropDownMenu;
    @FindBy(css="div>a[href='/clothing']")
    private WebElement clothingOptionInDropDownMenu;
    @FindBy(css="div>a[href='/furniture']")
    private WebElement furnitureOptionInDropDownMenu;
    @FindBy(css="div>a[href='/daily-needs']")
    private WebElement dailyNeedsOptionInDropDownMenu;
    @FindBy(css="div>a[href='/books']")
    private WebElement booksOptionInDropDownMenu;

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





//-------------------------------Display Methods--------------------------------------------------------------//

    public boolean isPickBazarLogoDisplayed(WebDriver driver){
        return isWebElementDisplayed(pickBazarLogo);
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

    public boolean isShopsButtonDisplayed() {
        return shopsButton.isDisplayed();
    }

    public boolean isOffersButtonDisplayed() {
        return offersButton.isDisplayed();
    }

    public boolean isFAQButtonDisplayed() {
        return FAQButton.isDisplayed();
    }

    public boolean isBecomeASellerButtonDisplayed() {
        return becomeASellerButton.isDisplayed();
    }

    public boolean isJoinButtonDisplayed() {
        return joinButton.isDisplayed();
    }

    public boolean isExpressDeliveryImageDisplayed() {
        return expressDeliveryImage.isDisplayed();
    }

    public boolean isCashOnDeliveryImageDeliveryImageDisplayed() {
        return cashOnDeliveryImage.isDisplayed();
    }



//-------------------------------End of Display Methods--------------------------------------------------------------//






//-------------------------------click Methods--------------------------------------------------------------//

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

    /**
     * Dropdown Menuden String parametresi göndererek ilgili Option seçeneklerine tıklar
     * @param optionName
     */
    public void clickDropDownMenuOption(String optionName) {

        //ilk adımda dropdownmenu açılır
        clickDropDownMenu();

        //ikinci adımda string değerine göre clickElement methodu çağırılır
        switch (optionName){
            case "Grocery" -> clickElement(groceryOptionInDropDownMenu);
            case "Bakery"  -> clickElement(bakeryOptionInDropDownMenu);
            case "Makeup"  -> clickElement(makeupOptionInDropDownMenu);
            case "Bags"  -> clickElement(bagsOptionInDropDownMenu);
            case "Clothing"  -> clickElement(clothingOptionInDropDownMenu);
            case "Furniture"  -> clickElement(furnitureOptionInDropDownMenu);
            case "Daily Needs"  -> clickElement(dailyNeedsOptionInDropDownMenu);
            case "Books"  -> clickElement(booksOptionInDropDownMenu);
            default -> clickElement(pickBazarLogo);
        }
        waitForSeconds(2);
    }
//-------------------------------End of Click Methods--------------------------------------------------------------//



    public void sendKeysSearchTextArea(String text){
        searchTextInput.sendKeys(text);
    }



    public boolean isGrocerySelectedDropDownValue() {
        return dropDownMenu.getText().equals("Grocery");
    }



    //-------------------------------getter Methods--------------------------------------------------------------//
    public WebElement getPickBazarLogo() {
        return pickBazarLogo;
    }

    public WebElement getDropDownMenu() {
        return dropDownMenu;
    }

    public WebElement getSearhAreaFrame() {
        return searhAreaFrame;
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
