package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static utilities.Driver.getDriver;
//***

public class GroceryPage {

    public GroceryPage() {
        PageFactory.initElements(getDriver(), this);  }

  //TODO***************************************** @FindBy **************************************************************

 @FindBy (xpath = "//h3[@class='mb-4 cursor-pointer truncate text-xs text-body md:text-sm']")
 private List<WebElement> productsList;

 @FindBy(xpath = "//span[@class='text-sm font-semibold text-heading md:text-base']")
 private List<WebElement> productPriceList;

 @FindBy (xpath = "//li[@class='rounded-md py-1']")
 private List<WebElement> ScrollDownOnTheLeft;

 @FindBy(xpath ="//button[@class='flex w-full items-center py-2 font-semibold text-body-dark outline-none transition-all ease-in-expo  focus:text-accent focus:outline-none focus:ring-0 ltr:text-left rtl:text-right text-body-dark text-sm text-body ltr:ml-5 rtl:mr-5']" )
 private List<WebElement> insideTheScrollDownMenuOnTheLeft;

 @FindBy(xpath = "//button[text()='Load More']")
 private WebElement loadMoreButton;

 @FindBy(xpath = "//button[@class='mt-1 inline-block font-bold text-accent ']")
 private WebElement readMoreButton;

 @FindBy(xpath = "//button[text()='Less']")
 private WebElement lessButton;

 @FindBy(xpath = "//div[@class='mt-3 text-sm leading-7 text-body md:mt-4']")
 private WebElement productDescription;

 @FindBy(xpath = "//img[starts-with(@alt,'Product thumb')]")
 private List<WebElement> productSmallfotos;

 @FindBy(xpath = "//img[@alt='Product gallery 573']")
 private WebElement productBigFotoIndex0;

 @FindBy(xpath = "//img[@alt='Product gallery 574']")
 private WebElement productBigFotoIndex1;

 @FindBy(xpath = "//img[@alt='Product gallery 575']")
 private WebElement productBigFotoIndex2;

 @FindBy(xpath = "//img[@alt='Product gallery 737']")
 private WebElement productBigFotoIndex3;

  @FindBy (xpath = "//div[@class='product-gallery-next absolute top-2/4 z-10 -mt-4 flex h-8 w-8 cursor-pointer items-center justify-center rounded-full border border-border-200 border-opacity-70 bg-light text-heading shadow-xl transition-all duration-200 hover:bg-gray-100 ltr:-right-4 rtl:-left-4 md:-mt-5 md:h-9 md:w-9 ltr:md:-right-5 rtl:md:-left-5']")
  private WebElement photoChange;

  //TODO******************************************Getter Methods**********************************************************

    public List<WebElement> getProductsList() {
        return productsList;
    }
    public List<WebElement> getProductPriceList() {
        return productPriceList;
    }
    public WebElement getLoadMoreButton() {
        return loadMoreButton;
    }
    public List<WebElement> getProductSmallfotos() {
        return productSmallfotos;
    }
    public WebElement getProductBigFotoIndex0() {
        return productBigFotoIndex0;
    }
    public WebElement getProductBigFotoIndex1() {
        return productBigFotoIndex1;
    }
    public WebElement getProductBigFotoIndex2() {
        return productBigFotoIndex2;
    }
    public WebElement getProductBigFotoIndex3() {
        return productBigFotoIndex3;
    }
    public WebElement getPhotoChange() {
        return photoChange;
    }
    public WebElement getProductDescription() {
        return productDescription;
    }
    public WebElement getLessButton() {
        return lessButton;
    }
    public WebElement getReadMoreButton() {
        return readMoreButton;
    }
    public List<WebElement> getInsideTheScrollDownMenuOnTheLeft() {
        return insideTheScrollDownMenuOnTheLeft;
    }
    public List<WebElement> getScrollDownOnTheLeft() {
        return ScrollDownOnTheLeft;
    }

  //TODO**************************************** Class Level Variables And Objects ***********************************
    AllPages allPages = new AllPages();
    Actions actions = new Actions(getDriver());
    String actualProductName;
    List<WebElement> bigFotosList = new ArrayList<>(Arrays.asList(productBigFotoIndex0,productBigFotoIndex1,productBigFotoIndex2,productBigFotoIndex3));


  //TODO************************************ Reusable Methods **********************************************************

    public boolean isInDropdownMenuUrlContains(String keyword, WebElement dropDownElement, WebElement element){
        Actions actions = new Actions(getDriver());
        actions.click(dropDownElement).perform();
        actions.moveToElement(element).click(element).perform();
        ReusableMethods.waitForUrlContains("grocery");
        String actualUrl = getDriver().getCurrentUrl();
        assert actualUrl != null;
        return actualUrl.contains(keyword);
    }

