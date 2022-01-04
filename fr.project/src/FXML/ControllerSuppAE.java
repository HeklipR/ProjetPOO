package FXML;

import CRUDExemple.SingleConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerSuppAE implements Initializable {
    @FXML
    public TableView<Contact> Contact;
    public TextField idSupp ;
    public Button OkSupp ;
    private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void OkSuppAction(ActionEvent actionEvent) {

        Stage stage = (Stage) OkSupp.getScene().getWindow();

        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "DELETE FROM contact WHERE idContact =" + Integer.parseInt(idSupp.getText());

            Statement st = con.createStatement();
            st.executeUpdate(SQL);


        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.close() ;
    }
}
