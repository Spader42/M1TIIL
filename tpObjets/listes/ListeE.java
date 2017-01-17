package listes;
public interface ListeE<F extends Comparable<F>> extends Liste<F> {
	void reverse(); // inverse l'ordre de la liste
	Object[] toArray(); // renvoie la liste sous forme de tableau
	Iterateur<F> iterator(); // renvoie un itérateur sur la liste positionné au début
	F max() throws java.util.NoSuchElementException; // renvoie le plus grand élément de la liste selon le critère de comparaison de F
	F min() throws java.util.NoSuchElementException; // renvoie le plus petit élément de la liste selon le critère de comparaison de F
	ListeE<F> subSet(F borneMin, F borneMax); // renvoie la liste des éléments compris entre
	 // borneMin (inclu) et borneMax (exclu) selon le critère de comparaison de F
	void sort(); // tri des élements dans l'ordre croissant selon le critère de comparaison de F
}
