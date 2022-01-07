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

public class ControllerCours implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheCours;
    @FXML public Button BoutonAjoutCour;
    @FXML public Button AjouterContact;
    @FXML private Button BoutonChangeCour;
    @FXML private Button BoutonSuppCour;
    @FXML private Button BoutonModifCour;
    @FXML private Button BoutonReinitialiserCour;
    @FXML private Button BoutonRechargeCour;
    @FXML private TableView <Cours> Cours;
    @FXML private TableColumn <Cours ,Integer> idCours;
    @FXML private TableColumn <Cours,String> matiere;
    @FXML private TableColumn <Cours,String> filiere;
    @FXML private TableColumn <Cours,Integer> annee;
    @FXML private ComboBox <String> FiltreTableCour;
    @FXML private ComboBox <String> FiltreAttributCour;
    @FXML private TextField RechercheCours;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Cours> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM cours";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Cours(rs.getInt("idCours"),rs.getString("matiere"),
                        rs.getString("filiere"),rs.getInt("annee")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idCours.setCellValueFactory(new PropertyValueFactory<>("idCours"));
        matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
        filiere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
        annee.setCellValueFactory(new PropertyValueFactory<>("annee"));


        Cours.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Contact"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succursales","recherche Taxes d'apprentissages" ) ;

            FiltreTableCour.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idCours" ,
                "matiere" , "filiere" , "annee" ) ;

        FiltreAttributCour.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableCour.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributCour.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();
       this.permUser();

        }





    public void ActionChangeCour(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangeCour.getScene().getWindow();

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

    public void ActionAjoutCour(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterCours.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter un Cours");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppCour(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Cours.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer un Cours");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeCour(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeCour.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Cours.fxml"));
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


    public void ActionModifCour(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Cours.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier le Cours");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheCours(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributCour.getSelectionModel().getSelectedItem() == "idCours" || FiltreAttributCour.getSelectionModel().getSelectedItem() == "annee" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM cours WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheCours.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Cours(rs.getInt("idCours"),rs.getString("matiere"),
                         rs.getString("filiere"),rs.getInt("annee")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idCours.setCellValueFactory(new PropertyValueFactory<>("idCours"));
         matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
         filiere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
         annee.setCellValueFactory(new PropertyValueFactory<>("annee"));


         Cours.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM cours WHERE `"+this.getAttribut()+"`='"+RechercheCours.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new Cours(rs.getInt("idCours"),rs.getString("matiere"),
                            rs.getString("filiere"),rs.getInt("annee")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idCours.setCellValueFactory(new PropertyValueFactory<>("idCours"));
         matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
         filiere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
         annee.setCellValueFactory(new PropertyValueFactory<>("annee"));


         Cours.setItems(data);

        }
    }

    public void permUser(){
        if(ControllerConnexion.currentLog.getRole().equals("Utilisateur")){
            BoutonAjoutCour.setVisible(false);
            BoutonModifCour.setVisible(false);
            BoutonSuppCour.setVisible(false);
        }
    }

    public void ActionReinitialiserCour(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


