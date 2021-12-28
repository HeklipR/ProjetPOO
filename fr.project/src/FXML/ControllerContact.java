package FXML;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerContact implements Initializable {

    @FXML private ComboBox<String> FiltreTable;
    @FXML private Button Changer;


    public String getURL () {
String url = FiltreTable.getSelectionModel().getSelectedItem().toString();
String URL = url +".fxml" ;
return URL ;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> FiltreTableList = FXCollections.observableArrayList("recherche Event" ,
                "recherche Ancien Etudiant" , "recherche Conferences" , "recherche Cours"
                ,"recherche Entreprise" ,"recherche Personne" ,"recherche Specialité","recherche Stagiaire","recherche Succurrsales","recherche Taxes d'apprentissages" ) ;

        FiltreTable.setItems(FiltreTableList);
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

    public void ActionAjouter(ActionEvent actionEvent) {
    }

    public void ActionSupprimer(ActionEvent actionEvent) {
    }

    public void ActionModifier(ActionEvent actionEvent) {
    }

    public void ActionRecharger(ActionEvent actionEvent) {
    }
}

