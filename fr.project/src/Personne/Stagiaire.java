package Personne;

import jdk.jfr.Timestamp;

public class Stagiaire {


    private String niveauEtude;
    private Timestamp annee;
    private Timestamp duree;
    private Personne personne;


    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public Timestamp getAnnee() {
        return annee;
    }

    public void setAnnee(Timestamp annee) {
        this.annee = annee;
    }

    public Timestamp getDuree() {
        return duree;
    }

    public void setDuree(Timestamp duree) {
        this.duree = duree;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String
    toString() {
        return "Stagiaire{" +
                "niveauEtude='" + niveauEtude + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", personne=" + personne +
                '}';
    }

    public Stagiaire(String niveauEtude, Timestamp annee, Timestamp duree, Personne personne) {
        this.niveauEtude = niveauEtude;
        this.annee = annee;
        this.duree = duree;
        this.personne = personne;

    }
    public void StagiaireAddBDD(){

    }

    public void StagiaireRemoveBDD(){

    }

    public void StagiaireModifBDD(){

    }

}
