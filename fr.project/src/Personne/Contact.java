package Personne;

public class Contact {

    //Variable de la class Contact
    private String fonction;
    private String mail;
    private String telephone;
    private String LinkeedIn;
    private Personne personne;


    /**
     * Constructeur de la class Contact
     * @param fonction
     * @param mail
     * @param telephone
     * @param linkeedIn
     * @param personne
     */
    public Contact(String fonction, String mail, String telephone, String linkeedIn, Personne personne) {
        this.fonction = fonction;
        this.mail = mail;
        this.telephone = telephone;
        LinkeedIn = linkeedIn;
        this.personne = personne;
    }


    /**
     * Getter and Setter de la class Contact
     * @return
     */
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


    /**
     * ToString de la class Contact
     * @return
     */
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

    /**
     * Fonction permettant l'ajout d'un contact à la BDD
     * @param fonction
     * @param mail
     * @param telephone
     * @param linkeedIn
     * @param personne
     */
    public void ContactAddBDD(String fonction, String mail, String telephone, String linkeedIn, Personne personne){

    }

    // Fonction permettant de supprimer un contact de la BDD
    public void ContactRemoveBDD(String fonction, String mail, String telephone, String linkeedIn, Personne personne){

    }

    // Fonction permettant de modifier les valeurs d'un contact puis les changer sur la BDD
    public void ContactModifBDD(String fonction, String mail, String telephone, String linkeedIn, Personne personne){

    }

}
