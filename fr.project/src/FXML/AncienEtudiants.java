package FXML;


import java.sql.SQLException;

public class AncienEtudiants {


    // Variable de la classe AncienEtudiants

    private int idAncienEtudiant;
    private String Niveau_etudes;
    private String Annee;
    private String Type_de_contrat_de_travail;
    private String Duree;
    private String Nom;
    private int idPersonne;

    /**
     * @param idPersonne
     * @param idAncienEtudiant
     * @param Niveau_etudes
     * @param Annee
     * @param Type_de_contrat_de_travail
     * @param Duree
     * @param Nom
     */

    public AncienEtudiants(int idAncienEtudiant, String Niveau_etudes, String Annee, String Type_de_contrat_de_travail, String Duree, String Nom, int idPersonne) {
        this.idAncienEtudiant = idAncienEtudiant;
        this.Niveau_etudes = Niveau_etudes;
        this.Annee = Annee;
        this.Type_de_contrat_de_travail = Type_de_contrat_de_travail;
        this.Duree = Duree;
        this.Nom = Nom;
        this.idPersonne = idPersonne;
    }


    public int getIdAncienEtudiant() {
        return idAncienEtudiant;
    }

    public void setIdAncienEtudiant(int idAncienEtudiant) {
        this.idAncienEtudiant = idAncienEtudiant;
    }

    public String getNiveau_etudes() {
        return Niveau_etudes;
    }

    public void setNiveau_etudes(String Niveau_etudes) {
        this.Niveau_etudes = Niveau_etudes;
    }

    public String getAnnee() {
        return Annee;
    }

    public void setAnnee(String Annee) {
        this.Annee = Annee;
    }

    public String getType_de_contrat_de_travail() {
        return Type_de_contrat_de_travail;
    }

    public void setType_de_contrat_de_travail(String Type_de_contrat_de_travail) {
        this.Type_de_contrat_de_travail = Type_de_contrat_de_travail;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String Duree) {
        this.Duree = Duree;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public String toString() {
        return "AncienEtudiants{" +
                "idAncienEtudiant=" + idAncienEtudiant +
                ", Niveau_etudes='" + Niveau_etudes + '\'' +
                ", Annee='" + Annee + '\'' +
                ", Type_de_contrat_de_travail='" + Type_de_contrat_de_travail + '\'' +
                ", Duree='" + Duree + '\'' +
                ", Nom='" + Nom + '\'' +
                ", idPersonne=" + idPersonne +
                '}';
    }

    /**
     * Fonction permettant l'ajout d'un Ancien Etudiant à la BDD
     * @param niveauEtude
     * @param annee
     * @param typeDeContrat
     * @param duree
     * @param personne
     * @throws SQLException
     */


    /**
     * Fonction permettant de supprimer un Ancien Etudiant de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void AncienEtudiantsRemoveBDD(int ligne) throws SQLException{

    }

    /**
     * Fonction permettant de modifier les valeurs d'un Ancien Etudiant puis les changer sur la BDD
     * @param niveauEtude
     * @param annee
     * @param typeDeContrat
     * @param duree
     * @param personne
     * @throws SQLException
     */


}
