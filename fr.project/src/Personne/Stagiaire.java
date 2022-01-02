package Personne;

import jdk.jfr.Timestamp;

import java.sql.SQLException;

public class Stagiaire {


    //Variable de la class Stagiaire
    private String niveauEtude;
    private Timestamp annee;
    private Timestamp duree;
    private Personne personne;


    //Getter and Setter de la class Stagiaire
    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public Timestamp getAnnee() {
        return annee;
    }

    public void setAnnee(Timestamp annee) {
        this.annee = annee;
    }

    public Timestamp getDuree() {
        return duree;
    }

    public void setDuree(Timestamp duree) {
        this.duree = duree;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    //ToString de la class Stagiaire
    @Override
    public String
    toString() {
        return "Stagiaire{" +
                "niveauEtude='" + niveauEtude + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", personne=" + personne +
                '}';
    }


    /**
     * Constructeur de la class Stagiaire
     * @param niveauEtude
     * @param annee
     * @param duree
     * @param personne
     */
    public Stagiaire(String niveauEtude, Timestamp annee, Timestamp duree, Personne personne) {
        this.niveauEtude = niveauEtude;
        this.annee = annee;
        this.duree = duree;
        this.personne = personne;

    }
    // Fonction permettant l'ajout d'un Stagiaire à la BDD

    /**
     * Fonction permettant l'ajout d'un Stagiaire à la BDD
     * @param niveauEtude
     * @param annee
     * @param duree
     * @param personne
     * @throws SQLException
     */
    public void StagiaireAddBDD(String niveauEtude, Timestamp annee, Timestamp duree, Personne personne) throws SQLException{

    }
    // Fonction permettant de supprimer un Stagiaire de la BDD

    /**
     * Fonction permettant de supprimer un Stagiaire de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void StagiaireRemoveBDD(int ligne) throws SQLException{

    }

    // Fonction permettant de modifier les valeurs d'un Stagiaire puis les changer sur la BDD

    /**
     * Fonction permettant de modifier les valeurs d'un Stagiaire puis les changer sur la BDD
     * @param niveauEtude
     * @param annee
     * @param duree
     * @param personne
     * @throws SQLException
     */
    public void StagiaireModifBDD(String niveauEtude, Timestamp annee, Timestamp duree, Personne personne) throws SQLException {

    }

}
