package Personne;

import jdk.jfr.Timestamp;

public class AncienEtudiants {

    private String niveauEtude;
    private Timestamp annee;
    private String typeDeContrat;
    private Timestamp duree;
    private Personne personne;


    public AncienEtudiants(String niveauEtude, Timestamp annee, String typeDeContrat, Timestamp duree, Personne personne) {
        this.niveauEtude = niveauEtude;
        this.annee = annee;
        this.typeDeContrat = typeDeContrat;
        this.duree = duree;
        this.personne = personne;
    }

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

    public String getTypeDeContrat() {
        return typeDeContrat;
    }

    public void setTypeDeContrat(String typeDeContrat) {
        this.typeDeContrat = typeDeContrat;
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
    public String toString() {
        return "AncienEtudiants{" +
                "niveauEtude='" + niveauEtude + '\'' +
                ", annee=" + annee +
                ", typeDeContrat='" + typeDeContrat + '\'' +
                ", duree=" + duree +
                ", personne=" + personne +
                '}';
    }

    public void AncienEtudiantsAddBDD(){

        String random = "test";

    }

    public void AncienEtudiantsRemoveBDD(){

    }

    public void AncienEtudiantsModifBDD(){

    }

}
