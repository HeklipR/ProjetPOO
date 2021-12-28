package FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerConnexion {

    @FXML private Button Connexion ;
    @FXML private TextField Identifiant ;
    @FXML private TextField Mdp ;


    public void ActionConnexion(ActionEvent actionEvent) {

        Stage stage = (Stage) Connexion.getScene().getWindow();

        stage.close();

              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fichier FXML"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root1));
        stage.show();


    }
}

