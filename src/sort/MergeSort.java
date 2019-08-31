package sort;/**
 * Created by lt on 2019/1/26.
 */

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Descrption TODO
 * 最佳情况：T(n) = O(n)
 * 最差情况：T(n) = O(nlogn)
 * 平均情况：T(n) = O(nlogn)
 * @Author lt
 * @Date 2019/1/26 22:43
 * @Version 1.0
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = new int[]{2, 1, 13, 5, 42, 67, 3, 21};

        intArray = MergeSort(intArray);

        System.out.println(Arrays.toString(intArray));
    }

    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

}
