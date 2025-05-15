package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShopsPage {


    public ShopsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[text()='Furniture Shop']")
    private WebElement furnitureShop;

    @FindBy(xpath = "//span[text()='Clothing Shop']")
    private WebElement clothingShop;

    @FindBy(xpath = "//span[text()='Bags Shop']")
    private WebElement bagsShop;

    @FindBy(xpath = "//span[text()='Makeup Shop']")
    private WebElement makeupShop;

    @FindBy(xpath = "//span[text()='Bakery Shop']")
    private WebElement bakeryShop;

    @FindBy(xpath = "//span[text()='Grocery Shop']")
    private WebElement groceryShop;

    @FindBy(xpath = "//span[text()='Books Shop']")
    private WebElement booksShop;


    public WebElement getShopElement(String shopName) {
        switch (shopName) {
            case "Furniture Shop":
                return furnitureShop;
            case "Clothing Shop":
                return clothingShop;
            case "Bags Shop":
                return bagsShop;
            case "Makeup Shop":
                return makeupShop;
            case "Bakery Shop":
                return bakeryShop;
            case "Grocery Shop":
                return groceryShop;
            case "Books Shop":
                return booksShop;
            default:
                throw new IllegalArgumentException("Shop with name " + shopName + " not found!");
        }
    }


    public boolean isShopVisible(String shopName) {
        try {
            return getShopElement(shopName).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void clickShopByName(String shopName) {
        getShopElement(shopName).click();
    }
}