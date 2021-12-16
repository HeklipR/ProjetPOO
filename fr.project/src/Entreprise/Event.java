package Entreprise;

import java.sql.SQLException;

public class Event {


    //Variable de la class Event
    private String type;
    private String lieu;
    private boolean presence;
    private Entreprise entreprise;



    /**
     * Constructeur de la class Event
     * @param type
     * @param lieu
     * @param presence
     * @param entreprise
     */
    public Event(String type, String lieu, boolean presence, Entreprise entreprise) {
        this.type = type;
        this.lieu = lieu;
        this.presence = presence;
        this.entreprise = entreprise;
    }

    //Getter and Setter de la class Event
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }



    // ToString de la class Event
    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", lieu='" + lieu + '\'' +
                ", presence=" + presence +
                ", entreprise=" + entreprise +
                '}';
    }

    // Fonction permettant l'ajout d'un Event à la BDD

    /**
     * Fonction permettant l'ajout d'un Event à la BDD
     * @param type
     * @param lieu
     * @param presence
     * @param entreprise
     * @throws SQLException
     */
    public void EventAddBDD(String type, String lieu, boolean presence, Entreprise entreprise) throws SQLException {

    }
    // Fonction permettant de supprimer un Event de la BDD

    /**
     * Fonction permettant de supprimer un Event de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void EventRemoveBDD(int ligne) throws SQLException {

    }
    // Fonction permettant de modifier les valeurs d'un Event puis les changer sur la BDD

    /**
     * Fonction permettant de modifier les valeurs d'un Event puis les changer sur la BDD
     * @param type
     * @param lieu
     * @param presence
     * @param entreprise
     * @throws SQLException
     */
    public void EventModifBDD(String type, String lieu, boolean presence, Entreprise entreprise) throws SQLException {

    }
}
