package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.getDriver;

//***

public class BooksPage {

    public BooksPage() {
        PageFactory.initElements(getDriver(), this);  }

    //*************************** Locates ************************

    @FindBy(xpath = "//div[@class='swiper-slide swiper-slide-active swiper-slide-duplicate-next swiper-slide-duplicate-prev']//img")
    private WebElement banner;

    @FindBy(xpath = "//div[@class='flex items-center justify-between mb-7 ']")
    private List<WebElement>mainTitles;

    @FindBy(xpath = "//div[@class='grid grid-cols-[repeat(auto-fill,minmax(260px,1fr))] gap-6 gap-y-10 lg:grid-cols-[repeat(auto-fill,minmax(200px,1fr))] xl:grid-cols-[repeat(auto-fill,minmax(220px,1fr))] xl:gap-8 xl:gap-y-11 2xl:grid-cols-5 3xl:grid-cols-[repeat(auto-fill,minmax(360px,1fr))]']//a[@class='cursor-pointer']//span//img[@class='product-image rounded-lg']")
    private List<WebElement> newArrivalBookNames;

    @FindBy(xpath = "//div[@class='grid grid-cols-[repeat(auto-fill,minmax(260px,1fr))] gap-6 gap-y-10 lg:grid-cols-[repeat(auto-fill,minmax(200px,1fr))] xl:grid-cols-[repeat(auto-fill,minmax(220px,1fr))] xl:gap-8 xl:gap-y-11 2xl:grid-cols-5 3xl:grid-cols-[repeat(auto-fill,minmax(360px,1fr))]']//div[@class='flex shrink-0 items-center']")
    private List<WebElement> newArrivalBooksPrice;

    @FindBy(xpath = "//div[@class='grid grid-cols-[repeat(auto-fill,minmax(260px,1fr))] gap-6 gap-y-10 lg:grid-cols-[repeat(auto-fill,minmax(200px,1fr))] xl:grid-cols-[repeat(auto-fill,minmax(220px,1fr))] xl:gap-8 xl:gap-y-11 2xl:grid-cols-5 3xl:grid-cols-[repeat(auto-fill,minmax(360px,1fr))]']//img")
    private List<WebElement> newArrivalBooksImg;

    @FindBy(xpath = "//h3[text()='New Arrival Books']")
    private WebElement newArrivalTitle;

    @FindBy(xpath = "//h3[text()='Popular Products']")
    private WebElement popularProductTitle;

    @FindBy(xpath = "//div[@class='grid grid-cols-[repeat(auto-fill,minmax(260px,1fr))] gap-6 gap-y-10 lg:grid-cols-[repeat(auto-fill,minmax(200px,1fr))] xl:grid-cols-[repeat(auto-fill,minmax(220px,1fr))] xl:gap-8 xl:gap-y-12 2xl:grid-cols-[repeat(auto-fill,minmax(280px,1fr))] 3xl:grid-cols-[repeat(auto-fill,minmax(360px,1fr))]']//img")
    private List<WebElement> popularProductImages;

    @FindBy( xpath = "//div[@class='grid grid-cols-[repeat(auto-fill,minmax(260px,1fr))] gap-6 gap-y-10 lg:grid-cols-[repeat(auto-fill,minmax(200px,1fr))] xl:grid-cols-[repeat(auto-fill,minmax(220px,1fr))] xl:gap-8 xl:gap-y-12 2xl:grid-cols-[repeat(auto-fill,minmax(280px,1fr))] 3xl:grid-cols-[repeat(auto-fill,minmax(360px,1fr))]']//a[@class='text-sm font-semibold text-heading transition-colors hover:text-orange-500 md:text-base']")
    private List<WebElement> popularProductBookNames;

    @FindBy (xpath = "//div[@class='grid grid-cols-[repeat(auto-fill,minmax(260px,1fr))] gap-6 gap-y-10 lg:grid-cols-[repeat(auto-fill,minmax(200px,1fr))] xl:grid-cols-[repeat(auto-fill,minmax(220px,1fr))] xl:gap-8 xl:gap-y-12 2xl:grid-cols-[repeat(auto-fill,minmax(280px,1fr))] 3xl:grid-cols-[repeat(auto-fill,minmax(360px,1fr))]']//div[@class='flex shrink-0 items-center']")
    private List<WebElement> popularPruductPrice;

