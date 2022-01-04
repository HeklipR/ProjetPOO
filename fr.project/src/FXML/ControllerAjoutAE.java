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

public class ControllerAjoutAE implements Initializable {

@FXML private Button ValiderAncienEtudiant ;
@FXML private TextField NomAncienEtudiant;
@FXML private TextField NiveauEtude;
@FXML private TextField Annee;
@FXML private TextField Duree;
@FXML private TextField TypeContrat;
@FXML private TextField idPersonne;

    private final String urlb="jdbc:mysql://localhost:3306/projet?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;



    public void ActionValidaxAE(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderAncienEtudiant.getScene().getWindow();
        try {
            this.con = SingleConnection.getInstance(urlb, password, login);
            String SQL = "INSERT INTO ancien_etudiants (Niveau_etudes ,Annee , Type_de_contrat_de_travail ,Duree, Nom, idPersonne )" +
                    "VALUES ('"+NiveauEtude.getText()+" ','"+Annee.getText()+" ','"+TypeContrat.getText()+" ','"+Duree.getText()+" ','"+NomAncienEtudiant.getText()+" ','"+idPersonne.getText()+"')";

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
