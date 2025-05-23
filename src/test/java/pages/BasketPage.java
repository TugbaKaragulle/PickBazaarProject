package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.ReusableMethods.*;

public class BasketPage {

    AllPages page = new AllPages();
    Logger logger = LogManager.getLogger(BasketPage.class);

    public BasketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //-------------------------------BasketPage Section Locates--------------------------------------------------------------//

    @FindBy(css = "div[dir='ltr']>aside.fixed.inset-0.z-50.h-full.overflow-hidden")
    private WebElement basketPanel;
    @FindBy(css = "div[class='flex-grow pt-16 pb-20']")
    private WebElement basketFrame;
    @FindBy(css = "div.flex.font-semibold.text-accent>span")
    private WebElement numberOfItemsInBasketSection;
    @FindBy(css = "button[class='flex h-7 w-7 items-center justify-center rounded-full bg-gray-100 text-muted transition-all duration-200 hover:bg-accent hover:text-light focus:bg-accent focus:text-light focus:outline-none ltr:ml-3 ltr:-mr-2 rtl:mr-3 rtl:-ml-2']")
    private WebElement closeButton;
    @FindBy(xpath = "(//div[@class='flex-shrink-0']//button)[2]")
    private List<WebElement> incrementItemNumberList;
    @FindBy(xpath = "(//div[@class='flex-shrink-0']//button)[1]")
    private List<WebElement> decrementItemNumberList;
    @FindBy(xpath = "//span[@class='flex pb-0.5']")
    private WebElement basketPanelSliderButton;
    @FindBy(xpath = "//div//h3[@class='font-bold text-heading']")
    private List<WebElement> productNameListInBasket;
    @FindBy(xpath = "//div//h4[text()='No products found']")
    private WebElement noProductFoundHeader;
    @FindBy(xpath = "//div[@class='flex-shrink-0']//div[@class='flex flex-1 items-center justify-center px-3 text-sm font-semibold !px-0 text-heading']")
    private List<WebElement> numberOfItemsOfOneProduct;
    @FindBy(css = "div>p[class='my-2.5 font-semibold text-accent']")
    private List<WebElement> priceOfOneProductList;
    @FindBy(css = "div>span[class='font-bold text-heading ltr:ml-auto rtl:mr-auto']")
    private List<WebElement> totalPriceOfOneProductList;
    @FindBy(xpath = "//span[@class='font-bold text-heading ltr:ml-auto rtl:mr-auto']/following-sibling::button")
    private List<WebElement> deleteProductWithXButton;

    @FindBy(xpath = "//button[.//span[text()='Checkout']]")
    private WebElement checkoutButton;


    //--------------------------------------------------locates of small basket button--------------------------------------------------------------------//


    @FindBy(xpath = "//span[@class='flex ltr:ml-2 rtl:mr-2']")
    private WebElement numberOfItemsInBasketButton;


    //********************************************** METHODS *******************************************************************//

    public void openBasketPanel() {
        clickElementByJS(basketPanelSliderButton );//ekranın sağındaki Sepet görüntüleme ikonuna tıklar
        logger.info("Ekranda sağdaki küçük Sepet ikonuna tıklandı");
    }

    public void closeBasketPage() {

        clickElement(closeButton);
        logger.info("Sepet panelinde X butonuna tıklandı, Sepet paneli kapatıldı");
    }

    public boolean verifyProductNameInBasket(String productName) {

        for (WebElement w : productNameListInBasket) {
            if (w.getText().trim().equals(productName.trim())) {
                logger.info(w.getText()+" adlı ürünün sepete eklendiği doğrulandı. İsim doğrulaması yapıldı" );
                return true;
            }
        }
        return false;
    }

    public boolean verfiyDeletedProductFromBasket() {

        int numberOfItems = ReusableMethods.convertElementTextIntoInteger(numberOfItemsInBasketButton);
        if (numberOfItems == 0){
            logger.info("Sepetteki ürün sayısının 0 olduğu doğrulandı.");
            return true;
        }
        else {
            logger.info("Sepette ürün bulunuyor.");
            return false;
        }
    }

    public int getPriceOfOneProduct(int index) {
        int price = ReusableMethods.convertElementTextIntoInteger(priceOfOneProductList.get(index));
        logger.info("Ürün tutarı: " + price);
        return price;
    }

