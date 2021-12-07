package JSONFileReading;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


public class JSONParser {

    public static void main(String[] args) {


        //Initialisation des String pour récupérer les valeurs du fichier json
        String url = null,password = null, dbName = null, login = null;

        try{

            //Creation d'une instance Gson
            Gson gson = new Gson();

            //Creation d'un reader de fichier
            Reader reader = Files.newBufferedReader(Path.of("./bdd.json"));

            //Mappage du fichier JSon
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            //Code non optimiser pour mettre les valeurs du JSON dans les Variables initialisé avant

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

            //Test pour voir si le code au dessus fonctionne
            System.out.println(url + " " + password + " " + dbName + " " + login);

            //Affichage du mappage avec les Clef et les Valeurs associé

            for(Map.Entry<?,?> entry : map.entrySet()){
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }


            //Fermeture du Reader

            reader.close();

        }catch (Exception e ){
            e.printStackTrace();
        }


    }

}
