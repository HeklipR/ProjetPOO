package Personne;



import java.sql.SQLException;

public class AncienEtudiants {


    // Variable de la classe AncienEtudiants

    private int idAncienEtudiant;
    private String niveauEtude;
    private String annee;
    private String typeDeContrat;
    private String duree;
    private Personne personne;
    private int idPersonne;

    /**
     * @param idPersonne
     * @param idAncienEtudiant
     * @param niveauEtude
     * @param annee
     * @param typeDeContrat
     * @param duree
     * @param personne
     */

    public AncienEtudiants(String niveauEtude, String annee, String typeDeContrat, String duree, Personne personne, int idAncienEtudiant, int idPersonne) {
        this.idPersonne = idPersonne;
        this.idAncienEtudiant = idAncienEtudiant;
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

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getTypeDeContrat() {
        return typeDeContrat;
    }

    public void setTypeDeContrat(String typeDeContrat) {
        this.typeDeContrat = typeDeContrat;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public int getIdAncienEtudiant() {
        return idAncienEtudiant;
    }

    public void setIdAncienEtudiant(int idAncienEtudiant) {
        this.idAncienEtudiant = idAncienEtudiant;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
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
    public void AncienEtudiantsAddBDD(String niveauEtude, String annee, String typeDeContrat, String duree, Personne personne) throws SQLException {

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
    public void AncienEtudiantsModifBDD(String niveauEtude, String annee, String typeDeContrat, String duree, Personne personne) throws SQLException{

    }

}
