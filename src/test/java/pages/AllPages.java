package pages;


import org.apache.logging.log4j.Logger;

public class AllPages {

    private ContactListHomePage contactListHomePage;
    private ContactListPage contactListPage;
    private HomePage pickBazarHomePage;
    private BasketPage basketPage;
    private  MakeUpPage makeUpPage;
    private CheckoutPage checkoutPage;
    private Logger logger;

    //-------------------------------------------------



    //
    public ContactListHomePage contactListHomePage() {
        if (contactListHomePage == null) {
            contactListHomePage = new ContactListHomePage();
        }
        return contactListHomePage;
    }




    public ContactListPage contactListPage() {
        if (contactListPage == null) {
            contactListPage = new ContactListPage();
        }
        return contactListPage;
    }


    public HomePage pickBazarHomePage(){
        if(pickBazarHomePage == null){
            pickBazarHomePage=new HomePage();
        }
        return pickBazarHomePage;
    }

    public BasketPage basketPage(){
        if(basketPage == null){
            basketPage = new BasketPage();
        }
        return basketPage;
    }

    public CheckoutPage checkoutPage(){
        if(checkoutPage == null){
            checkoutPage = new CheckoutPage();
        }
        return checkoutPage;
    }

    public MakeUpPage makeUpPage(){
        if (makeUpPage == null){
            makeUpPage =new MakeUpPage();
        }
        return makeUpPage;
    }

}
