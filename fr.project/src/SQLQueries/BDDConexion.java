package SQLQueries;

import CRUD.SingleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDConexion {

    // Variable de Connection
    private static Connection con;


    //Constructeur pour la class BDDConexion
    private BDDConexion(String url, String password, String login) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, login, password);
        System.out.println("Connexion test");
    }


    // Fonction publique permettant aux autres classes de pouvoir ce connecter à la BDD
    public static Connection SQLBridge(String url, String password, String login) throws ClassNotFoundException, SQLException{
        if(con == null){
            new BDDConexion(url, password, login);
        }
        return con;
    }

}
