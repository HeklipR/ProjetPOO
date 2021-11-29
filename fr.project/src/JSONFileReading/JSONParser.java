package JSONFileReading;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


public class JSONParser {

    public static void main(String[] args) {


        //String initialization
        String url = null,password = null, dbName = null, login = null;

        try{

            //Create the Gson instance
            Gson gson = new Gson();

            //Create a Reader
            Reader reader = Files.newBufferedReader(Path.of("./bdd.json"));

            //Mapping JSON File
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            //Put the JSon information in String probably work but not optimized at all

            for(Map.Entry<?,?> test : map.entrySet()){
                if(test.getKey().equals("url")){
                    url = (String) test.getValue();
                }else if(test.getKey().equals("password")){
                    password = (String) test.getValue();
                }else if(test.getKey().equals("dbName")){
                    dbName = (String) test.getValue();
                }else if(test.getKey().equals("login")){
                    login = (String) test.getValue();
                }
            }

            //Test print String
            System.out.println(url + " " + password + " " + dbName + " " + login);

            //Print the Map entries

            for(Map.Entry<?,?> entry : map.entrySet()){
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }


            //close reader

            reader.close();

        }catch (Exception e ){
            e.printStackTrace();
        }


    }

}
