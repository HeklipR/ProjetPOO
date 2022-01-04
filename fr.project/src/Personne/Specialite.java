package Personne;

import java.sql.SQLException;

public class Specialite {

    //Variable de la class Specialite
    private int idSpecialite;
    private String Technologie;


    /**
     * Constructeur de la class Specialite
     * @param idSpecialite
     * @param technologie
     */
    public Specialite(String technologie, int idSpecialite) {
        this.idSpecialite = idSpecialite;
        Technologie = technologie;
    }

    //Getter and Setter de la class Specialite
    public String getTechnologie() {
        return Technologie;
    }

    public void setTechnologie(String technologie) {
        Technologie = technologie;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    //ToString de la class

    @Override
    public String toString() {
        return "Specialite{" +
                "idSpecialite=" + idSpecialite +
                ", Technologie='" + Technologie + '\'' +
                '}';
    }


    // Fonction permettant l'ajout d'une Specialite à la BDD

    /**
     * Fonction permettant l'ajout d'une Specialite à la BDD
     * @param technologie
     * @throws SQLException
     */
    public void SpecialiteAddBDD(String technologie) throws SQLException{

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
     * @throws SQLException
     */
    public void SpecialiteModifBDD(String technologie) throws SQLException {

    }

}
