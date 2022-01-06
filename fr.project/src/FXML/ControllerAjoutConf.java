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

public class ControllerAjoutConf implements Initializable {

@FXML private Button ValiderConf ;
@FXML private TextField DateConf;
@FXML private TextField ThemeConf;
@FXML private TextField PublicConf;
@FXML private TextField DureeConf;



    private Connection con ;
    private DAO test= new DAO(con);



    public void ActionValidaxConf(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderConf.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "INSERT INTO conference (date ,theme , publique, duree)" +
                    "VALUES ('"+DateConf.getText()+" ','"+ThemeConf.getText()+" ','"+PublicConf.getText()+" ','"+DureeConf.getText()+"')";

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
