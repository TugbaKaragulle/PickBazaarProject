package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegisterPage {


    Logger logger = LogManager.getLogger(RegisterPage.class);

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerLink;

    @FindBy(xpath = "//p[text()='You must need to provide your name']")
    private WebElement nameFieldMissingMessage;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//p[text()='You must need to provide your email address']")
    private WebElement emailMissingMessage;

    @FindBy(xpath = "//p[text()='You must need to provide your email address']")
    private WebElement passwordMissingMessage;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[text()='Already have an account?']")
    private WebElement alreadyHaveAccountMessage;


    public void registerLinkClick() {
        ReusableMethods.clickElement(registerLink);
        logger.info("Register link is clicked");

    }


    public void registerButtonClick() {
        ReusableMethods.clickElement(registerButton);
        logger.info("Register button is clicked");

    }

    public boolean nameFieldMissingMessageIsDisplayed() {
        boolean flag = false;
        if (nameFieldMissingMessage.isDisplayed()) {
            logger.info("name Field Missing Message is Displayed");
            flag = true;
        } else {
            logger.info("name Field Missing Message is NOT Displayed");
        }
        return flag;
    }

    public boolean emailMissingMessageIsDisplayed() {
        boolean flag = false;
        if (emailMissingMessage.isDisplayed()) {

            logger.info("email Field Missing Message is Displayed");
            flag = true;
        } else {
            logger.info("email Field Missing Message is NOT Displayed");
        }
        return flag;
    }

    public boolean passwordMissingMessageIsDisplayed() {
        boolean flag = false;
        if (passwordMissingMessage.isDisplayed()) {
            logger.info("password Field Missing Message is Displayed");
            flag = true;
        }else {
            logger.info("passord Field Missing Message is NOT Displayed");
        }
        return flag;
    }

    public boolean alreadyHaveAnAccountMessageIsDisplayed() {
        boolean flag = false;
        if (alreadyHaveAccountMessage.isDisplayed()) {
            logger.info("already Have An Account Message Is Displayed");
            flag = true;
        }else{
            logger.info("already Have An Account Message Is NOT Displayed");
        }
        return flag;
    }


}
