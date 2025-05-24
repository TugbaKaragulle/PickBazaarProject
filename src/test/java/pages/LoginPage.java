package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class LoginPage {

    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailForgot;


    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement logInButton;


    @FindBy(xpath = "//img[@alt='user name']")
    private WebElement profileImage;

    @FindBy(xpath = "//button[text()='Forgot password?']")
    private WebElement forgotPassword;

    @FindBy(xpath = "//button[text()='Logout']")
    private WebElement logoutButton;


    @FindBy(xpath = "(//label[@for='password'])[2]")
    private WebElement isPasswordInvisible;


    @FindBy(xpath = "//p[@class='text-sm']")
    private WebElement passwordChangeMessage;

    @FindBy(xpath = "//button[text()='Submit Email']")
    private WebElement submitEmailButton;

    @FindBy(xpath = "//button[text()='Login with Google']")
    private WebElement googleLogin;

    @FindBy(xpath = "/html/body/pre")
    private WebElement googleErrorMessage;

    @FindBy(xpath = "//button[text()='Login with Mobile number']")
    private WebElement loginWithMobileButton;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement telNumberInput;

    @FindBy(xpath = "//button[text()='Send OTP']")
    private WebElement sendOPT;


    @FindBy(xpath = "//div[@style='display: flex; align-items: center;']//input")
    private List<WebElement> optCodeNumberList;

    @FindBy(xpath = "//button[text()='Verify Code']")
    private WebElement verifyCodeButton;


    public void logIn(String email, String password) {
        AllPages allPages = new AllPages();
        allPages.pickBazarHomePage().clickJoinButton();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        ReusableMethods.clickElement(logInButton);
    }

    public boolean isProfileImageDisplayed() {
        logger.info("Profile Image is Displayed");
        boolean flag = false;

        if (profileImage.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void forgotPasswordClick() {
        ReusableMethods.clickElement(forgotPassword);
        logger.info("forgot Password Clicked");
    }

    public void logoutbuttonClick() {
        logger.info("logout button Clickee");
        ReusableMethods.clickElement(logoutButton);
    }

    public void sendPassword() {
        passwordField.sendKeys(ConfigReader.getProperty("loginPassword"));
        logger.info("password sent");
    }


    public boolean isEyeImageDisplayed() {
        boolean flag = false;
        logger.info("EyeImageDisplayed");

        if (isPasswordInvisible.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void sendEmail() {
        Actions action = new Actions(Driver.getDriver());
        action.click(emailForgot).sendKeys(ConfigReader.getProperty("loginEmail")).perform();
        logger.info("Email sent");
    }


    public void submitEmailClick() {
        ReusableMethods.clickElement(submitEmailButton);
        logger.info("Email is Clicked");
    }

    public boolean passwordChangeSuccessfully() {
        boolean flag = false;
        logger.info("password Changed Successfully");

        if (passwordChangeMessage.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void googleLoginClick() {
        ReusableMethods.clickElement(googleLogin);
        logger.info("google Login Clicked");
    }

    public boolean googleErrorMessageIsdisplayed() {
        boolean flag = false;
        logger.info("Erroor Message Is displayed");
        if (googleErrorMessage.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void loginWithMobileButtonClick() {
        ReusableMethods.clickElement(loginWithMobileButton);
        logger.info("login With Mobile ButtonClick");
    }


    public void sendTelNumber() {
        Actions action = new Actions(Driver.getDriver());
        action.click(telNumberInput).sendKeys(ConfigReader.getProperty("telNumber")).perform();
   logger.info("Tel number sent");
    }

    public void sendOPTClick() {
        ReusableMethods.clickElement(sendOPT);
        logger.info("OPT sent");
    }

    public void sendOPTCode() {
        Actions action = new Actions(Driver.getDriver());

        int index = 0;
        for (WebElement w : optCodeNumberList) {
            if (index != 6) {

                action.click(w).sendKeys(ConfigReader.getProperty("OPTCode").substring(index, index + 1)).perform();
            } else {
                action.sendKeys(ConfigReader.getProperty("OPTCode").substring(index)).perform();
            }


            index += 1;


        }

    }

    public void verifyCodeButtonClick() {
        ReusableMethods.clickElement(verifyCodeButton);
       logger.info("verify Code Button Clicked");

    }







    public WebElement getLogInButton() {
        return logInButton;
    }




    public boolean isLoggedOut() {
        AllPages page = new AllPages();
        logger.info("LoggedOut");
        boolean isLoggedOut;
        try {
            isLoggedOut = page.pickBazarHomePage().isJoinButtonDisplayed();

        } catch (Exception e) {
            isLoggedOut = false;

        }
        return isLoggedOut;
    }




}












