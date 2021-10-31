package Greedy;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * @Description: 剑指 Offer 63. 股票的最大利润
 * @Author: Hypocrite30
 * @Date: 2021/10/31 20:56
 */
public class _63 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int res = 0, min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
