package services;

public interface IRecursite {
    
    /** 
     * Calcul la somme des elements de la liste de facon recursive
     * @param liste: la liste d'entiers
     * @param indexDepart: l'index depart du calcul
     * @return -1 si l'index est invalide, sinon retourne la somme des entiers
     * @throws services.RecursiviteException
     */
    public int sommeRec(int liste[], int indexDepart) throws RecursiviteException;
    
    /** 
     * Verifier que le nombre est pair de facon recursive 
     * @param nombre: le nombre à verifier
     * @return true si le nombre est pair et false sinon
     */
    public boolean estPair(int nombre);

    /** 
     * Verifier que le nombre est impair de facon recursive 
     * @param nombre: le nombre à verifier
     * @return true si le nombre est impair et false sinon
     */ 
    public boolean estImPair(int nombre);
    
    /**
     * Retourne l'index du nombre dans la liste de facon recursive,
     * La liste doit etre triee.
     * @param nombre: Le nombre pour lequel l'index doit etre trouvée
     * @param liste: La liste de recherche
     * @param depart: La position initiale
     * @param fin: La position finale
     * @return retourne l'index du nombre.
     * @throws services.RecursiviteException si le nombre est introuvable
     */    
    public int indexDichotomique(int nombre, int[] liste, int depart, int fin) throws RecursiviteException;
    
    /** 
     * Additionne nfois le nombre
     * @param nombre
     * @param fois
     * @return le nombre additionner nfois
     * @throws services.RecursiviteException
     */
    public int additionner(int nombre, int fois) throws RecursiviteException;
    
    /** 
     * Trouver le plus grand commun diviseur de deux nombre
     * @param n
     * @param m
     * @return le pgcd des deux nombres
     */
    public int pgcd(int n, int m);
}
