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

public class ControllerAjoutTaxe implements Initializable {

@FXML private Button ValiderTax ;
@FXML private TextField DateTaxe;
@FXML private TextField SommeTaxe;
@FXML private TextField CommTaxe;
@FXML private TextField idEntrTaxe;



    private Connection con ;
    private DAO test= new DAO(con);



    public void ActionValidax(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderTax.getScene().getWindow();
        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "INSERT INTO taxe_apprentissage ( date , somme, commentaire , idEntreprise )" +
                    "VALUES ('"+DateTaxe.getText()+" ','"+SommeTaxe.getText()+" ','"+CommTaxe.getText()+" ','"+idEntrTaxe.getText()+"')";

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
