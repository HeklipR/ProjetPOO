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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ControllerModifConf implements Initializable {


    @FXML private Button ValiderConfModif ;
    @FXML private TextField DateConfModif ;
    @FXML private TextField ThemeConfModif ;
    @FXML private TextField PublicConfModif ;
    @FXML private TextField idConfModif ;
    @FXML private TextField DureeConfModif ;
    @FXML private TableView Conference ;
    @FXML private Button OkConfModif ;
    @FXML private Button ViderConfModif;


    private Connection con ;
    private DAO test= new DAO(con);








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderConfModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE conference SET date='"+DateConfModif.getText()+"', theme='"+ThemeConfModif.getText()+" ',publique='"+PublicConfModif.getText()+" ',duree='"+DureeConfModif.getText()+"' WHERE idConference='"+idConfModif.getText()+"'";

            Statement st = con.createStatement();
            st.executeUpdate(SQL);


        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Attention aux erreurs de syntaxes ou bien des id qui n'éxiste pas !");
            alert.showAndWait();
        }
        stage.close() ;
    }

    public void OkModifAction(ActionEvent actionEvent) {



        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM conference WHERE idConference =" + Integer.parseInt(idConfModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                DateConfModif.setText(rs.getString("date"));
                ThemeConfModif.setText(rs.getString("theme"));
                PublicConfModif.setText(rs.getString("publique"));
                DureeConfModif.setText(rs.getString("duree"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText("Attention aux erreurs de syntaxes ou bien des id qui n'éxiste pas !");
            alert.showAndWait();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        idConfModif.setText("");
        DateConfModif.setText("");
        ThemeConfModif.setText("");
        PublicConfModif.setText("");
        DureeConfModif.setText("");


    }
}

