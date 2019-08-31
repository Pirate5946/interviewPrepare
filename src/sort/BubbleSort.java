package sort;

/**
 * Created by lt on 2019/2/17.
 */

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Descrption TODO
 * @Author lt
 * @Date 2019/2/17 14:29
 * @Version 1.0
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] intArray = new int[]{3, 1, 4, 12, 8, 7, 43, 5};

        intArray = sort(intArray);

        /*for (int i : intArray) {
            System.out.print(i + " ");
        }*/
        System.out.println(Arrays.toString(intArray));
    }

    private static int[] sort(int[] intArray) {
        int length = intArray.length;
        if (length == 0) {
            return intArray;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
        return intArray;
    }
}
