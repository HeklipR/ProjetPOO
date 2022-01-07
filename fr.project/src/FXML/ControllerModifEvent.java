package FXML;


import SQLQueries.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ControllerModifEvent implements Initializable {


    @FXML private Button  ValiderEntrModif;
    @FXML private TextField LieuEventModif ;
    @FXML private TextField  PresenceEventModif;
    @FXML private TextField  idEventModif;
    @FXML private TextField TypeEventModif ;
    @FXML private Button OkEventModif ;
    @FXML private Button ViderEntrModif ;


    private Connection con ;
    private DAO test= new DAO(con);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderEntrModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE event SET Type='"+TypeEventModif.getText()+"', Lieu='"+LieuEventModif.getText()+" ',Presence='"+PresenceEventModif.getText()+" ' WHERE idEvent='"+idEventModif.getText()+"'";

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
            String SQL = "SELECT * FROM event WHERE idEvent =" + Integer.parseInt(idEventModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                TypeEventModif.setText(rs.getString("Type"));
                LieuEventModif.setText(rs.getString("Lieu"));
                PresenceEventModif.setText(rs.getString("Presence"));


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
        TypeEventModif.setText("");
        LieuEventModif.setText("");
        idEventModif.setText("");
        PresenceEventModif.setText("");


    }
}

