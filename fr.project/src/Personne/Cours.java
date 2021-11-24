package Personne;

public class Cours {


    private String matiere;
    private String filliere;
    private int annee;
    private Personne personne;


    public Cours(String matiere, String filliere, int annee, Personne personne) {
        this.matiere = matiere;
        this.filliere = filliere;
        this.annee = annee;
        this.personne = personne;
    }

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

    @Override
    public String toString() {
        return "Cours{" +
                "matiere='" + matiere + '\'' +
                ", filliere='" + filliere + '\'' +
                ", annee=" + annee +
                ", personne=" + personne +
                '}';
    }




    public void CoursAddBDD(){

    }

    public void CoursRemoveBDD(){

    }

    public void CoursModifBDD(){

    }

}
