package lintcode;

public class FibonacciArray {
	/*
	 * @param n: an integer
	 * 
	 * @return: an ineger f(n)
	 * 
	 * 通过 迭代 计算 斐波那契数列  时间复杂度为 O(n)、 递归计算的时间复杂度为 O(2^n)
	 */
  public static int fibonacci(int n) {
		// write your code here
    if (n < 0) {
      throw (new RuntimeException("输入参数不能小于0"));
    }
    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return 1;
    }
    
    int a1 = 0,a2 = 1;

    for (int i = 2; i < n; i++) {

    // result = a1 + a2;
    // a2 = result; 
    // a1 = a2;
    	
      a2 += a1 ;  

      a1 = a2 - a1 ;  

    }

    return a2;
  }

  public static void main(String[] args) {

    System.out.println(fibonacci(5));
    
    int[] a = {1,2,3,1};
    
    System.out.println(a.length);

  }
}
