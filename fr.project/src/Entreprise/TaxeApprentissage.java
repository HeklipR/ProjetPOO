package Entreprise;



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
    public TaxeApprentissage(String date, double somme, String commentaire, int idEntreprise, int idTaxe) {
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

    // Fonction permettant l'ajout d'une Taxe d'apprentissage à la BDD

    /**
     * Fonction permettant l'ajout d'une Taxe d'apprentissage à la BDD
     * @param date
     * @param somme
     * @param commentaire
     * @throws SQLException
     */
    public void TaxeApprentissageAddBDD(String date, double somme, String commentaire ) throws SQLException{

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
     * @throws SQLException
     */
    public void TaxeApprentissageModifBDD(String date, double somme, String commentaire ) throws SQLException {

    }
}
