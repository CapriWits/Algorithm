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
    /**
     * DFS + HashSet 去重
     * 本质还是全排列，只是用 set 去重
     */
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
        // 用 set 去重，就需要从 idx 开始，有别于「回溯法」
        // set 是去重当前元素以后的重复元素，因为交换后结果会重复，但是之前的重复元素不用管
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

    /*********************回溯法**************************/
    private List<String> res;
    boolean[] visited;

    /**
     * 回溯
     * 核心思想是：需要先字典排序，重复字符会相邻，则单独判断响铃字符
     * 如果相同，则跳过，避免重复
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
     * (i > 0 && chars[i - 1] == chars[i] && !visited[i - 1])
     * 1. 索引在数组中合理
     * 2. 当前字符与上个字符相同
     * 3. 上一个相同字符没有遍历过
     * 同时满足，则 continue 跳过
     * 上一个相同的字符没遍历过，则应该先让它遍历，而不是当前值去遍历。其实就是为了保证在「同一层树」，相同的字符不能同时遍历，可直接剪枝
     * 这种判断属于从树层就开始剪枝。
     * 事实上改成 visited[i - 1] 也是符合答案的
     * 而此时的情况属于从树枝上剪枝，会增加不必要的判断
     * @Reference: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/dai-ma-sui-xiang-lu-jian-zhi-offer-38-zi-gwt6/
     */
    private void backTrack(char[] chars, StringBuilder path, int idx) {
        if (idx == chars.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) { // 每次 backtrack 都会从索引 0 开始，所以需要全局的 visit 判断，跳过重复
            if (visited[i]) // 上一层树层已经访问过了，跳过，与下面的判断写一起是为了方便理解
                continue;
            if (i > 0 && chars[i - 1] == chars[i] && !visited[i - 1])
                continue;
            visited[i] = true;
            path.append(chars[i]);
            backTrack(chars, path, idx + 1);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }

    /**
     * Debug
     */
    public static void main(String[] args) {
        String[] s = new _38().permutation2("abb");
        System.out.println(Arrays.toString(s));
    }
}
