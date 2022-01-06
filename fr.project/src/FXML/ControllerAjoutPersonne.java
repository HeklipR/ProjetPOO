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

public class ControllerAjoutPersonne implements Initializable {

@FXML private Button ValiderPers ;
@FXML private TextField NomPers;
@FXML private TextField PrenomPers;
@FXML private TextField AgePers;
@FXML private TextField idEntrPers;



    private Connection con ;
    private DAO test= new DAO(con);



    public void ActionValidaxPers(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderPers.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "INSERT INTO personne ( nom, prenom, age, idEntreprise )" +
                    "VALUES ('"+NomPers.getText()+" ','"+PrenomPers.getText()+" ','"+AgePers.getText()+" ','"+idEntrPers.getText()+"')";

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
