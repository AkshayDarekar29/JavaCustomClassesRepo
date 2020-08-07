package customConcurrentHashMap;

public class CustomConcurrentHashMap<K, V> implements CustomMap<K, V>{
	private int initialCapacity;
	private int concurrencyLevel;
	private float loadFactor;
	private final Segment[] segments;
	private Node[] table;
	public CustomConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel) {
		if(initialCapacity < concurrencyLevel){
			this.initialCapacity = concurrencyLevel;
		}else{
			this.initialCapacity = initialCapacity;
		}
		this.concurrencyLevel = concurrencyLevel;
		this.loadFactor = loadFactor;
		this.table = new Node[initialCapacity];
		this.segments = new CustomConcurrentHashMap.Segment[concurrencyLevel];
		initializeSegments();
	}

	private void initializeSegments() {
		for (int i = 0; i < concurrencyLevel; i++) {
			final Segment seg = new Segment();
			segments[i] = seg;
		}
	}

	@Override
	public V put(K key, V value) {
		V oldVal = null;
		int hash = key.hashCode();
		int index = hash % initialCapacity;
		Segment seg = getSegmentForLocking(index);
		synchronized(seg){
			Node<K, V> node = table[index];
			if(node == null){
				Node temp = new Node(hash, key, value, null);
				table[index] = temp;
			}else{
				while(node != null){
					if(key.equals(node.key)){
						oldVal = node.value;
						node.value = value;
						break;
					}else{
						if(node.next == null){
							Node temp = new Node(hash, key, value, null);
							node.next = temp;
							break;
						}
						node = node.next;
					}
				}
			}
		}
		return oldVal;
	}

	private CustomConcurrentHashMap<K, V>.Segment getSegmentForLocking(int index) {
		int ratio = initialCapacity / concurrencyLevel;
		int segIndex = index/ratio;
		return segments[segIndex];
	}

	@Override
	public V get(K key) {
		int hash = key.hashCode();
		int index = hash % initialCapacity;
		Node<K, V> node = table[index];
		V value = null;
		while(node != null){
			K tempKey = node.key;
			if(tempKey.equals(key)){
				value = node.value;
				break;
			}else{
				node = node.next;
			}
		}
		return value;
	}
	
	private static class Node<K, V>{
		int hash;
		K key;
		V value;
		Node<K, V> next;
		
		public Node(int hash, K key, V value, Node<K, V> next) {
			super();
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private class Segment{
		private Segment(){
			
		}
	}
}
