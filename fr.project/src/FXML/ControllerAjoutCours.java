package FXML;


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

public class ControllerAjoutCours implements Initializable {

@FXML private Button ValiderCours ;
@FXML private TextField MatièreCours;
@FXML private TextField FilièreCours;
@FXML private TextField AnnéeCours;



    private Connection con ;
    private DAO test= new DAO(con);


    public void ActionValidaxCour(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderCours.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "INSERT INTO cours (matiere ,filiere ,annee)" +
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
