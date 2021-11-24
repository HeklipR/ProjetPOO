package Entreprise;

import jdk.jfr.Timestamp;

public class TaxeApprentissage {

    private Timestamp date;
    private double somme;
    private String commentaire;
    private Entreprise entreprise;


    public TaxeApprentissage(Timestamp date, double somme, String commentaire, Entreprise entreprise) {
        this.date = date;
        this.somme = somme;
        this.commentaire = commentaire;
        this.entreprise = entreprise;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "TaxeApprentissage{" +
                "date=" + date +
                ", somme=" + somme +
                ", commentaire='" + commentaire + '\'' +
                ", entreprise=" + entreprise +
                '}';
    }


    public void TaxeApprentissageAddBDD(){

    }

    public void TaxeApprentissageRemoveBDD(){

    }

    public void TaxeApprentissageModifBDD(){

    }
}
