package FXML;

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
    public Specialite(int idSpecialite, String technologie) {
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



}
