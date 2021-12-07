package Entreprise;

import jdk.jfr.Timestamp;

public class Succursales {


    // Variable de la class Succursales
    private String nomSucc;
    private Timestamp dateCreation;
    private String lieu;
    private String siteInternet;
    private Entreprise entreprise;


    // Constructeur de la class Succursales
    public Succursales(String nomSucc, Timestamp dateCreation, String lieu, String siteInternet, Entreprise entreprise) {
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
    public void SuccursalesAddBDD(){

    }

    // Fonction permettant de supprimer une Succursale de la BDD
    public void SuccursalesRemoveBDD(){

    }

    // Fonction permettant de modifier les valeurs d'une Succursale puis les changer sur la BDD
    public void SuccursalesModifBDD(){

    }

}
