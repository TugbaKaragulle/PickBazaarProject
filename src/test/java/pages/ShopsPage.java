package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShopsPage {

    public ShopsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(@href, '/shops/furniture-shop')]")
    public WebElement furnitureShopLink;

    @FindBy(xpath = "//a[contains(@href, '/shops/clothing-shop')]")
    public WebElement clothingShopLink;

    @FindBy(xpath = "//a[contains(@href, '/shops/bags-shop')]")
    public WebElement bagsShopLink;

    @FindBy(xpath = "//a[contains(@href, '/shops/makeup-shop')]")
    public WebElement makeupShopLink;

    @FindBy(xpath = "//a[contains(@href, '/shops/bakery-shop')]")
    public WebElement bakeryShopLink;

    @FindBy(xpath = "//a[contains(@href, '/shops/grocery-shop')]")
    public WebElement groceryShopLink;

    @FindBy(xpath = "//a[contains(@href, '/shops/books-shop')]")
    public WebElement booksShopLink;


    // Sayfa başlıkları (sayfa yüklendiğinde görünür olması beklenen)

    @FindBy(xpath = "(//h3[contains(text(), 'Furniture Shop')])[2]")
    public WebElement furnitureShopTitle;

    @FindBy(xpath = "(//h3[contains(text(), 'Clothing Shop')])[2]")
    public WebElement clothingShopTitle;

    @FindBy(xpath = "(//h3[contains(text(), 'Bags Shop')])[2]")
    public WebElement bagsShopTitle;

    @FindBy(xpath = "(//h3[contains(text(), 'Makeup Shop')])[2]")
    public WebElement makeupShopTitle;

    @FindBy(xpath = "(//h3[contains(text(), 'Bakery Shop')])[2]")
    public WebElement bakeryShopTitle;

    @FindBy(xpath = "(//h3[contains(text(), 'Grocery Shop')])[2]")
    public WebElement groceryShopTitle;

    @FindBy(xpath = "(//h3[contains(text(), 'Books Shop')])[2]")
    public WebElement booksShopTitle;


    // Tıklama metotları
    public void clickFurnitureShop() {
        furnitureShopLink.click();
    }

    public void clickClothingShop() {
        clothingShopLink.click();
    }

    public void clickBagsShop() {
        bagsShopLink.click();
    }

    public void clickMakeupShop() {
        makeupShopLink.click();
    }

    public void clickBakeryShop() {
        bakeryShopLink.click();
    }

    public void clickGroceryShop() {
        groceryShopLink.click();
    }

    public void clickBooksShop() {
        booksShopLink.click();
    }
}
