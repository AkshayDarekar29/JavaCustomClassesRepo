package customConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String[] args) {
		CustomConcurrentHashMap<Integer, Integer> map = new CustomConcurrentHashMap<>(16, 0.75f, 16);
		
		System.out.println(map.put(1, 11));
		System.out.println(map.put(17, 177));
		System.out.println(map.put(2, 22));
		System.out.println(map.put(3, 33));
		System.out.println(	map.put(1, 110));
		System.out.println(map.get(1));
		System.out.println(map.get(17));
		System.out.println(map.get(2));
		System.out.println(map.get(15));
		System.out.println(map.get(3));
		System.out.println(map.get(0));
	}
}
