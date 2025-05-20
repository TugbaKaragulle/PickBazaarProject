package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    Logger logger = LogManager.getLogger(BagsPage.class);

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
        logger.info("\u001B[31mSayfada exclusiveBrandedbagsText görünür olduğunu doğrulanıyor..\u001B[0m");
        boolean gorundumu = isWebElementDisplayed(exclusiveBrandedbagsText);
        logger.info("\u001B[31mSayfada exclusiveBrandedbagsText görünür olduğunu doğrulandı..\u001B[0m");
        return gorundumu;
    }

    public boolean isDisplaygetYourExclusiveBrandedBagsDeliveredToYouinNoTimeText() {
        System.out.println();
        logger.info("\u001B[31mSayfada getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText görünür olduğunu doğrulanıyor..\u001B[0m");
        boolean gorundumu = isWebElementDisplayed(getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText);
        logger.info("\u001B[31mSayfada getYourExclusiveBrandedBagsDeliveredToYouinNoTimeText görünür olduğunu doğrulandı..\u001B[0m");
        return gorundumu;
    }

    public boolean isSearchAreaFrameDisplayed() {
        System.out.println();
        logger.info("\u001B[31mSayfada SearchAreaFrame görünür olduğunu doğrulanıyor..\u001B[0m");
        boolean gorundumu = isWebElementDisplayed(allPages.pickBazarHomePage().getSearhAreaFrame());
        logger.info("\u001B[31mSayfada SearchAreaFrame görünür olduğunu doğrulandı..\u001B[0m");
        return gorundumu;


    }

    //isSearchTextInputDisplayed //Fatma Hanım
    //isSearchButtonDisplayed //Fatma Hanım

    public boolean WhenYouSearchTextAboutBagCheckVerifyTrue()  {

        System.out.println();
        logger.info("\u001B[31mSayfada aranan çanta görünür olduğunu doğrulanıyor..\u001B[0m");
        allPages.pickBazarHomePage().getSearchTextInput().sendKeys("bag");
        allPages.pickBazarHomePage().clickSearchButton();
        boolean gorundumu = isWebElementDisplayed(gucciHandbagImage);
        logger.info("\u001B[31mSayfada aranan çanta görünür olduğunu doğrulandı..\u001B[0m");
       return gorundumu;

    }

    public void scrollToDeliveryImages(){
        actions.scrollToElement(allPages.pickBazarHomePage().getExpressDeliveryImage()).perform();
    }

    public void scrollToButtonOfToBagsPage(){
       actions.scrollByAmount(0,1350);
    }


    public boolean is3frames_ExpressDelivery_CashOnDelivery_GiftVoucher_Display() {

        System.out.println();
        logger.info("\u001B[31m3 Adet image frame görünür olduğunu doğrulanıyor..\u001B[0m");
        actions.scrollToElement(allPages.pickBazarHomePage().getExpressDeliveryImage()).perform();
        int index = 0;
        for (WebElement w : allPages.pickBazarHomePage().getDeliveryImagesList()) {
            if (index >= 3) {
                break;
            }
            logger.info(
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
        logger.info("\u001B[31m3 Adet image frame görünür olduğunu doğrulandı..\u001B[0m");
        return true;
    }

    public boolean inBagsPageAllBagsIsDisplay(){
        boolean isPriceVisible ;
        int FailSitutation = 0;
        System.out.println();
        logger.info("\u001B[31mÇantaların  görünür olduğunu doğrulanıyor..\u001B[0m");
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

            logger.info("----------------------------------");
            logger.info("\u001B[34mÜrünün Markası : \u001B[0m {}", bagsBrandType);

            logger.info("\u001B[34mFiyat Görünüyor mu? \u001B[0m {}", bagsPrices);
        }
        logger.info("\u001B[31mÇantaların  görünür olduğunu doğrulandı..\u001B[0m");
        return FailSitutation == 0;
    }

    public boolean inBagsPageAllMenuTypeIsDisplay(){
        actions.scrollToElement(gucciHandbagImage).perform();
        System.out.println();
        logger.info("\u001B[31mÇanta menü list  görünür olduğunu doğrulanıyor..\u001B[0m");

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

            logger.info("-----------------------------------");
            logger.info("List Name --> {}", menuTextName);

        }
        logger.info("\u001B[31mÇanta menü list  görünür olduğunu doğrulanıyor..\u001B[0m");
        return true;
    }































}
