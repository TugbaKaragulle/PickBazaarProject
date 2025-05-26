package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import tests.ShopsPageTest;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;


public class ShopsPage {

    public ShopsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static Logger logger = LogManager.getLogger(ShopsPageTest.class);

// ============================================================
//             WebElement Definitions (Locators)
// ============================================================

    // SHOP LİNKLERİ
    @FindBy(xpath = "//span[text()='Furniture Shop']/ancestor::a")
    private WebElement furnitureShop;
    @FindBy(xpath = "//span[text()='Clothing Shop']")
    private WebElement clothingShop;
    @FindBy(xpath = "//span[text()='Bags Shop']")
    private WebElement bagsShop;
    @FindBy(xpath = "//span[text()='Makeup Shop']")
    private WebElement makeupShop;
    @FindBy(xpath = "//span[text()='Bakery Shop']")
    private WebElement bakeryShop;
    @FindBy(xpath = "//span[text()='Grocery Shop']")
    private WebElement groceryShop;
    @FindBy(xpath = "//span[text()='Books Shop']")
    private WebElement booksShop;

    // SHOP BİLGİ PANELİ
    @FindBy(xpath = "//p[@class='mb-2 text-sm leading-relaxed text-center text-body']/span/button")
    private WebElement shopInfoSection;

    // SOSYAL MEDYA İKONLARI
    @FindBy(css = "path[data-name*=\"facebook\"]")
    private WebElement facebookIconPath;
    @FindBy(css = "www.facebook.com")
    private WebElement facebookLink;
    @FindBy(css = "a[href*='instagram.com']")
    private WebElement instagramIconLink;

    // İLETİŞİM BİLGİLERİ
    @FindBy(xpath = "(//span[contains(@class, 'text-body')])[1]")
    private WebElement addressSection;
    @FindBy(xpath = "(//span[contains(@class, 'text-sm') and contains(@class, 'text-body')])[2]")
    private WebElement phoneSection;

    // WEBSITE BİLGİLERİ
    @FindBy(css = "path[data-name*=\"globe\"]")
    private WebElement websiteIconPath;
    @FindBy(xpath = "//a[@href='https://redq.io/' and text()='Visit This Site']")
    private WebElement websiteLink;

    // ÜRÜN ELEMENTLERİ
    @FindBy(css = ".product-card")
    private List<WebElement> productCards;
    @FindBy(xpath = "//span[normalize-space()='Add To Shopping Cart']")
    private WebElement productDetailAddToCartButton;

    // SEPET ELEMENTLERİ
    @FindBy(xpath = "//button[.//span[contains(text(), 'Item')]]")
    private WebElement cartButton;
    @FindBy(css = "div.text-heading.font-semibold")
    private WebElement cartItemCount;
    @FindBy(css = "div.text-heading")
    private WebElement cartItemCount1;
    @FindBy(xpath = "//h3[text()='Chill Winston Waist Coat']")
    private WebElement clothingProductCart;
    @FindBy(xpath = "(//button[span[text()='Add To Shopping Cart']])[2]")
    private WebElement clothingAddToCart;
    @FindBy(xpath = "(//button[.//span[text()='plus']])[2]")
    private WebElement increaseProductQuantity;
    @FindBy(xpath = "(//button[.//span[text()='minus']])[2]")
    private WebElement decreaseQuantityOfProduct;
    @FindBy(xpath = "//div[contains(text(), 'added to cart')]")
    private List<WebElement> addedToCartMessages;
    @FindBy(xpath = "(//button[.//span[text()='plus']])[13]")
    private WebElement clothingIncreaseButton;
    @FindBy(xpath = "(//button[.//span[text()='minus']])[13]")
    private WebElement clothingDecreaseButton;

    @FindBy(xpath = "//span[contains(text(), 'Checkout')]")
    private WebElement checkoutSpan;
    @FindBy(xpath = "//button[@data-variant='normal' and contains(text(), 'Check Availability')]")
    private WebElement checkAvailabilityButton;
    @FindBy(xpath = "//span[@class='text-xs font-semibold text-heading' and text()='Cash On Delivery']")
    private WebElement cashOnDeliverySpan;
    @FindBy(xpath = "//button[@data-variant='normal' and normalize-space(text())='Place Order']")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//span[contains(@class, 'px-3') and contains(@class, 'py-1') and contains(@class, 'rounded-full') and contains(@class, 'bg-accent') and contains(@class, 'text-light') and contains(text(), 'Order Received')]")
    private WebElement orderReceivedSpan;
    @FindBy(xpath = "//div[contains(@class, 'relative') and .//img[@alt='Stripe']]")
    private WebElement stripeImage;
    @FindBy(css = "//span[text()='Please Pay After You Receive Your Goods!']")
    private WebElement paymentWarningMessage;
    @FindBy(css = "button.StripePay[type='submit']")
    private WebElement confirmButton;
    @FindBy(xpath = "//p[text()='Please Pay First']")
    private WebElement paymentWarningText;
    @FindBy(xpath = "(//button[@disabled]//span[text()='Add To Shopping Cart'])[2]")
    private WebElement secondDisabledAddToCartButton;


