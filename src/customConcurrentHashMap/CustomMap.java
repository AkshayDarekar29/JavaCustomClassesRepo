package customConcurrentHashMap;

public interface CustomMap<K, V> {
	public V put(K key, V value);
	public V get(K key);
}
