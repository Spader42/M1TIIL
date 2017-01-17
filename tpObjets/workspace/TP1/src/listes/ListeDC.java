package listes;
public class ListeDC<E> implements Liste<E> {

    protected class Chainon {
    	public E valeur;
    	public Chainon suivant;
    	public Chainon precedent;
    	public Chainon(E valeur) {
    	    this.valeur = valeur;
    	    this.suivant = null;
    	    this.precedent = null;
    	}
    }
    
    protected Chainon tete;
    protected Chainon queue;
    protected Chainon courant;
    protected int indiceCourant;
    protected int taille;
    
    public ListeDC() {
    	tete = null;
    	queue = null;
    	courant = null;
    	indiceCourant = -1;
    	taille = 0;
    }

    public ListeDC(E... init) {
    	this();
    	for (E e:init) this.add(e);
    }

	public boolean isEmpty() { return taille==0; }

	public int size() { return taille; }

	public Liste<E> clear() {
		// On défait le chainage avant pour éviter les fuites de mémoire :
		for(Chainon curseur = tete; curseur!=null; curseur = curseur.suivant) curseur.precedent=null;
		// On remet la liste dans l'état "vide" :
		tete = null;
    	queue = null;
    	courant = null;
    	indiceCourant = -1;
    	taille = 0;
		return this;
	}

	public E get(int i) throws HorsBornes {
		if (i<0 || i>= taille) throw new HorsBornes();
		positionne(i);
		return courant.valeur;
	}

	public E set(int i, E e) throws HorsBornes {
		if (i<0 || i>= taille) throw new HorsBornes();
		positionne(i);
		E res = courant.valeur;
		courant.valeur = e;
		return res;
	}

	public int contains(Object o) {
		int i; Chainon curseur; // variables de parcours
		for(curseur=tete, i=0; curseur!=null; curseur = curseur.suivant, i++)
			if(curseur.valeur.equals(o)) return i;
		return -1;
	}

	public boolean containsAll(Liste<?> l) {
		for(int k=0; k<l.size(); k++) if(contains(l.get(k))==-1) return false;
		return true;
	}

	public boolean equals(Object o) {
		if(!(o instanceof ListeDC<?>)) return false; // mauvais type
		ListeDC<?> l = (ListeDC<?>)o;
		if(l.taille!=taille) return false; // tailles différentes
		// il reste à comparer 2 à 2 les éléments des 2 listes :
		int i; Chainon curseur; // variables de parcours
		for(curseur=tete, i=0; curseur!=null; curseur = curseur.suivant, i++)
			if(!curseur.valeur.equals(l.get(i))) return false;
		return true;
	}
   
	public Liste<E> add(E e) { return add(taille, e); }

	public Liste<E> add(int i, E e) throws HorsBornes {
		if (i<0 || i> taille) throw new HorsBornes();
		Chainon nouveauChainon = new Chainon(e);
		if (i==taille) { // on ajoute à la fin (comprend le cas liste vide !)
			nouveauChainon.precedent = queue;
			queue = nouveauChainon;
			indiceCourant = taille;
		}
		else {
			positionne(i);
			nouveauChainon.suivant = courant;
			nouveauChainon.precedent = courant.precedent;
			nouveauChainon.suivant.precedent = nouveauChainon;
		}
		if (i==0) // on ajoute au début (comprend le cas liste vide !)
			tete = nouveauChainon;
		else
			nouveauChainon.precedent.suivant = nouveauChainon;
		courant = nouveauChainon;
		taille++;
		return this;
	}
	
	public Liste<E> addAll(Liste<? extends E> l) { return addAll(taille, l); }

	public Liste<E> addAll(int i, Liste<? extends E> l) throws HorsBornes {
		for(int k=0; k<l.size(); k++, i++) add(i, l.get(k));
		return this;
	}

	public E remove(int i) throws HorsBornes {
		if (i<0 || i>= taille) throw new HorsBornes();
		positionne(i);
		E res = courant.valeur;
		if(courant.precedent!=null)
			courant.precedent.suivant = courant.suivant;
		else // on est en train de supprimer la tete :
			tete = tete.suivant;
		if(courant.suivant!=null) {
			courant.suivant.precedent = courant.precedent;
			courant = courant.suivant;
		}
		else { // on est en train de supprimer la queue :
			courant = courant.precedent;
			indiceCourant--;
			queue = courant;
		}
		taille--;
		return res;
	}
	
