package customReentrantLock;

public class CustomReentrantLock implements CustomLock{
	private long idOfThreadCurrentlyHoldingLock;
	private int lockHoldCount;
	public CustomReentrantLock() {
		lockHoldCount = 0;
	}
	@Override
	public synchronized void lock() throws InterruptedException {
		if(lockHoldCount == 0){
			idOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
			lockHoldCount++;
		}else if (lockHoldCount > 0 && idOfThreadCurrentlyHoldingLock == Thread.currentThread().getId()){
			lockHoldCount++;
		}else{
			this.wait();
			lockHoldCount++;
			idOfThreadCurrentlyHoldingLock = Thread.currentThread().getId();
		}
		
	}

	@Override
	public synchronized void unlock() {
		if(lockHoldCount == 0){
			throw new IllegalMonitorStateException();
		}
		lockHoldCount--;
		if(lockHoldCount == 0){
			this.notifyAll();
		}
	}

	@Override
	public synchronized boolean tryLock() throws InterruptedException {
		if(lockHoldCount == 0){
			lock();
			return true;
		}
		return false;
	}
}
