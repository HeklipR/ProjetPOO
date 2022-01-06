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

    public DAO(Connection con) {
        this.con = con;
    }


    public Connection getCon() {
        return con;
    }

    public void Instance() throws SQLException, ClassNotFoundException, IOException {

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


}