package customCountDownLatch;

public class CustomCountDownLatch {
	private int count;
	
	public CustomCountDownLatch(int count){
		this.count = count;
	}

	public synchronized void await() throws InterruptedException{
		if(count > 0){
			System.out.println(Thread.currentThread().getName() + " thread is waiting for latch to open");
			this.wait();
		}
	}
	
	public synchronized void countDown(){
		count--;
		System.out.println(Thread.currentThread().getName() + " thread decremented count by 1. Current Count = "+ count);
		if(count == 0){
			this.notifyAll();
		}
	}
}
