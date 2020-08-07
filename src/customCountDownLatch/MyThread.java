package customCountDownLatch;

public class MyThread implements Runnable{
	CustomCountDownLatch latch;
	int sleepTime;
	MyThread(CustomCountDownLatch latch, int sleepTime){
		this.latch = latch;
		this.sleepTime = sleepTime;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " - thread is doing some work");
			Thread.sleep(sleepTime);
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " - thread is doing some work again after calling countdown method");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
