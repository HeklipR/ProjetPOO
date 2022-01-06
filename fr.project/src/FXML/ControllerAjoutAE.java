package FXML;

import CRUDExemple.SingleConnection;
import SQLQueries.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
@FXML public Button BoutonRechargeAE;

    private Connection con ;
    private DAO test= new DAO(con);



    public void ActionValidaxAE(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderAncienEtudiant.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
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
