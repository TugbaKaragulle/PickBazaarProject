package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.getDriver;

public class ContactPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public ContactPage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(linkText = "Contact")
    private WebElement contactMenu;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "subject")
    private WebElement subjectInput;

    @FindBy(id = "description")
    private WebElement descriptionInput;

    @FindBy(xpath = "//button[@data-variant='normal' and text()='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(),'Thank you for contacting us. We will get back to you soon.')]")
    private WebElement successMessage;

    @FindBy(xpath = "(//span[@class='text-sm text-body'])[1]")
    private WebElement addressInfo;

    @FindBy(xpath = "(//span[@class='text-sm text-body'])[2]")
    private WebElement phoneInfo;

    @FindBy(xpath = "(//span[@class='text-sm text-body'])[3]")
    private WebElement websiteInfo;

    @FindBy(css = "svg.w-4.h-4")
    private WebElement facebookIcon;

    @FindBy(xpath = "//a[contains(@href, 'twitter.com')]")
    private WebElement twitterIcon;

    @FindBy(xpath = "//a[contains(@href, 'instagram.com')]")
    private WebElement instagramIcon;

    @FindBy(xpath = "//a[contains(@href,'facebook.com')]")
    private WebElement facebookLinkLocator;

    @FindBy(xpath = "//a[contains(@href,'x.com')]")
    private WebElement twitterLinkLocator;

    @FindBy(xpath = "//a[contains(@href,'instagram.com')]")
    private WebElement instagramLinkLocator;


    public void goToContactPage() {
        ReusableMethods.clickElement(contactMenu);
        ReusableMethods.waitForVisibility(getDriver(), nameInput, 10);
    }



    // Formu doldur
    public void fillContactForm(String name, String email, String subject, String description) {
        // Elementlerin görünür olmasını bekle
        ReusableMethods.waitForVisibility(getDriver(), nameInput, 10);
        nameInput.clear();
        nameInput.sendKeys(name);

        ReusableMethods.waitForVisibility(getDriver(), emailInput, 10);
        emailInput.clear();
        emailInput.sendKeys(email);

        ReusableMethods.waitForVisibility(getDriver(), subjectInput, 10);
        subjectInput.clear();
        subjectInput.sendKeys(subject);

        ReusableMethods.waitForVisibility(getDriver(), descriptionInput, 10);
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    public void submitForm() {
        ReusableMethods.clickElement(submitButton);
    }


    public String getSuccessMessageText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getAddressText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(addressInfo)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getPhoneText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(phoneInfo)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getWebsiteText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(websiteInfo)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isFacebookLinkVisibleOnHover() {
        try {
            actions.moveToElement(facebookIcon).perform();
            return wait.until(ExpectedConditions.visibilityOf(facebookLinkLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTwitterLinkVisibleOnHover() {
        WebElement twitterLink = driver.findElement(By.xpath("//a[contains(@href, 'twitter.com/home')]"));
        boolean isVisible = twitterLink.isDisplayed();
        String href = twitterLink.getAttribute("href");
        boolean correctUrl = "https://twitter.com/home".equals(href);

        return isVisible && correctUrl;
    }

    public boolean isInstagramLinkVisibleOnHover() {
        try {
            actions.moveToElement(instagramIcon).perform();
            return wait.until(ExpectedConditions.visibilityOf(instagramLinkLocator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
