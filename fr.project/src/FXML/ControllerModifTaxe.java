package FXML;

import CRUDExemple.SingleConnection;
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


public class ControllerModifTaxe implements Initializable {


    @FXML private Button ValiderTaxeModif ;
    @FXML private TextField SommeTaxeModif ;
    @FXML private TextField CommTaxeModif ;
    @FXML private TextField idTaxeModif ;
    @FXML private TextField DateTaxeModif ;
    @FXML private TextField idEntrTaxeModif ;
    @FXML private TableView Taxe ;
    @FXML private Button OkTaxeModif ;
    @FXML private Button ViderTaxeModif;


    private Connection con ;
    private DAO test= new DAO(con);








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderTaxeModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE taxe_apprentissage SET date='"+DateTaxeModif.getText()+"', somme='"+SommeTaxeModif.getText()+" ',commentaire='"+CommTaxeModif.getText()+" ',idEntreprise='"+idEntrTaxeModif.getText()+"' WHERE idTaxe='"+idTaxeModif.getText()+"'";

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
            String SQL = "SELECT * FROM taxe_apprentissage WHERE idTaxe =" + Integer.parseInt(idTaxeModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                SommeTaxeModif.setText(rs.getString("somme"));
                CommTaxeModif.setText(rs.getString("commentaire"));
                DateTaxeModif.setText(rs.getString("date"));
                idEntrTaxeModif.setText(rs.getString("idEntreprise"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        idTaxeModif.setText("");
        SommeTaxeModif.setText("");
        CommTaxeModif.setText("");
        DateTaxeModif.setText("");
        idEntrTaxeModif.setText("");

    }
}

