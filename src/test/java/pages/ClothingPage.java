package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ClothingPage {

    public ClothingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h1")
    public WebElement clothingHeader;


    @FindBy(xpath = "//p[text()='Ready to wear dresses tailored for you online. Hurry up while stock lasts.']")
    public WebElement clothingSubHeader;


    @FindBy(id = "search")
    public WebElement clothingSearchField;


    @FindBy(xpath = "//button[text()='Search']")
    public WebElement clothingSearchButton;


    @FindBy(xpath = "//h3[text()='Mango Self Striped A Line Dress']")
    public WebElement clothingProductInfo;

    @FindBy(xpath = "(//div[@class='swiper-wrapper'])[2]//div")
    public List<WebElement> swiperList;

    @FindBy(xpath = "//li[@class='rounded-md py-1']//button//span[2]")
    public List<WebElement> clothTypeList;






    public void searchFieldSendKey(String Searchkey) {
        clothingSearchField.sendKeys(Searchkey);

    }

    public boolean productControl(String Key) {

        boolean flag = false;

        if (clothingProductInfo.getText().contains(Key)) {
            flag = true;

        }
        return flag;
    }

    public void searchButtonClick() {
        ReusableMethods.clickElement(clothingSearchButton);
    }

    public boolean isClothingHeaderDisplayed() {
        boolean flag = false;

        if (clothingHeader.isDisplayed()) {
            flag = true;

        }
        return flag;
    }

    public boolean isClothingSubHeaderDisplayed() {
        boolean flag = false;

        if (clothingSubHeader.isDisplayed()) {
            flag = true;

        }
        return flag;

    }

    public boolean swiperListControl() {

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (swiperList.get(i).isDisplayed()) {
                count += 1;

            }


        }
        if (count == 3) {
            return true;
        } else {
            return false;

        }


    }

    public boolean clothTypeListControl(String text) {


        boolean flag = false;
        for (int i = 0; i < 6; i++) {
            if (clothTypeList.get(i).getText().equals(text)) {
                System.out.println("clothTypeList.get(i).getText() = " + clothTypeList.get(i).getText());
                flag = true;
                break;
            }


        }

        return flag;
    }









}
