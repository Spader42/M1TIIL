package listes;
public interface Liste<E> {
	// Lexception "HorsBornes" est soulevée quand un indice fourni est négatif ou supérieur à la taille courante de la liste

	boolean	isEmpty(); // renvoie vrai si la liste est vide
	int	size(); // renvoie le nombre déléments dans la liste
	Liste<E>	clear(); // vide la liste ; renvoie linstance courante
	E 	get(int i) throws HorsBornes; // renvoie lélément à lindice i
	E 	set(int i, E e) throws HorsBornes; // remplace lélément existant à lindice i par e ; renvoie lélément supprimé
	int	contains(Object o); // renvoie lindice de la 1ère occurrence de o si o apparait dans la liste ; renvoie -1 sinon
	boolean 	containsAll(Liste<?> l); // renvoie vrai ou faux selon que l constitue un sous-ensemble de la liste courante ou non.
	boolean	equals(Object o); // test dégalité
	Liste<E>	add(E e); // ajoute e en fin de liste ; renvoie linstance courante
	Liste<E>	add(int i, E e) throws HorsBornes; // ajoute e à lindice i ; renvoie linstance courante
	// (i est compris entre 0 et size() inclu, auquel cas l'élément est rajouté à la fin)
	Liste<E>	addAll(Liste<? extends E> l); // ajoute l à la fin de la liste ; renvoie linstance courante
	Liste<E>	addAll(int i, Liste<? extends E> l) throws HorsBornes; // ajoute l à lindice i ; renvoie linstance courante
	// (i est compris entre 0 et size() inclu, auquel cas l'élément est rajouté à la fin)
	E	remove(int i) throws HorsBornes; // supprime lélément à lindice i ; renvoie lélément supprimé
	Liste<E>	subList(int deb, int fin) throws HorsBornes; // renvoie la liste constituée des élements compris
	// entre les indices deb (inclu) et fin (inclu)
}
