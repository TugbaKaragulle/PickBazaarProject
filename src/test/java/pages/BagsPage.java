package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.time.Duration;
import java.util.List;
import static utilities.ReusableMethods.isWebElementDisplayed;

public class BagsPage {
    AllPages allPages = new AllPages();
    Actions actions = new Actions(Driver.getDriver(), Duration.ofSeconds(10));

    //**********************************************************BAGS PAGE LOCATES***********************************************************************************

    @FindBy(xpath = "//a[@href='/bags']")
    private WebElement dropDownMenuBagsLocate;

    @FindBy(xpath = "//h1[normalize-space(text())='Exclusive Branded bags']")
    private WebElement exclusiveBrandedbagsText;

    @FindBy(xpath = "//p[normalize-space(text())='Get your exclusive & branded bags delivered to you in no time']")
    private WebElement getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText;

    @FindBy(xpath = "//img[@alt='Gucci Handbag' ]")
    private WebElement gucciHandbagImage;

    @FindBy(xpath = "//article[@class='product-card cart-type-helium h-full overflow-hidden rounded border border-border-200 bg-light transition-shadow duration-200 hover:shadow-sm']")
    private List<WebElement> allBagsList15pieces;

    @FindBy(xpath = "//li[@class='rounded-md py-1']")
    private List<WebElement> allBagsTypeMenu5pieces;


    public BagsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // **********************************************************Bags Methods********************************************************************************

    public void clickDropDownMenu() {
        allPages.pickBazarHomePage().getDropDownMenu().click(); //Fatma Hanım

    }

    public void clickDropdownMenuAndBags() {
        clickDropDownMenu();
        dropDownMenuBagsLocate.click();
    }

    public boolean isDisplayexclusiveBrandedbagsText() {
        return isWebElementDisplayed(exclusiveBrandedbagsText);
    }

    public boolean isDisplaygetYourExclusiveBrandedBagsDeliveredToYouinNoTimeText() {
        return isWebElementDisplayed(getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText);
    }

    public boolean isSearchAreaFrameDisplayed() {
        return isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame());
    }

    //isSearchTextInputDisplayed //Fatma Hanım
    //isSearchButtonDisplayed //Fatma Hanım

    public boolean WhenYouSearchTextAboutBagCheckVerifyTrue(){
        allPages.pickBazarHomePage().getSearchTextInput().sendKeys("bag");
        allPages.pickBazarHomePage().clickSearchButton();

       return isWebElementDisplayed(gucciHandbagImage);

    }

    public void scrollToDeliveryImages(){
        actions.scrollToElement(allPages.pickBazarHomePage().getExpressDeliveryImage()).perform();
    }

    public void scrollToButtonOfToBagsPage(){
       actions.scrollByAmount(0,1350);
    }


    public boolean is3frames_ExpressDelivery_CashOnDelivery_GiftVoucher_Display() {
        actions.scrollToElement(allPages.pickBazarHomePage().getExpressDeliveryImage()).perform();

        int index = 0;
        for (WebElement w : allPages.pickBazarHomePage().getDeliveryImagesList()) {
            if (index >= 3) {
                break;
            }
            System.out.println("- Express Delivery(902) "+
                    "- Cash On Delivery frame,(903) " +
                    "- Gift Voucher frame,(904)"+ "Seeing-->"+w.getDomAttribute("alt"));
            try {
                if (!isWebElementDisplayed(w)) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
            index++;
        }

        return true;
    }

    public boolean inBagsPageAllBagsIsDisplay(){
        actions.scrollToElement(gucciHandbagImage).perform();
        boolean isPriceVisible;
        for (WebElement bags:allBagsList15pieces){
            try {
                if (!isWebElementDisplayed(bags)){
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

            try {
                WebElement priceBox = bags.findElement(By.xpath("//span[@class='text-sm font-semibold text-accent md:text-base']"));
                isPriceVisible = isWebElementDisplayed(priceBox) && !priceBox.getText().trim().isEmpty();
            } catch (Exception e) {
                isPriceVisible = false;
            }

            WebElement bagsBrand = bags.findElement(By.cssSelector("article img"));
            String bagsBrandType = bagsBrand.getDomAttribute("alt");

            List<WebElement>  bagsPrice = bags.findElements(By.cssSelector("article span"));
            String bagsPrices = bagsPrice.get(2).getText();

            System.out.println("----------------------------------");
            System.out.println("Ürünün Markası : " + bagsBrandType);

            System.out.println("Fiyat Görünüyor mu? " + bagsPrices);
        }
        return true;
    }

    public boolean inBagsPageAllMenuTypeIsDisplay(){
        actions.scrollToElement(gucciHandbagImage).perform();

        for (WebElement BagsPageAllMenuType:allBagsTypeMenu5pieces){
            try {
                if (!isWebElementDisplayed(BagsPageAllMenuType)){
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

            List<WebElement>  menuTexts = BagsPageAllMenuType.findElements(By.cssSelector("li span"));
            String menuTextName = menuTexts.get(1).getText();

            System.out.println("-----------------------------------");
            System.out.println("List Name" + " --> " + menuTextName);

        }
        return true;
    }































}
