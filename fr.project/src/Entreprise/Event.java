package Entreprise;

public class Event {

    private String type;
    private String lieu;
    private boolean presence;
    private Entreprise entreprise;


    public Event(String type, String lieu, boolean presence, Entreprise entreprise) {
        this.type = type;
        this.lieu = lieu;
        this.presence = presence;
        this.entreprise = entreprise;
    }


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

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", lieu='" + lieu + '\'' +
                ", presence=" + presence +
                ", entreprise=" + entreprise +
                '}';
    }

    public void EventAddBDD(){

    }

    public void EventRemoveBDD(){

    }

    public void EventModifBDD(){

    }
}
