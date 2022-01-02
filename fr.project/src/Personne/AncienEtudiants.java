package Personne;

import jdk.jfr.Timestamp;

import java.sql.SQLException;

public class AncienEtudiants {


    // Variable de la classe AncienEtudiantsss

    private String niveauEtude;
    private Timestamp annee;
    private String typeDeContrat;
    private Timestamp duree;
    private Personne personne;


    /**
     * Constructeur de la class AncienEtudiants
     * @param niveauEtude
     * @param annee
     * @param typeDeContrat
     * @param duree
     * @param personne
     */
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


    /**
     * Fonction permettant l'ajout d'un Ancien Etudiant à la BDD
     * @param niveauEtude
     * @param annee
     * @param typeDeContrat
     * @param duree
     * @param personne
     * @throws SQLException
     */
    public void AncienEtudiantsAddBDD(String niveauEtude, Timestamp annee, String typeDeContrat, Timestamp duree, Personne personne) throws SQLException {

    }

    /**
     * Fonction permettant de supprimer un Ancien Etudiant de la BDD
     * @param ligne
     * @throws SQLException
     */
    public void AncienEtudiantsRemoveBDD(int ligne) throws SQLException{

    }

    /**
     * Fonction permettant de modifier les valeurs d'un Ancien Etudiant puis les changer sur la BDD
     * @param niveauEtude
     * @param annee
     * @param typeDeContrat
     * @param duree
     * @param personne
     * @throws SQLException
     */
    public void AncienEtudiantsModifBDD(String niveauEtude, Timestamp annee, String typeDeContrat, Timestamp duree, Personne personne) throws SQLException{

    }

}
