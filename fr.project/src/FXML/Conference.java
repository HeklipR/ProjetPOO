package FXML;




import java.sql.SQLException;

public class Conference {

    // Variable de la class Conférence
    private int idConference;
    private String date;
    private String theme;
    private int publique;
    private String duree;



    /**
     * Constructeur de la classe Conférence
     * @param idConference
     * @param date
     * @param theme
     * @param publique
     * @param duree
     */
    public Conference(int idConference, String date, String theme, int publique, String duree) {
        this.idConference = idConference;
        this.date = date;
        this.theme = theme;
        this.publique = publique;
        this.duree = duree;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getPublique() {
        return publique;
    }

    public void setPublique(int publique) {
        this.publique = publique;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
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
                ", nombrePublique=" + publique +
                ", duree=" + duree +
                '}';
    }


}
