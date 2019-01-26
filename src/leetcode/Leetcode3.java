package leetcode;

public class Leetcode3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lengthOfLongestSubstring("abbcaaadfgh");
	}
	
	 public static int lengthOfLongestSubstring(String s) {
	        //边界条件检查
	        if (s == null || s.length() == 0)
	            return 0;
	        
	        // 遍历给定的字符串 s，如果有相同字符，计算相同字符间的长度 ans，
	        // 比较不同的 ans，获取最长的nas
	        
	        int[] hash = new int[256];
	        // 重复字符区间的起始指针 begin， 末尾指针 end
	        int begin = 0, end = 0;
	        // 字符重复次数 repeat， 重复字符区间长度 ans
	        int repeat = 0, ans = 0;
	        int length = s.length();
	        
	        while (end < length) {
	            // 为什么 这里 hash[s.charAt(end)] > 0 
	            if (hash[s.charAt(end)] > 0) {
	                repeat++;
	            }
	            end++;
	            hash[s.charAt(end)]++;
	            
	            while (repeat > 0) {
	                if (hash[s.charAt(begin++)]-- > 1) {
	                    repeat--;    
	                }
	                
	            }
	            ans = Math.max(ans, end - begin);
	        }
	        return ans;
	    }
}
