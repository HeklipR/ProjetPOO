package Personne;

public class Cours {

    //Variable de la class Cours
    private String matiere;
    private String filliere;
    private int annee;
    private Personne personne;


    //Constructeur de la class Cours
    public Cours(String matiere, String filliere, int annee, Personne personne) {
        this.matiere = matiere;
        this.filliere = filliere;
        this.annee = annee;
        this.personne = personne;
    }

    //Getter and Setter de la class Cours
    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getFilliere() {
        return filliere;
    }

    public void setFilliere(String filliere) {
        this.filliere = filliere;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    //ToString de la class Cours
    @Override
    public String toString() {
        return "Cours{" +
                "matiere='" + matiere + '\'' +
                ", filliere='" + filliere + '\'' +
                ", annee=" + annee +
                ", personne=" + personne +
                '}';
    }



    // Fonction permettant l'ajout d'un cours à la BDD
    public void CoursAddBDD(){

    }

    // Fonction permettant de supprimer un cours de la BDD
    public void CoursRemoveBDD(){

    }
    // Fonction permettant de modifier les valeurs d'un cours puis les changer sur la BDD
    public void CoursModifBDD(){

    }

}
