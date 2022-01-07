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


public class ControllerModifCours implements Initializable {


    @FXML private Button ValiderCourModif ;
    @FXML private TextField  MatiereCourModif;
    @FXML private TextField FiliereCourModif ;
    @FXML private TextField  AnneeCourfModif;
    @FXML private TextField idCourModif ;
    @FXML private TableView Cours ;
    @FXML private Button OkCourModif ;
    @FXML private Button ViderCourModif;


    private Connection con ;
    private DAO test= new DAO(con);








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModifCour(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderCourModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE cours SET matiere='"+MatiereCourModif.getText()+"', filiere='"+FiliereCourModif.getText()+" ',annee='"+AnneeCourfModif.getText()+"' WHERE idCours='"+idCourModif.getText()+"'";

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

    public void OkModifActionCour(ActionEvent actionEvent) {



        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "SELECT * FROM cours WHERE idCours =" + Integer.parseInt(idCourModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                MatiereCourModif.setText(rs.getString("matiere"));
                FiliereCourModif.setText(rs.getString("filiere"));
                AnneeCourfModif.setText(rs.getString("annee"));


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
        idCourModif.setText("");
        MatiereCourModif.setText("");
        FiliereCourModif.setText("");
        AnneeCourfModif.setText("");


    }
}

