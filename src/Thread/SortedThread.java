package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>Title:SortedThread </p>
 * <p>Description:  使三个线程 A,B,C 依次执行  </p>
 * 这是一个典型的执行屏障的问题，可以通过构造屏障来实现。
 *
 * 如下图，我们需要构造 22 道屏障，second 线程等待 first 屏障，third 线程等待 second 屏障
 *
 * 作者：pulsaryu
 * 链接：<link>https://leetcode-cn.com/problems/print-in-order/solution/gou-zao-zhi-xing-ping-zhang-shi-xian-by-pulsaryu/</link>
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>Company: </p>
 * @author	lt
 * @date	2018年6月24日上午11:00:07
 * @vesion  1.0
 */
public class SortedThread {

	static class Foo {

		private boolean firstFinished;
		private boolean secondFineshed;
		private Object lock = new Object();

		public Foo() {

		}

		public void first(Runnable printFirst) throws InterruptedException {

			// printFirst.run() outputs "first". Do not change or remove this line.
			synchronized (lock) {
				printFirst.run();
				firstFinished = true;
				lock.notifyAll();
			}
		}

		public void second(Runnable printSecond) throws InterruptedException {

			synchronized (lock) {
				while (!firstFinished) {
					lock.wait();
				}
				// printSecond.run() outputs "second". Do not change or remove this line.
				printSecond.run();
				secondFineshed = true;
				lock.notifyAll();
			}
		}

		public void third(Runnable printThird) throws InterruptedException {

			synchronized (lock) {
				while (!secondFineshed) {
					lock.wait();
				}
				// printThird.run() outputs "third". Do not change or remove this line.
				printThird.run();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
//		cankao();
//		sortbyjoin();
		Foo f = new Foo();
		Thread t1 = new Thread(() -> {
			try {
				f.first(() -> {
					System.out.println("First ");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				f.second(() -> {
					System.out.println("second ");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(() -> {
			try {
				f.third(() -> {
					System.out.println("third ");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static void sortbyjoin() throws InterruptedException {
		Thread a = new Thread(new Runnable() {
			@Override
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
	            @Override
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
	            @Override
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
	            @Override
				public void run() {
	                System.out.println(Thread.currentThread().getName() + ": A");
	            }
	     });
		 
	     Thread b = new Thread(new Runnable() {
	            @Override
				public void run() {
	                System.out.println(Thread.currentThread().getName() + ": B");
	            }
	     });
	     
	     Thread c = new Thread(() -> System.out.println(Thread.currentThread().getName() + ": C"));
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
