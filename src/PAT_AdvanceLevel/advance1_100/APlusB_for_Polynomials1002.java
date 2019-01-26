package PAT_AdvanceLevel.advance1_100;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 * <p>Title:APlusB_for_Polynomials1002 </p>
 * <p>Description:  PAT 刷题 1002 </p>
 * <p>Company: </p>
 *
 * @author lt
 * @date 2018年1月7日下午4:16:52
 * @vesion 1.0
 * @Input input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial: K N1 aN1 N2 aN2 ... NK aNK, where K is the number of nonzero terms in the polynomial, Ni and aNi (i=1, 2, ..., K) are the exponents and coefficients, respectively. It is given that 1 <= K <= 10，0 <= NK < ... < N2 < N1 <=1000.
 * 2 1 2.4 0 3.2
 * 2 2 1.5 1 0.5
 * @Output For each test case you should output the sum of A and B in one line, with the same format as the input. Notice that there must be NO extra space at the end of each line. Please be accurate to 1 decimal place
 * @see <a href="http://google.com">http://google.com</a>
 */
public class APlusB_for_Polynomials1002 {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().trim().split(" ");
        String[] line2 = sc.nextLine().trim().split(" ");
        sc.close();

        int k1 = Integer.parseInt(line1[0]);
        int k2 = Integer.parseInt(line2[0]);

        TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();

        for (int i = 1; i < k1 * 2 + 1; i += 2) {
            int key = Integer.valueOf(line1[i]);
            double value = Double.valueOf(line1[i + 1]);
            map.put(key, value);
        }

        for (int i = 1; i < k2 * 2 + 1; i += 2) {
            int key = Integer.valueOf(line2[i]);
            double value = Double.valueOf(line2[i + 1]);

            if (map.containsKey(key)) {
                value += map.get(key);
                if (Math.abs(value) <= 0.00001) {
                    map.remove(key);              //注意！！！  排除 0系数项
                } else {
                    value = Math.round(value * 10) / 10.0;  //题目要求
                    map.put(key, value);
                }
            } else {
                value = Math.round(value * 10) / 10.0;
                map.put(key, value);
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        Stack<Integer> stack = new Stack<Integer>();
        while (it.hasNext()) {
            stack.push(it.next());
        }
        System.out.print(map.size());    //输出也注意
        while (!stack.isEmpty()) {
            System.out.print(" " + stack.peek());
            System.out.print(" " + map.get(stack.pop()));
        }
    }
}


