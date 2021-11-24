package Personne;

public class Specialite {

    private String Technologie;
    private Personne personne;


    public Specialite(String technologie, Personne personne) {
        Technologie = technologie;
        this.personne = personne;
    }

    public String getTechnologie() {
        return Technologie;
    }

    public void setTechnologie(String technologie) {
        Technologie = technologie;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "Specialite{" +
                "Technologie='" + Technologie + '\'' +
                ", personne=" + personne +
                '}';
    }

    public void SpecialiteAddBDD(){

    }

    public void SpecialiteRemoveBDD(){

    }

    public void SpecialiteModifBDD(){

    }

}
