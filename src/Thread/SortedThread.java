package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title:SortedThread </p>
 * <p>Description:  使三个线程 A,B,C 依次执行  </p>
 * <p>Company: </p>
 * @author	lt
 * @date	2018年6月24日上午11:00:07
 * @vesion  1.0
 */
public class SortedThread {
	
	public static void main(String[] args) throws InterruptedException {
//		cankao();
		sortbyjoin();
	}
	
	private static void sortbyjoin() throws InterruptedException {
		Thread a = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + ": A");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		 
		Thread b = new Thread(new Runnable() {
	            public void run() {
	                System.out.println(Thread.currentThread().getName() + ": B");
	                try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
	     });
	     
	    Thread c = new Thread(new Runnable() {
	            public void run() {
	                System.out.println(Thread.currentThread().getName() + ": C");
	                try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
	     });
	    a.start();
	    a.join();
	    b.start();
	    b.join();
	    c.start();
	    
	}
	public static void cankao() {
		/**
		 * 我们要做的就是有三个线程a，b，c，这三个线程都有一个方法分别打印A、B、C，问怎么能实现依次打印ABC的功能
		 */
		 Thread a = new Thread(new Runnable() {
	            public void run() {
	                System.out.println(Thread.currentThread().getName() + ": A");
	            }
	     });
		 
	     Thread b = new Thread(new Runnable() {
	            public void run() {
	                System.out.println(Thread.currentThread().getName() + ": B");
	            }
	     });
	     
	     Thread c = new Thread(new Runnable() {
	            public void run() {
	                System.out.println(Thread.currentThread().getName() + ": C");
	            }
	     });
	     //创建一个线程池，把这个三个线程装进这个线程池里
	     //线程池的实现是用的队列这个数据结构，因此先进先出，且每次只能弹出一个线程
	     //其实就是利用线程池完成每次工作的线程只有一个，且是队头线程
	     ExecutorService executor = Executors.newSingleThreadExecutor();
	     executor.submit(a);
	     executor.submit(b);
	     executor.submit(c);
	     //结束该线程池的生命周期
	     executor.shutdown();
			        
	}
}
