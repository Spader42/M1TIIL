package listes;

public class ListeDCE<F extends Comparable<F>> extends ListeDC<F> implements ListeE<F> {

	private static class IterateurDCE<E extends Comparable<E>> implements Iterateur<E> {
	    private ListeDC<E> liste;
	    private ListeDC<E>.Chainon next;
	    private ListeDC<E>.Chainon prev;
	    private ListeDC<E>.Chainon elementAccessible;
		
	    IterateurDCE(ListeDCE<E> l) {
			liste = l;
			elementAccessible = null;
			next = liste.tete;
			prev = null;
	    }
	    
		public boolean hasNext() {
			return next != null;
		}
		
		public boolean hasPrevious() {;
			return prev != null;
		}
		
		public E next() throws java.util.NoSuchElementException {
			if(!hasNext())
				throw new java.util.NoSuchElementException();

			prev = next;
			elementAccessible = next;
			next = next.suivant;
			
			return elementAccessible.valeur;
		}
		
		public E previous() throws java.util.NoSuchElementException {
			if(!hasPrevious())
				throw new java.util.NoSuchElementException();

			next = prev;
			elementAccessible = prev;
			prev = prev.precedent;
			
			return elementAccessible.valeur;
		}
		
		public void remove() throws IllegalStateException {
			if(elementAccessible == null){
				throw new IllegalStateException();
			}
			
			if(elementAccessible == liste.tete){
				liste.tete = liste.tete.suivant;
				liste.tete.precedent = null;
			}
			else if(elementAccessible == liste.queue){
				liste.queue = liste.queue.precedent;
				liste.queue.suivant = null;
			}
			else{
				ListeDC<E>.Chainon g = elementAccessible.precedent;
				ListeDC<E>.Chainon d = elementAccessible.suivant;
				
				g.suivant = d;
				d.precedent = g;
			}
			
			if(elementAccessible == next){
				next = next.suivant;
			}
			else if(elementAccessible == prev){
				prev = prev.precedent;
			}
	
			liste.taille--;
			liste.courant = liste.tete;
			liste.indiceCourant = (liste.taille==0 ? -1 : 0);
		}
		
		public void set(E e) throws IllegalStateException {
		if(elementAccessible == null)
			throw new IllegalStateException();
		elementAccessible.valeur = e;
		elementAccessible = null;
		}
	}
	
	public ListeDCE() {
		super();
	}

	public ListeDCE(F... init) {
		super(init);
	}

	public void reverse() {
		if(tete == null) return;
		Chainon g, d;
		g = tete;
		d = queue;
		F tmp;
		for(int i = 0; i < taille / 2; i++){
			tmp = g.valeur;
			g.valeur = d.valeur;
			d.valeur = tmp;
			g = g.suivant;
			d = d.precedent;
		}
		if(indiceCourant != -1)
			indiceCourant = taille - 1 - indiceCourant;
	}

