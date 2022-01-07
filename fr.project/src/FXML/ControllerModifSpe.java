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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ControllerModifSpe implements Initializable {


    @FXML private Button ValiderSpeModif ;
    @FXML private TextField idSpeModif ;
    @FXML private Button ViderSpeModif ;
    @FXML private TextField TechSpeModif ;
    @FXML private Button OkSpeModif;


    private Connection con ;
    private DAO test= new DAO(con);








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModifSpe(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderSpeModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE specialite SET Technologie='"+TechSpeModif.getText()+" ' WHERE idSpecialite='"+idSpeModif.getText()+"'";

            Statement st = con.createStatement();
            st.executeUpdate(SQL);


        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.close() ;
    }

    public void OkModifAction(ActionEvent actionEvent) {



        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM specialite WHERE idSpecialite =" + Integer.parseInt(idSpeModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                TechSpeModif.setText(rs.getString("Technologie"));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModifSpe(ActionEvent actionEvent) {
        idSpeModif.setText("");
        TechSpeModif.setText("");


    }
}

