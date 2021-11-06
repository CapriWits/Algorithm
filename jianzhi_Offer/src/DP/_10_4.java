package DP;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
 * 牛客；https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387
 * @Description: JZ71 跳台阶扩展问题
 * @Author: Hypocrite30
 * @Date: 2021/11/6 16:01
 */
public class _10_4 {
    /**
     * dp[i] = dp[i - 1] + dp[i - 2] + ... + dp[0]
     * @param target
     * @return
     */
    public int jumpFloorII(int target) {
        if (target == 0 || target == 1) return 1;
        int[] dp = new int[target + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target];
    }
}
