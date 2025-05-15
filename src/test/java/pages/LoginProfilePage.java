package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.getDriver;

public class LoginProfilePage {

    public LoginProfilePage() {
        PageFactory.initElements(getDriver(), this);
    }

    //***************************************** @FindBy *********************************************************************

@FindBy(xpath = "//button[.='Join']")
    private WebElement joinButton;

@FindBy(id = "email")
    private  WebElement email;

@FindBy(id = "password")
    private  WebElement password;

@FindBy(xpath = "//button[text()='Login']")
private WebElement loginButton;

@FindBy (xpath = "//img[@alt='user name']")
    private WebElement profilSilueti;

@FindBy(id = "headlessui-menu-item-11")
    private WebElement points;

@FindBy(xpath = "//button[text()='Profile']")
    private WebElement profile;

@FindBy(xpath = "//button[text()='My Orders']")
    private WebElement myOrders;

@FindBy(xpath = "//button[text()='My Wishlists']")
    private WebElement myWishlist;

@FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkout;

@FindBy(xpath = "//button[text()='Logout']")
    private WebElement logout;

//**************************************** Class Level Variables*********************************************+

    String exceptedText;
    String actualText;
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

//****************************************** Methods ******************************************************

public void loginMethod(String mail, String pass){

    getDriver().get(ConfigReader.getProperty("pickbazar_url"));
    joinButton.click();
    email.sendKeys(mail);
    password.sendKeys(pass);
    loginButton.click();

}

public boolean profilePoints() {
    loginMethod(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
    profilSilueti.click();
    exceptedText ="0";
    ReusableMethods.waitForVisibility(getDriver(),points,10);
    actualText= points.getText();
    return actualText.contains(exceptedText);
}



}
