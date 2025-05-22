package pages;

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

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailForgot;


    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement logInButton;


    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement profileImage;

    @FindBy(xpath = "//button[text()='Forgot password?']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;


    @FindBy(xpath = "(//label[@for='password'])[2]")
    public WebElement isPasswordInvisible;


    @FindBy(xpath = "//p[@class='text-sm']")
    public WebElement passwordChangeMessage;

    @FindBy(xpath = "//button[text()='Submit Email']")
    public WebElement submitEmailButton;

    @FindBy(xpath = "//button[text()='Login with Google']")
    public WebElement googleLogin;

    @FindBy(xpath = "/html/body/pre")
    public WebElement googleErrorMessage;

    @FindBy(xpath = "//button[text()='Login with Mobile number']")
    public WebElement loginWithMobileButton;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement telNumberInput;

    @FindBy(xpath = "//button[text()='Send OTP']")
    public WebElement sendOPT;


    @FindBy(xpath = "//div[@style='display: flex; align-items: center;']//input")
    public List<WebElement> optCodeNumberList;

    @FindBy(xpath ="//button[text()='Verify Code']")
    public WebElement verifyCodeButton;


    public void logIn(String email, String password) {
        AllPages allPages = new AllPages();
        allPages.pickBazarHomePage().clickJoinButton();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        ReusableMethods.clickElement(logInButton);
    }

    public boolean isProfileImageDisplayed() {
        boolean flag = false;

        if (profileImage.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void forgotPasswordClick() {
        ReusableMethods.clickElement(forgotPassword);
    }

    public void logoutbuttonClick() {

        ReusableMethods.clickElement(logoutButton);
    }

    public void sendPassword() {
        passwordField.sendKeys(ConfigReader.getProperty("loginPassword"));
    }


    public boolean isEyeImageDisplayed() {
        boolean flag = false;

        if (isPasswordInvisible.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void sendEmail() {
        Actions action = new Actions(Driver.getDriver());
        action.click(emailForgot).sendKeys(ConfigReader.getProperty("loginEmail")).perform();

    }


    public void submitEmailClick() {
        ReusableMethods.clickElement(submitEmailButton);
    }

    public boolean passwordChangeSuccessfully() {
        boolean flag = false;

        if (passwordChangeMessage.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void googleLoginClick() {
        ReusableMethods.clickElement(googleLogin);
    }

    public boolean googleErroorMessageIsdisplayed() {
        boolean flag = false;

        if (googleErrorMessage.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public void loginWithMobileButtonClick() {
        ReusableMethods.clickElement(loginWithMobileButton);

    }


    public void sendTelNumber() {
        Actions action = new Actions(Driver.getDriver());
        action.click(telNumberInput).sendKeys(ConfigReader.getProperty("telNumber")).perform();

    }

    public void sendOPTClick() {
        ReusableMethods.clickElement(sendOPT);
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


}

    public WebElement getLogInButton() {
        return logInButton;
    }
}




