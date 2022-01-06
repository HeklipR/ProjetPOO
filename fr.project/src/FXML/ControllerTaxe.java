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

public class ControllerTaxe implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheTaxe;
    @FXML public Button BoutonAjoutTaxe;
    @FXML public Button BoutonChangeTaxe;
    @FXML private Button BoutonSuppTaxe;
    @FXML private TableView <TaxeApprentissage> Taxe;
    @FXML private TableColumn <TaxeApprentissage ,Integer> idTaxe;
    @FXML private TableColumn <TaxeApprentissage,String> date;
    @FXML private TableColumn <TaxeApprentissage,Double> somme;
    @FXML private TableColumn <TaxeApprentissage,String> commentaire;
    @FXML private TableColumn <TaxeApprentissage, Integer> idEntreprise ;
    @FXML private ComboBox <String> FiltreAttributTaxe;
    @FXML private ComboBox <String> FiltreTableTaxe;
    @FXML private Button BoutonModifTaxe;
    @FXML private Button BoutonRechargeTaxe;
    @FXML private Button BoutonReinitialiseTaxe;
    @FXML private TextField RechercheTaxe;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <TaxeApprentissage> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM taxe_apprentissage";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new TaxeApprentissage(rs.getInt("idTaxe"),rs.getString("date"),
                        rs.getDouble("somme"),rs.getString("commentaire"),
                        rs.getInt("idEntreprise")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idTaxe.setCellValueFactory(new PropertyValueFactory<>("idTaxe"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        somme.setCellValueFactory(new PropertyValueFactory<>("somme"));
        commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));


        Taxe.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succursales","recherche Contact" ) ;

            FiltreTableTaxe.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idTaxe" ,
                "date" , "somme" , "commentaire" , "idEntreprise" ) ;

        FiltreAttributTaxe.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableTaxe.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributTaxe.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();

        }





    public void ActionChangeTaxe(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangeTaxe.getScene().getWindow();

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

    public void ActionAjoutTaxe(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterTaxeApprentissage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter une Taxe");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppTaxe(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Taxe.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer une Taxe");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeTaxe(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeTaxe.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Taxes d'apprentissages.fxml"));
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


    public void ActionModifTaxe(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Taxe.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier la Taxe");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheTaxe(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributTaxe.getSelectionModel().getSelectedItem() == "idTaxe" || FiltreAttributTaxe.getSelectionModel().getSelectedItem() == "idEntreprise" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM taxe_apprentissage WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheTaxe.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new TaxeApprentissage(rs.getInt("idTaxe"),rs.getString("date"),
                         rs.getDouble("somme"),rs.getString("commentaire"),
                         rs.getInt("idEntreprise")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idTaxe.setCellValueFactory(new PropertyValueFactory<>("idTaxe"));
         date.setCellValueFactory(new PropertyValueFactory<>("date"));
         somme.setCellValueFactory(new PropertyValueFactory<>("somme"));
         commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));


         Taxe.setItems(data);

}
       else if ( FiltreAttributTaxe.getSelectionModel().getSelectedItem() == "somme" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM taxe_apprentissage WHERE `" + this.getAttribut() + "`='" + Double.parseDouble(RechercheTaxe.getText()) + "'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()) {
                 data.add(new TaxeApprentissage(rs.getInt("idTaxe"), rs.getString("date"),
                         rs.getDouble("somme"), rs.getString("commentaire"),
                         rs.getInt("idEntreprise")));

             }

         } catch (Exception e) {
             e.printStackTrace();
         }

         idTaxe.setCellValueFactory(new PropertyValueFactory<>("idTaxe"));
         date.setCellValueFactory(new PropertyValueFactory<>("date"));
         somme.setCellValueFactory(new PropertyValueFactory<>("somme"));
         commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));


         Taxe.setItems(data);
     }

    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM taxe_apprentissage WHERE `"+this.getAttribut()+"`='"+RechercheTaxe.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new TaxeApprentissage(rs.getInt("idTaxe"),rs.getString("date"),
                            rs.getDouble("somme"),rs.getString("commentaire"),
                            rs.getInt("idEntreprise")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idTaxe.setCellValueFactory(new PropertyValueFactory<>("idTaxe"));
         date.setCellValueFactory(new PropertyValueFactory<>("date"));
         somme.setCellValueFactory(new PropertyValueFactory<>("somme"));
         commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));


         Taxe.setItems(data);

        }
    }


    public void ActionReinitialiseTaxe(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


