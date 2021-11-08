package DP;

import java.util.Arrays;

/**
 * 把 n 个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * @Description: 剑指 Offer 60. n个骰子的点数
 * @Author: Hypocrite30
 * @Date: 2021/11/8 20:12
 */
public class _60 {
    /**
     * dp(n, x) - n 个骰子，点数和为 x 的概率
     * dp(n - 1, x) - 对 dp(n, x + 1), dp(n, x + 2) ... dp(n, x + 6) 产生贡献，即摇出 1 - 6
     * 由于每个点数摇出来的概率为 1 / 6，所以只贡献原值的 1 / 6，即 1/6 * dp(n - 1, x)
     * tmp 保存下一行的结果，降空间
     * Time: O(n^2) Space: O(n)
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) { // dp(n-1, x) 这一层都要加上去
                for (int k = 0; k < 6; k++) // 只能在点数和 x 的基础上加上 1 - 6
                    tmp[j + k] += dp[j] / 6.0;
            }
            dp = tmp;
        }
        return dp;
    }
}
