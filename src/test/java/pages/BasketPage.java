package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BasketPage {


    public BasketPage() {      PageFactory.initElements(Driver.getDriver(), this);  }

    //-------------------------------BasketPage Locates--------------------------------------------------------------//

    @FindBy(css = "div.flex.font-semibold.text-accent>span")
    private WebElement numberOfItems;
    @FindBy ( css ="div[class='flex-grow pt-16 pb-20']" )
    private WebElement basketPage;
    @FindBy( css = "button[class='flex h-7 w-7 items-center justify-center rounded-full bg-gray-100 text-muted transition-all duration-200 hover:bg-accent hover:text-light focus:bg-accent focus:text-light focus:outline-none ltr:ml-3 ltr:-mr-2 rtl:mr-3 rtl:-ml-2']" )
    private  WebElement closeButton;
    @FindBy(xpath = "//div[@class='flex-shrink-0']//span[text()='plus']")
    private List<WebElement>  incrementItemNumberList;
    @FindBy(xpath = "//div[@class='flex-shrink-0']//span[text()='minus']")
    private List<WebElement> decrementItemNumberList;

}
