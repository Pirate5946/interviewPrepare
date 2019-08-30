package collections.array;

import java.util.HashMap;


/**
 * @ClassName findCharSequence
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/16 20:04
 * @Version 1.0
 **/
public class FindCharSequence {
    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] array = {1};

        int i = moreThanHalfNum(array);
        System.out.println(i);
    }
    public static int moreThanHalfNum(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        HashMap<Integer, Integer> charSeqMap = new HashMap<>();
        int length = array.length;
        int halfLength = length / 2 ;
        for(int i = 0; i < length; i++) {
            Integer charSeq = charSeqMap.get(Integer.valueOf(array[i]));
            if (charSeq == null) {
                charSeqMap.put(array[i], 1);
            } else {
                Integer newCharSeq = ++charSeq;
                if (newCharSeq > halfLength) {
                    return array[i];
                }
                charSeqMap.put(array[i], newCharSeq);
            }
        }
        return 0;
    }

}
