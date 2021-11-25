package SQLQueries;

import CRUD.SingleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDDConexion {

    private static Connection con;


    private BDDConexion(String url, String password, String login) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, login, password);
        System.out.println("Connexion test");
    }


    public static Connection SQLBridge(String url, String password, String login) throws ClassNotFoundException, SQLException{
        if(con == null){
            new BDDConexion(url, password, login);
        }
        return con;
    }

}
