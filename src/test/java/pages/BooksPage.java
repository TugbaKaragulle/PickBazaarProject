package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BooksTest;
import utilities.ConfigReader;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.getDriver;

//***

public class BooksPage {

    public BooksPage() {
        PageFactory.initElements(getDriver(), this);
    }
    //*************************** Locates ************************

    @FindBy(xpath = "//div[contains(@class, 'swiper-slide-active')]//img")
    private WebElement banner;

    @FindBy(xpath = "//div[@class='flex items-center justify-between mb-7 ']")
    private List<WebElement> mainTitles;

    @FindBy(xpath = "//div[contains(@class,'gap-y-11')]//a[@class='cursor-pointer']")
    private List<WebElement> newArrivalBookNames;

    @FindBy(xpath = "//div[contains(@class,'gap-y-11')]//span[@class='text-base font-semibold text-orange-500']")
    private List<WebElement> newArrivalBooksPrice;

    @FindBy(xpath = "//div[contains(@class,'gap-y-11')]//a[@class='cursor-pointer']//img")
    private List<WebElement> newArrivalBooksImg;

    @FindBy(xpath = "//h3[text()='New Arrival Books']")
    private WebElement newArrivalTitle;

    @FindBy(xpath = "//h3[text()='Popular Products']")
    private WebElement popularProductTitle;

    @FindBy(xpath = "//div[contains(@class, 'grid-cols') and contains(@class, 'gap')]//img")
    private List<WebElement> popularProductImages;

    @FindBy(xpath = "//div[contains(@class, 'grid-cols') and contains(@class, 'gap')]//a[contains(@class, 'text-heading')]")
    private List<WebElement> popularProductBookNames;

    @FindBy(xpath = "//div[contains(@class, 'grid-cols') and contains(@class, 'gap')]//div[contains(@class, 'shrink-0')]")
    private List<WebElement> popularPruductPrice;

    @FindBy(xpath = "//div[@class='relative overflow-hidden text-center cursor-pointer group']//img")
    private List<WebElement> whichBookImages;

    @FindBy(xpath = "//h3[text()='Which Book You Like to See?']")
    private WebElement whichBookTitle;

    @FindBy(xpath = "//span[@class='block mt-2 text-base font-semibold transition-colors text-heading group-hover:text-orange-500 ltr:text-left rtl:text-right']")
    private List<WebElement> whichBookNames;

    @FindBy(xpath = "//div[contains(@class, 'banner-slider-next')]")
    private WebElement whichBookScrollArrow;

    @FindBy(xpath = "//h3[text()='Top Authors']")
    private WebElement topAuthorsTitle;

