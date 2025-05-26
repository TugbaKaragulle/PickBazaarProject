package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.LoginProfileTest;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import static utilities.Driver.getDriver;
import static utilities.ReusableMethods.clickElement;

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

//**************************************** Class Level Variables And Objects *********************************

    String exceptedText;
    String actualText;
    AllPages allPages = new AllPages();
    Actions actions = new Actions(getDriver());
    Logger logger = LogManager.getLogger(LoginProfileTest.class);


//***************************************** Test Methods ******************************************************

    public boolean profilePoints() {
        try {
            allPages.booksPage().navigateToHomePage();
            logger.info("Logging into the page with valid credentials.");
            allPages.loginPage().logIn(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
            logger.info("Clicking on the profile silhouette.");
            clickElement(profilSilueti);
            exceptedText ="0";
            logger.info("Customer sees their points on the profile page.");
            ReusableMethods.waitForVisibility(getDriver(),points,10);
            actualText= points.getText();
            return actualText.contains(exceptedText);
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean profileDropDownMenu(String data) {
        try {
            allPages.booksPage().navigateToHomePage();
            logger.info("Logging into the page with valid credentials.");
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
                    logger.error("Geçersiz data : " + data);
                    return false;
            }

            logger.info("Clicking profile silhouette to open the dropdown menu.");
            clickElement(profilSilueti);
            logger.info("Waiting for '" + data + "' menu item to be clickable.");
            ReusableMethods.waitForClickability(element);
            logger.info("Clicking on the '" + data + "' menu item.");
            clickElement(element);

            ReusableMethods.waitForUrlContains(data);
            String currentUrl = getDriver().getCurrentUrl();
            logger.info("Current URL after click: " + currentUrl);
            return currentUrl.contains(data);
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    public boolean verifyLogoutWorks(){
        try {
            allPages.booksPage().navigateToHomePage();
            logger.info("Logging into the page with valid credentials.");
            allPages.loginPage().logIn(ConfigReader.getProperty("loginPageEmail"), ConfigReader.getProperty("loginPagePassword"));
            logger.info("Clicking on the profile silhouette.");
            clickElement(profilSilueti);
            logger.info("Waiting until the 'Logout' menu item becomes clickable.");
            ReusableMethods.waitForClickability(logout);
            logger.info("Clicking on the 'Logout' menu item.");
            clickElement(logout);
            logger.info("Checking if the 'Join' button is visible after clicking logout");
            return ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getJoinButton());
        } catch (Exception e) {
            logger.error("Test failed - Exception caught", e);
            return false;
        }
    }

    //******************************************Getter Methods***************************************************

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
}
