package customIterator2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6);
		Iterator it = new CustomIterator2(list);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
