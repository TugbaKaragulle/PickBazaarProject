package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.GroceryTest;
import utilities.ConfigReader;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.isWebElementDisplayed;
//***

public class GroceryPage {

    public GroceryPage() {
        PageFactory.initElements(getDriver(), this);
    }
    //***************************************** @FindBy **************************************************************

    @FindBy(xpath = "//h3[@class='mb-4 cursor-pointer truncate text-xs text-body md:text-sm']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//span[@class='text-sm font-semibold text-heading md:text-base']")
    private List<WebElement> productPriceList;

    @FindBy(xpath = "//li[@class='rounded-md py-1']")
    private List<WebElement> ScrollDownOnTheLeft;

    @FindBy(xpath = "//button[@class='flex w-full items-center py-2 font-semibold text-body-dark outline-none transition-all ease-in-expo  focus:text-accent focus:outline-none focus:ring-0 ltr:text-left rtl:text-right text-body-dark text-sm text-body ltr:ml-5 rtl:mr-5']")
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

    @FindBy(xpath = "//div[@class='product-gallery-next absolute top-2/4 z-10 -mt-4 flex h-8 w-8 cursor-pointer items-center justify-center rounded-full border border-border-200 border-opacity-70 bg-light text-heading shadow-xl transition-all duration-200 hover:bg-gray-100 ltr:-right-4 rtl:-left-4 md:-mt-5 md:h-9 md:w-9 ltr:md:-right-5 rtl:md:-left-5']")
    private WebElement photoChange;

    //**************************************** Class Level Variables And Objects ***********************************
    AllPages allPages = new AllPages();
    Actions actions = new Actions(getDriver());
    String actualProductName;
    boolean result;
    Logger logger = LogManager.getLogger(GroceryTest.class);
    List<String> Data1 = new ArrayList<>(Arrays.asList("Fruits", "Vegetables"));
    List<String> Data2 = new ArrayList<>(Arrays.asList("Fresh Fish", "Meat"));
    List<String> Data3 = new ArrayList<>(Arrays.asList("Nuts & Biscuits", "Chocolates", "Crisps", "Noodles & Pasta", "Sauce", "Soup"));
    List<String> Data4 = new ArrayList<>(Arrays.asList("Cat Food", "Dog Food", "Accessories"));
    List<String> Data5 = new ArrayList<>(Arrays.asList("Air Freshner", "Cleaning Products", "Kitchen Accessories", "Laundry"));
    List<String> Data6 = new ArrayList<>(Arrays.asList("Milk", "Butter", "Egg", "Yogurt"));
    List<String> Data7 = new ArrayList<>(Arrays.asList("Oil", "Rice", "Salt & Sugar", "Spices"));
    List<String> Data8 = new ArrayList<>(Arrays.asList("Bread", "Cereal", "Jam"));
    List<String> Data9 = new ArrayList<>(Arrays.asList("Bath", "Cream", "Deodorant", "Face Care", "Oral Care", "Shaving Needs"));

    //***************************************** Test Methods *********************************************************

