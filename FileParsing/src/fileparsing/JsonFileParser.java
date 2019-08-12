/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing;

import org.json.simple.parser.JSONParser;

/**
 *
 * @author majd1
 */
public class JsonFileParser  extends FileParser{

    @Override
    public void parseFile(String FileName) {
        JSONParser jsonParsor= new JSONParser();
    }
    
    
}
