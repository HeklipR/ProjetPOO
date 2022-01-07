package FXML;



import java.sql.SQLException;

public class Succursales {


    // Variable de la class Succursales
    private int idSuccursale;
    private int idEntreprise;
    private String NomSucc;
    private String Date_de_creation;
    private String Lieu;
    private String Site_internet;



    // Constructeur de la class Succursales

    /**
     * Constructeur de la class Succursales
     * @param idSuccursale
     * @param idEntreprise
     * @param NomSucc
     * @param Date_de_creation
     * @param Lieu
     * @param Site_internet
     */
    public Succursales(int idSuccursale, String NomSucc, String Date_de_creation, String Lieu, String Site_internet,  int idEntreprise) {
        this.idSuccursale = idSuccursale;
        this.idEntreprise = idEntreprise;
        this.NomSucc = NomSucc;
        this.Date_de_creation = Date_de_creation;
        this.Lieu = Lieu;
        this.Site_internet = Site_internet;

    }

    // Getter and Setter de la class Succursales
    public String getNomSucc() {
        return NomSucc;
    }

    public void setNomSucc(String NomSucc) {
        this.NomSucc = NomSucc;
    }

    public String getDate_de_creation() {
        return Date_de_creation;
    }

    public void setDate_de_creation(String Date_de_creation) {
        this.Date_de_creation = Date_de_creation;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public String getSite_internet() {
        return Site_internet;
    }

    public void setSite_internet(String Site_internet) {
        this.Site_internet = Site_internet;
    }


    public int getIdSuccursale() {
        return idSuccursale;
    }

    public void setIdSuccursale(int idSuccursale) {
        this.idSuccursale = idSuccursale;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }



    // ToString de la class Succursales
    @Override
    public String toString() {
        return "Succursales{" +
                "NomSucc='" + NomSucc + '\'' +
                ", Date_de_creation=" + Date_de_creation +
                ", Lieu='" + Lieu + '\'' +
                ", Site_internet='" + Site_internet + '\'' +
                '}';
    }



}
