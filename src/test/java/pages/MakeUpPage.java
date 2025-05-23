package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BasketPageTest;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.ReusableMethods.clickElement;

public class MakeUpPage {

    AllPages page = new AllPages();
    Logger logger = LogManager.getLogger(MakeUpPage.class);

    public MakeUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //-------product locates----
    @FindBy(xpath = "//article//h3")
    private List<WebElement> productNameList;
    @FindBy(xpath = "//article//div//span[@class='text-sm font-semibold text-accent md:text-base']")
    private List<WebElement> productPriceList;

    @FindBy(xpath = "//article//span[text()='plus' or text()='Cart']")
    private List<WebElement> addProductIntoBasketList_plusorcart;
    @FindBy(xpath = "//article//span[text()='Cart']")
    private List<WebElement> CartButtonList;
    @FindBy(xpath = "//article//button[.//span[text()='plus']]")
    private List<WebElement> plusIconList;
    @FindBy(xpath = "//article//button[.//span[normalize-space(text())='minus']]")
    private List<WebElement> minusIconList;


    @FindBy(xpath = "//article//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold']")
    private List<WebElement> numberOfProductAddedToBasket;

    public String getProductName(int index) {
        return productNameList.get(index).getText();
    }

    public void addProductIntoBasket(AllPages page, int indexOfList) {
        JavascriptUtils.scrollIntoViewJS(page.pickBazarHomePage().getProductFrame());  //ürünlerin olduğu frame görüntülenir
        page.makeUpPage().clickCartButtonOrPlusIcon(indexOfList); //sepete ürün eklenir
    }

    public String addProductIntoEmptyBasket(AllPages page, int indexOfList) {
        JavascriptUtils.scrollIntoViewJS(page.pickBazarHomePage().getProductFrame());
        page.makeUpPage().clickCartButton(indexOfList); //ürün ilk olarak sepete eklenir. (ürün sayısı 1 olacaktır)
        return page.makeUpPage().getProductName(indexOfList);
    }

    private void clickCartButton(int indexOfList) {
        clickElement(CartButtonList.get(indexOfList));
    }

    public String addAProductIntoBasketWithPlusIcon(AllPages page, int indexOfList) {
        page.makeUpPage().clickPlusIcon(indexOfList); //ürünü sepete ekle tıklanır
        return page.makeUpPage().getProductName(indexOfList);  //sepete eklenen ürün adı return eder.
    }

    public void clickCartButtonOrPlusIcon(int index) {
        clickElement(addProductIntoBasketList_plusorcart.get(index));
    }

    public void clickPlusIcon(int index) {
        clickElement(plusIconList.get(index));
    }

    public void addProductIntoBasket(int index) {
        clickElement(addProductIntoBasketList_plusorcart.get(index));
    }

    private void emptyBasket() {
        for (WebElement w : minusIconList)
            clickElement(w);
    }

    public void deleteProductWithMinusButton(int index) {
        clickElement(minusIconList.get(index));
    }

    public int getNumberOfProductAddedToBasket(int index) {

        int numberOfProduct = ReusableMethods.convertElementTextIntoInteger(page.makeUpPage().numberOfProductAddedToBasket.get(index));
        logger.info("Makeup sayfasında " + index+ " .indexteki ürünün sepete eklenen adeti: " + numberOfProduct);
        return numberOfProduct;
    }

    public WebElement addProductIntoBasketwithJS(AllPages page, int index, int times) {
        for (int i = 0; i < times; i++) {
            JavascriptUtils.scrollIntoViewJS(page.pickBazarHomePage().getProductFrame());  //elementin olduğu frame ekranda görüntülenir.
            JavascriptUtils.clickElementByJS(page.makeUpPage().addProductIntoBasketList_plusorcart.get(index));  //ürün sepete eklenir

        }
        return addProductIntoBasketList_plusorcart.get(index);
    }
}