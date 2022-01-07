package FXML;


import SQLQueries.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ControllerSuppConf implements Initializable {
    @FXML
    public TableView<Conference> Conference;
    public TextField idSuppConf ;
    public Button OkSuppConf ;

    private Connection con ;
    private DAO test= new DAO(con);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void OkSuppAction(ActionEvent actionEvent) {

        Stage stage = (Stage) OkSuppConf.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "DELETE FROM conference WHERE idConference =" + Integer.parseInt(idSuppConf.getText());

            Statement st = con.createStatement();
            st.executeUpdate(SQL);


        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Id incorrect ou alors vous ne pouvez pas le supprimer !");
            alert.showAndWait();
        }
        stage.close() ;
    }
}
