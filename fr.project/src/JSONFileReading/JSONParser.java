package JSONFileReading;


import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JSONParser {

    public static void main(String[] args){

        try{

            //Create the Gson instance
            Gson gson = new Gson();

            //Create a Reader
            Reader reader = Files.newBufferedReader(Path.of("/Desktop/ProjetPOOV/bdd.json"));

            //Mapping JSON File
            Map<?, ?> map = gson.fromJson(reader, Map.class);

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
