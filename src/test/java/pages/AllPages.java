package pages;

public class AllPages {

    private ContactListHomePage contactListHomePage;
    private ContactListPage contactListPage;

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



}
