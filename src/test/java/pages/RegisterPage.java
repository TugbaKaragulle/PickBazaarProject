package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Register']")
    public WebElement registerLink;

    @FindBy(xpath = "//p[text()='You must need to provide your name']")
    public WebElement nameFieldMissingMessage;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameField;


}
