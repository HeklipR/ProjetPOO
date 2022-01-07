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

public class ControllerEvent implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheEvent ;
    @FXML public Button BoutonAjoutEvent;
    @FXML public Button BoutonChangeEvent;
    @FXML private Button BoutonSuppEvent ;
    @FXML private Button BoutonModifEvent;
    @FXML private Button BoutonRechargeEvent;
    @FXML private Button BoutonReinitialiseEvent;
    @FXML private TableView <Event> Event;
    @FXML private TableColumn <Event ,Integer> idEvent;
    @FXML private TableColumn <Event,String> Type;
    @FXML private TableColumn <Event,String> Lieu;
    @FXML private TableColumn <Event,String> Presence;
    @FXML private ComboBox <String> FiltreTableEvent;
    @FXML private ComboBox <String> FiltreAttributEvent;
    @FXML private TextField RechercheEvent;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Event> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM event";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Event(rs.getInt("idEvent"),rs.getString("Type"),
                        rs.getString("Lieu"), rs.getString("Presence")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idEvent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
        Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        Lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
        Presence.setCellValueFactory(new PropertyValueFactory<>("Presence"));


        Event.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Contact" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succursales","recherche Taxes d'apprentissages" ) ;

            FiltreTableEvent.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idEvent" ,
                "Type" , "Lieu" , "Presence") ;

        FiltreAttributEvent.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableEvent.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributEvent.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();
       this.permUser();

        }





    public void ActionChangeEvent(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangeEvent.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(getURL()));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("");
        stage.setScene(new Scene(root1));
        stage.show();


    }

    public void ActionAjoutEvent(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterEvent.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter un Event");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppEvent(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Event.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer un Event");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeEvent(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeEvent.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Event.fxml"));
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


    public void ActionModifEvent(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Event.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier l'Event");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheEvent(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributEvent.getSelectionModel().getSelectedItem() == "idEvent") {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM event WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheEvent.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Event(rs.getInt("idEvent"),rs.getString("Type"),
                         rs.getString("Lieu"), rs.getString("Presence")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idEvent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
         Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
         Lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
         Presence.setCellValueFactory(new PropertyValueFactory<>("Presence"));


         Event.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM event WHERE `"+this.getAttribut()+"`='"+RechercheEvent.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new Event(rs.getInt("idEvent"),rs.getString("Type"),
                            rs.getString("Lieu"), rs.getString("Presence")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idEvent.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
         Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
         Lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
         Presence.setCellValueFactory(new PropertyValueFactory<>("Presence"));


         Event.setItems(data);
        }
    }

    public void permUser(){
        if(ControllerConnexion.currentLog.getRole().equals("Utilisateur")){
            BoutonAjoutEvent.setVisible(false);
            BoutonModifEvent.setVisible(false);
            BoutonSuppEvent.setVisible(false);
        }
    }


    public void ActionReinitialiseEvent(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


