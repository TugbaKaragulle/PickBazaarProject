package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

import static utilities.ReusableMethods.*;

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
        log("Verifying that exclusiveBrandedbagsText is visible on the page..");
        boolean isVisiable = false;
        try {
            isVisiable = isWebElementDisplayed(exclusiveBrandedbagsText);
        } catch (Exception e) {
            screenShot("exclusiveBrandedbagsText not visible");
        }
        log("isVisiable ? --> ", isVisiable);
        log("verified to be visible on the page..");
        return isVisiable;
    }

    public boolean isDisplaygetYourExclusiveBrandedBagsDeliveredToYouinNoTimeText() {
        System.out.println();
        log("Verifying that getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText is visible on the page..");
        boolean isVisiable = false;
        try {
            isVisiable = isWebElementDisplayed(getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText);
        } catch (Exception e) {
            screenShot("getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText not visible");
        }
        log("isVisiable ? --> ", isVisiable);
        log("verified to be visible on the page..");

        return isVisiable;
    }

    public boolean isSearchAreaFrameDisplayed() {
        System.out.println();
        log("Verifying that SearchAreaFrame is visible on the page..");
        boolean isVisiable = false;
        try {
            isVisiable = isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame());
        } catch (Exception e) {
            screenShot("SearchAreaFrame Görünür değil");
        }
        log("is visiable ? --> ", isVisiable);
        log("verified to be visible on the page..");
        return isVisiable;
    }

    //isSearchTextInputDisplayed //Fatma Hanım
    //isSearchButtonDisplayed //Fatma Hanım

    public boolean WhenYouSearchTextAboutBagCheckVerifyTrue()  {

        System.out.println();
        log("Sayfada aranan çanta görünür olduğunu doğrulanıyor..");
        allPages.pickBazarHomePage().getSearchTextInput().sendKeys("bag");
        allPages.pickBazarHomePage().clickSearchButton();
        boolean isVisiable = false;
        try {
            isVisiable = isWebElementDisplayed(gucciHandbagImage);
        } catch (Exception e) {
            screenShot("cant find this page");
        }
        log("Sayfada aranan çanta görünür olduğunu doğrulandı..");
       return isVisiable;

    }

    public void scrollToDeliveryImages(){
        actions.scrollToElement(allPages.pickBazarHomePage().getExpressDeliveryImage()).perform();
    }

    public void scrollToButtonOfToBagsPage(){
       actions.scrollByAmount(0,1350);
    }


    public boolean is3frames_ExpressDelivery_CashOnDelivery_GiftVoucher_Display() {

        System.out.println();
        log("3 Adet image frame görünür olduğunu doğrulanıyor..");
        actions.scrollToElement(allPages.pickBazarHomePage().getExpressDeliveryImage()).perform();
        int index = 0;
        for (WebElement w : allPages.pickBazarHomePage().getDeliveryImagesList()) {
            if (index >= 3) {
                break;
            }
            log(
                    "- Express Delivery(902) - Cash On Delivery frame,(903) - Gift Voucher frame,(904)Seeing-->{}", w.getDomAttribute("alt"));
            try {
                if (!isWebElementDisplayed(w)) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
            index++;
        }
        log("3 Adet image frame görünür olduğunu doğrulandı..");
        return true;
    }

    public boolean inBagsPageAllBagsIsDisplay(){
        boolean isPriceVisible ;
        int FailSitutation = 0;
        System.out.println();
        log("Çantaların  görünür olduğunu doğrulanıyor..");
        actions.scrollToElement(gucciHandbagImage).perform();
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
                FailSitutation++;
            }

            WebElement bagsBrand = bags.findElement(By.cssSelector("article img"));
            String bagsBrandType = bagsBrand.getDomAttribute("alt");

            List<WebElement>  bagsPrice = bags.findElements(By.cssSelector("article span"));
            String bagsPrices = bagsPrice.get(2).getText();

            log("----------------------------------");
            log("Ürünün Markası :  {}", bagsBrandType);

            log("Fiyat Görünüyor mu?  {}", bagsPrices);
        }
        log("Çantaların  görünür olduğunu doğrulandı..");
        return FailSitutation == 0;
    }

    public boolean inBagsPageAllMenuTypeIsDisplay(){
        actions.scrollToElement(gucciHandbagImage).perform();
        System.out.println();
        log("Çanta menü list  görünür olduğunu doğrulanıyor..");

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

            log("-----------------------------------");
            log("List Name --> {}", menuTextName);

        }
        log("Çanta menü list  görünür olduğunu doğrulandı..");
        return true;
    }

































}
