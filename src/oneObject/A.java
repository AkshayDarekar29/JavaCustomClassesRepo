package oneObject;

import java.util.HashSet;

public class A {
	static HashSet<String> hash = new HashSet<>();
	public A(){
		String objClass = this.getClass().getName();
		if(hash.contains(objClass)){
			throw new RuntimeException();
		}else{
			hash.add(objClass);
		}
	}
}
