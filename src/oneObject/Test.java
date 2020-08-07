package oneObject;

import java.util.concurrent.atomic.LongAdder;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		System.out.println("***********");
		B b = new B();
		A b1 = new B();
	}
}
