package FXML;

import java.sql.SQLException;

public class Event {


    //Variable de la class Event
    private int idEvent;
    private String Type;
    private String Lieu;
    private String Presence;
    



    /**
     * Constructeur de la class Event
     * @param Type
     * @param Lieu
     * @param Presence

     */
    public Event(int idEvent , String Type, String Lieu, String Presence ) {
        this.idEvent = idEvent ;
        this.Type = Type;
        this.Lieu = Lieu;
        this.Presence = Presence;

    }

    //Getter and Setter de la class Event
    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public String getPresence() {
        return Presence;
    }

    public void setPresence(String Presence) {
        this.Presence = Presence;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }



    // ToString de la class Event

    @Override
    public String toString() {
        return "Event{" +
                "idEvent=" + idEvent +
                ", Type='" + Type + '\'' +
                ", Lieu='" + Lieu + '\'' +
                ", Presence='" + Presence + '\'' +
                '}';
    }




}
