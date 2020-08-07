package customCyclicBarrier;

public class CustomCyclicBarrier {
	private int initialParties;
	private int partiesAwait;
	private Runnable barrierActionEvent;
	
	public CustomCyclicBarrier(int parties, Runnable barrierActionEvent){
		this.initialParties = parties;
		this.partiesAwait = parties;
		this.barrierActionEvent = barrierActionEvent;
	}
	
	public synchronized void await() throws InterruptedException{
		partiesAwait--;
		if(partiesAwait > 0){
			this.wait();
		}else{
			partiesAwait = initialParties;
			this.notifyAll();
			//if we uncomment below line last thread will run run method normally
			//barrierActionEvent.run();
			//use below code to let it handle by seperate thread
			Thread t = new Thread(barrierActionEvent);
			t.start();
		}
	}
}
