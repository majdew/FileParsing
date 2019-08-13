/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing.BasicClasses;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author majd1
 */
public class XmlFileParser extends FileParser{

    @Override
    public void parseFile(String FileName) {
        
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
