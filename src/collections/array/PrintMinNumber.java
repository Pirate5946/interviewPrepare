package collections.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName PrintMinNumber
 * @Descrption 剑指Offer 把数组排成最小的数<p>https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking</p>
 * @Author lt
 * @Date 2019/6/24 22:13
 * @Version 1.0
 **/
public class PrintMinNumber {
    public static void main(String[] args) {
        int[] intArray = new int[]{3, 32, 321};
        String minString = sort(intArray);
        System.out.println(minString);
    }

    private static String sort(int[] intArray) {

        if (intArray == null || intArray.length == 0) {
            return "";
        }
        int length = intArray.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = String.valueOf(intArray[i]);
        }

        Arrays.sort(strArr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
