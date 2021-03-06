
package app;

import java.util.Iterator;

public class ListeDC<E> implements Iterable<E> {
	private class Noeud<T>{
		public Noeud<T> _precedant = null;
		public Noeud<T> _suivant   = null;
		public T        _element   = null;
		
		public Noeud( T a_element ){
			_element = a_element;
		}
	}
	
	public class IterListeDC<S> implements Iterator<S> {
		private Noeud<S> _courrant = null;
		
		public IterListeDC( ListeDC<S> a_liste ){
			_courrant = (ListeDC<E>.Noeud<S>) a_liste._debut;
		}
		
		public boolean hasNext(){
			return null != _courrant;
		}
		
		public S next(){
			S element = _courrant._element;
			_courrant = _courrant._suivant;
			return element;
		}
	}
	
	private Noeud<E> _debut  = null;
	private Noeud<E> _fin    = null;
	private int      _taille = 0;
	
	public ListeDC(){}
	
	public boolean estVide(){
		return 0 == _taille;
	}
	
	public int taille(){
		return _taille;
	}
	
	public void ajouter_debut( E a_element ){
		Noeud<E> nouveau = new Noeud<>( a_element );
		
		if( null == _fin ){
			_fin = nouveau;
		} else {
			_debut._precedant = nouveau;
		}
		
		nouveau._suivant = _debut;
		_debut = nouveau;
		
		++ _taille;
	}

	public void ajouter_fin( E a_element ){
		Noeud<E> nouveau = new Noeud<>( a_element );
		
		if( null == _debut ){
			_debut = nouveau;
		} else {
			_fin._suivant = nouveau;
		}
		
		nouveau._precedant = _fin;
		_fin = nouveau;
		
		++ _taille;
	}
	
	public E debut() throws EstVide {
		if( estVide() ){
			throw new EstVide();
		}
		
		return _debut._element;
	}
	
	public E fin() throws EstVide {
		if( estVide() ){
			throw new EstVide();
		}
		
		return _fin._element;
	}
	
	public void supprimer_fin() throws EstVide {
		if( estVide() ){
			throw new EstVide();
		}
		
		_fin = _fin._precedant;

		if( null == _fin ) {
			_debut = null;
		} else {
			_fin._suivant = null;			
		}
		
		-- _taille;
	}

	public void supprimer_debut() throws EstVide {
		if( estVide() ){
			throw new EstVide();
		}
		
		_debut = _debut._suivant;

		if( null == _debut ) {
			_fin = null;
		} else {
			_debut._precedant = null;			
		}
		
		-- _taille;
	}
	
	public Iterator<E> iterator(){
		return new IterListeDC<E>( this );
	}
}
