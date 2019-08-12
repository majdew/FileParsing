/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing.Factory;

import fileparsing.Factory.FileParsingFactory;
import fileparsing.BasicClasses.JsonFileParser;

/**
 *
 * @author majd1
 */
public class JsonFileParserFactory implements  FileParsingFactory{

    @Override
    public void parser(String fileName) {
        JsonFileParser jsonFileParser=new JsonFileParser();
        jsonFileParser.parseFile(fileName);

}
}
