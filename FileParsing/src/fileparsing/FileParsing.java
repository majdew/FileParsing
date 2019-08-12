/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileparsing;

import fileparsing.Factory.JsonFileParserFactory;
import java.util.Scanner;

/**
 *
 * @author majd1
 */
public class FileParsing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new  Scanner(System.in);
        String menu="Welcome to \"File Parse\"\n-----------------------\n  1. Parse json file\n  2. Parse xml file\n  3. Exit\n----------------------- ";
        int choice;
        String fileName="";
        do{
            System.out.println(menu);
            System.out.println("Enter your Choice: ");
            choice =input.nextInt();
            switch (choice){
                case 1: {
                    System.out.print("Enter the relative path for the file:");
                    fileName=input.next();
                    JsonFileParserFactory factory=new JsonFileParserFactory();
                    factory.parser(fileName);
                    System.out.println("Done!!!");
                    
                }break;
                case 2:{
                    
                }break;
                case 3:{
                    System.exit(0);
                }break;
                
            }
                    
            
        }
        while(choice!=4);
        
        
        
         
        
    }
    
}
