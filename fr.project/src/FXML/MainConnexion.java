package FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MainConnexion extends Application {

    public static void main (String[] args ) {

        Application.launch() ;

    }



    public void start (Stage stage) throws Exception {

      TilePane root =
                FXMLLoader.load(getClass().getResource("Interface Connexion.fxml")) ;
    Scene sc = new Scene ( root, 500 , 400 );
    stage.setScene(sc);
    stage.show();
    }


}
