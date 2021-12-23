import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainConnexion extends Application {

    public static void main (String[] args ) {

        Application.launch() ;

    }

    public void start (Stage stage) throws Exception {

        BorderPane root =
                FXMLLoader.load(getClass().getResource("Interface Connexion.fxml")) ;
    }
}
