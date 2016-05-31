
package main;

import application.File;
import services.FileVide;


public class Main {


    public static void main(String[] args) {
        File<String> file = new File();
        
        System.out.println("taille: " + file.taille());
        System.out.println("estVide: " + file.estVide());
        
        file.enfiler("un");
        file.enfiler("deux");
        
        System.out.println("trouver l'element : " + file.trouverElement(1));
        
        try{
            file.defiler();
            
            String laTete = file.tete();
            System.out.println("tete: " + laTete);
        }catch(FileVide f){
            System.out.println("Message :" + f.getMessage());
        }
        
        System.out.println("taille: " + file.taille());
        System.out.println("estVide: " + file.estVide());
    }
    
}
