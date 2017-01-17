
public interface Map<K, V> {
	V put(K key, V value);
	V get(K key);
	V remove(K key);
	
	boolean containsKey(K key);
	boolean containsValue(V value);
	
	int size();
	
	public interface Entry<K, V> {
		K getKey();
		
		V getValue();
		V setValue(V value);
	}
}
