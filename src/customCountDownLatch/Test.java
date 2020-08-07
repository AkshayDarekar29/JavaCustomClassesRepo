package customCountDownLatch;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		CustomCountDownLatch latch = new CustomCountDownLatch(3);
		Executor pool = Executors.newFixedThreadPool(3);
		for(int i=0; i<4; i++){
			switch(i){
				case 1:
					pool.execute(new MyThread(latch, 5000));
					break;
				case 2:
					pool.execute(new MyThread(latch, 7000));
					break;
				case 3:
					pool.execute(new MyThread(latch, 2000));
					break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " calling await method");
		latch.await();
		System.out.println("latch is opened");
	}
}
