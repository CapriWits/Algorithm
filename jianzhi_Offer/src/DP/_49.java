package DP;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 * @Description: 剑指 Offer 49. 丑数
 * @Author: Hypocrite30
 * @Date: 2021/11/7 16:10
 */
public class _49 {
    /**
     * DP
     * dp[i]：第 i + 1 个丑数
     * 由于：丑数由更小的丑数乘「2/3/5」
     * 为了在迭代过程中取到相邻更大的丑数，要找到乘积刚刚好大于上个丑数的值
     * 如：10 对于 质因子 2，要取 6。质因子 3 要取 4。质因子 5，要取 3
     * 6 4 3 三数都是丑数，如何找？维护三个变量「abc」，从 0 开始，每当要找相邻丑数
     * 就对应取出 dp[a/b/c]，再乘各自的质因子。 最后取三数最小的就是相邻丑数
     * 还要判断当前谁被选中了，变量要递增 1，便于下一次取值
     */
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
