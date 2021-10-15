package day05_HashMap.src.class02;

import java.util.*;

public class GroupAnagrams_49 {

    /*
        排序
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);    // 排好序后,keyStr作为map-key
            String keyStr = new String(array);
            List<String> list = map.getOrDefault(keyStr, new ArrayList<String>());
            list.add(str);
            map.put(keyStr, list);
        }
        return new ArrayList<List<String>>(map.values());
    }*/

    /*
        计数
            记录字符串字母出现的次数，以此来作为map-key
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] count = new char[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String keyStr = new String(count);
            map.put(keyStr, map.getOrDefault(keyStr, new ArrayList<>()));
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }*/
}