    @FindBy(xpath = "//a[contains(@class, 'group')]")
    private List<WebElement> authorPhotos;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() <= 5]")
    private List<WebElement> first5AuthorPhotos;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() > last() - 5]")
    private List<WebElement> last5AuthorPhotos;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() <= 5]/span")
    private List<WebElement> first5AuthorNames;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() > last() - 5]/span")
    private List<WebElement> last5AuthorNames;

    @FindBy(xpath = "//div[contains(@class, 'author-slider-next')]")
    private WebElement authorScrollArrowRight;

    @FindBy(xpath = "//div[contains(@class, 'author-slider-prev')]")
    private WebElement authorScrollArrowLeft;

    @FindBy(xpath = "//span[@class='block text-center font-semibold text-heading transition-colors group-hover:text-orange-500']")
    private List<WebElement> authorNames;

    @FindBy(xpath = "//div[contains(@class,'grid grid-cols')]//a[@class='cursor-pointer']")
    private List<WebElement> allBooks;

    //**************************************** Variables ******************************************

    AllPages allPages = new AllPages();
    String bestSellingtitle = "Best Selling Products";
    Logger logger = LogManager.getLogger(BooksTest.class);
    boolean result;

    //***************************************** Methods ********************************************

    public void clickMultipleTimes(WebElement element, int clickCount) {
        try {
            logger.info("Clicking on the element.");
            for (int i = 0; i < clickCount; i++) {
                ReusableMethods.waitForVisibility(getDriver(), element, 10);
                JavascriptUtils.clickElementByJS(element);
            }
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
        }
    }

    public boolean isBannerDisplayed() {
        try {
            navigateToBooksPage();
            result = banner.isDisplayed();
            logger.info("Verifying that the banner with 'Sale UP TO 20% OFF' and 'Shop Now' is visible --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean bestSellingProductsField(String title) {
        try {
            navigateToBooksPage();
            List<String> titles = new ArrayList<>();
            for (WebElement each : mainTitles) {
                String text = each.getText();
                logger.info("Found title: '" + text + "'");
                titles.add(text);
            }
            result = titles.contains(title);
            logger.info("Verifying that the 'Best Selling Products' section is visible --> " + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            navigateToBooksPage();
            logger.info("Scrolling to 'Top Authors' section.");
            JavascriptUtils.scrollIntoViewJS(element);
            logger.info("Waiting for the page title to be visible.");
            ReusableMethods.waitForVisibilityOfTitle("Pickbazar | Books");
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
        }
    }

    public boolean areElementsDisplayed(List<WebElement> elements, WebElement targetElement, String logMessage) {
        try {
            scrollToElement(targetElement);
            logger.info("Verifying that " + logMessage + " are visible.");
            for (WebElement each : elements) {
                ReusableMethods.waitForVisibility(getDriver(), each, 10);
                if (!each.isDisplayed()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean checkAuthorSectionItems(List<WebElement>elementList, List<WebElement>elementList2) {
        try {
            scrollToElement(topAuthorsTitle);

            for (WebElement each :elementList ) {
                ReusableMethods.waitForVisibility(getDriver(), each, 10);
                result = each.isDisplayed();
                if (!result) {
                    return false;
                }
            }
            logger.info("Clicking on the scroll arrow 3 times.");
            clickMultipleTimes(authorScrollArrowRight, 3);
            logger.info("Verifying that author photos are visible.");
            for (WebElement each2 :elementList2 ) {
                ReusableMethods.waitForVisibility(getDriver(), each2, 10);
                result = each2.isDisplayed();
                if (!result) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isWhichBookSectionDisplayed(List<WebElement> elements, WebElement element, String logMessage) {
        try {
            scrollToElement(element);
            logger.info("Clicking on the scroll arrow.");
            clickMultipleTimes(whichBookScrollArrow, 1);
            logger.info("Verifying that the book " + logMessage + " are displayed.");
            for (WebElement each : elements) {
                ReusableMethods.waitForVisibility(getDriver(), each, 10);
                result = each.isDisplayed();
                if (!result) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean isTitleVisible(WebElement element) {
        scrollToElement(element);
        try {
            result = ReusableMethods.isWebElementDisplayed(element);
            logger.info("Verifying that the section title is visible -->" + result);
            return result;
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public void navigateToBooksPage() {
        navigateToHomePage();
        logger.info("Clicked on 'Books' category in the dropdown menu.");
        allPages.pickBazarHomePage().clickDropDownMenuOption("Books");
    }

    public void navigateToHomePage(){
        logger.info("Navigating to the homepage.");
        getDriver().get(ConfigReader.getProperty("pickbazar_url"));
    }



    //***************************** Getter Methods *******************

    public WebElement getBanner() {
        return banner;
    }

    public List<WebElement> getMainTitles() {
        return mainTitles;
    }

    public List<WebElement> getNewArrivalBookNames() {
        return newArrivalBookNames;
    }

    public List<WebElement> getNewArrivalBooksPrice() {
        return newArrivalBooksPrice;
    }

    public List<WebElement> getNewArrivalBooksImg() {
        return newArrivalBooksImg;
    }

    public WebElement getNewArrivalTitle() {
        return newArrivalTitle;
    }

    public WebElement getPopularProductTitle() {
        return popularProductTitle;
    }

    public List<WebElement> getPopularProductImages() {
        return popularProductImages;
    }

    public List<WebElement> getPopularProductBookNames() {
        return popularProductBookNames;
    }

    public List<WebElement> getPopularPruductPrice() {
        return popularPruductPrice;
    }

    public List<WebElement> getWhichBookImages() {
        return whichBookImages;
    }

    public WebElement getWhichBookTitle() {
        return whichBookTitle;
    }

    public List<WebElement> getWhichBookNames() {
        return whichBookNames;
    }

    public WebElement getWhichBookScrollArrow() {
        return whichBookScrollArrow;
    }

    public WebElement getTopAuthorsTitle() {
        return topAuthorsTitle;
    }

    public List<WebElement> getAuthorPhotos() {
        return authorPhotos;
    }

    public WebElement getAuthorScrollArrowRight() {
        return authorScrollArrowRight;
    }

    public WebElement getAuthorScrollArrowLeft() {
        return authorScrollArrowLeft;
    }

    public List<WebElement> getAuthorNames() {
        return authorNames;
    }

    public List<WebElement> getFirst5AuthorPhotos() {
        return first5AuthorPhotos;
    }

    public List<WebElement> getLast5AuthorPhotos() {
        return last5AuthorPhotos;
    }

    public List<WebElement> getFirst5AuthorNames() {
        return first5AuthorNames;
    }

    public List<WebElement> getLast5AuthorNames() {
        return last5AuthorNames;
    }

    public List<WebElement> getAllBooks() {
        return allBooks;
    }

    //********************** Variables getter **********************

    public String getBestSellingtitle() {
        return bestSellingtitle;
    }

}



