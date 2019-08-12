/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing.BasicClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
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
            
            //  get json string and write it on a file
            String jsonString=iterateJsonObject(jsonObject);
            PrintWriter writer =new  PrintWriter("result.txt");
            writer.println("====================================");
            // transform the json string into array split by end line
            String[] jsonStringArray=jsonString.split("\n");
            for(String string : jsonStringArray){
                // append the content of json string on the file with new line
                writer.append((string)+ System.getProperty( "line.separator" ));
            }
            writer.close();
            
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
        jsonString+= iterateSubJsonObject(iterValues.next());
        return jsonString;
        
    }
    public String iterateSubJsonObject(Object subJsonObject) {
        String jsonString="";
        if(subJsonObject instanceof  JSONArray){
            // check if there is json array to handle it 
            Iterator iterJsonArray=((JSONArray) subJsonObject).iterator();
            while (iterJsonArray.hasNext()) {
                // get the string from json array recursivly
               jsonString+=(String) (iterateSubJsonObject((Object)iterJsonArray.next()));
                
            }
        }
        else {
            // get the json string from  sub json object as keys and values
            Iterator iterJsonObject=((JSONObject)subJsonObject).entrySet().iterator();
            while (iterJsonObject.hasNext()) {
                Map.Entry currentJsonObject=(Map.Entry)iterJsonObject.next();
                // get the current key
                String currentKey=(String)currentJsonObject.getKey();
                // get the currnt value
                String currentValue=(String)currentJsonObject.getValue();   
                // format the  returned json string 
                jsonString+=currentKey.substring(0,1).toUpperCase()+currentKey.substring(1).toLowerCase()+":";
                jsonString+=currentValue.substring(0,1).toUpperCase()+currentValue.substring(1).toLowerCase()+"\n";

            }
        }
        return  jsonString;
        
    }
    
}
