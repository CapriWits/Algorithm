package day05_HashMap.src.class02;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram_242 {

    /*
        排序
            将两个字符串进行排序，然后判断是否相等
     */
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }*/

    /*
        哈希表
     */
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) return false;
        }
        return true;
    }*/

    /*
        哈希表，数组优化
     */
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mem = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mem[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            mem[t.charAt(i) - 'a']--;
        }
        for (int i : mem) {
            if (i != 0) return false;
        }
        return true;
    }*/

}
