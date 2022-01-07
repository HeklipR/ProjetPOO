package FXML;


import SQLQueries.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;


public class ControllerModifAE implements Initializable {


    @FXML private Button ValiderAEModif ;
    @FXML private Button ViderAEModif ;
    @FXML private TextField niveauetuAEModif ;
    @FXML private TextField DureeAEModif ;
    @FXML private TextField idPersAEModif ;
    @FXML private TextField anneeAEModif ;
    @FXML private TextField ContratAEModif ;
    @FXML private TextField NomAEModif ;
    @FXML private TextField idAEModif ;
    @FXML private Button OkAEModif ;
    @FXML private TextField idModif;
    @FXML private TableView <AncienEtudiants> Ancien_Etudiant;
    @FXML private TableColumn<AncienEtudiants ,Integer> idAncienEtudiant;
    @FXML private TableColumn <AncienEtudiants,String> Niveau_etudes;
    @FXML private TableColumn <AncienEtudiants, Date> AnneeEtudiant;
    @FXML private TableColumn <AncienEtudiants,String> Type_de_contrat_de_travail;
    @FXML private TableColumn <AncienEtudiants, Timestamp> Duree;
    @FXML private TableColumn <AncienEtudiants,String> Nom ;
    @FXML private TableColumn <AncienEtudiants,Integer> idPersAE ;

    private Connection con ;
    private DAO test= new DAO(con);








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }



    public void ActionValidaxModif(ActionEvent actionEvent) {

        Stage stage = (Stage) ValiderAEModif.getScene().getWindow();

        try {
            test.Instance();
            this.con=test.getCon();
            String SQL = "UPDATE ancien_etudiants SET Niveau_etudes='"+niveauetuAEModif.getText()+"', Annee='"+anneeAEModif.getText()+" ',Type_de_contrat_de_travail='"+ContratAEModif.getText()+" ',Nom='"+NomAEModif.getText()+" ',Duree='"+DureeAEModif.getText()+" ',idPersonne='"+idPersAEModif.getText()+" 'WHERE idAncienEtudiant='"+idAEModif.getText()+"'";

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
            String SQL = "SELECT * FROM ancien_etudiants WHERE idAncienEtudiant="+ Integer.parseInt(idAEModif.getText());
            PreparedStatement st =  con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();

            while (rs.next()){


                idAEModif.setText(rs.getString("idAncienEtudiant"));
                niveauetuAEModif.setText(rs.getString("Niveau_etudes"));
                anneeAEModif.setText(rs.getString("Annee"));
                ContratAEModif.setText(rs.getString("Type_de_contrat_de_travail"));
                DureeAEModif.setText(rs.getString("Duree"));
                NomAEModif.setText(rs.getString("Nom"));
                idPersAEModif.setText(rs.getString("idPersonne"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ActionViderModif(ActionEvent actionEvent) {
        idAEModif.setText("");
        niveauetuAEModif.setText("");
        anneeAEModif.setText("");
        ContratAEModif.setText("");
        DureeAEModif.setText("");
        NomAEModif.setText("");
        idPersAEModif.setText("");

    }
}

