package pages;


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
        log("Order status alanının Text görünürlüğü sırasıyla kontrol ediliyor..");

        List<String> foundFields = new ArrayList<>();
        for (WebElement First5OrderList : First5PiecesOrderStatusLoc) {

            String orderText = First5OrderList.getText();


            try {

                foundFields.add(orderText);
            } catch (Exception e) {
                logError("listeye atılacak order text bulunamadı");
                FailSituation++;
            }
        }


        for (String required : First5RequiredList) {

            if (foundFields.contains(required)) {
                log(" Eksik yok -->   {}", required);
            } else {
                logError(" Bu alan eksik -->  {}", required);
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
                logError("listeye atılacak order text bulunamadı");
                FailSituationn++;
            }
        }

        for (String ignoredd : Last6RequiredList) {

            if (foundFieldss.contains(ignoredd)) {
                log(" Eksik yok --> {}", ignoredd);
            } else {
                logError(" Bu alan eksik -->  {}", ignoredd);
                FailSituationn++;
            }


        }

        log("Order status alanının Text görünürlüğü sırasıyla kontrol edildi..");
        return FailSituationn == 0;
    }

    //This Method drag to order bar to right
    public void slideToright() {
        actions.dragAndDropBy(ForScrollStick, 1000, 0).perform();
    }

    public boolean all4StatusType_OrderNumber_Date_Total_PaymentMethod() {
        boolean orderStatusisDisplay;
        int failSituation = 0;

        log("Order status alanının Detay bilgilerin görünürlüğü kontrol ediliyor..");
        for (WebElement statusType : all4StatusType_OrderNumber_Date_Total_PaymentMethod) {
            log("-----------------------------------------");
            try {

                orderStatusisDisplay = isWebElementDisplayed(statusType);
                String statusText = statusType.getText();
                log("Order Status Name -->  {}", statusText);


            } catch (Exception e) {
                orderStatusisDisplay = false;
                logError("Görünür değil __>  {}", statusType);
                failSituation++;
            }

            log("Order Text göründü ?-->  {}", orderStatusisDisplay);
        }
        log("Order status alanının Detay bilgilerin görünürlüğü kontrol edildi..");
        return failSituation == 0;
    }

    public boolean isTotalAmountAreaPricesDiplay() {
        boolean priceTextDisplay;
        int failSituation = 0;

        for (WebElement priceType : isTotalAmountAreaPricesAreDisplay) {
            ReusableMethods.waitForVisibility(Driver.getDriver(),priceType,10);
            log("-----------------------------------------");
            try {

                priceTextDisplay = isWebElementDisplayed(priceType);
                String priceText = priceType.getText();
                log("price text -->  {}", priceText);


            } catch (Exception e) {
                priceTextDisplay = false;
                logError("Görünür değil -->  {}", priceType);
                failSituation++;
            }

            log("price Text göründü ?-->  {}", priceTextDisplay);
        }
        return failSituation == 0;
    }

    public boolean orderStatusAreaChecking() {
        boolean ısSeeing = false;
        int failSitutation = 0;
        System.out.println();
        log("Order status alanının görünürlüğü kontrol ediliyor..");
        try {
            ısSeeing = isWebElementDisplayed(orderStatusArea);
            log("Belirtilen alan görünür mü ? {}", ısSeeing);
            String areaText = orderStatusArea.getText();
            log("Belirtilen alan texti : {}", areaText);
            log("Order status alanının görünürlüğü kontrol edildi..");
            System.out.println();
        } catch (Exception e) {
            log("Göründü mü ? {}", ısSeeing);
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

                logError("Listeye atılacak heading bulunamadı..");
                failSituation++;
            }
        }

        for (String required : requiredFields) {

            if (foundFields.contains(required)) {
                log("Bütün alanlar Tam Eksik yok -->  {}", required);
            } else {

                screenShot(required + "Alanı eksik");
                logError("Bu alan eksik -->  {}", required);
                failSituation++;
            }


        }
        return failSituation == 0;
    }

    public void pageScrollDown()  {
        waitForVisibility(Driver.getDriver(),itemPrice,3000);
        JavascriptUtils.scrollIntoViewJS(itemPrice);

        //actions.scrollToElement(itemPrice).perform();

    }

    public boolean aboutItemQuantityImageAndPriceIsDisplay() {
        pageScrollDown();
        int failsituation = 0;

        boolean itemPricee = isWebElementDisplayed(itemPrice);
        if (itemPricee) {
            log("item price göründü mü ? --> {}", true);
        } else {
            logError("item price göründü mü ? --> {}", false);
            failsituation++;
        }

        boolean itemImage = isWebElementDisplayed(itemPicture);
        if (itemImage) {
            log("item image göründü mü ? --> {}", true);
        } else {
            logError("item image göründü mü --->  {} ", false);
            failsituation++;
        }

        boolean itemQuantity = isWebElementDisplayed(Quantityitem);
        if (itemQuantity) {
            log("Ürün miktarı görünüyor --> {}", true);
        } else {
            logError("Ürün miktarı görünmüyor --> {}", false);
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

            log("Yorum alanı içeriyor mu? --> {}", iscontainreview);
            log("Update alanı içeriyor mu? --> {}", iscontainreview);
        } catch (Exception e) {
            logError("Yorum alanı içeriyor mu --> {}", iscontainreview);
            logError("Update alanı içeriyor mu --> {}", iscontainUpdate);
            failsituation++;
        }

        return failsituation == 0;
    }


}

