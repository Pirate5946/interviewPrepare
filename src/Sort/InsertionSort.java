package Sort;/**
 * Created by lt on 2019/1/26.
 */

/**
 * @ClassName InsertionSort
 * @Descrption 插入排序
 * 平均性能  O(n^2)
 * 最坏情况
 * @Author lt
 * @Date 2019/1/26 16:37
 * @Version 1.0
 **/
public class InsertionSort {

    public static void main(String[] args) {
        int[] intArray = new int[]{5, 12, 13, 4, 3, 6, 8, 9, 2, 1};

        intArray = insertSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }

    private static int[] insertSort(int[] intArray) {
        int size = intArray.length;

        if (size == 0) {
            return intArray;
        }

        for (int index = 1; index < size; index++) {
            for (int j = index - 1; j >= 0; j--) {  // 遍历前面的已排序序列 跟 当前数字进行比较
                if (intArray[index] < intArray[j]) {
                    int temp = intArray[index];
                    intArray[index] = intArray[j];
                    intArray[j] = temp;
                    index--;       // 当前数字前移，下标需要同步往前移动
                }
            }
        }
        return intArray;
    }
}
