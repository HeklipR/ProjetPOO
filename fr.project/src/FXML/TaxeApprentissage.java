package FXML;



import java.sql.SQLException;

public class TaxeApprentissage {


    //Variable de la class TaxeApprentissage
    private int idTaxe;
    private int idEntreprise;
    private String date;
    private double somme;
    private String commentaire;
    


    //Constructeur de la class TaxeApprentissage

    /**
     * Constructeur de la class TaxeApprentissage
     * @param idTaxe
     * @param idEntreprise
     * @param date
     * @param somme
     * @param commentaire
     */
    public TaxeApprentissage( int idTaxe, String date, double somme, String commentaire, int idEntreprise) {
        this.idTaxe = idTaxe;
        this.idEntreprise = idEntreprise;
        this.date = date;
        this.somme = somme;
        this.commentaire = commentaire;
    }

    //Getter and Setter de la class TaxeApprentissage
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


    public int getIdTaxe() {
        return idTaxe;
    }

    public void setIdTaxe(int idTaxe) {
        this.idTaxe = idTaxe;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }



    //ToString de la class TaxeApprentissage
    @Override
    public String toString() {
        return "TaxeApprentissage{" +
                "date=" + date +
                ", somme=" + somme +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }

}
