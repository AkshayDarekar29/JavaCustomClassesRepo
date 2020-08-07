package evenIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6);
		EvenList<Integer> evenList = new EvenList<>(list);
		Iterator<Integer> it = evenList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
