package datastructure.array;

/**
 * @ClassName FindGreatestSumOfSubarray
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/23 9:28
 * @Version 1.0
 **/
public class FindGreatestSumOfSubarray {

    public int FindGreatestSumOfSubArray(int[] array) {


        if (array == null || array.length == 0){
            return 0;
        }

        int length = array.length;

        int currSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < length; i++) {
            currSum = (currSum < 0) ? array[i] : currSum + array[i];
            maxSum = (currSum > maxSum) ? currSum : maxSum;
        }
        return maxSum;
    }

}
