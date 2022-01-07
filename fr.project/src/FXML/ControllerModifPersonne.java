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


public class ControllerModifPersonne implements Initializable {


    @FXML private Button ValiderPersModif ;
    @FXML private Button OkPersModif  ;
    @FXML private Button ViderPersModif ;
    @FXML private TextField PrenomPersModif ;
    @FXML private TextField AgePersModif ;
    @FXML private TextField  idPersModif;
    @FXML private TextField NomPersModif ;
    @FXML private TextField  idEntrPersModif ;
    @FXML private TableView Personne ;


    private Connection con ;
    private DAO test= new DAO(con);








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderPersModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE personne SET nom='"+NomPersModif.getText()+"', prenom='"+PrenomPersModif.getText()+" ',age='"+AgePersModif.getText()+" ',idEntreprise='"+idEntrPersModif.getText()+" ' WHERE idPersonne='"+idPersModif.getText()+"'";

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
            String SQL = "SELECT * FROM personne WHERE idPersonne =" + Integer.parseInt(idPersModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){

                PrenomPersModif.setText(rs.getString("prenom"));
                AgePersModif.setText(rs.getString("age"));
                NomPersModif.setText(rs.getString("nom"));
                idEntrPersModif.setText(rs.getString("idEntreprise"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        PrenomPersModif.setText("");
        AgePersModif.setText("");
        idPersModif.setText("");
        NomPersModif.setText("");
        idEntrPersModif.setText("");

    }
}

