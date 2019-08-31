package datastructure;/**
 * Created by lt on 2019/1/31.
 */

import java.util.ArrayList;

/**
 * @ClassName ArrayListTest2
 * @Descrption TODO
 * @Author lt
 * @Date 2019/1/31 17:00
 * @Version 1.0
 **/
public class ArrayListTest2 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add(null);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
    }
}
