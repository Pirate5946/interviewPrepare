package collections.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName GetLeastNumbers
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/16 20:47
 * @Version 1.0
 **/
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> leastNumbers = getLeastNumbers(array, 4);
        System.out.println(leastNumbers.toString());
    }

    public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        int arrLength = input.length;
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (arrLength < k) {
            return resultList;
        }
        for (int i = 0; i < arrLength; i++) {
            resultList.add(input[i]);
        }
        Collections.sort(resultList);
        for (int i = 0; i < arrLength; i++) {
            if (resultList.indexOf(input[i]) == -1 ) {
                resultList.add(input[i]);
            }
        }
        if (resultList.size() <= k) {
            return resultList;
        } else {
            return new ArrayList<>(resultList.subList(0, k));
        }
    }
}