    @FindBy (xpath = "//div[@class='relative overflow-hidden text-center cursor-pointer group']//img")
    private List<WebElement> whichBookImages;

    @FindBy (xpath = "//h3[text()='Which Book You Like to See?']")
    private WebElement whichBookTitle;

    @FindBy (xpath = "//span[@class='block mt-2 text-base font-semibold transition-colors text-heading group-hover:text-orange-500 ltr:text-left rtl:text-right']")
    private List<WebElement> whichBookNames;

    @FindBy(xpath = "//div[@class='absolute z-10 flex items-center justify-center w-8 h-8 -mt-4 rounded-full outline-none cursor-pointer banner-slider-next text-heading bg-light shadow-300 top-1/2 ltr:-right-4 rtl:-left-4 focus:outline-none transition-colors hover:text-orange-500']")
    private WebElement whichBookScrollArrow;

    @FindBy(xpath = "//h3[text()='Top Authors']")
    private  WebElement topAuthorsTitle;

    @FindBy(xpath = "//a[contains(@class, 'group')]") //(xpath = "//a[@class='group relative flex cursor-pointer flex-col items-center bg-light text-center']")
    private List<WebElement> authorPhotos;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() <= 5]")
    private List<WebElement> first5AuthorPhotos;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() > last() - 5]")
    private List<WebElement> last5AuthorPhotos;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() <= 5]/span")
    private List<WebElement> first5AuthorNames;

    @FindBy(xpath = "(//span[contains(@class, 'rounded-full') and contains(@class, 'h-44') and contains(@class, 'shadow-350')])[position() > last() - 5]/span")
    private List<WebElement> last5AuthorNames;

    @FindBy(xpath = "//div[contains(@class, 'author-slider-next')]") //(xpath = "//div[@class='author-slider-next w-8 h-8 flex items-center justify-center text-heading bg-light shadow-300 outline-none rounded-full absolute top-1/2 -mt-4 z-[5] cursor-pointer ltr:-right-3 rtl:-left-3 ltr:lg:-right-4 rtl:lg:-left-4 focus:outline-none transition-colors hover:text-orange-500']")
    private WebElement authorScrollArrowRight;

    @FindBy(xpath = "//div[@class='author-slider-prev w-8 h-8 flex items-center justify-center text-heading bg-light shadow-300 outline-none rounded-full absolute top-1/2 -mt-4 z-[5] cursor-pointer ltr:-left-3 rtl:-right-3 ltr:lg:-left-4 rtl:lg:-right-4 focus:outline-none transition-colors hover:text-orange-500']")
    private WebElement authorScrollArrowLeft;

    @FindBy(xpath = "//span[@class='block text-center font-semibold text-heading transition-colors group-hover:text-orange-500']")
    private List<WebElement> authorNames;


    //TODO*****************************Getter Methods*******************

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
    //TODO***************************  Variables **********************

    AllPages allPages = new AllPages();
    Actions actions = new Actions(getDriver());

    //TODO************************** Reusable Methods *****************

    public void clickAsMuchAsYouWant(WebElement element, int clickCount){
        for (int i = 0; i < clickCount; i++) {
            ReusableMethods.waitForVisibility(getDriver(),element,10);
            JavascriptUtils.clickElementByJS(element);//element.click();
        }
    }

    //TODO************************** Methods **************************

    public boolean isBannerDisplayed(){
        allPages.pickBazarHomePage().clickDropDownMenuOption("Books");
        return banner.isDisplayed();
    }

    public boolean bestSellingProductsField(String title){
        allPages.pickBazarHomePage().clickDropDownMenuOption("Books");
        List<String> titles = new ArrayList<>();
        for (WebElement each : mainTitles){
        titles.add(each.getText());
        }
        return titles.contains(title);
    }

    public void scrollToElementOnBookPage(WebElement element){
        allPages.pickBazarHomePage().clickDropDownMenuOption("Books");
        JavascriptUtils.scrollIntoViewJS(element);
       // actions.scrollToElement(element).perform();
        ReusableMethods.waitForVisibilityOfTitle("Pickbazar | Books");
    }

    public boolean areElementsDisplayed(List<WebElement> elements){
        for (WebElement each : elements){
            ReusableMethods.waitForVisibility(getDriver(),each,10);
            if (!each.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public void deneme(){
        scrollToElementOnBookPage(topAuthorsTitle);
        for (WebElement each : authorPhotos){
            System.out.println(each.getAccessibleName()+" ");

        }

    }


}

