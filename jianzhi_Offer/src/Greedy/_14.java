package Greedy;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @Description: 剑指 Offer 14- I. 剪绳子
 * @Author: Hypocrite30
 * @Date: 2021/10/31 10:03
 */
public class _14 {
    /**
     * n < 2，分不了
     * n = 2，分为 1 * 1 = 1
     * n = 3，分为 1 * 2 = 2
     * n = 4，分为 2 * 2 = 4 > 1 * 3 = 3
     * n = 5，分为 2 * 3 > 5，所以 5以上要拆
     * n = 6，分为 2 * 2 * 2 = 8 < 3 * 3 = 9，所以5以上尽可能拆成3，而不是2
     * 所以5以上优先拆成3，剩下的 4「1 + 3」，就拆成 2 * 2
     */
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2; // 剩下的 4 拆成 2 * 2
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    /**
     * 动态规划
     * dp[i] 为长度 i 的绳子分段最大乘积
     * 当前不用分段，「j * (i - j)」
     * 当前分段，「dp[j] * (i - j)」
     */
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
        return dp[n];
    }

}
