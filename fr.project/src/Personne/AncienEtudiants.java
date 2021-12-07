package Personne;

import jdk.jfr.Timestamp;

public class AncienEtudiants {


    // Variable de la classe AncienEtudiants
    private String niveauEtude;
    private Timestamp annee;
    private String typeDeContrat;
    private Timestamp duree;
    private Personne personne;

    //Constructeur de la class AncienEtudiants
    public AncienEtudiants(String niveauEtude, Timestamp annee, String typeDeContrat, Timestamp duree, Personne personne) {
        this.niveauEtude = niveauEtude;
        this.annee = annee;
        this.typeDeContrat = typeDeContrat;
        this.duree = duree;
        this.personne = personne;
    }

    //Getter and setter de la class AncienEtudiants
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

    //ToString de la class AncienEtudiants
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

    // Fonction permettant l'ajout d'un Ancien Etudiant à la BDD
    public void AncienEtudiantsAddBDD(){

    }
    // Fonction permettant de supprimer un Ancien Etudiant de la BDD
    public void AncienEtudiantsRemoveBDD(){

    }
    // Fonction permettant de modifier les valeurs d'un Ancien Etudiant puis les changer sur la BDD
    public void AncienEtudiantsModifBDD(){

    }

}
