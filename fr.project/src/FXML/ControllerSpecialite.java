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

public class ControllerSpecialite implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheSpe;
    @FXML public Button BoutonAjoutSpe ;
    @FXML public Button BoutonChangeSpe ;
    @FXML private Button BoutonSuppSpe;
    @FXML public Button BoutonModifSpe ;
    @FXML public Button BoutonRechargeSpe ;
    @FXML private Button BoutonReinitialiseSpe ;
    @FXML private TableView <Specialite> Specialite;
    @FXML private TableColumn <Specialite ,Integer> idSpecialite;
    @FXML private TableColumn <Specialite,String> Technologie;
    @FXML private ComboBox <String> FiltreAttributSpe;
    @FXML private ComboBox <String> FiltreTableSpe;
    @FXML private TextField RechercheSpe;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Specialite> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM specialite";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Specialite(rs.getInt("idSpecialite"),rs.getString("Technologie")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idSpecialite.setCellValueFactory(new PropertyValueFactory<>("idSpecialite"));
        Technologie.setCellValueFactory(new PropertyValueFactory<>("Technologie"));


        Specialite.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Contact","recherche Stagiaire","recherche Succursales","recherche Taxes d'apprentissages" ) ;

            FiltreTableSpe.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idSpecialite" ,
                "Technologie" ) ;

        FiltreAttributSpe.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableSpe.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributSpe.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();

        }





    public void ActionChangeSpe(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangeSpe.getScene().getWindow();

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

    public void ActionAjoutSpe(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterSpecialite.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter une Specialité");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppSpe(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Specialite.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer une Specialité");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeSpe(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeSpe.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Specialité.fxml"));
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


    public void ActionModifSpe(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Specialité.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier la Specialité");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheSpe(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributSpe.getSelectionModel().getSelectedItem() == "idSpecialite" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM specialite WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheSpe.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Specialite(rs.getInt("idSpecialite"),rs.getString("Technologie")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idSpecialite.setCellValueFactory(new PropertyValueFactory<>("idSpecialite"));
         Technologie.setCellValueFactory(new PropertyValueFactory<>("Technologie"));


         Specialite.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM specialite WHERE `"+this.getAttribut()+"`='"+RechercheSpe.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    data.add(new Specialite(rs.getInt("idSpecialite"),rs.getString("Technologie")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idSpecialite.setCellValueFactory(new PropertyValueFactory<>("idSpecialite"));
         Technologie.setCellValueFactory(new PropertyValueFactory<>("Technologie"));


         Specialite.setItems(data);

        }
    }


    public void ActionReinitialiseSpe(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


