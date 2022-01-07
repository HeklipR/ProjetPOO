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

public class ControllerAjoutSucc implements Initializable {

@FXML private Button ValiderSucc ;
@FXML private TextField NomSucc;
@FXML private TextField DateCreateSucc;
@FXML private TextField LieuSucc;
@FXML private TextField SiteSucc;
@FXML private TextField idEntrSucc;


    private Connection con ;
    private DAO test= new DAO(con);



    public void ActionValidax(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderSucc.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "INSERT INTO succursales (NomSucc , Date_de_creation, Lieu , Site_internet, idEntreprise )" +
                    "VALUES ('"+NomSucc.getText()+" ','"+DateCreateSucc.getText()+" ','"+LieuSucc.getText()+" ','"+SiteSucc.getText()+" ','"+idEntrSucc.getText()+"')";

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
