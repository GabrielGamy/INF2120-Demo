package app;

import java.util.Arrays;
import services.IRecursite;
import services.RecursiviteException;

public class Recursivite implements IRecursite {

    @Override
    public int sommeRec(int[] liste, int indexDepart) throws RecursiviteException {
        
        if(indexDepart > liste.length || indexDepart < 0) 
            throw new RecursiviteException("Index de depart invalide !");
        else if(indexDepart == liste.length)
            return 0;
        else
            return liste[indexDepart] + sommeRec(liste, ++indexDepart);
    }    

    @Override
    public boolean estPair(int nombre) {
        
        switch (nombre) {
            case 1:
                return false;    
            case 0:
                return true;
            default:
                return estImPair (nombre -1);
        }
    }

    @Override
    public boolean estImPair(int nombre) {
        
        switch (nombre) {
            case 1:
                return true;    
            case 0:
                return false;
            default:
                return estPair (nombre -1);
        }    
    }

    @Override
    public int indexDichotomique(int nombre, int[] liste, int depart, int fin) throws RecursiviteException {
        
        String messageErreur = "Le nombre " + nombre + " est introuvable dans " + Arrays.toString(liste);
        int position, milieu;
        
        if (depart > fin) throw new RecursiviteException(messageErreur);
        
        position = (depart + fin) / 2;
        milieu = liste[position]; 
        
        if (nombre == milieu) return position;
        if (nombre < milieu) return indexDichotomique(nombre, liste, depart, position - 1);
        return indexDichotomique(nombre, liste, position + 1, fin);       
    }

    @Override
    public int additionner(int nombre, int nfois) throws RecursiviteException {
        if(nfois < 1) throw new RecursiviteException("Le nombre nfois: " + nfois + " est invalide");
        if(nfois == 1) return nombre;
        return nombre + additionner(nombre, --nfois);
    }

    @Override
    public int pgcd(int n, int m) {
        if(m == 0) return n;
        return pgcd(m, n % m);
    }
}
