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

public class ControllerEntreprise implements Initializable {

    //Tout le FXML
    @FXML public Button BoutonRechercheEntr ;
    @FXML public Button BoutonAjoutEntr ;
    @FXML public Button BoutonChangeEntr ;
    @FXML private Button BoutonSuppEntr ;
    @FXML private Button BoutonModifEntr ;
    @FXML private Button BoutonRechargeEntr ;
    @FXML private Button BoutonReinitialiserEntr ;
    @FXML private TableView <Entreprise> Entreprise;
    @FXML private TableColumn <Entreprise ,Integer> idEntreprise;
    @FXML private TableColumn <Entreprise,String> NomEntrep;
    @FXML private TableColumn <Entreprise,String> Raison_sociale;
    @FXML private TableColumn <Entreprise,String> Denomination;
    @FXML private TableColumn <Entreprise,String> Adresse_du_siege;
    @FXML private TableColumn <Entreprise, String> Secteur_d_activite ;
    @FXML private TableColumn <Entreprise,String> Date_de_creation;
    @FXML private TableColumn <Entreprise, String> Site_internet ;
    @FXML private ComboBox <String> FiltreTableEntr ;
    @FXML private ComboBox <String> FiltreAttributEntr;
    @FXML private TextField RechercheEntr;

    // Liste permettant l'affichage dans le Table View
    private ObservableList <Entreprise> data = FXCollections.observableArrayList() ;

    // Connexion
    private Connection con ;
    private DAO test= new DAO(con);




    public void AffichageDonnés () {

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM entreprise";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Entreprise(rs.getInt("idEntreprise"),rs.getString("NomEntrep"),
                        rs.getString("Raison_sociale"),rs.getString("Denomination"),
                        rs.getString("Adresse_du_siege") ,rs.getString("Secteurs_d_activite"),
                        rs.getString("Date_de_creation") ,rs.getString("Site_internet")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));
        NomEntrep.setCellValueFactory(new PropertyValueFactory<>("NomEntrep"));
        Raison_sociale.setCellValueFactory(new PropertyValueFactory<>("Raison_sociale"));
        Denomination.setCellValueFactory(new PropertyValueFactory<>("Denomination"));
        Adresse_du_siege.setCellValueFactory(new PropertyValueFactory<>("Adresse_du_siege"));
        Secteur_d_activite.setCellValueFactory(new PropertyValueFactory<>("Secteurs_d_activite"));
        Date_de_creation.setCellValueFactory(new PropertyValueFactory<>("Date_de_creation"));
        Site_internet.setCellValueFactory(new PropertyValueFactory<>("Site_internet"));

        Entreprise.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Contact" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succursales","recherche Taxes d'apprentissages" ) ;

            FiltreTableEntr.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idEntreprise" ,
                "NomEntrep" , "Raison_sociale" , "Denomination" , "Adresse_du_siege" ,"Secteurs_d_activite","Date_de_creation","Site_internet" ) ;

        FiltreAttributEntr.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTableEntr.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltreAttributEntr.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();
       this.permUser();

        }





    public void ActionChangeEntr(ActionEvent actionEvent) {

        Stage stage = (Stage) BoutonChangeEntr.getScene().getWindow();

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

    public void ActionAjoutEntr(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterEntreprise.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter une Entreprise");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSuppEntr(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Entreprise.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer une Entreprise");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRechargeEntr(ActionEvent actionEvent) {


        Stage stage = (Stage) BoutonRechargeEntr.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Entreprise.fxml"));
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


    public void ActionModifEntr(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Entrprise.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier une Entreprise");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercheEntr(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltreAttributEntr.getSelectionModel().getSelectedItem() == "idEntreprise" ) {
         try {
             test.Instance();
             this.con=test.getCon();
             String SQL = "SELECT * FROM entreprise WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(RechercheEntr.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Entreprise(rs.getInt("idEntreprise"),rs.getString("NomEntrep"),
                         rs.getString("Raison_sociale"),rs.getString("Denomination"),
                         rs.getString("Adresse_du_siege") ,rs.getString("Secteurs_d_activite"),
                         rs.getString("Date_de_creation") ,rs.getString("Site_internet")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));
         NomEntrep.setCellValueFactory(new PropertyValueFactory<>("NomEntrep"));
         Raison_sociale.setCellValueFactory(new PropertyValueFactory<>("Raison_sociale"));
         Denomination.setCellValueFactory(new PropertyValueFactory<>("Denomination"));
         Adresse_du_siege.setCellValueFactory(new PropertyValueFactory<>("Adresse_du_siege"));
         Secteur_d_activite.setCellValueFactory(new PropertyValueFactory<>("Secteurs_d_activite"));
         Date_de_creation.setCellValueFactory(new PropertyValueFactory<>("Date_de_creation"));
         Site_internet.setCellValueFactory(new PropertyValueFactory<>("Site_internet"));

         Entreprise.setItems(data);

}
    else{
            try {
                test.Instance();
                this.con=test.getCon();
                String SQL = "SELECT * FROM entreprise WHERE `"+this.getAttribut()+"`='"+RechercheEntr.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                    data.add(new Entreprise(rs.getInt("idEntreprise"),rs.getString("NomEntrep"),
                            rs.getString("Raison_sociale"),rs.getString("Denomination"),
                            rs.getString("Adresse_du_siege") ,rs.getString("Secteurs_d_activite"),
                            rs.getString("Date_de_creation") ,rs.getString("Site_internet")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

         idEntreprise.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));
         NomEntrep.setCellValueFactory(new PropertyValueFactory<>("NomEntrep"));
         Raison_sociale.setCellValueFactory(new PropertyValueFactory<>("Raison_sociale"));
         Denomination.setCellValueFactory(new PropertyValueFactory<>("Denomination"));
         Adresse_du_siege.setCellValueFactory(new PropertyValueFactory<>("Adresse_du_siege"));
         Secteur_d_activite.setCellValueFactory(new PropertyValueFactory<>("Secteurs_d_activite"));
         Date_de_creation.setCellValueFactory(new PropertyValueFactory<>("Date_de_creation"));
         Site_internet.setCellValueFactory(new PropertyValueFactory<>("Site_internet"));

         Entreprise.setItems(data);

        }
    }
    public void permUser(){
        if(ControllerConnexion.currentLog.getRole().equals("Utilisateur")){
            BoutonAjoutEntr.setVisible(false);
            BoutonModifEntr.setVisible(false);
            BoutonSuppEntr.setVisible(false);
        }
    }


    public void ActionReinitialiserEntr(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }



}


