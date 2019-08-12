/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
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
        // iterate through the main keys 
        Iterator iterKeys=jsonObject.keySet().iterator();
        // get  values from the json object
        Collection values=jsonObject.values();
        // iterate through json values 
        Iterator iterValues=values.iterator();
        // get the json string  form the main keys
        String currentKey=(String)iterKeys.next();
        jsonString+="Type: "+currentKey.substring(0,1).toUpperCase()+currentKey.substring(1).toLowerCase();
        jsonString+="\n-----------------------------------\n";
        return jsonString;
        
    }
    public String iterateSubJsonObject(Object jsonValue) {
        String jsonString="";
        return  jsonString;
        
    }
    
}
