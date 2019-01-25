package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionTest1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		Set<String> set = new LinkedHashSet<>();
		
		Map<Integer, String> map = new HashMap<>();
		
		String[] stringArray = new String[]{"a","b","c","d","e","a","f","a","g"};
		
		list.addAll(Arrays.asList(stringArray));
		
		set.addAll(Arrays.asList(stringArray));
		
		for(int i = 0; i < stringArray.length; i++) {
			map.put(i, stringArray[i]);
		}
		
		System.out.println("list.length = " + list.size());
		System.out.println("set.length = " + set.size());
		System.out.println("map.length = " + map.size());
		System.out.println("map.keyset.length = " + map.keySet().size());
		
		//遍历map，输出每个key的值、hash值
		Set<Integer> set1 = map.keySet();
		for (Iterator<Integer> iterator = set1.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println("key : " + integer + " hash key : " + integer.hashCode() );
			
		}
	}
}
