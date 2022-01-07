package FXML;


import SQLQueries.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ControllerModifSucc implements Initializable {


    @FXML private Button ValiderSuccModif ;
    @FXML private TextField DateSuccModif ;
    @FXML private TextField LieuSuccModif ;
    @FXML private TextField idSuccModif ;
    @FXML private TextField NomSuccModif ;
    @FXML private TextField SiteSuccModif ;
    @FXML private TableView Succursale ;
    @FXML private Button OkSuccModif ;
    @FXML private TextField idEntrSuccModif;
    @FXML private Button ViderSuccModif;

    private Connection con ;
    private DAO test= new DAO(con);








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderSuccModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE succursales SET NomSucc='"+NomSuccModif.getText()+" ',Date_de_creation='"+DateSuccModif.getText()+" ',Lieu='"+LieuSuccModif.getText()+" ',Site_internet='"+SiteSuccModif.getText()+" ',idEntreprise='"+idEntrSuccModif.getText()+" ' WHERE idSuccursale='"+idSuccModif.getText()+"'";

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
            String SQL = "SELECT * FROM succursales WHERE idSuccursale =" + Integer.parseInt(idSuccModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                DateSuccModif.setText(rs.getString("Date_de_creation"));
                LieuSuccModif.setText(rs.getString("Lieu"));
                NomSuccModif.setText(rs.getString("NomSucc"));
                SiteSuccModif.setText(rs.getString("Site_internet"));
                idEntrSuccModif.setText(rs.getString("idEntreprise"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        idSuccModif.setText("");
        DateSuccModif.setText("");
        LieuSuccModif.setText("");
        NomSuccModif.setText("");
        SiteSuccModif.setText("");
        idEntrSuccModif.setText("");

    }
}

