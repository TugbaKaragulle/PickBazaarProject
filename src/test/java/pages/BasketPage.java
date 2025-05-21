package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.ReusableMethods.clickElement;

public class BasketPage {

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


    //----------------------------------clickElement Methods------------------------------------//
    public void openBasketPanel() {
        clickElement(basketPanelSliderButton);//ekranın sağındaki Sepet görüntüleme ikonuna tıklar
    }

    public void closeBasketPage() {
        clickElement(closeButton);
    }

    public boolean verifyProductNameInBasket(String productName) {
        logger.info(productName);
        for (WebElement w : productNameListInBasket) {
            logger.info(w.getText().trim());
            if (w.getText().trim().equals(productName.trim()))
                return true;
        }
        return false;
    }

    public boolean verfiyDeletedProductFromBasket() {

        int numberOfItems = ReusableMethods.convertElementTextIntoInteger(numberOfItemsInBasketButton);
        System.out.println("numberOfItems = " + numberOfItems);
        if (numberOfItems == 0) return true;
        else return false;

    }

    public int getPriceOfOneProduct(int index) {
        return ReusableMethods.convertElementTextIntoInteger(priceOfOneProductList.get(index));
    }

    public int getTotalPriceOfOneProduct(int index) {
        return ReusableMethods.convertElementTextIntoInteger(totalPriceOfOneProductList.get(index));
    }


    public String getProductNameInBasket(int index) {
        return productNameListInBasket.get(index).getText();
    }

    public void addAProductIntoBasketWithPlusIcon(AllPages page, int indexOfList) {
        page.basketPage().clickPlusIcon(indexOfList); //ürünü sepete ekle tıklanır
    }

    public void deleteAProductFromBasketWithMinusIcon(AllPages page, int indexofList) {
        page.basketPage().clickMinusIcon(indexofList); //ürünü sepete ekle tıklanır
    }

    public boolean deleteAProductFromBasketXButton(AllPages page, int indexofList) {

        String nameOfIndexedProduct = page.basketPage().getProductNameInBasket(indexofList); //ürün silinmeden önce ürün adı depolanır
        boolean isProductDeleted = false;
        for (WebElement w : page.basketPage().getProductNameListInBasket()) {
            if (!(w.getText().equals(nameOfIndexedProduct))) {
                isProductDeleted = true;
            }
        }
        page.basketPage().clickXbuttonOfAProduct(indexofList);
        return isProductDeleted;
    }


    private void clickXbuttonOfAProduct(int indexofList) {
        clickElement((deleteProductWithXButton.get(indexofList)));
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

    public WebElement getNumberOfItemsInBasketButton() {
        return numberOfItemsInBasketButton;
    }

    public Logger getLogger() {
        return logger;
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
        clickElement(checkoutButton);
    }
}
