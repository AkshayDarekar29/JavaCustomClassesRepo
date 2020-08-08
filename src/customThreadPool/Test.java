package customThreadPool;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		CustomThreadPool threadPool = new CustomThreadPool(3);
        for(int taskNumber = 1 ; taskNumber <= 14; taskNumber++) {
            TestTask task = new TestTask(taskNumber);
            threadPool.submit(task);
        }
	}
}
