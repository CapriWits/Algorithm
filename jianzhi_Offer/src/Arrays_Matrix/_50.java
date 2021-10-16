package Arrays_Matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @Description: 剑指 Offer 50. 第一个只出现一次的字符
 * @Author: Hypocrite30
 * @Date: 2021/10/16 15:29
 */
public class _50 {
    /**
     * 打表，可用数组来模拟，也可以用HashMap
     */
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}
