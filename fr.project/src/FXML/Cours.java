package FXML;

import java.sql.SQLException;

public class Cours {

    //Variable de la class Cours
    private int idCours;
    private String matiere;
    private String filiere;
    private int annee;



    public Cours(int idCours, String matiere, String filiere, int annee) {
        this.idCours = idCours;
        this.matiere = matiere;
        this.filiere = filiere;
        this.annee = annee;
    }

    //Getter and Setter de la class Cours
    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }


    @Override
    public String toString() {
        return "Cours{" +
                "idCours=" + idCours +
                ", matiere='" + matiere + '\'' +
                ", filiere='" + filiere + '\'' +
                ", annee=" + annee +
                '}';
    }

    /**
     * Fonction permettant l'ajout d'un cours à la BDD
     * @param matiere
     * @param filliere
     * @param annee
     * @throws SQLException
     */
    public void CoursAddBDD(String matiere, String filliere, int annee, Personne personne) throws SQLException {

    }



    /**
     * Fonction permettant de supprimer un cours de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void CoursRemoveBDD(int ligne) throws SQLException{

    }

    /**
     * Fonction permettant de modifier les valeurs d'un cours puis les changer sur la BDD
     * @param matiere
     * @param filliere
     * @param annee
     * @param personne
     * @throws SQLException
     */
    public void CoursModifBDD(String matiere, String filliere, int annee, Personne personne) throws SQLException {

    }

}