	public Liste<E> subList(int deb, int fin) throws HorsBornes {
		if (deb<0 || deb>= taille || fin<0 || fin>= taille) throw new HorsBornes();
		ListeDC<E> res = new ListeDC<E>();
		int i; Chainon curseur; // variables de parcours
		for(curseur=tete, i=0; i<deb; curseur = curseur.suivant, i++) {}
		for(; i<=fin; curseur = curseur.suivant, i++) res.add(curseur.valeur);
		return res;
	}

	public String toString() {
		String res = "( ";
		for(Chainon curseur = tete; curseur!=null; curseur = curseur.suivant)
			res += curseur.valeur+" ";
		return res+")";
	}
	
	protected void positionne(int i) {
		if(i<indiceCourant) // on se positionne depuis tete ou courant
			if(i<indiceCourant-i) // on se positionne depuis tete
				for(courant=tete, indiceCourant=0; indiceCourant<i; indiceCourant++) courant = courant.suivant;
			else // on se positionne depuis courant en décrémentant
				for( ; indiceCourant>i; indiceCourant--) courant = courant.precedent;
		else  // on se positionne depuis queue ou courant
			if(i-indiceCourant<taille-1-i) // on se positionne courant en incrémentant
				for( ; indiceCourant<i; indiceCourant++) courant = courant.suivant;
			else // on se positionne depuis queue 
				for(courant=queue, indiceCourant=taille-1; indiceCourant>i; indiceCourant--) courant = courant.precedent;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListeDC<Integer> l = new ListeDC<Integer>(4, -8, 55);
		System.out.println(l.add(7).add(-12));
		System.out.println(l.add(0, 17).add(0,18).add(3, 3));
		System.out.println(l.addAll(new ListeDC<Integer>(1, 2, 3)));
		System.out.println(l.addAll(0, new ListeDC<Integer>(-1, -2, -3)));
		System.out.println(l.addAll(5, new ListeDC<Integer>(8, 88)));
		System.out.println(l.addAll(5, new ListeDC<Integer>()));
		System.out.println("3  : "+l.contains(3));
		System.out.println("-3 : "+l.contains(-3));
		System.out.println("16 : "+l.contains(16));
		ListeDC<Integer> l2 = new ListeDC<Integer>(55, 18, 18, 2);
		ListeDC<Integer> l3 = new ListeDC<Integer>(55, -17, 18, 2);
		ListeDC<Integer> l4 = new ListeDC<Integer>(55, 18, 18, 2);
		System.out.println(l2+" ? "+l.containsAll(l2));
		System.out.println(l3+" ? "+l.containsAll(l3));
		System.out.println(l2+" == "+l4+" ? "+l2.equals(l4));
		System.out.println(l3+" == "+l4+" ? "+l3.equals(l4));
		System.out.println(l4+" remove(2) : "+l4.remove(2)+" -> "+l4);
		System.out.println(l4+" remove(2) : "+l4.remove(2)+" -> "+l4);
		System.out.println(l4+" remove(0) : "+l4.remove(0)+" -> "+l4);
		System.out.println(l4+" remove(0) : "+l4.remove(0)+" -> "+l4);
		System.out.println(l+" 1->5 : "+l.subList(1,5));
		System.out.println(l+" 5->1 : "+l.subList(5,1));
		System.out.println(l+" clear : "+l.clear()+" clear : "+l.clear());
		/*
			( 4 -8 55 7 -12 )
			( 18 17 4 3 -8 55 7 -12 )
			( 18 17 4 3 -8 55 7 -12 1 2 3 )
			( -1 -2 -3 18 17 4 3 -8 55 7 -12 1 2 3 )
			( -1 -2 -3 18 17 8 88 4 3 -8 55 7 -12 1 2 3 )
			( -1 -2 -3 18 17 8 88 4 3 -8 55 7 -12 1 2 3 )
			3  : 8
			-3 : 2
			16 : -1
			( 55 18 18 2 ) ? true
			( 55 -17 18 2 ) ? false
			( 55 18 18 2 ) == ( 55 18 18 2 ) ? true
			( 55 -17 18 2 ) == ( 55 18 18 2 ) ? false
			( 55 18 18 2 ) remove(2) : 18 -> ( 55 18 2 )
			( 55 18 2 ) remove(2) : 2 -> ( 55 18 )
			( 55 18 ) remove(0) : 55 -> ( 18 )
			( 18 ) remove(0) : 18 -> ( )
			( -1 -2 -3 18 17 8 88 4 3 -8 55 7 -12 1 2 3 ) 1->5 : ( -2 -3 18 17 8 )
			( -1 -2 -3 18 17 8 88 4 3 -8 55 7 -12 1 2 3 ) 5->1 : ( )
			( -1 -2 -3 18 17 8 88 4 3 -8 55 7 -12 1 2 3 ) clear : ( ) clear : ( )
		 */
	}

}
