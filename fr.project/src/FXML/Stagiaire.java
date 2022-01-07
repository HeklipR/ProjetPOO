package FXML;



import java.sql.SQLException;

public class Stagiaire {


    //Variable de la class Stagiaire
    private int idStagiaire;
    private String Niveau_etudes;
    private String annee;
    private String Duree;
    private String Nom;
    private int idPersonne;


    //Getter and Setter de la class Stagiaire


    public int getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    public String getNiveau_etudes() {
        return Niveau_etudes;
    }

    public void setNiveau_etudes(String Niveau_etudes) {
        this.Niveau_etudes = Niveau_etudes;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String duree) {
        this.Duree = duree;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    //ToString de la class Stagiaire


    @Override
    public String toString() {
        return "Stagiaire{" +
                "idStagiaire=" + idStagiaire +
                ", niveauEtude='" + Niveau_etudes + '\'' +
                ", annee=" + annee +
                ", duree=" + Duree +
                ", nom='" + Nom + '\'' +
                ", idPersonne=" + idPersonne +
                '}';
    }

    /**
     * Constructeur de la class Stagiaire
     * @param idPersonne
     * @param idStagiaire
     * @param Niveau_etudes
     * @param annee
     * @param Duree
     * @param Nom
     */
    public Stagiaire(int idStagiaire, String Niveau_etudes, String annee, String Duree,  String Nom ,int idPersonne) {
        this.idPersonne = idPersonne;
        this.idStagiaire = idStagiaire;
        this.Niveau_etudes = Niveau_etudes;
        this.annee = annee;
        this.Duree = Duree;
        this.Nom = Nom;

    }



}
