package evenIterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class EvenList<T> implements Iterable<T>{
	private List<T> list;
	
	EvenList(List<T> list){
		this.list = list;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new EvenIterator<T>();
	}

	private class EvenIterator<T> implements Iterator<T>{
		int size = list.size();
		int currPointer = 0;
		@Override
		public boolean hasNext() {
			return (currPointer < size);
		}

		@Override
		public T next() {
			 if (!hasNext()) {
			    throw new NoSuchElementException();
			 }
			 T val = (T)list.get(currPointer);
			 currPointer = currPointer + 2;
			 return val;
		}
		
	}
}
