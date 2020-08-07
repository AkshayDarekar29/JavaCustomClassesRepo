package customReentrantLock;

public class Test {
	public Test() {
		sum();
		//main(null);
	}

	private  void sum() {
		System.out.println("sum method is called");
	}
	
	private  void sum2() {
		System.out.println("sum method is called");
	} 
	
	public static void main(String[] args) {
		Test t = new Test();
		//t.sum2();
	}
}
