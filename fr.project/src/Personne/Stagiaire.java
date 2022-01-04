package Personne;



import java.sql.SQLException;

public class Stagiaire {


    //Variable de la class Stagiaire
    private int idStagiaire;
    private String Niveau_etudes;
    private String annee;
    private String duree;
    private String nom;
    private int idPersonne;


    //Getter and Setter de la class Stagiaire


    public int getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(int idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    public String getNiveauEtude() {
        return Niveau_etudes;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.Niveau_etudes = niveauEtude;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
                ", duree=" + duree +
                ", nom='" + nom + '\'' +
                ", idPersonne=" + idPersonne +
                '}';
    }

    /**
     * Constructeur de la class Stagiaire
     * @param idPersonne
     * @param idStagiaire
     * @param niveauEtude
     * @param annee
     * @param duree
     */
    public Stagiaire(String niveauEtude, String annee, String duree, int idStagiaire, int idPersonne) {
        this.idPersonne = idPersonne;
        this.idStagiaire = idStagiaire;
        this.Niveau_etudes = niveauEtude;
        this.annee = annee;
        this.duree = duree;

    }
    // Fonction permettant l'ajout d'un Stagiaire à la BDD

    /**
     * Fonction permettant l'ajout d'un Stagiaire à la BDD
     * @param niveauEtude
     * @param annee
     * @param duree
     * @throws SQLException
     */
    public void StagiaireAddBDD(String niveauEtude, String annee, String duree) throws SQLException{

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
     * @throws SQLException
     */
    public void StagiaireModifBDD(String niveauEtude, String annee, String duree) throws SQLException {

    }

}
