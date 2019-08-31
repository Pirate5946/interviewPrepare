package thread;

public class DeadLockDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadDeadLock threadDeadLock = new ThreadDeadLock();
		Thread a = new Thread(threadDeadLock);
		threadDeadLock.setFlag("a");
		a.start();
		Thread.sleep(1);  // 这里 main 线程让出cpu ，让a启动，然后修改flag；  不暂停的话，flag直接变成b
		threadDeadLock.setFlag("b");
		Thread b = new Thread(threadDeadLock);
		b.start();
	}

}

class ThreadDeadLock extends Thread {
	String flag ;
	Object threadA = new Object();
	Object threadB = new Object();
	
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		if (flag == "a") {
			synchronized (threadA) {
				System.out.println("a start");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (threadB) { 
					System.out.println("a over");
				}
			}
		}
		
		if (flag == "b") {
			synchronized (threadB) {
				System.out.println("b start");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (threadA) {
					System.out.println("b over");
				}
			}
		}
	}
}