    public boolean isElementTextEquals(WebElement element, String expectedText){
        ReusableMethods.isWebElementDisplayed(element);
        String actualText = element.getText();
        return actualText.equals(expectedText);
    }

    public boolean verifyElementsInListVisible(List<WebElement> elements){
        boolean flag= false;
        for (WebElement each : elements){
            if (each.isDisplayed()){
                flag= true;
            }
        }
        return flag;
    }

    //Bu method String ifadede sadece sayilari birakir
    public String justDigit(String text){
        text = text.replaceAll("\\D","");
        return text;
    }

    //Bir web elementin attribute degerinde sadece rakamlari birakip string olarak döner
    public String getBigFotoAtributeAlt(WebElement element){
        String text =  element.getDomProperty("alt");
        return justDigit(text);
    }

    //web elementlerden olusan listte verilen indexteki elementin attribute degerinde sadece rakamlari birakip string olarak döner
    public String getSmallFotoAtributeAlt(int index, List<WebElement> elements){
        String text = elements.get(index).getDomProperty("alt");
        return justDigit(text);
    }

  //TODO***************************************** Test Methods *********************************************************

    public boolean isGroceryClickable(){
        return ReusableMethods.waitForClickability(allPages.pickBazarHomePage().getDropDownMenu());
    }

    public boolean isGroceryLinkContains(){

        return isInDropdownMenuUrlContains("grocery",allPages.pickBazarHomePage()
                .getDropDownMenu(),allPages.pickBazarHomePage()
                .getGroceryOptionInDropDownMenu());
    }

    public boolean verifyProductsAppearAfterSearch(String products){ //Search frame'de aratilan ürünlerin görünürlügünü kontrol eder
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        allPages.pickBazarHomePage().sendKeysSearchTextArea(products + Keys.ENTER);
        actions.scrollToElement(productsList.getFirst());
        ReusableMethods.waitForVisibility(getDriver(), productsList.getFirst(),10);
        actualProductName = productsList.getFirst().getText().toLowerCase();
        return actualProductName.contains(products.toLowerCase());
    }

    //Alttaki iki method ayni teste ait
    //Bu method sayesinde menüde basliklarin siralamasi degisse de isme göre bulacak
    public String clickLeftMenuByTitle(String title) {
        for (WebElement menu : ScrollDownOnTheLeft) {
            if (menu.getText().equalsIgnoreCase(title)) {
                menu.click();
            }
        }
        return title;
    }
    public boolean VerifyIfScrollDownMenuContainsSubMenu(String text, List<String> expectedSubMenu){
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        clickLeftMenuByTitle(text);
        List<String> actualSubMenu = new ArrayList<>();
        for (WebElement element : insideTheScrollDownMenuOnTheLeft){
            actualSubMenu.add(element.getText());
        }
        return actualSubMenu.containsAll(expectedSubMenu);
    }

    public boolean VerifyproductCount(){ //Ürün sayisinin 30 oldugunu dogrular
        return productsList.size()==30;
    }

    public boolean countOfProductWithLoadMoreButton(){
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        actions.scrollToElement(loadMoreButton).perform();
        ReusableMethods.waitForClickability(loadMoreButton);
        loadMoreButton.click();
        ReusableMethods.waitForProductCountToIncrease(productsList, 30);
        return productsList.size() > 30;
    }

    public boolean verifyReadMoreButtonIsClickable (){
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        productsList.getFirst().click();
        return ReusableMethods.waitForClickability(readMoreButton);
    }

    //Read more'a tiklayinca uzun aciklamanin geldigini dogrular
    public boolean productDescriptionforLongText(String longText){
        ReusableMethods.waitForClickability(readMoreButton,10);
        readMoreButton.click();
        String actualText = productDescription.getDomProperty("textContent").trim();
        return actualText.equals(longText);
    }

    //Less'e tiklayinca aciklamanin kisaldigini dogrular
    public boolean productDescriptionforShortText(String shortText){
        ReusableMethods.waitForClickability(lessButton,10);
        lessButton.click();
        String actualText = productDescription.getDomProperty("textContent").trim();
        return actualText.equals(shortText);
    }

    public boolean areSmallImagesVisible(){
        allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
        productsList.getFirst().click();
        for (WebElement each: productSmallfotos){
            if (!each.isDisplayed()){ //biri bile görünmüyorsa test basarisiz
                return false;
            }
        }
        return true;
    }

    public boolean verifyIfPhotosAreEquals(WebElement bigFotoElement, List<WebElement> elements, int index){
        JavascriptUtils.clickElementByJS(photoChange);
        ReusableMethods.waitForSeconds(1);
        return getBigFotoAtributeAlt(bigFotoElement)
                .equals(getSmallFotoAtributeAlt(index, elements));
    }
}
