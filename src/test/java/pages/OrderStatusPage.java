package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.*;

import static utilities.ReusableMethods.*;

public class OrderStatusPage {

    Actions actions = new Actions(Driver.getDriver(), Duration.ofSeconds(10));
    Logger logger = LogManager.getLogger(OrderStatusPage.class);


    //**************************************************************ORDER STATUS LOCATES**********************************************************************************

    @FindBy(xpath = "(//span[@class='text-base font-semibold capitalize text-body-dark ltr:text-left rtl:text-right md:px-2 md:!text-center'])[position() <= 5]")
    private List<WebElement> First5PiecesOrderStatusLoc;

    @FindBy(xpath = "(//span[@class='text-base font-semibold capitalize text-body-dark ltr:text-left rtl:text-right md:px-2 md:!text-center'])[position() > 5]")
    private List<WebElement> Last6PiecesOrderStatusLoc;

    @FindBy(xpath = "(//div[@class='os-scrollbar-handle'])[1]")
    private WebElement ForScrollStick;

    @FindBy(xpath = "//div[@class='rounded border border-border-200 py-4 px-5 shadow-sm']")
    private List<WebElement> all4StatusType_OrderNumber_Date_Total_PaymentMethod;

    @FindBy(xpath = "//div[@class='mb-12 w-full lg:mb-0 lg:w-1/2 ltr:lg:pr-3 rtl:lg:pl-3']//p/span")
    private List<WebElement> isTotalAmountAreaPricesAreDisplay;

    @FindBy(xpath = "//span[@class='order-2 mt-5 ltr:mr-auto rtl:ml-auto sm:order-1 sm:mt-0']")
    private WebElement orderStatusArea;

    @FindBy(xpath = "//div[@class='w-full lg:w-1/2 ltr:lg:pl-3 rtl:lg:pr-3']//p/strong")
    private List<WebElement> orderDetailsTextHeading;

    @FindBy(xpath = "//div[@class='relative flex h-16 w-16 shrink-0 overflow-hidden rounded']//img")
    private WebElement itemPicture;

    @FindBy(xpath = "//p[@class='text-base']")
    private WebElement Quantityitem;

    @FindBy(xpath = "//td[@class='rc-table-cell' and @style='text-align: right;']//p")
    private WebElement itemPrice;

    @FindBy(xpath = "//button[@class='cursor-pointer text-sm font-semibold text-body transition-colors hover:text-accent']")
    private WebElement writeReview;

    @FindBy(xpath = "//div[@class='border-t border-border-200 border-opacity-70 py-7 first:border-t-0']")
    private WebElement productReviewArea;

    @FindBy(xpath = "//tr[@class='rc-table-row rc-table-row-level-0 !cursor-auto']//td[4]")
    private WebElement writeAndUpdateChecking;


    //************************************************************CONST.*************************************************************************************************

    public OrderStatusPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //**************************************************************ORDER STATUS METHODS**********************************************************************************

    //These are should be First 5 text sentence to arrayList for compare to text using inside to method
    List<String> First5RequiredList = Arrays.asList(
            "Order Received",
            "Order Processing",
            "Ready To Dispatch",
            "Order Dispatched",
            "Order At Local Facility"


    );
    //These are should be last 6 text sentence to arrayList for compare to text using inside to method
    List<String> Last6RequiredList = Arrays.asList(
            "Order Out For Delivery",
            "Order Pending",
            "Failed to collect payment",
            "Failed to contact Consignee",
            "Shipment Refused by Consignee",
            "Delivered"

    );

    //There are 10 Order status but this method checking to first 5 element verify with the text situation
    public boolean First5PiecesOrderStatus() {
        int FailSituation = 0;
        logger.info("\u001B[31mOrder status alanının Text görünürlüğü sırasıyla kontrol ediliyor..\u001B[0m");

        List<String> foundFields = new ArrayList<>();
        for (WebElement First5OrderList : First5PiecesOrderStatusLoc) {

            String orderText = First5OrderList.getText();


            try {

                foundFields.add(orderText);
            } catch (Exception e) {
                logger.error("listeye atılacak order text bulunamadı");
                FailSituation++;
            }
        }


        for (String required : First5RequiredList) {

            if (foundFields.contains(required)) {
                logger.info("\u001B[34m Eksik yok --> \u001B[0m  {}", required);
            } else {
                logger.error("\u001B[34m Bu alan eksik --> \u001B[0m {}", required);
                FailSituation++;
            }


        }
        return FailSituation == 0;
    }


    //There are 10 Order status but this method checking to last 6 element verify with the text situation
    public boolean Last6PiecesOrderStatus() {
        int FailSituationn = 0;
        Set<String> foundFieldss = new HashSet<>();
        for (WebElement Last6orderList : Last6PiecesOrderStatusLoc) {

            String orderText = Last6orderList.getText().trim();
            try {
                foundFieldss.add(orderText);
            } catch (Exception e) {
                logger.error("listeye atılacak order text bulunamadı");
                FailSituationn++;
            }
        }

        for (String ignoredd : Last6RequiredList) {

            if (foundFieldss.contains(ignoredd)) {
                logger.info("\u001B[34m Eksik yok --> \u001B[0m {}", ignoredd);
            } else {
                logger.error("\u001B[34m Bu alan eksik --> \u001B[0m {}", ignoredd);
                FailSituationn++;
            }


        }

        logger.info("\u001B[31mOrder status alanının Text görünürlüğü sırasıyla kontrol edildi..\u001B[0m");
        return FailSituationn == 0;
    }

    //This Method drag to order bar to right
    public void slideToright() {
        actions.dragAndDropBy(ForScrollStick, 1000, 0).perform();
    }

