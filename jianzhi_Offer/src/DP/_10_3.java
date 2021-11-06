package DP;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 注：n = 0, res = 1
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Author: Hypocrite30
 * @Date: 2021/11/6 15:21
 */
public class _10_3 {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int p = 1, q = 2, res = p + q;
        for (int i = 3; i <= n; i++) {
            res = (p + q) % 1000000007;
            p = q;
            q = res;
        }
        return res;
    }
}
