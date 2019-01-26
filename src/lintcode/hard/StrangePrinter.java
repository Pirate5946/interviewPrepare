package lintcode.hard;

import java.util.ArrayList;

public class StrangePrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabc";
		
		System.out.println(strangePrinter(s));
	}

	public static int strangePrinter(String s) {
        char[] char1 = s.toCharArray();
        ArrayList<String> al2 = new ArrayList<String>();
        int count = 0;
        int length = s.length();

        for(int i = 0; i < length; i++){
            //遍历容器1，如果容器2中没有对应字符，计数器++，将字符加入容器2
        	String chari = String.valueOf(char1[i]);
        	if(!al2.contains(chari)){
            	count++;
            	al2.add(chari);
            }
        }
        return count;
    }
}