    public boolean all4StatusType_OrderNumber_Date_Total_PaymentMethod() {
        boolean orderStatusisDisplay;
        int failSituation = 0;

        logger.info("\u001B[31mOrder status alanının Detay bilgilerin görünürlüğü kontrol ediliyor..\u001B[0m");
        for (WebElement statusType : all4StatusType_OrderNumber_Date_Total_PaymentMethod) {
            logger.info("-----------------------------------------");
            try {

                orderStatusisDisplay = isWebElementDisplayed(statusType);
                String statusText = statusType.getText();
                logger.info("\u001B[34mOrder Status Name --> \u001B[0m {}", statusText);


            } catch (Exception e) {
                orderStatusisDisplay = false;
                logger.error("\u001B[34mGörünür değil __> \u001B[0m {}", statusType);
                failSituation++;
            }

            logger.info("\u001B[34mOrder Text göründü ?--> \u001B[0m {}", orderStatusisDisplay);
        }
        logger.info("\u001B[31mOrder status alanının Detay bilgilerin görünürlüğü kontrol edildi..\u001B[0m");
        return failSituation == 0;
    }

    public boolean isTotalAmountAreaPricesDiplay() {
        boolean priceTextDisplay;
        int failSituation = 0;

        for (WebElement priceType : isTotalAmountAreaPricesAreDisplay) {
            ReusableMethods.waitForVisibility(Driver.getDriver(),priceType,10);
            logger.info("-----------------------------------------");
            try {

                priceTextDisplay = isWebElementDisplayed(priceType);
                String priceText = priceType.getText();
                logger.info("\u001B[34mprice text --> \u001B[0m {}", priceText);


            } catch (Exception e) {
                priceTextDisplay = false;
                logger.error("\u001B[34mGörünür değil --> \u001B[0m {}", priceType);
                failSituation++;
            }

            logger.info("\u001B[34mprice Text göründü ?--> \u001B[0m {}", priceTextDisplay);
        }
        return failSituation == 0;
    }

    public boolean orderStatusAreaChecking() {
        boolean ısSeeing = false;
        int failSitutation = 0;
        System.out.println();
        logger.info("\u001B[31mOrder status alanının görünürlüğü kontrol ediliyor..\u001B[0m");
        try {
            ısSeeing = isWebElementDisplayed(orderStatusArea);
            logger.info("\u001B[34mBelirtilen alan görünür mü ?\u001B[0m {}", ısSeeing);
            String areaText = orderStatusArea.getText();
            logger.info("\u001B[34mBelirtilen alan texti :\u001B[0m {}", areaText);
            logger.info("\u001B[31mOrder status alanının görünürlüğü kontrol edildi..\u001B[0m");
            System.out.println();
        } catch (Exception e) {
            logger.error("\u001B[34mGöründü mü ?\u001B {}", ısSeeing);
            failSitutation++;
        }

        return failSitutation == 0;
    }

    public boolean verifyAllRequiredFieldsExist() {
        String[] requiredFields = {
                "Name",
                "Total Item",
                "Delivery Time",
                "Shipping Address",
                "Billing Address"
        };
        Set<String> foundFields = new HashSet<>();
        int failSituation = 0;
        for (WebElement headingText : orderDetailsTextHeading) {
            try {
                String title = headingText.getText().trim();
                foundFields.add(title);
            } catch (Exception e) {
                logger.error("Listeye atılacak heading bulunamadı..");
                failSituation++;
            }
        }

        for (String required : requiredFields) {

            if (foundFields.contains(required)) {
                logger.info("Bütün alanlar Tam Eksik yok -->  {}", required);
            } else {
                logger.error("Bu alan eksik -->  {}", required);
                failSituation++;
            }


        }
        return failSituation == 0;
    }

    public void pageScrollDown() throws InterruptedException {

        JavascriptUtils.scrollIntoViewJS(itemPrice);
        //actions.scrollToElement(itemPrice).perform();

    }

    public boolean aboutItemQuantityImageAndPriceIsDisplay() {

        int failsituation = 0;

        boolean itemPricee = isWebElementDisplayed(itemPrice);
        if (itemPricee) {
            logger.info("item price göründü mü ? --> {}", true);
        } else {
            logger.error("item price göründü mü ? --> {}", false);
            failsituation++;
        }

        boolean itemImage = isWebElementDisplayed(itemPicture);
        if (itemImage) {
            logger.info("item image göründü mü ? --> {}", true);
        } else {
            logger.error("item image göründü mü --->  {} ", false);
            failsituation++;
        }

        boolean itemQuantity = isWebElementDisplayed(Quantityitem);
        if (itemQuantity) {
            logger.info("Ürün miktarı görünüyor --> {}", true);
        } else {
            logger.error("Ürün miktarı görünmüyor --> {}", false);
            failsituation++;
        }

        return failsituation == 0;

    }


    public boolean writeReviewAndUpdateReview() {
        List<WebElement> buttons = writeAndUpdateChecking.findElements(By.cssSelector("td button"));

        boolean iscontainreview = false;
        boolean iscontainUpdate = false;
        int failsituation = 0;
        try {
            iscontainreview = buttons.get(0).getText().contains("Write a review");
            iscontainUpdate = buttons.get(1).getText().contains("Update review");

            logger.info("Yorum alanı içeriyor mu? --> {}", iscontainreview);
            logger.info("Update alanı içeriyor mu? --> {}", iscontainreview);
        } catch (Exception e) {
            logger.error("Yorum alanı içeriyor mu --> {}", iscontainreview);
            logger.error("Update alanı içeriyor mu --> {}", iscontainUpdate);
            failsituation++;
        }

        return failsituation == 0;
    }


}

