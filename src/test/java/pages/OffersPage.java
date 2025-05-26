package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class OffersPage {
    private static final Logger logger = LogManager.getLogger(OffersPage.class);
    private WebDriver driver;

    public OffersPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//span[@class='mb-2 text-lg font-semibold text-heading' and normalize-space(text())='Furniture Shop']")
    private WebElement furnitureShopTitle;

    @FindBy(xpath = "//h3[@class='mb-2 truncate text-sm font-semibold text-heading' and normalize-space(text())='Ash Double Bed']")
    private WebElement ashDoubleBedTitle;

    @FindBy(xpath = "//p[@role='button' and contains(@class,'text-xs') and contains(text(),'Do you have coupon')]")
    private WebElement couponQuestionText;

    // Güncellenmiş: Daha genel bir locator (örneğin, name veya class attribute’u)
    @FindBy(xpath = "//input[@name='coupon' or @type='text' or contains(@class, 'coupon')]")
    private WebElement couponInputBox;

    @FindBy(xpath = "//button[normalize-space()='Apply']")
    private WebElement applyCouponButton;

    @FindBy(xpath = "//*[contains(text(), 'Coupon applied successfully')]")
    private WebElement couponSuccessMessage;

    @FindBy(xpath = "//*[contains(text(), 'Coupon is invalid')]")
    private WebElement couponInvalidMessage;

    @FindBy(xpath = "//span[normalize-space()='Add To Shopping Cart']/parent::button")
    public WebElement addToCartButton;




    private By copyButtonLocatorByCouponCode(String couponCode) {
        return By.xpath("//span[normalize-space(text())='" + couponCode + "']/following-sibling::button[contains(normalize-space(.), 'Copy')]");
    }

    private By copiedMessageLocatorByCouponCode(String couponCode) {
        return By.xpath("//span[normalize-space(text())='" + couponCode + "']/following-sibling::button[contains(normalize-space(.), 'Copied!')]");
    }


    public void applyCouponCode(String couponCode) {
        logger.info("Kupon kodu uygulanıyor: " + couponCode);
        try {
            WebElement inputBox = ReusableMethods.waitForVisibility(driver, couponInputBox, 10);
            inputBox.clear();
            inputBox.sendKeys(couponCode);
            WebElement applyButton = ReusableMethods.waitForClickability(applyCouponButton, 10);
            ReusableMethods.clickElement(applyButton);
            logger.info("Kupon uygulama butonuna tıklandı: " + couponCode);
        } catch (NoSuchElementException e) {
            logger.error("Kupon giriş alanı veya uygulama butonu bulunamadı: " + e.getMessage());
            throw new RuntimeException("Kupon uygulama başarısız: " + couponCode, e);
        } catch (Exception e) {
            logger.error("Kupon uygulama sırasında hata oluştu: " + e.getMessage());
            throw new RuntimeException("Kupon uygulama başarısız: " + couponCode, e);
        }
    }


    public void clickCopyButtonByCouponCode(String couponCode) {
        try {
            WebElement copyButton = ReusableMethods.waitForVisibility(
                    driver,
                    driver.findElement(copyButtonLocatorByCouponCode(couponCode)),
                    10
            );
            ReusableMethods.clickElement(copyButton);
            logger.info("Kupon kodu kopyalama butonuna tıklandı: " + couponCode);
        } catch (Exception e) {
            logger.error("Kupon kopyalama butonu tıklamada hata: " + e.getMessage());
            throw new RuntimeException("Kupon kopyalama başarısız: " + couponCode, e);
        }
    }

    public boolean isCopiedMessageVisible(String couponCode) {
        try {
            WebElement copiedMsg = ReusableMethods.waitForVisibility(
                    driver,
                    driver.findElement(copiedMessageLocatorByCouponCode(couponCode)),
                    5
            );
            logger.info("Kupon kopyalandı mesajı göründü: " + couponCode);
            return copiedMsg.isDisplayed();
        } catch (Exception e) {
            logger.warn("Kupon kopyalandı mesajı görünmedi: " + couponCode);
            return false;
        }
    }


    public WebElement getFurnitureShopTitle() {
        return ReusableMethods.waitForVisibility(driver, furnitureShopTitle, 10);
    }

    public WebElement getAshDoubleBedTitle() {
        return ReusableMethods.waitForVisibility(driver, ashDoubleBedTitle, 10);
    }

    public WebElement getCouponQuestionText() {
        return ReusableMethods.waitForVisibility(driver, couponQuestionText, 10);
    }

    public WebElement getCouponInputBox() {
        return ReusableMethods.waitForVisibility(driver, couponInputBox, 10);
    }

    public WebElement getApplyCouponButton() {
        return ReusableMethods.waitForClickability(applyCouponButton, 10);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public double getSubTotalAmount() {
        WebElement subTotalElement = Driver.getDriver().findElement(By.xpath("(//div[contains(@class, 'flex') and .//p[text()='Sub Total']]//span[contains(text(), '$')])[2]"));
        return Double.parseDouble(subTotalElement.getText().replace("$", "").trim());
    }

    public double getDiscountAmount() {
        WebElement discountElement = Driver.getDriver().findElement(By.xpath("(//div[contains(@class, 'flex') and .//p[text()='Sub Total']]//span[contains(text(), '$')])[5]"));
        String discountText = discountElement.getText().replace("$", "").trim();
        return discountText.isEmpty() ? 0.0 : Double.parseDouble(discountText);
    }

    public double getTotalAmount() {
        WebElement totalElement = Driver.getDriver().findElement(By.xpath("(//div[contains(@class, 'flex') and .//p[text()='Sub Total']]//span[contains(text(), '$')])[6]"));
        return Double.parseDouble(totalElement.getText().replace("$", "").trim());
    }

    public double getCouponValue(String couponCode) {

        return 10.0;
    }

    public boolean isCouponSuccessMessageVisible() {
        try {
            WebElement successMsg = ReusableMethods.waitForVisibility(driver, couponSuccessMessage, 5);
            logger.info("Kupon başarıyla uygulandı mesajı göründü.");
            return successMsg.isDisplayed();
        } catch (Exception e) {
            logger.warn("Kupon başarıyla uygulandı mesajı görünmedi.");
            return false;
        }
    }

    public boolean isCouponInvalidMessageVisible() {
        try {
            WebElement invalidMsg = ReusableMethods.waitForVisibility(driver, couponInvalidMessage, 5);
            logger.warn("Kupon geçersiz mesajı göründü.");
            return invalidMsg.isDisplayed();
        } catch (Exception e) {
            logger.warn("Kupon geçersiz mesajı görünmedi.");
            return false;
        }
    }


    public void clickCheckoutWithWait(AllPages allPages) {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            WebElement checkoutSpan = wait.until(ExpectedConditions.elementToBeClickable(allPages.shopsPage().getCheckoutSpan()));
            checkoutSpan.click();
        } catch (TimeoutException e) {
            System.out.println("Checkout butonu 10 saniye içinde tıklanabilir olmadı.");

        } catch (StaleElementReferenceException e) {
            System.out.println("Checkout butonu stale oldu, tekrar bulunuyor...");

            WebElement checkoutSpan = wait.until(ExpectedConditions.elementToBeClickable(allPages.shopsPage().getCheckoutSpan()));
            checkoutSpan.click();
        } catch (Exception e) {
            System.out.println("Checkout tıklama sırasında beklenmeyen hata: " + e.getMessage());
        }
    }

}