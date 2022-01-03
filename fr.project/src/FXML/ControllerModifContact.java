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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ControllerModifContact implements Initializable {


    @FXML private Button ValiderContactModif ;
    @FXML private TextField FonctionContactModif ;
    @FXML private TextField MailContactModif ;
    @FXML private TextField TelephoneContactModif ;
    @FXML private TextField LinkContactModif ;
    @FXML private TextField idPersContactModif ;
    @FXML private TableView Contact ;
    @FXML private Button OkModif ;
    @FXML private TextField idModif;

private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
private final String login="root";
private final String password="root";
private Connection con;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderContactModif.getScene().getWindow();

        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "UPDATE contact SET Fonction='"+FonctionContactModif.getText()+"', Mail='"+MailContactModif.getText()+" ',Telephone='"+TelephoneContactModif.getText()+" ',LinkeedIn='"+LinkContactModif.getText()+" ',idPersonne='"+idPersContactModif.getText()+"' ";

            Statement st = con.createStatement();
            st.executeUpdate(SQL);


        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.close() ;
    }

    public void OkModifAction(ActionEvent actionEvent) {



        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "SELECT * FROM contact WHERE idContact =" + Integer.parseInt(idModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                FonctionContactModif.setText(rs.getString("Fonction"));
                MailContactModif.setText(rs.getString("Mail"));
                TelephoneContactModif.setText(rs.getString("Telephone"));
                LinkContactModif.setText(rs.getString("LinkeedIn"));
                idPersContactModif.setText(rs.getString("idPersonne"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        idModif.setText("");
        FonctionContactModif.setText("");
        MailContactModif.setText("");
        TelephoneContactModif.setText("");
        LinkContactModif.setText("");
        idPersContactModif.setText("");

    }
}

