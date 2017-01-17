package listes;
public interface Iterateur<E> {
	// Un itérateur encapsule une sorte de curseur pointant entre 2 élements d'une liste.
	// Le curseur peut donc être avant la tête, après la queue, ou entre 2 éléments successifs.
	
	 boolean hasNext(); // rend faux si l'itérateur est positionné après le dernier élément. 
	 boolean hasPrevious(); // rend faux si l'itérateur est positionné avant le premier élément.
	 E next() throws java.util.NoSuchElementException; // renvoie la valeur de l'élément suivant le curseur et déplace le curseur
	 E previous() throws java.util.NoSuchElementException; // renvoie la valeur de l'élément précédent le curseur et déplace le curseur
	 void remove() throws IllegalStateException; // supprime le dernier élément renvoyé par next ou previous
	 // ATTENTION : next ou previous doit avoir été invoqué UNE et UNE SEULE fois juste avant (exception
	 // dans le cas contraire)
	 void set(E e) throws IllegalStateException; // met à jour le dernier élément renvoyé par next ou previous
	 // ATTENTION : next ou previous doit avoir été invoqué UNE et UNE SEULE fois juste avant
}
