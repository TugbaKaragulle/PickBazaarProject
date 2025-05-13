package pages;


import org.apache.logging.log4j.Logger;

public class AllPages {

    private ContactListHomePage contactListHomePage;
    private ContactListPage contactListPage;
    private PickBazarHomePage pickBazarHomePage;
    private Logger logger;

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

    public PickBazarHomePage pickBazarHomePage(){
        if(pickBazarHomePage == null){
            pickBazarHomePage=new PickBazarHomePage();
        }
        return pickBazarHomePage;
    }



}