    // Mağaza Adına Göre Elementler
    private WebElement getShopElementByName(String shopName) {
        return switch (shopName) {
            case "Furniture Shop" -> furnitureShop;
            case "Clothing Shop" -> clothingShop;
            case "Bags Shop" -> bagsShop;
            case "Makeup Shop" -> makeupShop;
            case "Bakery Shop" -> bakeryShop;
            case "Grocery Shop" -> groceryShop;
            case "Books Shop" -> booksShop;
            default -> throw new IllegalArgumentException("Geçersiz shop adı: " + shopName);
        };
    }

// ============================================================
//                   Method Declarations List
// ============================================================

    // Shop linkine tıklayan metod
    public void clickShopByName(String shopName) {
        WebElement shopElement = getShopElementByName(shopName);
        //JavascriptUtils.scrollIntoViewJS(shopElement);
        ReusableMethods.clickElement(shopElement);
    }

    // Shop Info bölümünün görünür olup olmadığını kontrol eder
    public boolean isShopInfoVisible() {
        try {
            return shopInfoSection.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean rejectOptionalCookies() {
        Driver.getDriver().switchTo().defaultContent();

        List<WebElement> iframes = Driver.getDriver().findElements(By.tagName("iframe"));

        for (WebElement iframe : iframes) {
            try {
                Driver.getDriver().switchTo().frame(iframe);

                List<WebElement> buttons = Driver.getDriver().findElements(
                        By.xpath("//span[text()='İsteğe bağlı çerezleri reddet']"));

                if (!buttons.isEmpty()) {
                    WebElement button = buttons.get(0);
                    if (button.isDisplayed() && button.isEnabled()) {
                        ((JavascriptExecutor) Driver.getDriver())
                                .executeScript("arguments[0].click();", button);
                        Driver.getDriver().switchTo().defaultContent();
                        return true;
                    }
                }

            } catch (Exception ignored) {
                // diğer iframe'e geç
            } finally {
                Driver.getDriver().switchTo().defaultContent();
            }
        }

        return false;
    }

    public void handleCookiePopup() {
        rejectOptionalCookies();
    }

    // Örnek: Facebook ikonunun olup olmadığını kontrol eden method
    public boolean isFacebookIconPresent() {
        try {
            return Driver.getDriver().findElement(By.cssSelector("a[href*='facebook.com']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Facebook ikonuna tıklayan method
    public void clickFacebookIcon() {
        WebElement facebookIcon = Driver.getDriver().findElement(By.cssSelector("a[href*='facebook.com']"));
        facebookIcon.click();
    }

    // Facebook linkinin açılıp açılmadığını kontrol eden method
    public boolean isFacebookLinkVisible() {
        for (String window : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(window);
            if (Driver.getDriver().getCurrentUrl().contains("facebook.com")) {
                return true;
            }
        }
        return false;
    }

    // Instagram linkini kontrol eden method
    public boolean isInstagramIconPresent() {
        try {
            return Driver.getDriver().findElement(By.cssSelector("a[href*='instagram.com']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Instagram ikonuna tıklayan method
    public void clickInstagramIcon() {
        WebElement instagramIcon = Driver.getDriver().findElement(By.cssSelector("a[href*='instagram.com']"));
        instagramIcon.click();
    }

    // Instagram linkinin açılıp açılmadığını kontrol eder
    public boolean isInstagramLinkVisible() {
        for (String window : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(window);
            if (Driver.getDriver().getCurrentUrl().contains("instagram.com")) {
                return true;
            }
        }
        return false;
    }

    // Address bölümünün görünür olup olmadığını kontrol eder
    public boolean isAddressVisible() {
        try {
            return addressSection.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Phone bölümünün görünür olup olmadığını kontrol eder
    public boolean isPhoneVisible() {
        try {
            return phoneSection.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Website ikonunun olup olmadığını kontrol eder
    public boolean isWebsiteIconPresent() {
        try {
            return websiteLink.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Website ikonuna tıklayan method
    public void clickWebsiteIcon() {
        websiteLink.click();
    }

    // Website linkinin açılıp açılmadığını kontrol eden method
    public boolean isWebsiteLinkVisible() {
        for (String window : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(window);
            if (Driver.getDriver().getCurrentUrl().startsWith("http")) {
                return true;
            }
        }
        return false;
    }

    public void clickFirstAvailableProduct() {
        for (WebElement product : productCards) {
            if (product.isDisplayed() && product.isEnabled()) {
                JavascriptUtils.scrollIntoViewJS(product);
                ReusableMethods.waitForClickability(product, 10);
                product.click();
                return;
            }
        }
        throw new NoSuchElementException("Uygun ürün bulunamadı.");
    }

    public boolean tryAddToCartFirstAvailableProduct(String shopName) {
        Logger logger = LogManager.getLogger(ShopsPage.class);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        boolean addedToCart = false;

        if (shopName.equalsIgnoreCase("Clothing Shop")) {
            try {
                // 8. ürünün görseline tıkla
                WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//h3[text()='Chill Winston Waist Coat']")));
                product.click();
                logger.info("Clothing Shop: 30. ürüne tıklandı (XPath: (//img[@class='product-image'])[8]).");

                // Sayfa yüklenmesini garanti et - örnek bir container beklenebilir
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".product-details")));

                // Sayfa başlığını ve URL’yi logla
                logger.info("Detay Sayfası Title: {}", Driver.getDriver().getTitle());
                logger.info("Detay Sayfası URL: {}", Driver.getDriver().getCurrentUrl());

                // Butonu bekle
                WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='Add To Shopping Cart']")));

                if (addToCartBtn.isDisplayed() && addToCartBtn.isEnabled()) {
                    addToCartBtn.click();
                    addedToCart = true;
                    logger.info("Clothing Shop: Ürün sepete eklendi.");
                } else {
                    // Fallback - JavaScript ile tıkla
                    logger.warn("Clothing Shop: Buton görünür değil, JS ile tıklanacak.");
                    ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", addToCartBtn);
                    addedToCart = true;
                    logger.info("Clothing Shop: JS ile ürün sepete eklendi.");
                }

            } catch (TimeoutException e) {
                logger.error("Clothing Shop: Zaman aşımı - ürün detayları veya sepete ekle butonu bulunamadı: {}", e.getMessage());
                throw new RuntimeException("Clothing Shop: Ürün detayları veya sepete ekle butonu bulunamadı.", e);
            } catch (Exception e) {
                logger.error("Clothing Shop: Ürün eklenirken beklenmeyen hata: {}", e.getMessage());
                throw new RuntimeException("Clothing Shop: Ürün eklenirken beklenmeyen hata.", e);
            }
        } else {

            List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.cssSelector(".product-card")));

            for (int i = 0; i < products.size(); i++) {
                try {
                    products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.cssSelector(".product-card")));
                    products.get(i).click();
                    logger.info("Ürün {}'e tıklandı.", i + 1);

                    WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//span[normalize-space()='Add To Shopping Cart']")));

                    if (addToCartBtn.isEnabled() && addToCartBtn.isDisplayed()) {
                        addToCartBtn.click();
                        addedToCart = true;
                        logger.info("Ürün sepete eklendi.");
                        break;
                    } else {
                        logger.info("Sepete ekle butonu aktif değil, bir sonraki ürüne geçiliyor.");
                        Driver.getDriver().navigate().back();
                    }
                } catch (TimeoutException e) {
                    logger.info("Sepete ekle butonu bulunamadı: {}", e.getMessage());
                    Driver.getDriver().navigate().back();
                } catch (Exception e) {
                    logger.info("Ürün eklenirken hata oluştu: {}", e.getMessage());
                    Driver.getDriver().navigate().back();
                }
            }
        }

        if (!addedToCart) {
            logger.error("Sepete eklenebilecek uygun ürün bulunamadı.");
            throw new RuntimeException("Sepete eklenebilecek uygun ürün bulunamadı.");
        }
        return addedToCart;
    }

    public void clickAddToCartOnProductPage() {
        // Mevcut tanımlı productDetailAddToCartButton kullanılarak tıklama
        JavascriptUtils.scrollIntoViewJS(productDetailAddToCartButton);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productDetailAddToCartButton));

        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0, -150);");

        JavascriptUtils.clickElementByJS(productDetailAddToCartButton);
    }

    public void clickAddToCartOnProductPageDynamic() {
        WebDriver driver = Driver.getDriver();
        WebElement addToCartButton = null;


        By[] locators = {
                By.xpath("(//span[normalize-space()='Add To Shopping Cart'])[1]"),
                By.xpath("(//span[normalize-space()='Add To Shopping Cart'])[2]"),
                By.xpath("//button[normalize-space()='Add to Cart']"),
                By.xpath("//button[.//span[contains(text(), 'Item')]]"),
                By.xpath("(//button[span[text()='Add To Shopping Cart']])[2]"),
        };


        for (By locator : locators) {
            try {
                // Buton işlemleri
                addToCartButton = ReusableMethods.waitForElementToBeClickable(driver, locator, 10);
                System.out.println("Bulunan locator: " + locator.toString());


                JavascriptUtils.scrollIntoViewJS(addToCartButton);
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");
                ReusableMethods.waitForSeconds(2);


                addToCartButton.click();
                return;

            } catch (Exception e) {
                System.out.println("Normal tıklama başarısız, JS ile tıklanıyor... Locator: " + locator.toString());
                try {
                    // JS click için yeniden locate edilir
                    addToCartButton = driver.findElement(locator);
                    JavascriptUtils.scrollIntoViewJS(addToCartButton);
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");
                    ReusableMethods.waitForSeconds(1);
                    JavascriptUtils.clickElementByJS(addToCartButton);
                    return;
                } catch (Exception jsEx) {
                    System.out.println("JS ile tıklama da başarısız oldu: " + locator.toString());
                }
            }
        }


        throw new NoSuchElementException("Hiçbir 'Add to Cart' butonu bulunamadı.");
    }

    public void clickCartButton() {
        JavascriptUtils.scrollIntoViewJS(cartButton);
        ReusableMethods.waitForClickability(cartButton, 5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", cartButton);
    }


    public boolean isAddedMessageVisible() {
        return !addedToCartMessages.isEmpty();
    }

    public int getCartItemCount() {
        try {
            if (cartItemCount.isDisplayed()) {
                String text = cartItemCount.getText();
                String numberOnly = text.replaceAll("[^0-9]", "");
                return Integer.parseInt(numberOnly);
            }
        } catch (NoSuchElementException e) {

        }
        return 0;
    }

    public WebElement getClothingProductCart() {
        return clothingProductCart;
    }

    public WebElement getClothingAddToCart() {
        return clothingAddToCart;
    }

    public void clickClothingProduct() {
        ReusableMethods.waitForVisibility(Driver.getDriver(), clothingProductCart, 15);
        ReusableMethods.waitForClickability(clothingProductCart, 15);
        clothingProductCart.click();
    }

    public void clickAddToCart() {
        ReusableMethods.waitForVisibility(Driver.getDriver(), clothingAddToCart, 15);
        ReusableMethods.waitForClickability(clothingAddToCart, 15);
        clothingAddToCart.click();

    }

    public WebElement getIncreaseProductQuantity() {
        return increaseProductQuantity;
    }

    public WebElement getDecreaseQuantityOfProduct() {
        return decreaseQuantityOfProduct;
    }

    public void clickPlusButton() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", increaseProductQuantity);
    }

    public WebElement getPlusButton() {
        return increaseProductQuantity;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getCartItemElement() {
        return cartItemCount;
    }

    public WebElement getClothingIncreaseButton() {
        return clothingIncreaseButton;
    }

    public WebElement ClothingDecreaseButton() {
        return clothingDecreaseButton;
    }

    public WebElement getCheckoutSpan() {
        return checkoutSpan;
    }

    public WebElement getCheckAvailabilityButton() {
        return checkAvailabilityButton;
    }

    public WebElement getCashOnDeliverySpan() {
        return cashOnDeliverySpan;
    }

    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

    public WebElement getOrderReceivedSpan() {
        return orderReceivedSpan;
    }

    public WebElement getStripeImage() {
        return stripeImage;
    }

    public void assertPaymentWarningMessageIfVisible() {
        List<WebElement> messages = Driver.getDriver().findElements(By.xpath("//span[text()='Please Pay After You Receive Your Goods!']"));
        if (!messages.isEmpty() && messages.get(0).isDisplayed()) {
            String actualMessage = messages.get(0).getText().trim();
            Assert.assertEquals(actualMessage, "Please Pay After You Receive Your Goods!", "Uyarı mesajı beklenenle aynı değil!");
            logger.info("Uyarı mesajı doğrulandı: " + actualMessage);

        }
    }


    public WebElement getConfirmButton() {
        return confirmButton;
    }

    // Stripe ödeme seçeneğini seçmek için
    public void selectStripePaymentMethod() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(stripeImage));
        stripeImage.click();
    }


    public boolean isConfirmOrderButtonEnabled() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(confirmButton));
            return confirmButton.isEnabled();
        } catch (TimeoutException e) {
            logger.warn("Confirm Order butonu bulunamadı veya görünür değil.");
            return false;
        }
    }

    public boolean isPaymentWarningVisible() {
        return paymentWarningText.isDisplayed();
    }

    public String getPaymentWarningText() {
        return paymentWarningText.getText();
    }

    public WebElement getSecondDisabledAddToCartButton() {
        return secondDisabledAddToCartButton;
    }



}