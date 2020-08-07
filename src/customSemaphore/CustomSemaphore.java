package customSemaphore;

public class CustomSemaphore {
	private int availablePermits;
	
	public CustomSemaphore(int availablePermits){
		this.availablePermits = availablePermits;
	}
	
	public synchronized void acquire() throws InterruptedException{
		if(availablePermits > 0){
			availablePermits--;
		}else{
			this.wait();
			availablePermits--;
		}
	}
	
	public synchronized void release() {
		availablePermits++;
		if(availablePermits > 0){
			this.notifyAll();
		}
	}
}
