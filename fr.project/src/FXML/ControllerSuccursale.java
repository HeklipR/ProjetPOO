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

public class ControllerSuccursale implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheSucc;
    @FXML public Button BoutonAjoutSucc;
    @FXML public Button BoutonChangeSucc;
    @FXML private Button BoutonSuppSucc;
    @FXML private Button BoutonModifSucc;
    @FXML private Button BoutonRechargeSucc;
    @FXML private Button BoutonReinitialiseSucc;
    @FXML private TableView <Succursales> Succursale;
    @FXML private TableColumn <Succursales ,Integer> idSuccursale ;
    @FXML private TableColumn <Succursales,String> Date_de_creation;
    @FXML private TableColumn <Succursales,String> NomSucc;
    @FXML private TableColumn <Succursales,String> Lieu;
    @FXML private TableColumn <Succursales,String> Site_internet;
    @FXML private TableColumn <Succursales, Integer> idEntreprise ;
    @FXML private ComboBox <String> FiltreAttributSucc;
    @FXML private ComboBox <String> FiltreTableSucc;
    @FXML private TextField RechercheSucc ;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Succursales> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM succursales";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Succursales(rs.getInt("idSuccursale"),rs.getString("NomSucc"),
                        rs.getString("Date_de_creation"),rs.getString("Lieu"),
                        rs.getString("Site_internet") ,rs.getInt("idEntreprise")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idSuccursale.setCellValueFactory(new PropertyValueFactory<>("idSuccursale"));
        NomSucc.setCellValueFactory(new PropertyValueFactory<>("NomSucc"));
        Date_de_creation.setCellValueFactory(new PropertyValueFactory<>("Date_de_creation"));
        Lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
        Site_internet.setCellValueFactory(new PropertyValueFactory<>("Site_internet"));
        idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));

        Succursale.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Contact","recherche Taxes d'apprentissages" ) ;

            FiltreTableSucc.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idSuccursale" ,
                "NomSucc" , "Date_de_creation" , "Lieu" , "Site_internet" ,"idEntreprise" ) ;

        FiltreAttributSucc.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableSucc.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributSucc.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();
       this.permUser();

        }





    public void ActionChangeSucc(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangeSucc.getScene().getWindow();

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

    public void ActionAjoutSucc(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterSuccursales.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter une Succursales");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppSucc(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Succursale.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer une Succursales");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeSucc(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeSucc.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Succursales.fxml"));
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


    public void ActionModifSucc(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifer Succursale.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier la Succursales");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheSucc(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributSucc.getSelectionModel().getSelectedItem() == "idSuccursale" || FiltreAttributSucc.getSelectionModel().getSelectedItem() == "idEntreprise" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM succursales WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheSucc.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Succursales(rs.getInt("idSuccursale"),rs.getString("NomSucc"),
                         rs.getString("Date_de_creation"),rs.getString("Lieu"),
                         rs.getString("Site_internet") ,rs.getInt("idEntreprise")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idSuccursale.setCellValueFactory(new PropertyValueFactory<>("idSuccursale"));
         NomSucc.setCellValueFactory(new PropertyValueFactory<>("NomSucc"));
         Date_de_creation.setCellValueFactory(new PropertyValueFactory<>("Date_de_creation"));
         Lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
         Site_internet.setCellValueFactory(new PropertyValueFactory<>("Site_internet"));
         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));

         Succursale.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM succursales WHERE `"+this.getAttribut()+"`='"+RechercheSucc.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                    data.add(new Succursales(rs.getInt("idSuccursale"),rs.getString("NomSucc"),
                            rs.getString("Date_de_creation"),rs.getString("Lieu"),
                            rs.getString("Site_internet") ,rs.getInt("idEntreprise")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idSuccursale.setCellValueFactory(new PropertyValueFactory<>("idSuccursale"));
         NomSucc.setCellValueFactory(new PropertyValueFactory<>("NomSucc"));
         Date_de_creation.setCellValueFactory(new PropertyValueFactory<>("Date_de_creation"));
         Lieu.setCellValueFactory(new PropertyValueFactory<>("Lieu"));
         Site_internet.setCellValueFactory(new PropertyValueFactory<>("Site_internet"));
         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));

         Succursale.setItems(data);

        }
    }

    public void permUser(){
        if(ControllerConnexion.currentLog.getRole().equals("Utilisateur")){
            BoutonAjoutSucc.setVisible(false);
            BoutonModifSucc.setVisible(false);
            BoutonSuppSucc.setVisible(false);
        }
    }


    public void ActionReinitialiseSucc(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


