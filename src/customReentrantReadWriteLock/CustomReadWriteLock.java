package customReentrantReadWriteLock;

public interface CustomReadWriteLock {
	public CustomReentrantReadWriteLock.ReadLock readLock();
	public CustomReentrantReadWriteLock.WriteLock writeLock();
}
