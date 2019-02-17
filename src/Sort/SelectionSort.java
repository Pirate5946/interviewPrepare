package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName SelectionSort
 * @Descrption ：选择排序
 *      算法分析  最佳情况：T(n) = O(n2)、
 *              最差情况：T(n) = O(n2)、
 *              平均情况：T(n) = O(n2)
 * @Author lt
 * @Date 2019/2/17 15:16
 * @Version 1.0
 **/
public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = new int[]{3, 1, 4, 12, 8, 7, 43, 5};

        intArray = sort(intArray);

        System.out.println(Arrays.toString(intArray));
    }

    private static int[] sort(int[] intArray) {
        int length = intArray.length;
        if (length == 0) {
            return intArray;
        }
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (intArray[j] < intArray[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = intArray[i];
            intArray[i] = intArray[minIndex];
            intArray[minIndex] = temp;
        }
        return intArray;
    }
}
