package datastructure.map;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author : LIUTAO
 * create at : 2019-09-01 15:35
 * @description: keyMap
 **/
public class TreeMapTest {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        Integer count = treeMap.get(ch);
        if (count == null) {
            treeMap.put(String.valueOf(ch), 1);
        } else {
            treeMap.put(String.valueOf(ch), count++);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        Set<String> strings = treeMap.keySet();
        for (String string  : strings) {
            if (treeMap.get(string) == 1) {
                char[] chars = string.toCharArray();
                return chars[0];
            }
        }
        return '#';
    }
}
