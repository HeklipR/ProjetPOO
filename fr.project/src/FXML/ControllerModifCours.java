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


public class ControllerModifCours implements Initializable {


    @FXML private Button ValiderCourModif ;
    @FXML private TextField  MatiereCourModif;
    @FXML private TextField FiliereCourModif ;
    @FXML private TextField  AnneeCourfModif;
    @FXML private TextField idCourModif ;
    @FXML private TableView Cours ;
    @FXML private Button OkCourModif ;
    @FXML private Button ViderCourModif;


private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
private final String login="root";
private final String password="root";
private Connection con;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModifCour(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderCourModif.getScene().getWindow();

        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "UPDATE cours SET matiere='"+MatiereCourModif.getText()+"', filiere='"+FiliereCourModif.getText()+" ',annee='"+AnneeCourfModif.getText()+"' WHERE idCours='"+idCourModif.getText()+"'";

            Statement st = con.createStatement();
            st.executeUpdate(SQL);


        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.close() ;
    }

    public void OkModifActionCour(ActionEvent actionEvent) {



        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "SELECT * FROM cours WHERE idCours =" + Integer.parseInt(idCourModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                MatiereCourModif.setText(rs.getString("matiere"));
                FiliereCourModif.setText(rs.getString("filiere"));
                AnneeCourfModif.setText(rs.getString("annee"));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        idCourModif.setText("");
        MatiereCourModif.setText("");
        FiliereCourModif.setText("");
        AnneeCourfModif.setText("");


    }
}

