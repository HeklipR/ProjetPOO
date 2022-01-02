package SQLQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

    private static Connection con;

    private SingleConnection(String url, String password, String login) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, password, login);
        System.out.println("Connexion oui");
    }

    public static Connection getInstance(String url, String password, String login) throws SQLException, ClassNotFoundException{
        if(con == null){
            new SingleConnection(url, login, password);
        }
        return con;
    }



}
