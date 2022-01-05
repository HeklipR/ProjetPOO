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

public class ControllerAjoutCours implements Initializable {

@FXML private Button ValiderCours ;
@FXML private TextField MatièreCours;
@FXML private TextField FilièreCours;
@FXML private TextField AnnéeCours;



    private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;



    public void ActionValidax(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderCours.getScene().getWindow();
        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "INSERT INTO Cours (matiere ,filiere ,annee)" +
                    "VALUES ('"+MatièreCours.getText()+" ','"+FilièreCours.getText()+" ','"+AnnéeCours.getText()+"')";

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
