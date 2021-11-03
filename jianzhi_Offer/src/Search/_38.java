package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素
 * @Description: 剑指 Offer 38. 字符串的排列
 * @Author: Hypocrite30
 * @Date: 2021/11/3 22:05
 */
public class _38 {
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        DFS(s.toCharArray(), list, 0);
        return list.toArray(new String[0]);
    }

    /**
     * 在全排列的基础上，使用 set 去重即可
     */
    private void DFS(char[] chars, List<String> list, int idx) {
        if (idx == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        HashSet<Character> set = new HashSet<>(); // 用 set 去重
        for (int i = idx; i < chars.length; i++) {
            if (set.contains(chars[i]))
                continue;
            set.add(chars[i]);
            swap(chars, idx, i);
            DFS(chars, list, idx + 1);
            swap(chars, i, idx);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    /***********************************************/
    private List<String> res;
    boolean[] visited;

    /**
     * 回溯
     */
    public String[] permutation2(String s) {
        res = new ArrayList<>();
        visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // 按照字典排序，重复的字符会相邻
        StringBuilder path = new StringBuilder();
        backTrack(chars, path, 0);
        return res.toArray(new String[0]);
    }

    /**
     * 回溯
     */
    private void backTrack(char[] chars, StringBuilder path, int idx) {
        if (idx == chars.length) {
            path.append(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && chars[i - 1] == chars[i]))
                continue;
            visited[i] = true;
            path.append(chars[i]);
            backTrack(chars, path, idx + 1);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }

}
