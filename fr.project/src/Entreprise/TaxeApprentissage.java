package Entreprise;

import jdk.jfr.Timestamp;

import java.sql.SQLException;

public class TaxeApprentissage {


    //Variable de la class TaxeApprentissage
    private int idTaxe;
    private int idEntreprise;
    private Timestamp date;
    private double somme;
    private String commentaire;
    private Entreprise entreprise;


    //Constructeur de la class TaxeApprentissage

    /**
     * Constructeur de la class TaxeApprentissage
     * @param idTaxe
     * @param idEntreprise
     * @param date
     * @param somme
     * @param commentaire
     * @param entreprise
     */
    public TaxeApprentissage(Timestamp date, double somme, String commentaire, Entreprise entreprise, int idEntreprise, int idTaxe) {
        this.idTaxe = idTaxe;
        this.idEntreprise = idEntreprise;
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

    /**
     * Fonction permettant l'ajout d'une Taxe d'apprentissage à la BDD
     * @param date
     * @param somme
     * @param commentaire
     * @param entreprise
     * @throws SQLException
     */
    public void TaxeApprentissageAddBDD(Timestamp date, double somme, String commentaire, Entreprise entreprise) throws SQLException{

    }

    // Fonction permettant de supprimer une Taxe d'apprentissage de la BDD

    /**
     * Fonction permettant de supprimer une Taxe d'apprentissage de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void TaxeApprentissageRemoveBDD(int ligne) throws SQLException{

    }
    // Fonction permettant de modifier les valeurs d'une Taxe d'apprentissage puis les changer sur la BDD

    /**
     * Fonction permettant de modifier les valeurs d'une Taxe d'apprentissage puis les changer sur la BDD
     * @param date
     * @param somme
     * @param commentaire
     * @param entreprise
     * @throws SQLException
     */
    public void TaxeApprentissageModifBDD(Timestamp date, double somme, String commentaire, Entreprise entreprise) throws SQLException {

    }
}
