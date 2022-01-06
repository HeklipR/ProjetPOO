package FXML;

import CRUDExemple.SingleConnection;
import SQLQueries.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerAncienEtu implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheAE;
    @FXML public Button BoutonAjoutAE;
    @FXML public Button ChangerTableAE;
    @FXML private Button BoutonSuppAE;
    @FXML private Button BoutonModifAE;
    @FXML public Button BoutonRechargeAE;
    @FXML private Button BoutonReinitialiserAE;
    @FXML private TableView <AncienEtudiants> Ancien_Etudiant;
    @FXML private TableColumn <AncienEtudiants ,Integer> idAncienEtudiant;
    @FXML private TableColumn <AncienEtudiants,String> Niveau_etudes;
    @FXML private TableColumn <AncienEtudiants,Date> AnneeEtudiant;
    @FXML private TableColumn <AncienEtudiants,String> Type_de_contrat_de_travail;
    @FXML private TableColumn <AncienEtudiants,Timestamp> Duree;
    @FXML private TableColumn <AncienEtudiants,String> Nom ;
    @FXML private TableColumn <AncienEtudiants,Integer> idPersAE ;
    @FXML private ComboBox <String> FiltreAttributAE;
    @FXML private ComboBox <String> FiltreTableAE;
    @FXML private TextField RechercheAE;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <AncienEtudiants> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnésAE() {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM ancien_etudiants";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new AncienEtudiants(rs.getInt("idAncienEtudiant"),rs.getString("Niveau_etudes"),
                        rs.getString("Annee"),rs.getString("Type_de_contrat_de_travail"),
                        rs.getString("Duree"),rs.getString("Nom"),rs.getInt("idPersonne")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idAncienEtudiant.setCellValueFactory(new PropertyValueFactory<>("idAncienEtudiant"));
        Niveau_etudes.setCellValueFactory(new PropertyValueFactory<>("Niveau_etudes"));
        AnneeEtudiant.setCellValueFactory(new PropertyValueFactory<>("Annee"));
        Type_de_contrat_de_travail.setCellValueFactory(new PropertyValueFactory<>("Type_de_contrat_de_travail"));
        Duree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        idPersAE.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

        Ancien_Etudiant.setItems(data);
    }

        public void FiltreTableComboBoxAE() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Contact" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succurrsales","recherche Taxes d'apprentissages" ) ;

            FiltreTableAE.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBoxAE() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idAncienEtudiant" ,
                "Niveau_etudes" , "Annee" , "Type_de_contrat_de_travail" ,"Duree" ,"Nom", "idPersonne" ) ;

        FiltreAttributAE.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableAE.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributAE.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBoxAE();
       this.AffichageDonnésAE();
       this.FiltresAttributComboBoxAE();

        }





    public void ActionChangerAE(ActionEvent actionEvent) {

        Stage stage = (Stage) ChangerTableAE.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(getURL()));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        stage.setScene(new Scene(root1));
        stage.show();


    }

    public void ActionAjoutAE(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterAncienEtudiant.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter un Ancien Etudiant");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppAE(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez AE.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer un Ancien Etudiant");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeAE(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeAE.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Ancien Etudiant.fxml"));
        Parent root1 = null;
        try {
            this.AffichageDonnésAE();
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root1));
        stage.show();



    }


    public void ActionModifAE(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier AncienEtudiant.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier un Ancien Etudiant");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheAE(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributAE.getSelectionModel().getSelectedItem() == "idAncienEtudiant" || FiltreAttributAE.getSelectionModel().getSelectedItem() == "idPersonne" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM ancien_etudiants WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheAE.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new AncienEtudiants(rs.getInt("idAncienEtudiant"),rs.getString("Niveau_etudes"),
                         rs.getString("Annee"),rs.getString("Type_de_contrat_de_travail"),
                         rs.getString("Duree"),rs.getString("Nom"),rs.getInt("idPersonne")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idAncienEtudiant.setCellValueFactory(new PropertyValueFactory<>("idAncienEtudiant"));
         Niveau_etudes.setCellValueFactory(new PropertyValueFactory<>("Niveau_etudes"));
         AnneeEtudiant.setCellValueFactory(new PropertyValueFactory<>("Annee"));
         Type_de_contrat_de_travail.setCellValueFactory(new PropertyValueFactory<>("Type_de_contrat_de_travail"));
         Duree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
         Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
         idPersAE.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Ancien_Etudiant.setItems(data);


}

    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM ancien_etudiants WHERE `"+this.getAttribut()+"`='"+RechercheAE.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new AncienEtudiants(rs.getInt("idAncienEtudiant"),rs.getString("Niveau_etudes"),
                            rs.getString("Annee"),rs.getString("Type_de_contrat_de_travail"),
                            rs.getString("Duree"),rs.getString("Nom"),rs.getInt("idPersonne")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idAncienEtudiant.setCellValueFactory(new PropertyValueFactory<>("idAncienEtudiant"));
         Niveau_etudes.setCellValueFactory(new PropertyValueFactory<>("Niveau_etudes"));
         AnneeEtudiant.setCellValueFactory(new PropertyValueFactory<>("Annee"));
         Type_de_contrat_de_travail.setCellValueFactory(new PropertyValueFactory<>("Type_de_contrat_de_travail"));
         Duree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
         Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
         idPersAE.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Ancien_Etudiant.setItems(data);

        }
    }


    public void ActionReinitialiserAE(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnésAE();
    }
}


