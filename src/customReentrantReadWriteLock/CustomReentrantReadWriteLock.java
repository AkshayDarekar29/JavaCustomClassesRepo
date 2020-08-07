package customReentrantReadWriteLock;


public class CustomReentrantReadWriteLock implements CustomReadWriteLock{
	private final ReadLock readLock;
	private final WriteLock writeLock;
	private int readLockCount;
	private int writeLockCount;

	public CustomReentrantReadWriteLock() {
		readLock = new ReadLock();
		writeLock = new WriteLock();
	}
	@Override
	public ReadLock readLock() {
		return readLock;
	}

	@Override
	public WriteLock writeLock() {
		return writeLock;
	}
	
	public class ReadLock{
		public synchronized void lock() throws InterruptedException{
			if(writeLockCount == 0){
				readLockCount++;
			}else{
				this.wait();
				readLockCount++;
			}
		}
		
		public synchronized void unlock(){
			readLockCount--;
			if(readLockCount == 0 && writeLockCount == 0){
				this.notifyAll();
			}
		}
	}
	
	public class WriteLock{
		public synchronized void lock() throws InterruptedException{
			if(writeLockCount == 0 && readLockCount == 0){
				writeLockCount++;
			}else{
				this.wait();
			}
		}
		
		public synchronized void unlock(){
			writeLockCount--;
			if(writeLockCount == 0 && readLockCount == 0){
				this.notifyAll();
			}
		}
	}

}
