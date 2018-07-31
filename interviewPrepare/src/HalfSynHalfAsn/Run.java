package HalfSynHalfAsn;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task = new Task();
		MyThread1 myThread1 = new MyThread1(task);
		myThread1.start();
		
		MyThread2 myThread2	 = new MyThread2(task);
		myThread2.start();
	}

}

class MyThread1 extends Thread {
	private Task task;
	
	public MyThread1(Task task) {
		this.task = task;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		task.doLongTimeTask();
	}
}

class MyThread2 extends Thread {
	private Task task;
	
	public MyThread2(Task task) {
		this.task = task;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		task.doLongTimeTask();
	}
}