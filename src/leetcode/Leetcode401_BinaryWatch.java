package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode401_BinaryWatch {

	public static void main(String[] args) {
		Solution2 solution2 = new Solution2();
		List<String> list = solution2.readBinaryWatch(8);
		System.out.println(list);
	}
	
	/**
	 * <p>Title:solution2 </p>
	 * <p>Description: </p>
	 *  思路总结
	 *  <li>1. 总亮灯树为 hour的亮灯树 + min的亮灯数	
	 *  <li>2. 将 hour 和 min 的int值转换成 亮灯数
	 *  <li>3. 字符串 的格式化  String.format("%d:%02d",i,j);
	 * <p>Company: </p>
	 * @author	lt
	 * @date	2018年1月5日下午2:14:05
	 * @vesion  1.0
	 */
	static final class Solution2{
		/* 将 temp 最右边的二进制位 跟 1 进行位与 运算，结果为1，表示最右位 灯亮
		 * 右移一位， 重复上一步，直到 temp 为0
		 */
		 public int int2bit(int x) {
			 int num = 0, temp = x;
			 while(temp != 0) {
				 if ((temp & 0x01) == 0x01) {
					 num++;
				}
				temp >>= 1;
			 }
			 return num;
		 }
		 
		 public List<String> readBinaryWatch(int num) {
			if (num < 0 || num > 10) return null;
			
			List<String> watches = new ArrayList<String>();
			if (num == 0) {
				watches.add("0:00");
				return watches;
			}
			
			for (int hour = 0; hour < 12; hour++) {
				// if (int2bit(hour) > num) break;
				for (int min = 0; min < 60; min++) {
					// 小时的 亮灯数 + 分钟的亮灯数
					if (int2bit(hour) + int2bit(min) == num) {
//						if (min < 10) {
//		                       watches.add(hour + ":0" + min); 
//		                    } else {
//		                        watches.add(hour + ":" + min);
//		                    }
						watches.add(String.format("\"%d:%02d\"", hour,min));
					}
				}
			}
			
			return watches;
		}
	}
	
	
}
