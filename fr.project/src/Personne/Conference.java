package Personne;


import jdk.jfr.Timestamp;

import java.sql.SQLException;

public class Conference {

    // Variable de la class Conférence
    private int idConference;
    private Timestamp date;
    private String theme;
    private int nombrePublique;
    private Timestamp duree;



    /**
     * Constructeur de la classe Conférence
     * @param idConference
     * @param date
     * @param theme
     * @param nombrePublique
     * @param duree
     */
    public Conference(Timestamp date, String theme, int nombrePublique, Timestamp duree, int idConference) {
        this.idConference = idConference;
        this.date = date;
        this.theme = theme;
        this.nombrePublique = nombrePublique;
        this.duree = duree;
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getNombrePublique() {
        return nombrePublique;
    }

    public void setNombrePublique(int nombrePublique) {
        this.nombrePublique = nombrePublique;
    }

    public Timestamp getDuree() {
        return duree;
    }

    public void setDuree(Timestamp duree) {
        this.duree = duree;
    }

    public int getIdConference() {
        return idConference;
    }

    public void setIdConference(int idConference) {
        this.idConference = idConference;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "idConference=" + idConference +
                ", date=" + date +
                ", theme='" + theme + '\'' +
                ", nombrePublique=" + nombrePublique +
                ", duree=" + duree +
                '}';
    }


    /**
     * Fonction permettant l'ajout d'une conférence à la BDD
     * @param date
     * @param theme
     * @param nombrePublique
     * @param duree
     * @param personne
     * @throws SQLException
     */
    public void ConferenceAddBDD(Timestamp date, String theme, int nombrePublique, Timestamp duree, Personne personne) throws SQLException {

    }

    /**
     * Fonction permettant de supprimer une conférence de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void ConferenceRemoveBDD(int ligne) throws SQLException{

    }

    /**
     * Fonction permettant de modifier les valeurs d'une conférence puis les changer sur la BDD
     * @param date
     * @param theme
     * @param nombrePublique
     * @param duree
     * @param personne
     * @throws SQLException
     */
    public void ConferenceModifBDD(Timestamp date, String theme, int nombrePublique, Timestamp duree, Personne personne) throws SQLException{

    }

}
