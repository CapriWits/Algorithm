package stock;

/**
 * 股票问题
 * 121. 买卖股票的最佳时机
 * 122. 买卖股票的最佳时机 II
 * 123. 买卖股票的最佳时机 III
 * 188. 买卖股票的最佳时机 IV
 * 309. 最佳买卖股票时机含冷冻期
 * 714. 买卖股票的最佳时机含手续费
 *
 * @Author: Hypocrite30
 * @Date: 2022/1/15 11:35
 */
public class Stock {

    /* 1.股票交易 k = 1，k 不控制结果，降维 */

    /**
     * 交易一次
     */
    public int maxProfit_k1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            // base case
            if (i - 1 == -1) {
                // = max(dp[-1][0], dp[-1][1] + prices[i]) = max(0, -infinity + prices[i]) = 0
                dp[i][0] = 0;
                // = max(dp[-1][1], dp[-1][0] - prices[i]) = max(-infinity, 0 - prices[i])
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 交易一次，空间 O(1)
     */
    public int maxProfit_k1_2(int[] prices) {
        int n = prices.length;
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, -prices[i]);
        }
        return dp_0;
    }

    /**
     * 交易一次，贪心解法
     */
    public int maxProfit_k1_3(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    /* 2.股票交易 k = +INF，k - 1 = k，k 不控制结果，降维 */

    /**
     * 交易无限次，DP 解法
     */
    public int maxProfit_kINF(int[] prices) {
        int n = prices.length;
        int dp_0 = 0, dp_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, tmp - prices[i]);
        }
        return dp_0;
    }

    /**
     * 交易无限次，贪心解法
     */
    public int maxProfit_kINF_2(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    /* 3.股票交易 k = 2，k 控制结果，不能降维，需要遍历 k 维度，而 k = 2，所以把 dp 直接写出来 */

    /**
     * 股票交易，次数限制最多 2 次
     */
    public int maxProfit_k2(int[] prices) {
        int n = prices.length, max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                // base case
                if (i - 1 == -1) {
                    // max(dp[-1][k][0], dp[-1][k][1] + prices[i]) = max(0, -INF) = 0
                    dp[i][k][0] = 0;
                    // max(dp[-1][k][1], dp[-1][k - 1][0] - prices[i]) = max(-INF, 0 - prices[i])
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    /**
     * 交易次数限制 2 次，空间降为 O(1)
     */
    public int maxProfit_k2_1(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    /* 4.股票交易 k = k，k 控制结果，不能降维;  k 太大会数组会爆，一次交易至少要 2 天，
    所以 k 超过 len / 2 ，意味着 k 不控制结果，直接按照 k = +INF 处理; 其他的情况套模板 */

    /**
     * 交易次数为 k
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n >> 1) return maxProfit_kINF(prices); // k = +INF
        // k = k
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    /* 5.股票交易 k = +INF，sell 之后冷冻一天才能继续 buy，所以 buy 时要使用两天前(dp[i-2][0])的状态 */

    /**
     * 交易次数无限，含一天交易冷冻期
     */
    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // dp[i-2][0] = 0
        for (int price : prices) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - price);
            dp_pre_0 = tmp; // 前面计算相当于都往后推了一天，所以 dp_i_0 就是前两天
        }
        return dp_i_0;
    }

    /* 6.股票交易 k = +INF，含交易费，交易费算在 buy 里面，所以 在 k = +INF 基础上 buy 时额外取消 fee 即可 */

    /**
     * 交易次数无限，含交易费
     */
    public int maxProfit(int[] prices, int fee) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - price - fee);
        }
        return dp_i_0;
    }
}
