package services;

public interface IPile <T> {
    public int taille();
    
    public boolean estVide();
    
    public T tete() throws PileVide;
            
    public void enpiler(T element);
    
    public void depiler() throws PileVide;    
}
