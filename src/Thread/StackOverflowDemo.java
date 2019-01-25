package Thread;

/**
 *   本来想练习死锁， 结果成了 栈溢出 的例子
 * <p>Title:StackOverflowDemo </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author	lt
 * @date	2018年7月12日下午10:39:03
 * @vesion  1.0
 */
public class StackOverflowDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		a.start();
		b.start();
	}

}

class  ThreadA extends Thread {
	ThreadB ThreadB = new ThreadB();
	@Override
	public void run() {
		synchronized (new Object()) {
			System.out.println("waiting for thread b");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ThreadB.deadlock();
		}
	}
	
	synchronized public void deadlock() {
		System.out.println("wating for thread b");
	}
}

class ThreadB extends Thread {
	ThreadA threadA = new ThreadA();
	
	@Override
	public void run() {
		synchronized (new Object()) {
			System.out.println("waiting for thread a");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadA.deadlock();
		}
	}
	synchronized public void deadlock() {
		System.out.println("waiting for thread a");
	}
}