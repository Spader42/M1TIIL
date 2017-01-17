import static org.junit.Assert.*;

import org.junit.Test;


public class OpenedClosedHashDictTest {

	@Test
	public void test() {
		int taille = 10;
		OpenedClosedHashDict<Integer, Integer> ht = new OpenedClosedHashDict<Integer, Integer>(taille);
		int key 	= 5;
		int value = 10;
		
		assertTrue(ht.size() == 0);
		
		// On rempli le tableau une fois puis une seconde fois
		for(int i = 0; i < taille * 2; i++) {
			assertTrue(ht.put(key + i, value) == value);
		}
		
		// On a 20 elements et la capacité a donc triplé
		assertTrue(ht.size() == 20);
		assertTrue(ht.capacity() == 30);
		
		// On retire assez d'élément pour reduire la taille de la table 2 fois
		for(int i = 0; i < taille + 2; i++) {
			ht.remove(key + i);
		}
		
		// On a donc 9 éléments et la taille réduite
		assertTrue(ht.size() == 9);
		assertTrue(ht.capacity() == 10);	
	}

}
