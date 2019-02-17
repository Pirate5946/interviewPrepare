package Sort;

import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Descrption 希尔排序  https://mp.weixin.qq.com/s/iuDVZqShmg1CV6bdXVQmKw
 *             最佳情况：T(n) = O(nlog2 n)
 *             最坏情况：T(n) = O(nlog2 n)
 *             平均情况：T(n) = O(nlog2n)
 * @Author lt
 * @Date 2019/2/17 15:52
 * @Version 1.0
 **/
public class ShellSort {

    public static void main(String[] args) {
        int[] intArray = new int[]{2, 1, 13, 5, 42, 67, 3, 21};

        intArray = sort(intArray);

        System.out.println(Arrays.toString(intArray));
    }

    private static int[] sort(int[] intArray) {
        int len = intArray.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = intArray[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && intArray[preIndex] > temp) {
                    intArray[preIndex + gap] = intArray[preIndex];
                    preIndex -= gap;
                }
                intArray[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return intArray;
    }

}
