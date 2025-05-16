package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class GroceryPage {

    public GroceryPage() {
        PageFactory.initElements(getDriver(), this);  }


//***************************************** @FindBy *******************************************************************







//******************************************Getter Methods************************************************************





//**************************************** Class Level Variables And Objects ******************************************
    AllPages allPages = new AllPages();
    Actions actions = new Actions(getDriver());




//************************************ Reusable Methods ***************************************************************

    public boolean isInDropdownMenuUrlContains(String keyword, WebElement dropDownElement, WebElement element){
        Actions actions = new Actions(getDriver());
        actions.click(dropDownElement).perform();
        actions.moveToElement(element).click(element).perform();
        ReusableMethods.waitForUrlContains("grocery");
        String actualUrl = getDriver().getCurrentUrl();
        return actualUrl.contains(keyword);
    }

    public boolean isElementTextEquals(WebElement element, String actualText, String expectedText){
        ReusableMethods.isWebElementDisplayed(element);
        actualText= element.getText();
        return actualText.equals(expectedText);
    }



//***************************************** Test Methods **************************************************************


    public boolean isGroceryClickable(){
        return ReusableMethods.waitForClickability(allPages.pickBazarHomePage().getDropDownMenu());
    }

    public boolean isGroceryLinkContains(){

        return isInDropdownMenuUrlContains("grocery",allPages.pickBazarHomePage()
                .getDropDownMenu(),allPages.pickBazarHomePage()
                .getGroceryOptionInDropDownMenu());
    }

    public boolean isGroceriesDeliveredIn90MinuteVisible(){
        ReusableMethods.isWebElementDisplayed(allPages.pickBazarHomePage().getH1TagText());
        return allPages.pickBazarHomePage().getH1TagText().getText().equals("Groceries Delivered in 90 Minute");

    }

    public boolean isGetYourHealthyFoodsSnacksVisible(){

        return isElementTextEquals(allPages.pickBazarHomePage().getpTagText(),
                allPages.pickBazarHomePage().getpTagText().getText()
                ,"Get your healthy foods & snacks delivered at your doorsteps all day everyday");
    }
































}
