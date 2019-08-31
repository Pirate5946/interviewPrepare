package thread;

public class DeadLockDemo {

	public static void main(String[] args) {
		TaskA taskA = new TaskA();
		TaskB taskB = new TaskB();
		ThreadA1 a = new ThreadA1(taskA);
		ThreadB1 b = new ThreadB1(taskB);
		a.start();
		
		b.start();
	}

}

class TaskA {
	private TaskB taskB = new TaskB();

	public void taskA() {
		synchronized (new Object()) {
			System.out.println("taskA start");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			taskB.taskB();
			System.out.println("TaskA over");
		}
	}
}
class TaskB {
	TaskA taskA = new TaskA();
	public void taskB() {
		synchronized (new Object()) {
			System.out.println("TaskB start");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			taskA.taskA();
			System.out.println("TaskB over");
		}
	}
}

class ThreadA1 extends Thread {
	TaskA taskA;
	public ThreadA1(TaskA taskA) {
		this.taskA = taskA;
	}
	public void run() {
		taskA.taskA();
	}
}


class ThreadB1 extends Thread {
	TaskB task;
	public ThreadB1(TaskB task) {
		this.task = task;
	}
	public void run() {
		task.taskB();
	}
}