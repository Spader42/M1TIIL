import static org.junit.Assert.*;

import org.junit.Test;


public class ClosedHashDictTest {

	@Test
	public void test() {
		int taille = 10;
		ClosedHashDict<Integer, Integer> ht = new ClosedHashDict<Integer, Integer>(taille); 
		assertTrue(ht.size() == 0);
		
		int key = 5;
		int value = 10;
		int value2 = 50;
		
		//On ajoute une clé, la taille augmente et la valeur associé est présente
		assertTrue(ht.put(key, value) == value);
		assertTrue(ht.size() == 1);
		assertTrue(ht.get(key) == value);
		
		//On rajoute une valeur avec la meme clé, la valeur est mise à jour
		assertTrue(ht.put(key, value2) == value2);
		assertTrue(ht.get(key) == value2);
		
		//On retire l'entrée
		assertTrue(ht.remove(key) == value2);
		assertTrue(ht.size() == 0);
		
		//On ajoute assez d'entrée pour remplir la table
		for(int i = 0; i < taille; i++){
			assertTrue(ht.put(key + i, value) == value);
		}

		//On ne peut plus ajouter d'entree
		assertTrue(ht.put(key, value) == null);
		assertTrue(ht.size() == taille);
		
		//On retire toutes les entrées
		for(int i = 0; i < taille; i++){
			assertTrue(ht.remove(key + i) == value);
		}
		
		//Si on retire une entrée qui n'existe pas
		assertTrue(ht.remove(key) == null);
		
		ht.put(key, value);
		assertTrue(ht.get(key) == value);
		assertTrue(ht.containsValue(value));
		assertTrue(ht.containsKey(key));
	}

}
