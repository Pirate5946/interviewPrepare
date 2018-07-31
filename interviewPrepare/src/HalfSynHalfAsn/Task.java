package HalfSynHalfAsn;

public class Task {
	String string = new String("");  // 多个线程对象调用同一个task对象  只会生成同一个的 string对象锁
	public void doLongTimeTask() {
//		String string = new String("");  // 多个线程对象调用同一个task对象  会生成不同的 string对象锁
//		for (int i = 0; i < 100; i++) {
//			System.out.println("nosynchronized ThreadName=" + Thread.currentThread().getName()
//					+ " i=" + (i + 1));
//		}
//		System.out.println("");
		synchronized (string) {
			for (int i = 0; i < 100; i++) {
				System.out.println("synchronized ThreadName=" + Thread.currentThread().getName()
					+ " i=" + (i + 1));
			}
		}
	}
}
