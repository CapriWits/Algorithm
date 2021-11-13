package DP;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @Description: 剑指 Offer 46. 把数字翻译成字符串
 * @Author: Hypocrite30
 * @Date: 2021/11/13 15:27
 */
public class _46 {
    /**
     * DP
     * 数字从 1 ~ num，对应 dp 下标也是 1 ~ num
     * dp[i] 为 1 ~ i 能翻译的个数
     * 1. num[i - 1] 单独翻译，dp[i] = dp[i - 1]
     * 2. num[i - 1] 和 num[i - 2] 组合在一起翻译，dp[i] = dp[i - 1] + dp[i - 2]
     * 两两组合有条件限制，不能超过 25「z」，同时大于等于 10，因为 00,01,02...09 不能翻译
     * 所以前提是 [10, 25] 才能两两组合，否则只能取 dp[i - 1]
     * dp[1] = 1，第一个数字只有一种选择，dp[2] 有可能同时取两个，所以 dp[0] 和 dp[1]，所以 dp[2] 可能为 2
     * 倒推 dp[0] = 1
     * 用滚动数组省空间
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1; // dp[i - 1], dp[i - 2]
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i); // 截取末尾两个字符，左闭右开[i - 2, i)
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
