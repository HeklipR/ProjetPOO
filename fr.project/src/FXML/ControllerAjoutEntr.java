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

public class ControllerAjoutEntr implements Initializable {

@FXML private Button ValiderEntreprise ;
@FXML private TextField NomEntr;
@FXML private TextField RaisonSociale;
@FXML private TextField Dénomination;
@FXML private TextField Adresse;
@FXML private TextField Activites;
@FXML private TextField DateCreation;
@FXML private TextField Site;


    private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;



    public void ActionValidaxEntr(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderEntreprise.getScene().getWindow();
        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "INSERT INTO entreprise ( NomEntrep , Raison_sociale, Denomination , Adresse_du_siege, Secteur_d_activite , Date_de_creation, Site_internet )" +
                    "VALUES ('"+NomEntr.getText()+" ','"+RaisonSociale.getText()+" ','"+Dénomination.getText()+" ','"+Adresse.getText()+" ','"+Activites.getText()+"','"+DateCreation.getText()+" ','"+Site.getText()+"')";

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
