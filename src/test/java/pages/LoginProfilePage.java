package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;

import static utilities.Driver.getDriver;

public class LoginProfilePage {

    public LoginProfilePage() {
        PageFactory.initElements(getDriver(), this);
    }

@FindBy(xpath = "//button[.='Join']")
    private WebElement joinButton;

@FindBy(id = "email")
    private  WebElement email;

@FindBy(id = "password")
    private  WebElement password;

@FindBy(xpath = "//button[@class='inline-flex items-center justify-center shrink-0 font-semibold leading-none rounded outline-none transition duration-300 ease-in-out focus:outline-none focus:shadow focus:ring-1 focus:ring-accent-700 bg-accent text-light border border-transparent hover:bg-accent-hover px-5 py-0 h-12 h-11 w-full sm:h-12']")
private WebElement loginButton;

@FindBy (xpath = "//img[@alt='user name']")
    private WebElement profilSilueti;

@FindBy(id = "headlessui-menu-item-31")
    private WebElement points;

@FindBy(xpath = "//button[@class='block w-full py-2.5 px-6 text-sm font-semibold capitalize text-heading transition duration-200 hover:text-accent focus:outline-none ltr:text-left rtl:text-right text-accent']")
    private WebElement profile;

@FindBy(xpath = "//button[.='Profile']")
    private WebElement myOrders;

@FindBy(xpath = "//button[@class='block w-full py-2.5 px-6 text-sm font-semibold capitalize text-heading transition duration-200 hover:text-accent focus:outline-none ltr:text-left rtl:text-right text-accent']")
    private WebElement myWishlist;

@FindBy(xpath = "//button[@class='block w-full py-2.5 px-6 text-sm font-semibold capitalize text-heading transition duration-200 hover:text-accent focus:outline-none ltr:text-left rtl:text-right text-accent']")
    private WebElement checkout;

@FindBy(xpath = "//button[@class='block w-full py-2.5 px-6 text-sm font-semibold capitalize text-heading transition duration-200 hover:text-accent focus:outline-none ltr:text-left rtl:text-right']")
    private WebElement logout;



public void loginMethod(String mail, String pass){

    getDriver().get(ConfigReader.getProperty("Pb_url"));
    joinButton.click();
    email.sendKeys(mail);
    password.sendKeys(pass);
    loginButton.click();

}



}
