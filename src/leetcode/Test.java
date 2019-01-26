package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// HashMap<Object, Object> hashMap = new HashMap<>();
		
		// String string = new String().join("||", "Hello", "Royal", "Mario");
		// System.out.println(string);
	}
	public List<String> copyOfBinaryWatch(int num) {

		if (num < 0 || num > 9) {
			return null;	
		}
		List<String> watches = new ArrayList<String>();
		if (num == 0) {
			watches.add("0:00");
		}	

		return watches;
	}
}
