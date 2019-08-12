/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing.Factory;

import fileparsing.BasicClasses.XmlFileParser;

/**
 *
 * @author majd1
 */
public class XmlFileParserFactory implements FileParsingFactory{

    @Override
    public void parser(String fileName) {
        XmlFileParser xmlFileParser=new XmlFileParser();
        xmlFileParser.parseFile(fileName);
    }
    
}
