package Personne;

import Entreprise.Entreprise;

import java.sql.SQLException;

public class Personne {

    //Variable de la class Personne
    private int idPersonne ;
    private String nom;
    private String prenom;
    private int age;
    private Entreprise entreprise;
    private int idEntreprise;

    /**
     * Constructeur de la class Personne
     * @param idEntreprise
     * @param idPersonne
     * @param nom
     * @param prenom
     * @param age
     * @param entreprise
     */
    public Personne(int idPersonne , String nom, String prenom, int age, Entreprise entreprise, int idEntreprise) {
        this.idEntreprise = idEntreprise;
        this.idPersonne = idPersonne ;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.entreprise = entreprise;
    }

    //Getter and Setter de la calss Personne

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }


    /**
     * Fonction permettant l'ajout d'une Personne à la BDD
     * @param nom
     * @param prenom
     * @param age
     * @param entreprise
     * @throws SQLException
     */
    public void PersonneAddBDD(String nom, String prenom, int age, Entreprise entreprise) throws SQLException{

    }

    /**
     * Fonction permettant de supprimer une Personne de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void PersonneRemoveBDD(int ligne) throws SQLException{

    }

    //

    /**
     * Fonction permettant de modifier les valeurs d'une Personne puis les changer sur la BDD
     * @param nom
     * @param prenom
     * @param age
     * @param entreprise
     * @throws SQLException
     */
    public void PersonneModifBDD(String nom, String prenom, int age, Entreprise entreprise) throws SQLException {
        String rqt1 = "UPDATE PERSONNE SET nom = ?, prenom = ?, age = ? WHERE idPersonne = ?";


    }

}
//    private String nom;
//    private String prenom;
//    private int age;

/*  public fr.noah.CRUD.Employes findById(String id) throws SQLException {

        String rqt1 = "SELECT * FROM employes WHERE id = ?" ;
        PreparedStatement test = this.con.prepareStatement(rqt1);
        test.setString(1, id);
        ResultSet res = test.executeQuery();
        res.next();
        fr.noah.CRUD.Employes Wow = new fr.noah.CRUD.Employes(res.getInt("id"), res.getString("lastname"), res.getString("firstname"), res.getString("city"), res.getInt("salary"));

        return Wow;
    }
    */