    public int getTotalPriceOfOneProduct(int index) {
        int totalPrice = ReusableMethods.convertElementTextIntoInteger(totalPriceOfOneProductList.get(index));
        logger.info("Bir üründen alınan toplam tutar: " + totalPrice );
        return totalPrice;
    }


    public String getProductNameInBasket(int index) {

        try {
            openBasketPanel();
            logger.info("Sepet paneli açıldı");
        } catch (Exception e) {
            logger.info("Sepet paneli açık");
        } finally {
            String productName = productNameListInBasket.get(index).getText();
            return productName;
        }
    }

    public void addAProductIntoBasketWithPlusIcon( int indexOfList) {
        clickPlusIcon(indexOfList);
        logger.info(" ( + ) butonuna tıklandı, sepete 1 adet ürün eklenmeli");
    }

    public void deleteAProductFromBasketWithMinusIcon(int indexofList) {
        clickMinusIcon(indexofList);
        logger.info(" ( - ) butonuna tıklandı, sepetten 1 adet ürün çıkarılmalı");
    }

    public boolean deleteAProductFromBasketXButton( int indexofList) {

        System.out.println("indexofList = " + indexofList);
        String nameOfIndexedProduct = getProductNameInBasket(indexofList); //ürün silinmeden önce ürün adı depolanır

        logger.info("Silinecek ürün = " + nameOfIndexedProduct);

        boolean isProductDeleted = false;
        for (WebElement w : getProductNameListInBasket()) {
            if (!(w.getText().equals(nameOfIndexedProduct))) {
                isProductDeleted = true;
            }
        }
        clickXbuttonOfAProduct(indexofList);
        logger.info("ürün silme = " +isProductDeleted);
        return isProductDeleted;
    }


    private void clickXbuttonOfAProduct(int indexofList) {
        clickElement((deleteProductWithXButton.get(indexofList)));
        logger.info("Sepet paneline ürün silmek için (X) butonuna tıklandı,");
    }

    private void clickPlusIcon(int indexOfList) {
        clickElement(incrementItemNumberList.get(indexOfList));
    }

    private void clickMinusIcon(int indexOfList) {
        clickElement(decrementItemNumberList.get(indexOfList));
    }

    //*****************************************************  isVisible methods  ***************************************************************************************//
    public boolean isVisibleBasketPanel() {
        return ReusableMethods.isWebElementDisplayed(basketFrame);
    }

    public boolean isBasketPanelClosed() {
        try {
            String style = basketFrame.getAttribute("style");
            // Eğer style değeri yoksa veya "right: 0%" içermiyorsa, panel kapalı sayılır
            boolean isClosed = (style == null || !style.contains("right: 0%"));
            return isClosed;
        } catch (Exception e) {
            return false;
        }
    }
//*****************************************************  getter methods  ***************************************************************************************//

    public int getNumberOfItemsInBasketButton() {
        int numberOfItems =  ReusableMethods.convertElementTextIntoInteger(page.basketPage().numberOfItemsInBasketButton);
        logger.info("Basket butonundaki ürün sayısı: " + numberOfItems);
        return numberOfItems;
    }

    public WebElement getNumberOfItemsInBasketPanel() {
        return getNumberOfItemsInBasketPanel();
    }

    public WebElement getBasketFrame() {
        return basketFrame;
    }

    public WebElement getCloseButton() {
        return closeButton;
    }

    public List<WebElement> getIncrementItemNumberList() {
        return incrementItemNumberList;
    }

    public List<WebElement> getDecrementItemNumberList() {
        return decrementItemNumberList;
    }

    public WebElement getBasketPanelSliderButton() {
        return basketPanelSliderButton;
    }

    public List<WebElement> getProductNameListInBasket() {
        return productNameListInBasket;
    }

    public WebElement getNoProductFoundHeader() {
        return noProductFoundHeader;
    }

    public boolean isNoProductFoundTextVisible() {
        return ReusableMethods.isWebElementDisplayed(noProductFoundHeader);
    }

    public int getNumberofItemsOfOneProduct(AllPages page, int index) {
        return ReusableMethods.convertElementTextIntoInteger(numberOfItemsOfOneProduct.get(index));
    }


    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public void clickCheckoutButton() {
        clickElementByJS(checkoutButton);
    }
}
