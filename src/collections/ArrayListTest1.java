package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ArrayListTest1 {
	public static void main(String[] args) {
		User user1 = new User(12);
		User user2 = new User(22);
		User user3 = new User(13);
		User user4 = new User(112);
		
		
		List<User> userList = new ArrayList<User>();
			
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user.getAge());
		}
		
		final CountDownLatch latch = new CountDownLatch(1);
		
		Thread a = new Thread() {
			public void run() {
				User.remove(userList);
				latch.countDown();
			}
		};

		Thread b = new Thread() {
			public void run() {
				User.remove(userList);
				latch.countDown();
			}
		};

		a.start();
//		b.start();

		try {
			latch.await();
			System.out.println("...");
			for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				System.out.println(user.getAge());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
;
