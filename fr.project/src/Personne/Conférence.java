package Personne;


import jdk.jfr.Timestamp;

public class Conférence {

    private Timestamp date;
    private String theme;
    private int nombrePublique;
    private Timestamp duree;
    private Personne personne;


    public Conférence(Timestamp date, String theme, int nombrePublique, Timestamp duree, Personne personne) {
        this.date = date;
        this.theme = theme;
        this.nombrePublique = nombrePublique;
        this.duree = duree;
        this.personne = personne;
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

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "Conférence{" +
                "date=" + date +
                ", theme='" + theme + '\'' +
                ", nombrePublique=" + nombrePublique +
                ", duree=" + duree +
                ", personne=" + personne +
                '}';
    }


    public void ConferenceAddBDD(){

    }

    public void ConferenceRemoveBDD(){

    }

    public void ConferenceModifBDD(){

    }

}
