package Entreprise;

import jdk.jfr.Timestamp;

import java.sql.SQLException;

public class Succursales {


    // Variable de la class Succursales
    private int idSuccursale;
    private int idEntreprise;
    private String nomSucc;
    private Timestamp dateCreation;
    private String lieu;
    private String siteInternet;
    private Entreprise entreprise;


    // Constructeur de la class Succursales

    /**
     * Constructeur de la class Succursales
     * @param idSuccursale
     * @param idEntreprise
     * @param nomSucc
     * @param dateCreation
     * @param lieu
     * @param siteInternet
     * @param entreprise
     */
    public Succursales(String nomSucc, Timestamp dateCreation, String lieu, String siteInternet, Entreprise entreprise, int idSuccursale, int idEntreprise) {
        this.idSuccursale = idSuccursale;
        this.idEntreprise = idEntreprise;
        this.nomSucc = nomSucc;
        this.dateCreation = dateCreation;
        this.lieu = lieu;
        this.siteInternet = siteInternet;
        this.entreprise = entreprise;
    }

    // Getter and Setter de la class Succursales
    public String getNomSucc() {
        return nomSucc;
    }

    public void setNomSucc(String nomSucc) {
        this.nomSucc = nomSucc;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
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
                "nomSucc='" + nomSucc + '\'' +
                ", dateCreation=" + dateCreation +
                ", lieu='" + lieu + '\'' +
                ", siteInternet='" + siteInternet + '\'' +
                ", entreprise=" + entreprise +
                '}';
    }

    // Fonction permettant l'ajout d'une Succursale à la BDD

    /**
     * Fonction permettant l'ajout d'une Succursale à la BDD
     * @param nomSucc
     * @param dateCreation
     * @param lieu
     * @param siteInternet
     * @param entreprise
     * @throws SQLException
     */
    public void SuccursalesAddBDD(String nomSucc, Timestamp dateCreation, String lieu, String siteInternet, Entreprise entreprise) throws SQLException {

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
     * @param nomSucc
     * @param dateCreation
     * @param lieu
     * @param siteInternet
     * @param entreprise
     * @throws SQLException
     */
    public void SuccursalesModifBDD(String nomSucc, Timestamp dateCreation, String lieu, String siteInternet, Entreprise entreprise) throws SQLException {

    }

}
