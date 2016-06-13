package main;

import app.Recursivite;
import services.RecursiviteException;

public class Main {

    public static void main(String[] args) {
        
        Recursivite recursivite = new Recursivite();
        int liste [] = {1,2};
        
        // sommeRec(int liste[], int indexDepart)
        try{
           System.out.println("Somme : " + recursivite.sommeRec(liste, 0)); 
           System.out.println("Somme : " + recursivite.sommeRec(liste, -1)); 
        }catch(Exception e){
            System.out.println("Une erreur est survenue: " + e.getMessage());
        }
        // estPair(int nombre)    
        System.out.println();
        
        System.out.println("Pair : " + recursivite.estPair(0));
        System.out.println("Pair : " + recursivite.estPair(20));
        System.out.println("Pair : " + recursivite.estPair(31));
        // estImPair(int nombre)
        System.out.println();

        System.out.println("Impair : " + recursivite.estImPair(1));
        System.out.println("Impair : " + recursivite.estImPair(19));
        System.out.println("Impair : " + recursivite.estImPair(30));            
        
        //indexDichotomique(int nombre, int[] liste, int depart, int fin)
        try{
            System.out.println();

            System.out.println("Index element: " + recursivite.indexDichotomique(1, liste, 0, liste.length - 1));            
            System.out.println("Index element: " + recursivite.indexDichotomique(2, liste, 0, liste.length - 1));
            System.out.println("Index element: " + recursivite.indexDichotomique(3, liste, 0, liste.length - 1));
            
        }catch(Exception e){
            
           System.out.println("Une erreur est survenue: " + e.getMessage()); 
        }
        
        //additionner(int nombre, int fois)
        try {
            System.out.println();
            
            System.out.println("Additionnner: " + recursivite.additionner(3, 2));
            System.out.println("Additionnner: " + recursivite.additionner(-1, 3));
            System.out.println("Additionnner: " + recursivite.additionner(1, -1));
        } catch (RecursiviteException e) {
            System.out.println("Une erreur est survenue: " + e.getMessage()); 
        }
        
        // pgcd(int n, int m);
        System.out.println();
        
        System.out.println("Pgcd: " + recursivite.pgcd(15, 26));
        System.out.println("Pgcd: " + recursivite.pgcd(96, 36));
    }  
}
