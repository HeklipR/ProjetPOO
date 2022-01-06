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

public class ControllerAjoutEvent implements Initializable {

@FXML private Button  ValiderEvent;
@FXML private TextField TypeEvent;
@FXML private TextField LieuEvent;
@FXML private TextField PresenceEvent;



    private Connection con ;
    private DAO test= new DAO(con);


    public void ActionValidaxEvent(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderEvent.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "INSERT INTO event (Type , Lieu, Presence)" +
                    "VALUES ('"+TypeEvent.getText()+" ','"+LieuEvent.getText()+" ','"+PresenceEvent.getText()+"')";

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