    public boolean isElementTextEquals(WebElement element, String expectedText, String logMessage) {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Waiting for the element to be visible");
            ReusableMethods.isWebElementDisplayed(element);
            String actualText = element.getText();
            logger.info("Actual text from element: '" + actualText + "' ");
            logger.info("Expected text to verify: '" + expectedText + "' ");
            result = actualText.equals(expectedText);
            logger.info("Verifying if the text " + logMessage + " is visible --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean verifyElementsInListVisible(List<WebElement> elements, String logMessage) {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Selecting 'Grocery' category from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            logger.info("Scrolling to the element in the list.");
            JavascriptUtils.scrollIntoViewJS(elements.get(1));
            logger.info("Waiting for visibility of the element.");
            ReusableMethods.waitForVisibility(getDriver(), elements.get(1), 10);
            boolean flag = false;
            logger.info("Verifying that " + logMessage);
            logger.info("Checking if element is displayed ");
            for (WebElement each : elements) {
                if (each.isDisplayed()) {
                    flag = true;
                } else {
                    logger.info("Element is not displayed ");
                }
            }
            logger.info("Result of verification--> " + flag);
            return flag;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isGroceryClickable() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            result = ReusableMethods.waitForClickability(allPages.pickBazarHomePage().getDropDownMenu());
            logger.info("Verifying if the grocery button is clickable on homepage --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isGroceryLinkContains() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking on 'Grocery' option in the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            logger.info("Waiting for the URL to contain the word 'grocery'.");
            ReusableMethods.waitForUrlContains("grocery");
            String actualUrl = getDriver().getCurrentUrl();
            result = actualUrl.contains("grocery");
            logger.info("Does URL contain 'grocery'? --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean verifyProductsAppearAfterSearch(String products) {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking on 'Grocery' option in the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            logger.info("Searching for product: " + products);
            allPages.pickBazarHomePage().sendKeysSearchTextArea(products + Keys.ENTER);
            actions.scrollToElement(productsList.getFirst());
            logger.info("Waiting for visibility of the product '" + products + "' in the list");
            ReusableMethods.waitForVisibility(getDriver(), productsList.getFirst(), 10);
            actualProductName = productsList.getFirst().getText().toLowerCase();
            result = actualProductName.contains(products.toLowerCase());
            logger.info("Verified that the product " + products + " is displayed --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    //Bu method sayesinde menüde basliklarin siralamasi degisse de isme göre bulack
    public String clickLeftMenuByTitle(String title) {
        try {
            for (WebElement menu : ScrollDownOnTheLeft) {
                if (menu.getText().equalsIgnoreCase(title)) {
                    menu.click();
                }
            }
            return title;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public boolean verifySubmenuInMainMenu(String text, List<String> expectedSubMenu, String logMessage) {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking on 'Grocery' dropdown menu option.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            logger.info("Clicking on left menu item with title: '" + text + "'");
            clickLeftMenuByTitle(text);
            List<String> actualSubMenu = new ArrayList<>();
            for (WebElement element : insideTheScrollDownMenuOnTheLeft) {
                String submenuText = element.getText();
                actualSubMenu.add(submenuText);
                logger.info("Found submenu item: '" + submenuText + "'");
            }
            logger.info("Checking if the submenu contains all expected items: " + expectedSubMenu);
            result = actualSubMenu.containsAll(expectedSubMenu);
            logger.info("Result of submenu verification --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean VerifyproductCount() { //Ürün sayisinin 30 oldugunu dogrular
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            result = productsList.size() == 30;
            logger.info("Checking if there are max 30 products before clicking 'Load More'.");
            logger.info("Result of verification --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean countOfProductWithLoadMoreButton() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking the 'Grocery' option from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            logger.info("Scrolling to the 'Load More' button.");
            actions.scrollToElement(loadMoreButton).perform();
            logger.info("Waiting for the 'Load More' button to become clickable.");
            ReusableMethods.waitForClickability(loadMoreButton);
            logger.info("Clicking the 'Load More' button.");
            loadMoreButton.click();
            logger.info("Waiting for the product count to increase beyond 30.");
            ReusableMethods.waitForProductCountToIncrease(productsList, 30);
            result = productsList.size() > 30;
            logger.info("Clicking 'Load More' button and checking if product count increases.");
            logger.info("Result of verification --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean verifyReadMoreButtonIsClickable() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking the 'Grocery' option from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            productsList.getFirst().click();
            logger.info("Checking if 'Read More' button is clickable.");
            result = ReusableMethods.waitForClickability(readMoreButton);
            logger.info("Result of verification --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    //Read more'a tiklayinca uzun aciklamanin geldigini dogrular
    public boolean productDescriptionforLongText(String longText) {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking the 'Grocery' option from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            productsList.getFirst().click();
            ReusableMethods.waitForClickability(readMoreButton, 10);
            readMoreButton.click();
            String actualText = productDescription.getDomProperty("textContent").trim();
            result = actualText.equals(longText);
            logger.info("Verifying the long product description appears.");
            logger.info("Result of verification --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    //Less'e tiklayinca aciklamanin kisaldigini dogrular
    public boolean productDescriptionforShortText(String shortText) {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking the 'Grocery' option from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            productsList.getFirst().click();
            ReusableMethods.waitForClickability(readMoreButton, 10);
            readMoreButton.click();
            ReusableMethods.waitForClickability(lessButton, 10);
            lessButton.click();
            String actualText = productDescription.getDomProperty("textContent").trim();
            result = actualText.equals(shortText);
            logger.info("Checking if 'Less' button is clickable and short text appears again.");
            logger.info("Result of verification --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isSearchButtonDisplayedOnGroceryPage() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Clicking on 'Grocery' option in the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            boolean result = isWebElementDisplayed(allPages.pickBazarHomePage().getSearchButton());
            logger.info("Verifying if the search button is visible ");
            logger.info("Result of verification --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isImageDisplayed(WebElement element, String logMessage) {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Selecting 'Grocery' category from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            logger.info("Waiting until the web element is visible on the page");
            ReusableMethods.isWebElementDisplayed(element);
            boolean result = ReusableMethods.waitForVisibility(getDriver(), element, 10).isDisplayed();
            logger.info("Checking if the image in " + logMessage + " frame is visible --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isSearchFrameDisplayed() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Selecting 'Grocery' category from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            logger.info("Waiting until the web element is visible on the page");
            ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame());
            boolean result = ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame());
            logger.info("Verifying if the search frame is visible --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean areSmallImagesVisible() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Selecting 'Grocery' category from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            productsList.getFirst().click();
            for (WebElement each : productSmallfotos) {
                if (!each.isDisplayed()) {
                    return false;
                }
            }
            logger.info("All small photos are visible.");
            return true;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isProductPhotoFunctionalityWorking() {
        logger.info("Navigating to the homepage.");
        try {
            getDriver().get(ConfigReader.getProperty("pickbazar_url"));
            logger.info("Selecting 'Grocery' category from the dropdown menu.");
            allPages.pickBazarHomePage().clickDropDownMenuOption("Grocery");
            productsList.getFirst().click();
            List<WebElement> bigPhotos = Arrays.asList(getProductBigFotoIndex1(), getProductBigFotoIndex2(), getProductBigFotoIndex3());

            for (int i = 1; i <= 3; i++) {
                String bigAlt = getBigFotoAtributeAlt(bigPhotos.get(i - 1));
                String smallAlt = getSmallFotoAtributeAlt(i, productSmallfotos);

                if (!bigAlt.equals(smallAlt)) {
                    logger.warn("Mismatch between big and small photo at index " + i);
                    return false;
                }
            }
            logger.info("All small product photos are visible and match their corresponding big photos.");
            return true;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    //Bir web elementin attribute degerinde sadece rakamlari birakip string olarak döner
    public String getBigFotoAtributeAlt(WebElement element) {
        try {
            String text = element.getDomProperty("alt");
            return justDigit(text);
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public String justDigit(String text) {
        try {
            text = text.replaceAll("\\D", "");
            return text;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //web elementlerden olusan listte verilen indexteki elementin attribute degerinde sadece rakamlari birakip string olarak döner
    public String getSmallFotoAtributeAlt(int index, List<WebElement> elements) {
        try {
            String text = elements.get(index).getDomProperty("alt");
            return justDigit(text);
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            throw new RuntimeException(e);
        }
    }

    //******************************************Getter Methods**********************************************************

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

    public List<String> getData1() {
        return Data1;
    }

    public List<String> getData9() {
        return Data9;
    }

    public List<String> getData8() {
        return Data8;
    }

    public List<String> getData7() {
        return Data7;
    }

    public List<String> getData6() {
        return Data6;
    }

    public List<String> getData5() {
        return Data5;
    }

    public List<String> getData4() {
        return Data4;
    }

    public List<String> getData3() {
        return Data3;
    }

    public List<String> getData2() {
        return Data2;
    }

}
