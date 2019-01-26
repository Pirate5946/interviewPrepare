package lintcode.easy;

public class Longestpalindrome {
	/*
	 * @param s: a string which consists of lowercase or uppercase letters
	 * 
	 * @return: the length of the longest palindromes that can be built
	 * 
	 * 已知字符串，判断其中最长回文字符串的长度
	 */
	public static int longestPalindrome(String s) {
		// write your code here
		// 获取字符串 String a 的所有子串，长度为key，值为value，存入HashMap
		// 获取字符串 String a 的所有子串并反转 长度为key，值为value，存入HashMap;
		// 迭代HashMap，比较Value，相等则获取key

		// if(s == null && s.length > 1010) {
		// return false;
		// }

		int length = s.length();
		int stringlength = length;

        // hi - lo  = length;
		while (length > 0){

            int hi = 0;
			
			for (int lo = 0; hi < stringlength; lo++) {

				hi = length + lo ;

				String subString = s.substring(lo, hi);

				StringBuilder sb = new StringBuilder(subString);

				String _subString = sb.reverse().toString();

				if (subString.equals(_subString)) {
					return length  ;
				}

				// int subStringLength = s1.length;
				// for(int index; index > subStringLength; index++) {
				// if(s1[index].equals(s2[index])) {
				// return i;
				// }
				// }
			}
			
    	    length--;
		}
    	return length ;
	}
	
	public static void main(String[] args) {
		String teString = "abccccdd";
		
		System.out.println(longestPalindrome(teString));
	}
}
