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


public class ControllerModifPersonne implements Initializable {


    @FXML private Button ValiderPersModif ;
    @FXML private Button OkPersModif  ;
    @FXML private Button ViderPersModif ;
    @FXML private TextField PrenomPersModif ;
    @FXML private TextField AgePersModif ;
    @FXML private TextField  idPersModif;
    @FXML private TextField NomPersModif ;
    @FXML private TextField  idEntrPersModif ;
    @FXML private TableView Personne ;


private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
private final String login="root";
private final String password="root";
private Connection con;








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderPersModif.getScene().getWindow();

        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "UPDATE personne SET nom='"+NomPersModif.getText()+"', prenom='"+PrenomPersModif.getText()+" ',age='"+AgePersModif.getText()+" ',idEntreprise='"+idEntrPersModif.getText()+" ' WHERE idPersonne='"+idPersModif.getText()+"'";

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
            String SQL = "SELECT * FROM personne WHERE idPersonne =" + Integer.parseInt(idPersModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                PrenomPersModif.setText(rs.getString("prenom"));
                AgePersModif.setText(rs.getString("age"));
                NomPersModif.setText(rs.getString("nom"));
                idEntrPersModif.setText(rs.getString("idEntreprise"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        PrenomPersModif.setText("");
        AgePersModif.setText("");
        idPersModif.setText("");
        NomPersModif.setText("");
        idEntrPersModif.setText("");

    }
}

