package app;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import services.RechercheBinaireException;

public class RechercheBinaireTest {
    
    public RechercheBinaireTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testRechercheBinaireIterative() {
        System.out.println("rechercheBinaireIterative");
        RechercheBinaire instance = new RechercheBinaire();        
        
        // Liste vide
        String [] liste = {};
        int result = instance.rechercheBinaireIterative(liste, "Chaine");
        assertEquals(result, -1);
        
        liste = new String[4];
        liste[0] = "chaine1"; 
        liste[1] = "chaine2"; 
        liste[2] = "chaine3"; 
        liste[3] = "chaine4"; 
        
        // La valeur recherchee est au debut de la liste
        result = instance.rechercheBinaireIterative(liste, "chaine1");
        assertEquals(result, 1);
        
        // La valeur recherchee est a la fin de la liste
        result = instance.rechercheBinaireIterative(liste, "chaine4");
        assertEquals(result, 4); 
        
        // La valeur recherchee est au milieu de la liste
        result = instance.rechercheBinaireIterative(liste, "chaine2");
        assertEquals(result, 2); 
        
        // La valeur recherchee est introuvable 
        result = instance.rechercheBinaireIterative(liste, "chaine0");
        assertEquals(result, -1); 
        
        // La valeur recherchee est introuvable 
        result = instance.rechercheBinaireIterative(liste, "chaine5");
        assertEquals(result, -1);        
    }

    @Test
    public void testRechercheBinaireRecursive() throws RechercheBinaireException {
        System.out.println("rechercheBinaireRecursive");
        RechercheBinaire instance = new RechercheBinaire();        
        
        // Liste vide
        String [] liste = {};
        int depart = 0, fin = liste.length - 1;        
        int result;
        try {
            result = instance.rechercheBinaireRecursive(liste, "chaine1", depart, fin);
        } catch (RechercheBinaireException ex) {
            String messageErreur = "La valeure chaine1 est introuvable dans " + Arrays.toString(liste);
            assertEquals(ex.getMessage(), messageErreur);
        }
        
        liste = new String[4];
        liste[0] = "chaine1"; 
        liste[1] = "chaine2"; 
        liste[2] = "chaine3"; 
        liste[3] = "chaine4"; 
        
        // La valeur recherchee est au debut de la liste
        fin = liste.length - 1;
        result = instance.rechercheBinaireRecursive(liste, "chaine1", depart, fin );
        assertEquals(result, 1);
        
        // La valeur recherchee est a la fin de la liste
        result = instance.rechercheBinaireRecursive(liste, "chaine4", depart, fin );
        assertEquals(result, 4); 
        
        // La valeur recherchee est au milieu de la liste
        result = instance.rechercheBinaireRecursive(liste, "chaine2",depart, fin );
        assertEquals(result, 2); 
        
        // La valeur recherchee est introuvable 
        try {
            result = instance.rechercheBinaireRecursive(liste, "chaine0", depart, fin);
        } catch (RechercheBinaireException ex) {
            String messageErreur = "La valeure chaine0 est introuvable dans " + Arrays.toString(liste);
            assertEquals(ex.getMessage(), messageErreur);
        }

        try {
            result = instance.rechercheBinaireRecursive(liste, "chaine5", depart, fin);
        } catch (RechercheBinaireException ex) {
            String messageErreur = "La valeure chaine5 est introuvable dans " + Arrays.toString(liste);
            assertEquals(ex.getMessage(), messageErreur);
        }
    }
    
}
