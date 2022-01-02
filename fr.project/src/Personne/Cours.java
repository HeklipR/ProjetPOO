package Personne;

import java.sql.SQLException;

public class Cours {

    //Variable de la class Cours
    private int idCours;
    private String matiere;
    private String filliere;
    private int annee;
    private Personne personne;



    public Cours(String matiere, String filliere, int annee, Personne personne, int idCours) {
        this.idCours = idCours;
        this.matiere = matiere;
        this.filliere = filliere;
        this.annee = annee;
        this.personne = personne;
    }

    //Getter and Setter de la class Cours
    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getFilliere() {
        return filliere;
    }

    public void setFilliere(String filliere) {
        this.filliere = filliere;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
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
                "matiere='" + matiere + '\'' +
                ", filliere='" + filliere + '\'' +
                ", annee=" + annee +
                ", personne=" + personne +
                '}';
    }


    /**
     * Fonction permettant l'ajout d'un cours à la BDD
     * @param matiere
     * @param filliere
     * @param annee
     * @param personne
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
