package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

//***

public class LoginProfilePage {

    public LoginProfilePage() {
        PageFactory.initElements(getDriver(), this);
    }

//***************************************** @FindBy *************************************************

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


//***************************************** Test Methods ***********************************************************

    public boolean profilePoints() {
    allPages.loginPage().logIn(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
    ReusableMethods.clickElement(profilSilueti);
    exceptedText ="0";
    ReusableMethods.waitForVisibility(getDriver(),points,10);
    actualText= points.getText();
    return actualText.contains(exceptedText);
}

    public boolean profileDropDownMenu(String data) {
        SoftAssert softAssert = new SoftAssert();
        allPages.loginPage().logIn(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));

        WebElement element = null ;

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
                softAssert.fail("Geçersiz data : " + data);
        }

        actions.click(profilSilueti).perform(); //siluete tiklar, menuye girmk icin
        ReusableMethods.waitForClickability(element);
        actions.moveToElement(element).perform();
        element.click();

        ReusableMethods.waitForUrlContains(data);
        String currentUrl = getDriver().getCurrentUrl();
        assert currentUrl != null; // contains sari renkti, intellij tavsiye etti.
        return currentUrl.contains(data);
    }

    public boolean verifyLogoutWorks(){
        allPages.loginPage().logIn(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
        actions.click(profilSilueti).perform();
        ReusableMethods.waitForClickability(logout);
        actions.moveToElement(logout).click().perform();
        return ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getJoinButton());
    }

}
