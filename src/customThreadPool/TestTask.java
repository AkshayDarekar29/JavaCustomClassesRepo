package customThreadPool;

public class TestTask implements Runnable{
	private int number;
    public TestTask(int number) {
        this.number = number;
    }
   @Override
    public void run() {
        System.out.println(" ************ Started execution of task number : "+ number + " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ended execution of task number : "+ number + " by " + Thread.currentThread().getName());

    }
}
