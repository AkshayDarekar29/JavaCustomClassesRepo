package customThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class CustomThreadPool {
	
	private BlockingQueue<Runnable> queue;
	
	public CustomThreadPool(int nThreads){
		this.queue = new LinkedBlockingQueue<>();
		for(int i=0; i< nThreads; i++){
			String threadName = "ThreadPool - Thread - " + i;
			TaskExecutorThread runnable = new TaskExecutorThread();
			Thread thread = new Thread(runnable, threadName);
			thread.start();
		}
	}
	
	public void submit(Runnable task) throws InterruptedException{
		queue.put(task);
	}
	
	private class TaskExecutorThread implements Runnable{
		
		private TaskExecutorThread(){	}
		
		@Override
		public void run() {
			try {
				while(true){
					Runnable task = queue.take();
	                task.run();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
