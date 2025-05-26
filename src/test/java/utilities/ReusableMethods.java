package utilities;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPages;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.getDriver;

/**
 * Utility class that provides reusable helper methods for Selenium WebDriver interactions.
 * Includes wait operations, element interaction and screenshot support.
 */
public class ReusableMethods {

    /**
     * Checks if the given WebElement is visible on the page.
     */
    public static boolean isWebElementDisplayed(WebElement element) {
        return ReusableMethods.waitForVisibility(getDriver(), element, 10).isDisplayed();
    }

    /**
     * Waits for a single WebElement to become visible.
     */
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for all elements in the list to become visible.
     */
    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Waits and clicks the given element when clickable.
     */
    public static void clickElement(WebElement element) {
        ReusableMethods.waitForClickability(element, 10).click();
    }

    /**
     * Clicks the element using JavaScriptExecutor.
     */
    public static void clickElementByJS(WebElement element) {
        JavascriptUtils.clickElementByJS(element);
    }

    /**
     * Waits until the given WebElement is clickable.
     */
    public static WebElement waitForClickability(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until the element located by the given locator is clickable.
     */
    public static WebElement waitForElementToBeClickable(WebDriver driver, By by, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Returns trimmed text of a WebElement.
     */
    public static String getElementText(WebElement element) {
        String text = element.getText().trim();
        System.out.println("Element Text: " + text);
        return text;
    }

    /**
     * Extracts and returns an integer from a WebElement's text.
     * (e.g. "$1,234" → 1234)
     */
    public static int convertElementTextIntoInteger(WebElement element) {
        String text = element.getText().replaceAll("[^0-9]", "");
        if (text.isEmpty()) {
            throw new NumberFormatException("Element text does not contain any numeric characters: " + element.getText());
        }
        return Integer.parseInt(text);
    }

    /**
     * Pauses the thread for given seconds (not recommended in real tests).
     */
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep was interrupted");
        }
    }
    /**
     * Tries to wait for element clickability and returns boolean.
     */
    public static boolean waitForClickability(WebElement element) {
        try {
            ReusableMethods.waitForClickability(element, 10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Waits for the current URL to contain the given string.
     */
    public static boolean waitForUrlContains(String data) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        try {
            return wait.until(ExpectedConditions.urlContains(data));
        } catch (TimeoutException e) {
            return false;
        }
    }
    /**
     * Waits for the page title to contain the given string.
     */
    public static boolean waitForVisibilityOfTitle(String string) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.titleContains(string));
    }
    /**
     * Waits until product list size increases beyond the given count.
     */
    public static boolean waitForProductCountToIncrease(List<WebElement> productList, int count) {
        //Bu Methodla dom'da gerçekten count'tan fazla ürün gösterilene kadar bekliyor
        //Ürünlerin oldugu bir sayfada, ürünlerin sayisini vs test etmek icin kullanilan bekleme methodu
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            return wait.until(driver -> productList.size() > count);
        } catch (TimeoutException e) {
            System.out.println("Ürün sayısı artmadı, suanki ürün sayisi: " + productList.size());
            return false;
        }
    }
    /**
     * Captures a screenshot and attaches it to Allure report.
     */
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
    /**
     * Logs an info message to console and Allure.
     */
    public static void log(String message) {
        logger.info(message);             // Konsola yaz
        Allure.step(message);             // Allure raporuna yaz
    }
    /**
     * Logs a formatted info message with one argument.
     */
    public static void log(String format, Object arg) {
        String message = format.replace("{}", String.valueOf(arg));
        logger.info(message);
        Allure.step(message);
    }
    /**
     * Logs an error message to console and Allure.
     */
    public static void logError(String message) {
        logger.error(message);
        Allure.step("[ERROR] " + message);
    }
    /**
     * Logs a formatted error message with one argument.
     */
    public static void logError(String format, Object arg) {
        String message = format.replace("{}", String.valueOf(arg));
        logger.info(message);
        Allure.step("[ERROR] " + message);
    }
    /**
     * Takes a screenshot and attaches it to Allure with a given name.
     */
    public static void screenShot(String name) {
        try {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment(name, "image/png", "png", screenshot);
        } catch (Exception e) {
            log("Ekran görüntüsü alınamadı: " + e.getMessage(), name);
        }
    }

}
