package FXML;

import CRUDExemple.SingleConnection;
import SQLQueries.DAO;
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

public class ControllerAjoutStag implements Initializable {

@FXML private Button ValiderStagiaire ;
@FXML private TextField NomStagiaire;
@FXML private TextField NivEtdudeStag;
@FXML private TextField AnneeStagiaire;
@FXML private TextField DureeStagiaire;
@FXML private TextField idPersStag ;


    private Connection con ;
    private DAO test= new DAO(con);



    public void ActionValidax(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderStagiaire.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "INSERT INTO stagiaire (Niveau_etudes, annee,  Duree, Nom, idPersonne )" +
                    "VALUES ('"+NivEtdudeStag.getText()+" ','"+AnneeStagiaire.getText()+" ','"+DureeStagiaire.getText()+" ','"+NomStagiaire.getText()+" ','"+idPersStag.getText()+"')";

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
