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


public class ControllerModifSpe implements Initializable {


    @FXML private Button ValiderSpeModif ;
    @FXML private TextField idSpeModif ;
    @FXML private Button ViderSpeModif ;
    @FXML private TextField TechSpeModif ;
    @FXML private Button OkSpeModif;


private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
private final String login="root";
private final String password="root";
private Connection con;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModifSpe(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderSpeModif.getScene().getWindow();

        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "UPDATE specialite SET Technologie='"+TechSpeModif.getText()+" ' WHERE idSpecialite='"+idSpeModif.getText()+"'";

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
            String SQL = "SELECT * FROM specialite WHERE idSpecialite =" + Integer.parseInt(idSpeModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                TechSpeModif.setText(rs.getString("Technologie"));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModifSpe(ActionEvent actionEvent) {
        idSpeModif.setText("");
        TechSpeModif.setText("");


    }
}

