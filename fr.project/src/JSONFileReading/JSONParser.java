package JSONFileReading;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


public class JSONParser {

    //Initialisation des String pour récupérer les valeurs du fichier json
    String url = null,password = null, dbName = null, login = null;

    /**
     * Getter and setter
     * @return
     */

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getDbName() {
        return dbName;
    }

    public String getLogin() {
        return login;
    }

    public void ParseValue(){

        try{


            /**
             * Creation d'un instance Gson (librairie)
             */
            Gson gson = new Gson();


            /**
             * Creation d'un reader de fichier avec comme source le fichier bdd.json
             */
            Reader reader = Files.newBufferedReader(Path.of("./bdd.json"));


            /**
             * Mappage du fichier JSon bdd.json
             */
            Map<?, ?> map = gson.fromJson(reader, Map.class);



            /**
             * Code pour récuperer les valeurs des entrées du fichier JSon et les initialisé dans des variables
             */
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


            /**
             * Fermeture du reader
             */

            reader.close();

        }catch (Exception e ){
            e.printStackTrace();
        }



        //Test pour voir si le code au dessus fonctionne
        System.out.println(url + " " + password + " " + dbName + " " + login);


    }

}


//            Affichage du mappage avec les Clef et les Valeurs associé
//
//            for(Map.Entry<?,?> entry : map.entrySet()){
//                System.out.println(entry.getKey() + " = " + entry.getValue());
//            }