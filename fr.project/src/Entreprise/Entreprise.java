package Entreprise;

import jdk.jfr.Timestamp;

public class Entreprise {


    private String nomEntreprise;
    private String raisonSociale;
    private String denomination;
    private String adresseDuSiege;
    private String secteurActivite;
    private Timestamp dateCreation;
    private String siteInternet;


    public Entreprise(String nomEntreprise, String raisonSociale, String denomination, String adresseDuSiege, String secteurActivite, Timestamp dateCreation, String siteInternet) {
        this.nomEntreprise = nomEntreprise;
        this.raisonSociale = raisonSociale;
        this.denomination = denomination;
        this.adresseDuSiege = adresseDuSiege;
        this.secteurActivite = secteurActivite;
        this.dateCreation = dateCreation;
        this.siteInternet = siteInternet;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getAdresseDuSiege() {
        return adresseDuSiege;
    }

    public void setAdresseDuSiege(String adresseDuSiege) {
        this.adresseDuSiege = adresseDuSiege;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }


    @Override
    public String toString() {
        return "Entreprise{" +
                "nomEntreprise='" + nomEntreprise + '\'' +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", denomination='" + denomination + '\'' +
                ", adresseDuSiege='" + adresseDuSiege + '\'' +
                ", secteurActivite='" + secteurActivite + '\'' +
                ", dateCreation=" + dateCreation +
                ", siteInternet='" + siteInternet + '\'' +
                '}';
    }


    public void EntrepriseAddBDD(){

    }

    public void EntrepriseRemoveBDD(){

    }

    public void EntrepriseModifBDD(){

    }

}
