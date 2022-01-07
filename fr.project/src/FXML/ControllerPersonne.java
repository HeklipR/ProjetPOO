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

public class ControllerPersonne implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonAjoutPers;
    @FXML public Button BoutonChangePers;
    @FXML public Button BoutonSuppPers ;
    @FXML private Button BoutonModifPers;
    @FXML private Button BoutonRechargePers;
    @FXML public Button BoutonRecherchePers;
    @FXML public Button BoutonReinitialisePers;
    @FXML private TableView <Personne> Personne;
    @FXML private TableColumn <Personne ,Integer> idPersonne;
    @FXML private TableColumn <Personne,String> nom;
    @FXML private TableColumn <Personne,String> prenom;
    @FXML private TableColumn <Personne,Integer> age;
    @FXML private TableColumn <Personne,Integer> idEntreprise;
    @FXML private ComboBox <String> FiltreAttributPers ;
    @FXML private ComboBox <String> FiltreTablePers;

    @FXML private TextField RecherchePers;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Personne> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM personne";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Personne(rs.getInt("idPersonne"),rs.getString("nom"),
                        rs.getString("prenom"),rs.getInt("age"),
                        rs.getInt("idEntreprise")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));
        idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

        Personne.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Contact" ,"recherche Specialité","recherche Stagiaire","recherche Succursales","recherche Taxes d'apprentissages" ) ;

            FiltreTablePers.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idPersonne" ,
                "nom" , "prenom" , "age" , "idEntreprise") ;

        FiltreAttributPers.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTablePers.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributPers.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();
       this.permUser();

        }





    public void ActionChangePers(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangePers.getScene().getWindow();

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

    public void ActionAjoutPers(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterPersonne.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter une Personne");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppPers(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Personne.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer une Personne");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargePers(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargePers.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Personne.fxml"));
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


    public void ActionModifPers(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modfier Personne.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier la Personne");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRecherchePers(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributPers.getSelectionModel().getSelectedItem() == "idEntreprise" || FiltreAttributPers.getSelectionModel().getSelectedItem() == "idPersonne" || FiltreAttributPers.getSelectionModel().getSelectedItem() == "age" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM personne WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RecherchePers.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Personne(rs.getInt("idPersonne"),rs.getString("nom"),
                         rs.getString("prenom"),rs.getInt("age"),
                         rs.getInt("idEntreprise")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         age.setCellValueFactory(new PropertyValueFactory<>("age"));
         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));
         idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Personne.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM personne WHERE `"+this.getAttribut()+"`='"+RecherchePers.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new Personne(rs.getInt("idPersonne"),rs.getString("nom"),
                            rs.getString("prenom"),rs.getInt("age"),
                            rs.getInt("idEntreprise")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         age.setCellValueFactory(new PropertyValueFactory<>("age"));
         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));
         idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Personne.setItems(data);

        }
    }

    public void permUser(){
        if(ControllerConnexion.currentLog.getRole().equals("Utilisateur")){
            BoutonAjoutPers.setVisible(false);
            BoutonModifPers.setVisible(false);
            BoutonSuppPers.setVisible(false);
        }
    }


    public void ActionReinitialisePers(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


