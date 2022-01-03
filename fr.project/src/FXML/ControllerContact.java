package FXML;

import CRUDExemple.SingleConnection;
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
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerContact implements Initializable {

    @FXML public Button ModifierContact;
    @FXML public Button SupprimerContact;
    @FXML public Button AjouterContact;
    @FXML public Button RechargerContact;
    @FXML public TableView <Contact> Contact;
    @FXML private TableColumn <Contact ,Integer> idContact;
    @FXML private TableColumn <Contact,String> LinkeedIn;
    @FXML private TableColumn <Contact,String> Telephone;
    @FXML private TableColumn <Contact,String> Mail;
    @FXML private TableColumn <Contact,String> Fonction;
    @FXML private TableColumn <Contact, Integer> idPersonne ;
    @FXML private ComboBox <String> FiltreTable;
    @FXML private ComboBox <String> FiltresAttribut;
    @FXML private Button Changer;
    @FXML private TextField rechercheContact;

    private ObservableList <Contact> data = FXCollections.observableArrayList() ;

    private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;




    public void AffichageDonnés () {

        try {
            this.con = SingleConnection.getInstance(urlb,password,login);
            String SQL = "SELECT * FROM contact";
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();


            while (rs.next()){
                data.add(new Contact(rs.getInt("idContact"),rs.getString("Fonction"),
                        rs.getString("Mail"),rs.getString("Telephone"),
                        rs.getString("LinkeedIn") ,rs.getInt("idPersonne")));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        // AJout données dans la BDD
        idContact.setCellValueFactory(new PropertyValueFactory<>("idContact"));
        Fonction.setCellValueFactory(new PropertyValueFactory<>("Fonction"));
        Mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
        Telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        LinkeedIn.setCellValueFactory(new PropertyValueFactory<>("LinkeedIn"));
        idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

        Contact.setItems(data);
    }

        public void FiltreTableComboBox() {

            ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succurrsales","recherche Taxes d'apprentissages" ) ;

        FiltreTable.setItems(FiltreTableList);

    }

    public void FiltresAttributComboBox() {

        ObservableList<String> FiltreAttributsList = FXCollections.observableArrayList("idContact" ,
                "Fonction" , "Mail" , "Telephone" , "LinkeedIn" ,"idPersonne" ) ;

        FiltresAttribut.setItems(FiltreAttributsList);

    }

    public String getURL () {
String url = FiltreTable.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    public String getAttribut() {
        String attr =FiltresAttribut.getSelectionModel().getSelectedItem().toString();
        return attr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       this.FiltreTableComboBox();
       this.AffichageDonnés();
       this.FiltresAttributComboBox();

        }





    public void ActionChanger(ActionEvent actionEvent) {

        Stage stage = (Stage) Changer.getScene().getWindow();

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

    public void ActionAjouter(ActionEvent actionEvent) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterContact.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Ajouter un Contact");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void ActionSupprimer(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Supprimez Contact.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Supprimer un Contact");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public void ActionRecharger(ActionEvent actionEvent) {


        Stage stage = (Stage) RechargerContact.getScene().getWindow();

        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Contact.fxml"));
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


    public void ActionModifier(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modifier Contact.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Modifier le Contact");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void ActionRechercher(ActionEvent actionEvent) {

    data.removeAll(data);

     if ( FiltresAttribut.getSelectionModel().getSelectedItem() == "idContact" || FiltresAttribut.getSelectionModel().getSelectedItem() == "idPersonne" ) {
         try {
             this.con = SingleConnection.getInstance(urlb, password, login);
             String SQL = "SELECT * FROM contact WHERE `"+this.getAttribut()+"`='"+Integer.parseInt(rechercheContact.getText())+"'";
             PreparedStatement st = con.prepareStatement(SQL);
             ResultSet rs = st.executeQuery();


             while (rs.next()){
                 data.add(new Contact(rs.getInt("idContact"),rs.getString("Fonction"),
                         rs.getString("Mail"),rs.getString("Telephone"),
                         rs.getString("LinkeedIn") ,rs.getInt("idPersonne")));

             }

         }
         catch (Exception e){
             e.printStackTrace();
         }

         // AJout données dans la BDD
         idContact.setCellValueFactory(new PropertyValueFactory<>("idContact"));
         Fonction.setCellValueFactory(new PropertyValueFactory<>("Fonction"));
         Mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
         Telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
         LinkeedIn.setCellValueFactory(new PropertyValueFactory<>("LinkeedIn"));
         idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Contact.setItems(data);

}
    else{
            try {
                this.con = SingleConnection.getInstance(urlb, password, login);
                String SQL = "SELECT * FROM contact WHERE `"+this.getAttribut()+"`='"+rechercheContact.getText()+"'";
                PreparedStatement st = con.prepareStatement(SQL);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                    data.add(new Contact(rs.getInt("idContact"),rs.getString("Fonction"),
                            rs.getString("Mail"),rs.getString("Telephone"),
                            rs.getString("LinkeedIn") ,rs.getInt("idPersonne")));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }
         // AJout données dans la BDD
         idContact.setCellValueFactory(new PropertyValueFactory<>("idContact"));
         Fonction.setCellValueFactory(new PropertyValueFactory<>("Fonction"));
         Mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));
         Telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
         LinkeedIn.setCellValueFactory(new PropertyValueFactory<>("LinkeedIn"));
         idPersonne.setCellValueFactory(new PropertyValueFactory<>("idPersonne"));

         Contact.setItems(data);

        }
    }


    public void ActionReinitialiser(ActionEvent actionEvent) {

        data.removeAll(data);

        this.AffichageDonnés();
    }
}


