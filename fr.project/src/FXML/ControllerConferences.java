package FXML;


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

public class ControllerConferences implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheConf;
    @FXML public Button BoutonAjoutConf ;
    @FXML public Button AjouterContact;
    @FXML private Button BoutonRechargeConf ;
    @FXML private Button BoutonChangerConf;
    @FXML private Button BoutonSuppConf ;
    @FXML private Button BoutonModifConf;
    @FXML private Button BoutonReinitialiserConf;
    @FXML private TableView <Conference> Conferences;
    @FXML private TableColumn <Conference ,Integer> idConference;
    @FXML private TableColumn <Conference,String> date;
    @FXML private TableColumn <Conference,String> theme;
    @FXML private TableColumn <Conference,Integer> publique;
    @FXML private TableColumn <Conference,String> duree;
    @FXML private ComboBox <String> FiltresTableConf;
    @FXML private ComboBox <String> FiltreAttributConf;
    @FXML private TextField RechercheConf;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Conference> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM conference";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Conference (rs.getInt("idConference"),rs.getString("date"),
                        rs.getString("theme"),rs.getInt("publique"),
                        rs.getString("duree")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idConference.setCellValueFactory(new PropertyValueFactory<>("idConference"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
        publique.setCellValueFactory(new PropertyValueFactory<>("publique"));
        duree.setCellValueFactory(new PropertyValueFactory<>("duree"));


        Conferences.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Contact" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succursales","recherche Taxes d'apprentissages" ) ;

            FiltresTableConf.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idConference" ,
                "date" , "theme" , "publique" , "duree" ) ;

        FiltreAttributConf.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltresTableConf.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr = null;
        try{
            attr =FiltreAttributConf.getSelectionModel().getSelectedItem().toString();
            return attr;
        }catch (Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez mettre un filtre");
            alert.showAndWait();

        }
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();
       this.permUser();

        }





    public void ActionChangerConf(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangerConf.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(getURL()));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle(getURL());
        stage.setScene(new Scene(root1));
        stage.show();


    }

    public void ActionAjoutConf(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterConference.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter une Conference");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppConf(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Conference.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer une Conference");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeConf(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeConf.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Conferences.fxml"));
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


    public void ActionModifConf(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Conference.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier la  Conference");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheConf(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributConf.getSelectionModel().getSelectedItem() == "idConference" || FiltreAttributConf.getSelectionModel().getSelectedItem() == "public" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM conference WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheConf.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Conference (rs.getInt("idConference"),rs.getString("date"),
                         rs.getString("theme"),rs.getInt("publique"),
                         rs.getString("duree")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         // AJout données dans la BDD
         idConference.setCellValueFactory(new PropertyValueFactory<>("idConference"));
         date.setCellValueFactory(new PropertyValueFactory<>("date"));
         theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
         publique.setCellValueFactory(new PropertyValueFactory<>("publique"));
         duree.setCellValueFactory(new PropertyValueFactory<>("duree"));

         Conferences.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM conference WHERE `"+this.getAttribut()+"`='"+RechercheConf.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new Conference (rs.getInt("idConference"),rs.getString("date"),
                            rs.getString("theme"),rs.getInt("publique"),
                            rs.getString("duree")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }
         // AJout données dans la BDD
         idConference.setCellValueFactory(new PropertyValueFactory<>("idConference"));
         date.setCellValueFactory(new PropertyValueFactory<>("date"));
         theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
         publique.setCellValueFactory(new PropertyValueFactory<>("publique"));
         duree.setCellValueFactory(new PropertyValueFactory<>("duree"));

         Conferences.setItems(data);

        }
    }
    public void permUser(){
        if(ControllerConnexion.currentLog.getRole().equals("Utilisateur")){
            BoutonAjoutConf.setVisible(false);
            BoutonModifConf.setVisible(false);
            BoutonSuppConf.setVisible(false);
        }
    }


    public void ActionReinitialiserConf(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


