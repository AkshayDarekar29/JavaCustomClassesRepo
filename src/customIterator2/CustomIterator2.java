package customIterator2;

import java.util.Iterator;
import java.util.List;

public class CustomIterator2 implements Iterator{
	Iterator it;
	public CustomIterator2(List list){
		it = list.iterator();
	}
	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public Object next() {
		Object obj = null;
		if(it.hasNext()){
			obj = it.next();
			if(it.hasNext()){
				it.next();
			}
		}
		return obj;
	}
}
