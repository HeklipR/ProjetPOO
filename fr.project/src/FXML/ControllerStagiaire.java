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
import java.util.ResourceBundle;

public class ControllerStagiaire implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheStag ;
    @FXML public Button BoutonAjoutStag ;
    @FXML public Button BoutonChangeStag;
    @FXML private Button BoutonSuppStag;
    @FXML private Button BoutonModifStag ;
    @FXML private Button BoutonRechargeStag;
    @FXML private Button BoutonReinitialiseStag;
    @FXML private TableView <Stagiaire> Stagiaire;
    @FXML private TableColumn <Stagiaire ,Integer> idStagiaire;
    @FXML private TableColumn <Stagiaire,String> Niveau_etudes;
    @FXML private TableColumn <Stagiaire,String>annee ;
    @FXML private TableColumn <Stagiaire,String> Duree;
    @FXML private TableColumn <Stagiaire,String> Nom;
    @FXML private TableColumn <Stagiaire, Integer> idPersonne ;
    @FXML private ComboBox <String> FiltreAttrributStag;
    @FXML private ComboBox <String> FiltreTableStag ;
    @FXML private TextField RechercheStag;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Stagiaire> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM stagiaire";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Stagiaire(rs.getInt("idStagiaire"),rs.getString("Niveau_etudes"),
                        rs.getString("annee"),rs.getString("Duree"),
                        rs.getString("Nom") ,rs.getInt("idPersonne")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idStagiaire.setCellValueFactory(new PropertyValueFactory<>("idStagiaire"));
        Niveau_etudes.setCellValueFactory(new PropertyValueFactory<>("Niveau_etudes"));
        annee.setCellValueFactory(new PropertyValueFactory<>("annee"));
        Duree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

        Stagiaire.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Contact","recherche Succursales","recherche Taxes d'apprentissages" ) ;

            FiltreTableStag.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idStagiaire" ,
                "Niveau_etudes" , "annee" , "Duree" , "Nom" ,"idPersonne" ) ;

        FiltreAttrributStag.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableStag.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttrributStag.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();

        }





    public void ActionChangeStag(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangeStag.getScene().getWindow();

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

    public void ActionAjoutStag(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterStagiaire.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter un Stagiaire");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppStag(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Stagiaire.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer un Stagiaire");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeStag(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeStag.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Stagiaire.fxml"));
        Parent root1 = null;
        try {
            this.AffichageDonnés();
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root1));
        stage.show();



    }


    public void ActionModifStag(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Stagiaire.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier le Stagiaire");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheStag(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttrributStag.getSelectionModel().getSelectedItem() == "idStagiaire" || FiltreAttrributStag.getSelectionModel().getSelectedItem() == "idPersonne" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM stagiaire WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheStag.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Stagiaire(rs.getInt("idStagiaire"),rs.getString("Niveau_etudes"),
                         rs.getString("annee"),rs.getString("Duree"),
                         rs.getString("Nom") ,rs.getInt("idPersonne")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idStagiaire.setCellValueFactory(new PropertyValueFactory<>("idStagiaire"));
         Niveau_etudes.setCellValueFactory(new PropertyValueFactory<>("Niveau_etudes"));
         annee.setCellValueFactory(new PropertyValueFactory<>("annee"));
         Duree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
         Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
         idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Stagiaire.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM stagiaire WHERE `"+this.getAttribut()+"`='"+RechercheStag.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new Stagiaire(rs.getInt("idStagiaire"),rs.getString("Niveau_etudes"),
                            rs.getString("annee"),rs.getString("Duree"),
                            rs.getString("Nom") ,rs.getInt("idPersonne")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idStagiaire.setCellValueFactory(new PropertyValueFactory<>("idStagiaire"));
         Niveau_etudes.setCellValueFactory(new PropertyValueFactory<>("Niveau_etudes"));
         annee.setCellValueFactory(new PropertyValueFactory<>("annee"));
         Duree.setCellValueFactory(new PropertyValueFactory<>("Duree"));
         Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
         idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Stagiaire.setItems(data);

        }
    }


    public void ActionReinitialiseStag(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


