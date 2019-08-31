package datastructure;

import java.util.Iterator;
import java.util.List;

/**
 * boss 直聘面试题    ，考察  fast fail机制
 * <p>Title:User </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author	lt
 * @date	2018年7月31日上午11:35:59
 * @vesion  1.0
 */
public class User {
	public User(Integer age) {
		super();
		this.age = age;
	}

	private Integer age ;
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge(){
		return age;
	}
	
	public static  void remove(List<User> userList){		 			
		Iterator<User> it = userList.iterator();
		while (it.hasNext()) {
			User user = it.next();
			if (user.getAge() > 20) {
				it.remove();
			}
		}
	}

}
