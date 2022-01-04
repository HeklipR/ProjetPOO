package FXML;

import CRUDExemple.SingleConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControlllerAjoutAE implements Initializable {

@FXML private Button ValiderContact ;
@FXML private TextField FonctionContact;
@FXML private TextField MailContact;
@FXML private TextField TelephoneContact;
@FXML private TextField LinkContact;
@FXML private TextField idPersContact;


    private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;



    public void ActionValidax(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderContact.getScene().getWindow();
        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "INSERT INTO Contact (Fonction ,Mail , Telephone, LinkeedIn , idPersonne )" +
                    "VALUES ('"+FonctionContact.getText()+" ','"+MailContact.getText()+" ','"+TelephoneContact.getText()+" ','"+LinkContact.getText()+" ','"+idPersContact.getText()+"')";

            Statement st = con.createStatement();
             st.executeUpdate(SQL);


        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
