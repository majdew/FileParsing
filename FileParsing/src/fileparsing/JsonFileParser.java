/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author majd1
 */
public class JsonFileParser  extends FileParser{

    @Override
    public void parseFile(String FileName) {
        // declare a json file parser
        JSONParser jsonParsor= new JSONParser();
        try {
            // read the content of json file and parse it
            Object jsonFileContent= jsonParsor.parse(new FileReader (FileName)); 
            JSONObject jsonObject= (JSONObject) jsonFileContent;
            
        } 
        catch (ParseException ex) {  ex.printStackTrace(); }
        catch (FileNotFoundException ex) {ex.printStackTrace(); }
        catch (IOException ex) { ex.printStackTrace();}
    
    }
    
    public  String iterateJsonObject(JSONObject jsonObject){
        String jsonString="";
        return jsonString;
    }
    
    
}
