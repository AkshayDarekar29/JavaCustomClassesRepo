package customReentrantLock;

public interface CustomLock {
	public void lock() throws InterruptedException;
	public void unlock();
	public boolean tryLock() throws InterruptedException;
}
