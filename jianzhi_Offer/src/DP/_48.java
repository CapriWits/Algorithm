package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @Description: 剑指 Offer 48. 最长不含重复字符的子字符串
 * @Author: Hypocrite30
 * @Date: 2021/11/7 11:52
 */
public class _48 {
    /**
     * DP
     * dp[i]：以 s[i] 结尾的字符串，最长不重复子串长度
     * 令 s[preIdx] 为 s[i] 前面最近同值元素，即 s[i] = s[preIdx]
     * 1. i < 0: s[i] 左边没有重复元素，dp[i] = dp[i - 1] + 1
     * 2. dp[i - 1] < i - preIdx: dp[i - 1] 的最长子串 没有包含住 s[preIdx]，即 s[preIdx..i-1] 更长
     * 此时被其他字符所限制长度，变得更短，因为 dp[i - 1] < i - preIdx，所以 dp[i] = dp[i - 1] + 1，在原先基础上加上当前字符即可
     * 3. dp[i - 1] >= i - preIdx: s[preIdx] 在 dp[i - 1] 子串里面，即 s[preIdx..i-1] 更短
     * 此时加上当前元素，则会被 s[preIdx] 限制长度，dp[i] = i - preIdx，因为遇到重复字符了，所以整体缩短
     * 以上 1. 2. 合并在一起，因为 dp[i - 1] < i - preIdx 在 i < 0「i = -1」恒成立
     * 用 pre 记录 dp[i - 1]，res 为 dp[i]，把空间复杂度降为 O(1)
     * Q: 如何找到同值最近的 preIdx
     * A: 用哈希表维护，循环开始先把当前的 preIdx 取出来，紧接着更新 map，然后再更新 pre，最后是 res
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, pre = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int preIdx = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i); // 更新哈希表
            // dp[j - 1] -> dp[j]
            if (pre < i - preIdx)
                pre = pre + 1;
            else
                pre = i - preIdx;
            res = Math.max(res, pre); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
