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

public class ControllerAjoutSucc implements Initializable {

@FXML private Button ValiderSucc ;
@FXML private TextField NomSucc;
@FXML private TextField DateCreateSucc;
@FXML private TextField LieuSucc;
@FXML private TextField SiteSucc;
@FXML private TextField idEntrSucc;


    private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;



    public void ActionValidax(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderSucc.getScene().getWindow();
        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "INSERT INTO succursales (NomSucc , Date_de_creation, Lieu , Site_internet, idEntreprise )" +
                    "VALUES ('"+NomSucc.getText()+" ','"+DateCreateSucc.getText()+" ','"+LieuSucc.getText()+" ','"+SiteSucc.getText()+" ','"+idEntrSucc.getText()+"')";

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
