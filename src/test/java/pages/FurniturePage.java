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
import java.util.NoSuchElementException;

import static utilities.ReusableMethods.isWebElementDisplayed;

public class FurniturePage {

    Actions actions = new Actions(Driver.getDriver(), Duration.ofSeconds(10));
    Logger logger = LogManager.getLogger(FurniturePage.class);

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
        logger.info("\u001B[31mMobilya menü görünür olduğunu doğrulanıyor..\u001B[0m");
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

            logger.info("-------------------------------");
            logger.info("\u001B[34mChair Menu Lists --> \u001B[0m {}", menuTypeText);
        }
        logger.info("\u001B[31mMobilya menü görünür olduğunu doğrulandı..\u001B[0m");
        return true;
    }

    public boolean isExclusiveFurnituresMadeOnlyForYouFrameImageDisplay() {
        System.out.println();
        logger.info("\u001B[31mMobilya frame görünür olduğunu doğrulanıyor..\u001B[0m");

        boolean ısDisplay =isWebElementDisplayed(ExclusiveFurnituresMadeOnlyForYouFrameImage);

        logger.info("\u001B[31mMobilya frame görünür olduğunu doğrulandı..\u001B[0m");
        return ısDisplay;



    }

    public boolean isallFurnitureProduct30PiecesImgAndPrice() {
        System.out.println();
        logger.info("\u001B[31mEşyaların genel olarak görünürlüğüne bakılacak..\u001B[0m");
        for (WebElement card : allFurnitureProduct30Pieces) {
            actions.scrollByAmount(0, 50).perform();
            boolean isImageVisible;
            boolean isPriceVisible;


            try {
                WebElement image = card.findElement(By.tagName("img"));
                String productName = image.getDomAttribute("alt");
                isImageVisible = isWebElementDisplayed(image);
                logger.info("\u001B[34m Product Name --> \u001B[0m {}", productName);
            } catch (NoSuchElementException e) {
                isImageVisible = false;
            }
            logger.info("\u001B[34m Resim Görünüyor mu? \u001B[0m {}", isImageVisible);

            logger.info("--------------------------------------");

            try {
                List<WebElement> priceBoxsTexts = card.findElements(By.cssSelector("article span"));
                String productPrice = priceBoxsTexts.get(2).getText();
                WebElement priceBoxText = priceBoxsTexts.get(2);
                logger.info("\u001B[34m Product Price --> \u001B[0m {}", productPrice);
                isPriceVisible = isWebElementDisplayed(priceBoxText);
            } catch (NoSuchElementException e) {
                isPriceVisible = false;
            }

            logger.info("\u001B[34m Fiyat Görünüyor mu? \u001B[0m {}", isPriceVisible);

            logger.info("---------------------------------------");
            actions.scrollByAmount(0, 50).perform();

        }
        logger.info("\u001B[31mEşyaların genel olarak görünürlüğüne bakıldı..\u001B[0m");
        return true;
    }








}
