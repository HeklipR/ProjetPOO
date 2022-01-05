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


public class ControllerModifStag implements Initializable {


    @FXML private Button ValiderStagModif ;
    @FXML private TextField AnneStagModif ;
    @FXML private TextField DureeStagModif ;
    @FXML private TextField idStagModif ;
    @FXML private TextField NivStagModif ;
    @FXML private TextField NomStagModif ;
    @FXML private TableView Stagiaire ;
    @FXML private Button OkStagModif ;
    @FXML private Button ViderStagModif;
    @FXML private TextField idPersStagModif;

private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
private final String login="root";
private final String password="root";
private Connection con;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderStagModif.getScene().getWindow();

        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "UPDATE stagiaire SET Niveau_etudes='"+NivStagModif.getText()+"', annee='"+AnneStagModif.getText()+" ',Duree='"+DureeStagModif.getText()+" ',Nom='"+NomStagModif.getText()+" ',idPersonne='"+idPersStagModif.getText()+"' WHERE idStagiaire='"+idStagModif.getText()+"'";

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
            String SQL = "SELECT * FROM stagiaire WHERE idStagiaire =" + Integer.parseInt(idStagModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                AnneStagModif.setText(rs.getString("annee"));
                DureeStagModif.setText(rs.getString("Duree"));
                NivStagModif.setText(rs.getString("Niveau_etudes"));
                NomStagModif.setText(rs.getString("Nom"));
                idPersStagModif.setText(rs.getString("idPersonne"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        idStagModif.setText("");
        AnneStagModif.setText("");
        DureeStagModif.setText("");
        NivStagModif.setText("");
        NomStagModif.setText("");
        idPersStagModif.setText("");

    }
}

