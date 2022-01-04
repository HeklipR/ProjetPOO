package Entreprise;

import jdk.jfr.Timestamp;

import java.sql.SQLException;

public class Succursales {


    // Variable de la class Succursales
    private int idSuccursale;
    private int idEntreprise;
    private String NomSucc;
    private Timestamp Date_de_creation;
    private String Lieu;
    private String Site_internet;
    private Entreprise entreprise;


    // Constructeur de la class Succursales

    /**
     * Constructeur de la class Succursales
     * @param idSuccursale
     * @param idEntreprise
     * @param NomSucc
     * @param Date_de_creation
     * @param Lieu
     * @param Site_internet
     * @param entreprise
     */
    public Succursales(String NomSucc, Timestamp Date_de_creation, String Lieu, String Site_internet, Entreprise entreprise, int idSuccursale, int idEntreprise) {
        this.idSuccursale = idSuccursale;
        this.idEntreprise = idEntreprise;
        this.NomSucc = NomSucc;
        this.Date_de_creation = Date_de_creation;
        this.Lieu = Lieu;
        this.Site_internet = Site_internet;
        this.entreprise = entreprise;
    }

    // Getter and Setter de la class Succursales
    public String getNomSucc() {
        return NomSucc;
    }

    public void setNomSucc(String NomSucc) {
        this.NomSucc = NomSucc;
    }

    public Timestamp getDate_de_creation() {
        return Date_de_creation;
    }

    public void setDate_de_creation(Timestamp Date_de_creation) {
        this.Date_de_creation = Date_de_creation;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public String getSite_internet() {
        return Site_internet;
    }

    public void setSite_internet(String Site_internet) {
        this.Site_internet = Site_internet;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public int getIdSuccursale() {
        return idSuccursale;
    }

    public void setIdSuccursale(int idSuccursale) {
        this.idSuccursale = idSuccursale;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }



    // ToString de la class Succursales
    @Override
    public String toString() {
        return "Succursales{" +
                "NomSucc='" + NomSucc + '\'' +
                ", Date_de_creation=" + Date_de_creation +
                ", Lieu='" + Lieu + '\'' +
                ", Site_internet='" + Site_internet + '\'' +
                ", entreprise=" + entreprise +
                '}';
    }

    // Fonction permettant l'ajout d'une Succursale à la BDD

    /**
     * Fonction permettant l'ajout d'une Succursale à la BDD
     * @param NomSucc
     * @param Date_de_creation
     * @param Lieu
     * @param Site_internet
     * @param entreprise
     * @throws SQLException
     */
    public void SuccursalesAddBDD(String NomSucc, Timestamp Date_de_creation, String Lieu, String Site_internet, Entreprise entreprise) throws SQLException {

    }

    // Fonction permettant de supprimer une Succursale de la BDD

    /**
     * Fonction permettant de supprimer une Succursale de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void SuccursalesRemoveBDD(int ligne) throws SQLException {

    }

    // Fonction permettant de modifier les valeurs d'une Succursale puis les changer sur la BDD

    /**
     * Fonction permettant de modifier les valeurs d'une Succursale puis les changer sur la BDD
     * @param NomSucc
     * @param Date_de_creation
     * @param Lieu
     * @param Site_internet
     * @param entreprise
     * @throws SQLException
     */
    public void SuccursalesModifBDD(String NomSucc, Timestamp Date_de_creation, String Lieu, String Site_internet, Entreprise entreprise) throws SQLException {

    }

}
