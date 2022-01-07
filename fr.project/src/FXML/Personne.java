package FXML;

import java.sql.SQLException;

public class Personne {

    //Variable de la class Personne
    private int idPersonne ;
    private String nom;
    private String prenom;
    private int age;
    private int idEntreprise;

    /**
     * Constructeur de la class Personne
     * @param idEntreprise
     * @param idPersonne
     * @param nom
     * @param prenom
     * @param age
     */
    public Personne(int idPersonne , String nom, String prenom, int age, int idEntreprise) {
        this.idEntreprise = idEntreprise;
        this.idPersonne = idPersonne ;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
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
                "idPersonne=" + idPersonne +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", idEntreprise=" + idEntreprise +
                '}';
    }


    }
