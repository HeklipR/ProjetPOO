package FXML;

import java.sql.SQLException;

public class Contact {

    //Variable de la class Contact
    private int idContact;
    private String fonction;
    private String mail;
    private String telephone;
    private String LinkeedIn;
    private int idPersonne;


    /**
     * Constructeur de la class Contact
     *
     * @param fonction
     * @param mail
     * @param telephone
     * @param LinkeedIn
     * @param idPersonne
     */
    public Contact(int idContact, String fonction, String mail, String telephone, String LinkeedIn, int idPersonne) {
        this.idContact = idContact;
        this.fonction = fonction;
        this.mail = mail;
        this.telephone = telephone;
        this.LinkeedIn = LinkeedIn;
        this.idPersonne = idPersonne;

    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
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

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLinkeedIn() {
        return LinkeedIn;
    }

    public void setLinkeedIn(String linkeedIn) {
        linkeedIn = linkeedIn;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "fonction='" + fonction + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", LinkeedIn='" + LinkeedIn + '\'' +
                ", personne=" + idPersonne +
                '}';
    }
}



