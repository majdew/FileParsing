/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing;

/**
 *
 * @author majd1
 */
public class JsonFileParserFactory implements  FileParsingFactory{

    @Override
    public void fileParserFactory(String fileName) {
        JsonFileParser jsonFileParser=new JsonFileParser();
        jsonFileParser.parseFile(fileName);

}
}
