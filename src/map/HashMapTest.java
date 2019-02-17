package map;/**
 * Created by lt on 2019/1/31.
 */

import java.util.HashMap;

/**
 * @ClassName HashMapTest
 * @Descrption TODO
 * @Author lt
 * @Date 2019/1/31 15:27
 * @Version 1.0
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, 111);
        map.put(null, 222);
        System.out.println(map.get(null));
        map.put(123, null);
        System.out.println(map.get(123));
    }

}
