public class ClosedHashDict<K, V> implements Map<K, V>{
	Entry<K, V> [] 	table;
	int 			size;
	

	public class EntryHashDict<K, V> implements Entry<K, V> {
		K key;
		V value;
		
		public EntryHashDict(K key, V value){
			this.key 	= key;
			this.value 	= value;
		}
		
		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public V setValue(V value) {
			this.value = value;
			return this.value;
		}
	}

	public ClosedHashDict(int capacity){
		table = new EntryHashDict[capacity];
		size = 0;
	}

	public boolean containsKey(K key) {
		for(int i = 0; i < this.table.length; i++){
			if(table[i] != null && table[i].getKey().equals(key))
				return true;
		}
		return false;
	}

	public boolean containsValue(V value) {
		for(int i = 0; i < this.table.length; i++){
			if(table[i] != null && table[i].getValue().equals(value))
				return true;
		}
		return false;
	}

	public int size() {
		return this.size;
	}

	public V put(K key, V value) {
		if(this.size == this.table.length)
			return null;
		
		Entry<K, V> newEntry = new EntryHashDict<K, V>(key, value);
		
		int pos = Math.abs(key.hashCode()) % table.length;
		
		boolean boucle = false;
		for(int i = pos; i < table.length; i++) {
			//Si on revient à la position de départ on stop
			if(i == pos && boucle)
				return null;
			//Si la clé existe déjà
			if(table[i] != null && table[i].getKey().equals(key)){
				table[i].setValue(value);
				return table[i].getValue();
			}
			//Si on trouve un emplacement
			if(table[i] == null) {
				table[i] = newEntry;
				this.size++;
				return table[i].getValue();
			}
			// Si on arrive à la fin on revient au début
			if(i == table.length - 1){
				i = 0;
				boucle = true;
			}
		}
		return null;
	}

	public V get(K key) {
		int pos = Math.abs(key.hashCode()) % table.length;
		boolean boucle = false;

		for(int i = 0; i < table.length; i ++) {
			if(i == pos && boucle)
				return null;
			if(table[i] != null && table[i].getKey().equals(key))
				return table[i].getValue();
			if(i == table.length - 1){
				boucle = true;
				i = 0;
			}
		}
		return null;
	}

	public V remove(K key) {
		int pos = Math.abs(key.hashCode()) % table.length;
		boolean boucle = false;
		for(int i = pos; i < table.length; i++){
			if(i == pos && boucle)
				return null;
			if(table[i] != null && table[i].getKey().equals(key)){
				Entry<K, V> res = table[i];
				table[i] = null;
				size--;
				return res.getValue();
			}
			if(i == table.length - 1){
				boucle = true;
				i = 0;
			}
		}
		return null;
	}
}
