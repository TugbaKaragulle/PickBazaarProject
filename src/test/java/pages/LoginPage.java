package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement logInButton;


    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement profileImage;

    @FindBy(xpath = "//button[text()='Forgot password?']")
    public WebElement forgotPassword;




    public void logIn(String email, String password) {
        AllPages allPages = new AllPages();
        allPages.pickBazarHomePage().clickJoinButton();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        ReusableMethods.clickElement(logInButton);
    }
      public boolean isProfileImageDisplayed() {
      boolean flag=false;

      if(profileImage.isDisplayed()){
          flag=true;

      }
      return flag;
      }

      public void forgotPasswordClick() {
          ReusableMethods.clickElement(forgotPassword);
      }


      }




