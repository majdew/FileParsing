/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing.BasicClasses;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author majd1
 */
public class XmlFileParser extends FileParser{

    @Override
    public void parseFile(String FileName) {
        try {
        // Instantiate XML file
	File xmlFile = new File(FileName);
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document document= builder.parse(xmlFile);
        
        // get the main node name
        String rootName= document.getDocumentElement().getNodeName();
        } 
        catch(ParserConfigurationException ex){ex.getMessage();}
        catch (IOException ex){ ex.getMessage();} 
        catch (SAXException ex) { ex.getMessage();}
        catch(Exception ex){ ex.getMessage();}
        
    }
    
    
    private static String printChildNodes (NodeList nodeList){
       String xmlString="";
       for(int i=0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            // get  subNodes
            if (node.hasChildNodes())
                for (int count =0 ; count <node.getChildNodes().getLength(); count++){
                    Node tempNode = node.getChildNodes().item(count);
                    // make sure it's element node.
                    if(tempNode.getNodeType()==Node.ELEMENT_NODE){
                        // get subnode name and value
		        xmlString+=tempNode.getNodeName().substring(0, 1).toUpperCase()+tempNode.getNodeName().substring(1).toLowerCase();
                        xmlString+=":"+tempNode.getTextContent().substring(0, 1).toUpperCase()+tempNode.getTextContent().substring(1).toLowerCase();
                        xmlString+="\n";
		        xmlString+=printChildNodes(tempNode.getChildNodes());
                    }
                    if(tempNode.hasChildNodes())
                        xmlString+=printChildNodes(tempNode.getChildNodes());
            }
        }
        return  xmlString;
    }
    
}
