package collections.array;

import java.util.ArrayList;

/**
 * @ClassName GetUglyNumber
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/24 22:58
 * @Version 1.0
 **/
public class GetUglyNumber {

    public static void main(String[] args) {
        int index = 10;
        int indexUglyNumber = getIndexUglyNumber(index);
        System.out.println(indexUglyNumber);
    }

    private static int getIndexUglyNumber(int index) {
        // 因子只包含 2 、 3、 5
        if (index < 7) {
            return index;
        }
        ArrayList<Integer> list = new ArrayList<Integer>(index);
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0, min = 0;

        while (list.size() < index) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            min = Math.min(m2, Math.min(m3, m5));
            System.out.println(min);
            list.add(min);
            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
        }
        return min;

    }
}
