package utilities;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.getDriver;

public class ReusableMethods {

//--------------------------------------------------------------
    ////BU method waitForVisibility methodunu çağırırken sadece element parametresiyle çağırır, isDisplayed methodunu true/false return eder
    public static boolean   isWebElementDisplayed(WebElement element) {
        return ReusableMethods.waitForVisibility(getDriver(), element, 10).isDisplayed();
    }
    // Waits for the visibility of a specific element
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
//--------------------------------------------------------------------

    // Waits for all elements in a list to be visible
    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
//---------------------------------------------------------------------------



//---------------------------------------------------------------------------
    public static void clickElement(WebElement element) {
        ReusableMethods.waitForClickability(element,10).click();
    }
    // Waits until a specific element is clickable
    public static WebElement waitForClickability( WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
//-------------------------------------------------------------------------------------------


    // Waits until a specific element located by a locator is clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By by, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

//---------------------------------------------------------------------------------------
    // Logs and returns the text of a WebElement
    public static String getElementText(WebElement element) {
        String text = element.getText().trim();
        System.out.println("Element Text: " + text);
        return text;
    }

//---------------------------------------------------------------------------------------
    // Converts a numeric string inside a WebElement to an integer (e.g. "$1,234" → 1234)
    public static int convertElementTextIntoInteger(WebElement element) {
        String text = element.getText().replaceAll("[^0-9]", "");
        if (text.isEmpty()) {
            throw new NumberFormatException("Element text does not contain any numeric characters: " + element.getText());
        }
        return Integer.parseInt(text);
    }

//---------------------------------------------------------------------------------------
    // Simple wait (not recommended for real tests, prefer explicit waits)
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep was interrupted");
        }
    }


//---------------------------------------------------------------------------------------
    //BU method waitForElementToBeClickable methodunu çağırırken sadece element parametresiyle çağırma amaçlı eklendi
    public static boolean waitForClickability(WebElement element) {
        try {
            ReusableMethods.waitForClickability(element, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//---------------------------------------------------------------------------------------
public static boolean waitForUrlContains(String data) {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    try {
        return wait.until(ExpectedConditions.urlContains(data));
    } catch (TimeoutException e) {
        return false;
    }
}

//---------------------------------------------------------------------------------------
    public static boolean waitForVisibilityOfTitle(String string){
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.titleContains(string));
    }

    //Bu Methodla dom'da gerçekten count'tan fazla ürün gösterilene kadar bekliyor
    //Ürünlerin oldugu bir sayfada, ürünlerin sayisini vs test etmek icin kullanilan bekleme methodu
    public static boolean waitForProductCountToIncrease(List<WebElement> productList, int count){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            return wait.until(driver -> productList.size() > count);
        } catch (TimeoutException e) {
            System.out.println("Ürün sayısı artmadı, suanki ürün sayisi: " + productList.size());
            return false;
        }
    }

    public static void captureScreenshot(String name) {
        WebDriver driver = Driver.getDriver();
        if (driver == null) return;

        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment(name, "image/png", "png", screenshot);
        } catch (Exception e) {
            System.out.println("Screenshot alınamadı: " + e.getMessage());
        }
    }

    static Logger logger = LogManager.getLogger(ReusableMethods.class);

    public static void log(String message) {
        logger.info(message);             // Konsola yaz
        Allure.step(message);             // Allure raporuna yaz
    }

    public static void log(String format, Object arg) {
        String message = format.replace("{}", String.valueOf(arg));
        logger.info(message);
        Allure.step(message);
    }
    public static void logError(String message) {
        logger.error(message);
        Allure.step("[ERROR] " + message);
    }

    public static void logError(String format, Object arg) {
        String message = format.replace("{}", String.valueOf(arg));
        logger.info(message);
        Allure.step("[ERROR] " +message);
    }
}
