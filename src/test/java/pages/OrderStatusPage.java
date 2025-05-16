package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class OrderStatusPage {

    Actions actions = new Actions(Driver.getDriver(), Duration.ofSeconds(10));


    //**************************************************************ORDER STATUS LOCATES**********************************************************************************

    @FindBy(xpath = "(//div[@class='progress-box_progress_container___zzev'])[position() <= 5]")
    private List<WebElement> First5PiecesOrderStatusLoc;

    @FindBy(xpath = "(//div[@class='progress-box_progress_container___zzev'])[position() > 5]")
    private List<WebElement> Last5PiecesOrderStatusLoc;

    @FindBy(xpath = "(//div[@class='os-scrollbar-handle'])[1]")
    private WebElement ForScrollStick;


    //************************************************************CONST.*************************************************************************************************

    public OrderStatusPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //**************************************************************ORDER STATUS METHODS**********************************************************************************

    //These are should be First 5 text sentence to arrayList for compare to text using inside to method
    List<String> First5statusList = Arrays.asList(
            "Order Received",
            "Order Processing",
            "Ready To Dispatch",
            "Order Dispatched",
            "Order At Local Facility"

    );
    //These are should be last 5 text sentence to arrayList for compare to text using inside to method
    List<String> Last5statusList = Arrays.asList(
            "Order Out For Delivery",
            "Order Pending",
            "Failed to collect payment",
            "Failed to contact Consignee",
            "Shipment Refused by Consignee",
            "Delivered"

    );

    //There are 10 Order status but this method checking to first 5 element verify with the text situation
    public boolean First5PiecesOrderStatus() {
        for (WebElement First5OrderList : First5PiecesOrderStatusLoc) {

            WebElement orderStatusText = First5OrderList.findElement(By.cssSelector("div span"));
            String orderText = orderStatusText.getText();

            boolean matches = First5statusList.stream().anyMatch(orderText::contains);

            System.out.println("----------------------------------");
            if (matches) {
                System.out.println("Durum eşleşti: " + orderText);

            } else {
                System.out.println("Eşleşme yok: " + orderText);
                return false;
            }
        }
        return true;
    }
    //There are 10 Order status but this method checking to last 5 element verify with the text situation
    public boolean Last5PiecesOrderStatus() {
        for (WebElement Last5OrderList : Last5PiecesOrderStatusLoc) {


            String statusText = Last5OrderList.getText();

            boolean matches = Last5statusList.stream().anyMatch(statusText::contains);

            if (matches) {
                System.out.println("Durum eşleşti: " + statusText);

            } else {
                System.out.println("Eşleşme yok: " + statusText);
                return false;
            }
        }
        return true;
    }

    //This Method drag to order bar to right
    public void slideToright() {
        actions.dragAndDropBy(ForScrollStick, 1000, 0).perform();
    }
}
