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
    private ShopsPage shopsPage;
    private OffersPage offersPage;
    private  FaqPage faqPage;
    private ContactPage contactPage;
    private HomePageProfile homePageProfile;
    private BagsPage bagsPage;
    private FurniturePage furniturePage;
    private OrderStatusPage orderStatusPage;
    private ClothingPage clothingPage;
    private CustomerLoginPage customerLoginPage;
    private DailyNeedsPage dailyNeedsPage;
    private GroceryPage groceryPage;
    private LoginProfilePage loginProfilePage;
    private BooksPage booksPage;
    private LoginPage loginPage;


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
            pickBazarHomePage =new HomePage();
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

    public ShopsPage shopsPage(){
        if (shopsPage == null){
            shopsPage =new ShopsPage();
        }
        return shopsPage;
    }

    public OffersPage offersPage(){
        if (offersPage == null){
            offersPage =new OffersPage();
        }
        return offersPage;
    }

    public FaqPage faqPage(){
        if (faqPage == null){
            faqPage =new FaqPage();
        }
        return faqPage;
    }

    public ContactPage contactPage(){
        if (contactPage == null){
            contactPage =new ContactPage();
        }
        return contactPage;
    }

    public HomePageProfile homePageProfile(){
        if (homePageProfile == null){
            homePageProfile =new HomePageProfile();
        }
        return homePageProfile;
    }

    public BagsPage bagsPage(){
        if (bagsPage == null){
            bagsPage =new BagsPage();
        }
        return bagsPage;
    }

    public FurniturePage furniturePage(){
        if (furniturePage == null){
            furniturePage =new FurniturePage();
        }
        return furniturePage;
    }

    public OrderStatusPage orderStatusPage(){
        if (orderStatusPage == null){
            orderStatusPage =new OrderStatusPage();
        }
        return orderStatusPage;
    }

    public ClothingPage clothingPage(){
        if (clothingPage == null){
            clothingPage =new ClothingPage();
        }
        return clothingPage;
    }

    public CustomerLoginPage customerLoginPage(){
        if (customerLoginPage == null){
            customerLoginPage =new CustomerLoginPage();
        }
        return customerLoginPage;
    }

    public DailyNeedsPage dailyNeedsPage(){
        if (dailyNeedsPage == null){
            dailyNeedsPage =new DailyNeedsPage();
        }
        return dailyNeedsPage;
    }

    public GroceryPage groceryPage(){
        if (groceryPage == null){
            groceryPage =new GroceryPage();
        }
        return groceryPage;
    }

    public LoginProfilePage loginProfilePage(){
        if (loginProfilePage == null){
            loginProfilePage =new LoginProfilePage();
        }
        return loginProfilePage;
    }



    public BooksPage booksPage(){
        if (booksPage == null){
            booksPage =new BooksPage();
        }
        return booksPage;
    }

    public LoginPage loginPage(){
        if (loginPage == null){
            loginPage =new LoginPage();
        }
        return loginPage;

    }

}
