package Entreprise;

import jdk.jfr.Timestamp;

public class TaxeApprentissage {


    //Variable de la class TaxeApprentissage
    private Timestamp date;
    private double somme;
    private String commentaire;
    private Entreprise entreprise;


    //Constructeur de la class TaxeApprentissage
    public TaxeApprentissage(Timestamp date, double somme, String commentaire, Entreprise entreprise) {
        this.date = date;
        this.somme = somme;
        this.commentaire = commentaire;
        this.entreprise = entreprise;
    }

    //Getter and Setter de la class TaxeApprentissage
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


    //ToString de la class TaxeApprentissage
    @Override
    public String toString() {
        return "TaxeApprentissage{" +
                "date=" + date +
                ", somme=" + somme +
                ", commentaire='" + commentaire + '\'' +
                ", entreprise=" + entreprise +
                '}';
    }

    // Fonction permettant l'ajout d'une Taxe d'apprentissage à la BDD
    public void TaxeApprentissageAddBDD(){

    }

    // Fonction permettant de supprimer une Taxe d'apprentissage de la BDD
    public void TaxeApprentissageRemoveBDD(){

    }
    // Fonction permettant de modifier les valeurs d'une Taxe d'apprentissage puis les changer sur la BDD
    public void TaxeApprentissageModifBDD(){

    }
}
