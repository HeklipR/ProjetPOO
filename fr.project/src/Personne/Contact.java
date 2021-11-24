package Personne;

public class Contact {

    private String fonction;
    private String mail;
    private String telephone;
    private String LinkeedIn;
    private Personne personne;

    public Contact(String fonction, String mail, String telephone, String linkeedIn, Personne personne) {
        this.fonction = fonction;
        this.mail = mail;
        this.telephone = telephone;
        LinkeedIn = linkeedIn;
        this.personne = personne;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLinkeedIn() {
        return LinkeedIn;
    }

    public void setLinkeedIn(String linkeedIn) {
        LinkeedIn = linkeedIn;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fonction='" + fonction + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", LinkeedIn='" + LinkeedIn + '\'' +
                ", personne=" + personne +
                '}';
    }

    public void ContactAddBDD(){

    }

    public void ContactRemoveBDD(){

    }

    public void ContactModifBDD(){

    }

}
