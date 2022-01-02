package SQLQueries;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DAO {

    private String url;
    private String login;
    private String password;
    private String dbName;
    private String port;
    private Connection con;
    private Statement test;

    public DAO() throws SQLException, ClassNotFoundException, IOException {

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Path.of("./bdd.json"));
        Map<?, ?> map = gson.fromJson(reader, Map.class);

        for(Map.Entry<?,?> parseValue : map.entrySet()){
            if(parseValue.getKey().equals("url")){
                url = (String) parseValue.getValue();
            }else if(parseValue.getKey().equals("password")){
                password = (String) parseValue.getValue();
            }else if(parseValue.getKey().equals("dbName")){
                dbName = (String) parseValue.getValue();
            }else if (parseValue.getKey().equals("login")){
                login = (String) parseValue.getValue();
            }else if (parseValue.getKey().equals("port")){
                port = (String) parseValue.getValue();
            }
        }

        this.con = SingleConnection.getInstance("jdbc:mysql://" + url + ":" + port + "/" + dbName + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",password,login);

    }




    public void Delete(String tableName, String idName, String idNumber) throws SQLException{

        String rqt1 = "DELETE FROM `" +  tableName + "` WHERE " + idName + "=" + idNumber;

        try{

            this.test = null;
            this.test = con.createStatement();
            test.executeUpdate(rqt1);

            System.out.println("Execution de la requête : " + rqt1);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void Update (String tableName, String idModif, String modif, String idTable, String idNumber) throws SQLException{

        String rqt2 = "UPDATE `" + tableName + "` SET `" + idModif + "` = '" +  modif + "' WHERE " + idTable + "=" + idNumber;

        try{

            this.test = null;
            this.test = con.createStatement();
            test.executeUpdate(rqt2);

            System.out.println("Execution de la requête : " + rqt2);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void Insert(String tableName, String a, String b, String c, String d, String e, String f, String g, String h, String un, String deux, String trois, String quatre, String cinq, String six, String sept, String huit) throws SQLException{

        String rqt3 = null;


        if (a.isEmpty() == true){
            System.out.println("Aucun arg");
        }else if(b.isEmpty() == true){
            System.out.println("y'a rien avec 2 arg");
        }else if(c.isEmpty() == true){
            rqt3 = "INSERT INTO `" + tableName + "` (`" + a + "`, `" + b + "`) VALUES ('" + un + "'" + ", '" +  deux + "')";
        }else if(d.isEmpty() == true){
            rqt3 = "INSERT INTO `" + tableName + "` (`" + a + "`, `" + b + "`,`" + c + "`) VALUES ('" + un + "'" + ", '" +  deux + "', '" + trois + "')";
        }else if(e.isEmpty() == true) {
            rqt3 = "INSERT INTO `" + tableName + "` (`" + a + "`, `" + b + "`,`" + c + "`,`" + d + "`) VALUES ('" + un + "'" + ", '" + deux + "', '" + trois + "', '" + quatre + "')";
        }else if(f.isEmpty() == true){
            rqt3 = "INSERT INTO `" + tableName + "` (`" + a + "`, `" + b + "`,`" + c + "`,`" + d + "`,`" + e + "`) VALUES ('" + un + "'" + ", '" +  deux + "', '" + trois + "', '" + quatre + "', '" + cinq + "')";
        }else if(g.isEmpty() == true) {
            rqt3 = "INSERT INTO `" + tableName + "` (`" + a + "`, `" + b + "`,`" + c + "`,`" + d + "`,`" + e + "`,`" + f + "`) VALUES ('" + un + "'" + ", '" + deux + "', '" + trois + "', '" + quatre + "', '" + cinq + "', '" + six + "')";
        }else if(h.isEmpty() == true) {
            rqt3 = "INSERT INTO `" + tableName + "` (`" + a + "`, `" + b + "`,`" + c + "`,`" + d + "`,`" + e + "`,`" + f + "`,`" + g + "`) VALUES ('" + un + "'" + ", '" + deux + "', '" + trois + "', '" + quatre + "', '" + cinq + "', '" + six + "', '" + sept + "')";
        }else {
            rqt3 = "INSERT INTO `" + tableName + "` (`" + a + "`, `" + b + "`,`" + c + "`,`" + d + "`,`" + e + "`,`" + f + "`,`" + g + "`,`" + h + "`) VALUES ('" + un + "'" + ", '" +  deux + "', '" + trois + "', '" + quatre + "', '" + cinq + "', '" + six + "', '" + sept + "', '" + huit + "')";
        }

        System.out.println(rqt3);

        try {
            this.test = null;
            this.test = con.createStatement();
            test.executeUpdate(rqt3);

            System.out.println("Execution de la requête : " + rqt3);

        }catch (Exception v){
            v.printStackTrace();
        }

    }

}