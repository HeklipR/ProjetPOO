package Personne;

import Entreprise.Entreprise;

import java.sql.SQLException;

public class Personne {

    private String nom;
    private String prenom;
    private int age;
    private Entreprise entreprise;

    public Personne(String nom, String prenom, int age, Entreprise entreprise) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.entreprise = entreprise;
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

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }



    public void PersonneAddBDD(){

    }

    public void PersonneRemoveBDD(){

    }

    public void PersonneModifBDD(String nom, String prenom, int age) throws SQLException {
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