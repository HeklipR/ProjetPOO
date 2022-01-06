package FXML;

import Login.Login;
import SQLQueries.DAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerConnexion {

    @FXML private Button Connexion ;
    @FXML private TextField Identifiant ;
    @FXML private TextField Mdp ;
    private Connection con;
    private DAO test = new DAO(con);
    public static Login currentLog = new Login("","","");


    public void ActionConnexion(ActionEvent actionEvent) throws SQLException, IOException, ClassNotFoundException {

        if(Identifiant.getText().isBlank() == false && Mdp.getText().isBlank() == false){
            loginValidation();

        }
    }


    public void loginValidation() throws SQLException, IOException, ClassNotFoundException {

        test.Instance();
        this.con = test.getCon();

        String verifyLogin = "SELECT count(1) FROM compte WHERE Identifiant = '"+ Identifiant.getText() +"' AND Mdp = '"+ Mdp.getText() +"'";
        String getRole = "SELECT Role FROM compte WHERE Identifiant = '" + Identifiant.getText() + "'";

        try{
            Statement statement = con.createStatement();
            ResultSet querryResult = statement.executeQuery(verifyLogin);

            while (querryResult.next()) {
                if(querryResult.getInt(1) == 1){
                    try{
                        ResultSet checkRole = statement.executeQuery(getRole);
                        while (checkRole.next()){
                            currentLog.setLogin(Identifiant.getText());
                            currentLog.setRole(checkRole.getString(1));
                            currentLog.setPassword(Mdp.getText());

                            Stage stage = (Stage) Connexion.getScene().getWindow();

                            stage.close();

                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recherche Entreprise.fxml"));
                            Parent root1 = null;
                            try {
                                root1 = (Parent) fxmlLoader.load();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            stage.setScene(new Scene(root1));
                            stage.show();

                            System.out.println(currentLog.getRole());

                        }

                    }catch (Exception c){
                        c.printStackTrace();
                    }


                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur de connexion");
                    alert.setContentText("Impossible de ce connecter vérifier votre nom d'utilisateur et mot de passe.");
                    alert.showAndWait();
                }

            }

        }catch (Exception e){

        }


    }


}

