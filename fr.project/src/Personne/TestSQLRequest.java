package Personne;

import java.sql.*;

public class TestSQLRequest {

    // Class de Test de requête SQL

    private final String url="jdbc:mysql://localhost:8889/projetbdd?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;
    private Statement test;


    public TestSQLRequest() throws SQLException, ClassNotFoundException {
        this.con = SQLQueries.BDDConexion.SQLBridge(url,password,login);
    }


    public void PrintSQLTest(String tesct) throws SQLException {


        String rqt1 = "SELECT idEntreprise FROM ? WHERE idEntreprise = 1" ;

        PreparedStatement test = this.con.prepareStatement(rqt1);

       test.setString(1, tesct);



        ResultSet res = test.executeQuery();
        res.next();
        System.out.println(res.next());
    }

    /*
    String rqt1 = "SELECT * FROM employes WHERE id = ?" ;
        PreparedStatement test = this.con.prepareStatement(rqt1);
        test.setString(1, id);
        ResultSet res = test.executeQuery();
        res.next();
        */
}
