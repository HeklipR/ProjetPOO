package Entreprise;

import jdk.jfr.Timestamp;

import java.sql.SQLException;

public class Entreprise {

    // Variable de la class Entreprise

    private String NomEntrep;
    private String Raison_sociale;
    private String Denomination;
    private String Adresse_du_siege;
    private String Secteurs_d_activite;
    private Timestamp Date_de_creation;
    private String Site_internet;
    private int idEntreprise;

    /**
     * Constructeur de la classe Entreprise
     * @param NomEntrep
     * @param Raison_sociale
     * @param Denomination
     * @param Adresse_du_siege
     * @param Secteurs_d_activite
     * @param Date_de_creation
     * @param Site_internet
     */

    public Entreprise(String NomEntrep, String Raison_sociale, String Denomination, String Adresse_du_siege, String Secteurs_d_activite, Timestamp Date_de_creation, String Site_internet) {
        this.NomEntrep = NomEntrep;
        this.Raison_sociale = Raison_sociale;
        this.Denomination = Denomination;
        this.Adresse_du_siege = Adresse_du_siege;
        this.Secteurs_d_activite = Secteurs_d_activite;
        this.Date_de_creation = Date_de_creation;
        this.Site_internet = Site_internet;
    }

    //Getter et Setter de la class Entreprise

    public String getNomEntrep() {
        return NomEntrep;
    }

    public void setNomEntrep(String NomEntrep) {
        this.NomEntrep = NomEntrep;
    }

    public String getRaison_sociale() {
        return Raison_sociale;
    }

    public void setRaison_sociale(String Raison_sociale) {
        this.Raison_sociale = Raison_sociale;
    }

    public String getDenomination() {
        return Denomination;
    }

    public void setDenomination(String Denomination) {
        this.Denomination = Denomination;
    }

    public String getAdresse_du_siege() {
        return Adresse_du_siege;
    }

    public void setAdresse_du_siege(String Adresse_du_siege) {
        this.Adresse_du_siege = Adresse_du_siege;
    }

    public String getSecteurs_d_activite() {
        return Secteurs_d_activite;
    }

    public void setSecteurs_d_activite(String Secteurs_d_activite) {
        this.Secteurs_d_activite = Secteurs_d_activite;
    }

    public Timestamp getDate_de_creation() {
        return Date_de_creation;
    }

    public void setDate_de_creation(Timestamp Date_de_creation) {
        this.Date_de_creation = Date_de_creation;
    }

    public String getSite_internet() {
        return Site_internet;
    }

    public void setSite_internet(String Site_internet) {
        this.Site_internet = Site_internet;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    // To String de la classe Entreprise
    @Override
    public String toString() {
        return "Entreprise{" +
                "NomEntrep='" + NomEntrep + '\'' +
                ", Raison_sociale='" + Raison_sociale + '\'' +
                ", Denomination='" + Denomination + '\'' +
                ", Adresse_du_siege='" + Adresse_du_siege + '\'' +
                ", Secteurs_d_activite='" + Secteurs_d_activite + '\'' +
                ", Date_de_creation=" + Date_de_creation +
                ", Site_internet='" + Site_internet + '\'' +
                '}';
    }




    /**
     * Fonction permettant l'ajout d'une entreprise à la BDD
     * @param NomEntrep
     * @param Raison_sociale
     * @param Denomination
     * @param Adresse_du_siege
     * @param Secteurs_d_activite
     * @param Date_de_creation
     * @param Site_internet
     * @throws SQLException
     */
    public void EntrepriseAddBDD(String NomEntrep, String Raison_sociale, String Denomination, String Adresse_du_siege, String Secteurs_d_activite, Timestamp Date_de_creation, String Site_internet) throws SQLException {

    }


    /**
     * Fonction permettant de supprimer une entreprise de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void EntrepriseRemoveBDD(int ligne) throws SQLException {

    }


    /**
     * Fonction permettant de modifier les valeurs d'une entreprise puis les changer sur la BDD
     * @param NomEntrep
     * @param Raison_sociale
     * @param Denomination
     * @param Adresse_du_siege
     * @param Secteurs_d_activite
     * @param Date_de_creation
     * @param Site_internet
     * @throws SQLException
     */
    public void EntrepriseModifBDD(String NomEntrep, String Raison_sociale, String Denomination, String Adresse_du_siege, String Secteurs_d_activite, Timestamp Date_de_creation, String Site_internet) throws SQLException {

    }

}
