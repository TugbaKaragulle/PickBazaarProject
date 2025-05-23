package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static utilities.ReusableMethods.isWebElementDisplayed;
import static utilities.ReusableMethods.log;

public class FurniturePage {

    Actions actions = new Actions(Driver.getDriver(), Duration.ofSeconds(10));


    //**********************************************************FURNITURE PAGE LOCATES************************************************************************

    @FindBy(xpath = "//div[@class='text-center rounded bg-light py-4 flex flex-col items-center justify-start relative overflow-hidden cursor-pointer border-2 border-border-100 xl:border-transparent']")
    private List<WebElement> allFurnitureMenu4pieces;

    @FindBy(xpath = "//img[@alt='Exclusive furniture on cheap price' and @src='/_next/image?url=https%3A%2F%2Fpickbazarlaravel.s3.ap-southeast-1.amazonaws.com%2F922%2Ffurniture-banner-1.jpg&w=3840&q=75']")
    private WebElement ExclusiveFurnituresMadeOnlyForYouFrameImage;

    @FindBy(xpath = "//article[@class='product-card cart-type-krypton h-full cursor-pointer overflow-hidden rounded border border-border-200 bg-light transition-shadow duration-200 hover:shadow-sm']")
    private List<WebElement> allFurnitureProduct30Pieces;


    //************************************************************CONST.*************************************************************************************

    public FurniturePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // **********************************************************Furniture Methods***************************************************************************

    public boolean inFurniturePageAllMenuTypeIsDisplay() {
        log("Mobilya menü görünür olduğunu doğrulanıyor..");
        for (WebElement furnitureMenuType : allFurnitureMenu4pieces) {
            try {
                if (!isWebElementDisplayed(furnitureMenuType)) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

            List<WebElement> allMenuTypeText = furnitureMenuType.findElements(By.cssSelector("div span"));
            String menuTypeText = allMenuTypeText.get(1).getText();

            log("-------------------------------");
            log("Chair Menu Lists -->  {}", menuTypeText);
        }
        log("Mobilya menü görünür olduğunu doğrulandı..");
        return true;
    }

    public boolean isExclusiveFurnituresMadeOnlyForYouFrameImageDisplay() {
        System.out.println();
        log("Mobilya frame görünür olduğunu doğrulanıyor..");

        boolean ısDisplay = isWebElementDisplayed(ExclusiveFurnituresMadeOnlyForYouFrameImage);

        log("Mobilya frame görünür olduğunu doğrulandı..");
        return ısDisplay;


    }

    public boolean isallFurnitureProduct30PiecesImgAndPrice() {
        System.out.println();
        log("Eşyaların genel olarak görünürlüğüne bakılacak..");

        for (WebElement card : allFurnitureProduct30Pieces) {
            actions.scrollByAmount(0, 50).perform();
            boolean isImageVisible;
            boolean isPriceVisible;


            try {
                WebElement image = card.findElement(By.tagName("img"));
                String productName = image.getDomAttribute("alt");
                isImageVisible = isWebElementDisplayed(image);
                log(" Product Name -->  {}", productName);
            } catch (NoSuchElementException e) {
                isImageVisible = false;
            }
            log(" Resim Görünüyor mu?  {}", isImageVisible);

            log("--------------------------------------");

            try {
                List<WebElement> priceBoxsTexts = card.findElements(By.cssSelector("article span"));
                String productPrice = priceBoxsTexts.get(2).getText();
                WebElement priceBoxText = priceBoxsTexts.get(2);
                log(" Product Price -->  {}", productPrice);
                isPriceVisible = isWebElementDisplayed(priceBoxText);
            } catch (NoSuchElementException e) {
                isPriceVisible = false;
            }

            log(" Fiyat Görünüyor mu?  {}", isPriceVisible);

            log("---------------------------------------");
            actions.scrollByAmount(0, 50).perform();

        }
        log("Eşyaların genel olarak görünürlüğüne bakıldı..");
        return true;
    }


}