	public Object[] toArray() {
	Object[] arr = new Object[taille];
	Chainon g = tete;
	for(int i = 0; i < taille; i++){
		arr[i] = g.valeur;
		g = g.suivant;
	}
	
	return arr;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterateur<F> iterator() {
		IterateurDCE itr = new IterateurDCE(this);
		return itr;
	}

	public F max() throws java.util.NoSuchElementException {
		if(taille == 0) throw new java.util.NoSuchElementException();
		
		F max = tete.valeur;
		
		Chainon g = tete;
		for(int i = 0; i < taille; i++){
			if(g.valeur.compareTo(max) > 0){
				max = g.valeur;
			}
			g = g.suivant;
		}
		return max;
	}

	public F min() throws java.util.NoSuchElementException {
		if(taille == 0) throw new java.util.NoSuchElementException();
		
		F min = tete.valeur;
		
		Chainon g = tete;
		for(int i = 0; i < taille; i++){
			if(g.valeur.compareTo(min) < 0){
				min = g.valeur;
			}
			g = g.suivant;
		}
		return min;
	}

	public ListeE<F> subSet(F borneMin, F borneMax) {
	ListeDCE<F> l = new ListeDCE<F>();
	Chainon g = tete;
	for(int i = 0; i < taille; i++){
		if(g.valeur.compareTo(borneMin) >= 0 && g.valeur.compareTo(borneMax) < 0)
			l.add(g.valeur);
		g = g.suivant;
	}
	return l;
	}

	public void sort() {
		Chainon g;
		g = tete;
		for(int i = 0; i < taille; i++){
			for(int j = 0; j < taille - i; j++){
				if(j != taille - 1 && g.valeur.compareTo(g.suivant.valeur) > 0){
					F tmp = g.valeur;
					g.valeur = g.suivant.valeur;
					g.suivant.valeur = tmp;
				}
				g = g.suivant;
			}
			g = tete;
		}
	}
	
	public static void main(String[] args) {
		ListeDCE<Integer> l1 = new ListeDCE<Integer>();
		System.out.print(l1+" renversée : "); l1.reverse(); System.out.println(l1); 
		l1 = new ListeDCE<Integer>(1);
		System.out.print(l1+" renversée : "); l1.reverse(); System.out.println(l1); 
		l1 = new ListeDCE<Integer>(1, -2, 17, 0, 15);
		System.out.print(l1+" renversée : "); l1.reverse(); System.out.print(l1);
		l1.reverse(); System.out.println(" re-renversée : "+l1); 
		
		ListeDCE<Integer> l2 = new ListeDCE<Integer>();
		System.out.print(l2+" en tableau : "); for(Object o : l2.toArray()) System.out.print("|"+o);
		System.out.println("|");
		l2 = new ListeDCE<Integer>(-10, -20, -30);
		System.out.print(l2+" en tableau : "); for(Object o : l2.toArray()) System.out.print("|"+o);
		System.out.println("|");
		
		l2 = new ListeDCE<Integer>(-10, 5, 7, 0, 0, -2, 18, 53, 32, -41, -30);
		Iterateur<Integer> it1 = l2.iterator();
		Iterateur<Integer> it2 = l2.iterator();
		while(it1.hasNext()) it1.next();
		System.out.println("Parcours de : "+l2+" :");
		for(int i=0; i<l2.size(); i++) {
			it1.hasPrevious();
			it2.hasNext();
			System.out.println(l2.get(i)+" "+it1.previous()+" "+it2.next());
		}
		it1 = l2.iterator();
		System.out.println("Suppression des nombres négatifs et incrément des nombres pairs dans "+l2+" :");
		while(it1.hasNext()) {
			Integer val = it1.next();
			if(val<0) it1.remove();
			else if(val%2==0) it1.set(val+1);
		}
		System.out.println("-> "+l2+" (tete : "+l2.tete.valeur+" ; queue : "+l2.queue.valeur+")");
		
		l2 = new ListeDCE<Integer>(-10, 5, 7, 0, 0, -2, 18, 53, 32, -41, -30);
		System.out.println("maximum / minimum dans "+l2+" : "+l2.max()+" / "+l2.min());
		System.out.println("sous-ensemble compris entre -30 et 7 dans "+l2+" : "+l2.subSet(-30, 7));

		System.out.print(l2+" triée : "); l2.sort(); System.out.println(l2);
		/*
			( ) renversée : ( )
			( 1 ) renversée : ( 1 )
			( 1 -2 17 0 15 ) renversée : ( 15 0 17 -2 1 ) re-renversée : ( 1 -2 17 0 15 )
			( ) en tableau : |
			( -10 -20 -30 ) en tableau : |-10|-20|-30|
			Parcours de : ( -10 5 7 0 0 -2 18 53 32 -41 -30 ) :
			-10 -30 -10
			5 -41 5
			7 32 7
			0 53 0
			0 18 0
			-2 -2 -2
			18 0 18
			53 0 53
			32 7 32
			-41 5 -41
			-30 -10 -30
			Suppression des nombres négatifs et incrément des nombres pairs dans ( -10 5 7 0 0 -2 18 53 32 -41 -30 ) :
			-> ( 5 7 1 1 19 53 33 ) (tete : 5 ; queue : 33)
			maximum / minimum dans ( -10 5 7 0 0 -2 18 53 32 -41 -30 ) : 53 / -41
			sous-ensemble compris entre -30 et 7 dans ( -10 5 7 0 0 -2 18 53 32 -41 -30 ) : ( -10 5 0 0 -2 -30 )
			( -10 5 7 0 0 -2 18 53 32 -41 -30 ) triée : ( -41 -30 -10 -2 0 0 5 7 18 32 53 )
		 */
	}

}
