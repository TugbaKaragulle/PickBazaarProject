package pages;


import org.apache.logging.log4j.Logger;

public class AllPages {

    private ContactListHomePage contactListHomePage;
    private ContactListPage contactListPage;
    private HomePage pickBazarHomePage;
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



}
