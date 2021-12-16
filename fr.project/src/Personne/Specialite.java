package Personne;

import java.sql.SQLException;

public class Specialite {

    //Variable de la class Specialite
    private String Technologie;
    private Personne personne;


    /**
     * Constructeur de la class Specialite
     * @param technologie
     * @param personne
     */
    public Specialite(String technologie, Personne personne) {
        Technologie = technologie;
        this.personne = personne;
    }

    //Getter and Setter de la class Specialite
    public String getTechnologie() {
        return Technologie;
    }

    public void setTechnologie(String technologie) {
        Technologie = technologie;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    //ToString de la class
    @Override
    public String toString() {
        return "Specialite{" +
                "Technologie='" + Technologie + '\'' +
                ", personne=" + personne +
                '}';
    }

    // Fonction permettant l'ajout d'une Specialite à la BDD

    /**
     * Fonction permettant l'ajout d'une Specialite à la BDD
     * @param technologie
     * @param personne
     * @throws SQLException
     */
    public void SpecialiteAddBDD(String technologie, Personne personne) throws SQLException{

    }

    // Fonction permettant de supprimer une Specialite de la BDD

    /**
     * Fonction permettant de supprimer une Specialite de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void SpecialiteRemoveBDD(int ligne) throws SQLException{

    }

    // Fonction permettant de modifier les valeurs d'une Specialite puis les changer sur la BDD

    /**
     * Fonction permettant de modifier les valeurs d'une Specialite puis les changer sur la BDD
     * @param technologie
     * @param personne
     * @throws SQLException
     */
    public void SpecialiteModifBDD(String technologie, Personne personne) throws SQLException {

    }

}
