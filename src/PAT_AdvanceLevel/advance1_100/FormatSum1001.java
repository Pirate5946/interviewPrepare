package PAT_AdvanceLevel.advance1_100;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * <p>Title:FormatSum1001 </p>
 * <p>Description: 练习 PAT1001，格式化输出整形数字</p>
 * <p>Company: </p>
 * @author	lt
 * @date	2017年11月25日上午10:07:10
 * @vesion  1.0
 */
public class FormatSum1001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		decimalFormat1();
		
	}
	
	/**
	 * 从System.in 读取两个整数并求和，返回格式化后的值
	 * @input 1231412 2313
	 */
	public static void decimalFormat1(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);  
        int a = sc.nextInt();  
        int b = sc.nextInt();  
		
		DecimalFormat df1 = (DecimalFormat) DecimalFormat.getInstance();
		df1.setGroupingSize(3);
		System.out.println(df1.format(a + b));
	}
	
	@SuppressWarnings("resource")//告诉编译器忽略指定的警告，不用在编译完成后出现警告信息。
	public static void decimalFormat2() {
		Scanner sc=new Scanner(System.in);  
        int a = sc.nextInt();  
        int b = sc.nextInt();  
        
        System.out.printf("%,d", a+b);
	}
}
