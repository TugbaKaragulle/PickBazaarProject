package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class LoginProfilePage {

    public LoginProfilePage() {
        PageFactory.initElements(getDriver(), this);
    }

    //***************************************** @FindBy *********************************************************************

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

//******************************************Getter Methods********************************************************+

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getProfilSilueti() {
        return profilSilueti;
    }

    public WebElement getPoints() {
        return points;
    }

    public WebElement getProfile() {
        return profile;
    }

    public WebElement getMyOrders() {
        return myOrders;
    }

    public WebElement getMyWishlist() {
        return myWishlist;
    }

    public WebElement getCheckout() {
        return checkout;
    }

    public WebElement getLogout() {
        return logout;
    }

//**************************************** Class Level Variables And Objects *****************************************

    String exceptedText;
    String actualText;
    AllPages allPages = new AllPages();
    Actions actions = new Actions(getDriver());

//****************************************** My Reausable Methods ******************************************************

public void loginMethod(String mail, String pass){ //Homepage'de login olmak icin kullanilacak olan method

    getDriver().get(ConfigReader.getProperty("pickbazar_url"));
    ReusableMethods.clickElement(allPages.pickBazarHomePage().getJoinButton());
    email.sendKeys(mail);
    password.sendKeys(pass);
    ReusableMethods.clickElement(loginButton);
}


public boolean isUrlContainsKeyWord(String keyword, WebElement element){
    loginMethod(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));

    actions.click(profilSilueti).perform();
    ReusableMethods.waitForClickability(element);
    actions.moveToElement(element).click().perform();
    String actualUrl = getDriver().getCurrentUrl();
    return actualUrl.contains(keyword);
}

//***************************************** Test Methods ***********************************************************

public boolean profilePoints() { //TODO login methodu Sengul hnm'dan al
    loginMethod(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
    ReusableMethods.clickElement(profilSilueti);
    exceptedText ="0";
    ReusableMethods.waitForVisibility(getDriver(),points,10);
    actualText= points.getText();
    return actualText.contains(exceptedText);
}


    public boolean profileDropDownMenu(String data) {
        loginMethod(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));

        WebElement element = null;

        switch (data) {
            case "profile":
                element = profile;
                break;
            case "orders":
                element = myOrders;
                break;
            case "wishlists":
                element = myWishlist;
                break;
            case "checkout":
                element = checkout;
                break;
            default:
                Assert.fail("Geçersiz data : " + data);
        }

        actions.click(profilSilueti).perform(); //siluete tiklar, menuye girmk icin
        ReusableMethods.waitForClickability(element);
        actions.moveToElement(element).perform();
        element.click();

        ReusableMethods.waitForUrlContains(data);
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl.contains(data);
    }

    public boolean verifyLogoutWorks(){ //TODO login methodu Sengul hnm'dan al
        loginMethod(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
        actions.click(profilSilueti).perform();
        ReusableMethods.waitForClickability(logout);
        actions.moveToElement(logout).click().perform();
        return ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getJoinButton());
    }


}
