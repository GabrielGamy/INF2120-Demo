package app;

import java.util.Arrays;
import services.IRechercheBinaire;
import services.RechercheBinaireException;

public class RechercheBinaire implements IRechercheBinaire {

    @Override
    public int rechercheBinaireIterative(String [] liste, String valeurRecherchee) {
        int result = -1;
        int depart  = 0, fin = liste.length, pos = 0;
        
        while(depart < fin  && result == -1){
            int milieu = (depart + fin) / 2;
            result = liste[milieu].equals(valeurRecherchee) ? (milieu + 1) : -1;
            
            if(liste[milieu].compareTo(valeurRecherchee) < 0) depart = milieu; // valeurRecherchee est vers la droite
            else  fin = milieu; // valeurRecherchee est vers la gauche  
            
            if(++pos > liste.length) break; // Depassement de la liste
        }        
        return result;
    }

    @Override
    public int rechercheBinaireRecursive(String [] liste, String valeurRecherchee, int depart, int fin) throws RechercheBinaireException {
        String messageErreur = "La valeure " + valeurRecherchee + " est introuvable dans " + Arrays.toString(liste);
        int milieu;
        String elementMilieu;
        
        if (depart > fin) throw new RechercheBinaireException(messageErreur);
        
        milieu = (depart + fin) / 2;
        elementMilieu = liste[milieu]; 
        
        if (elementMilieu.compareTo(valeurRecherchee) == 0) return (milieu + 1); // On trouve la valeure recherchee
        
        if (elementMilieu.compareTo(valeurRecherchee) < 0 ) depart = milieu + 1; // La valeurRecherchee est vers la droite
        else fin = milieu - 1; // La valeurRecherchee est vers la gauche
        
        return rechercheBinaireRecursive(liste, valeurRecherchee, depart, fin); 
    }
}
