package DP;

/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，
 * 从同一个方向看总共有多少种不同的方法？
 * 牛客：https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6
 * @Description: JZ70 矩形覆盖
 * @Author: Hypocrite30
 * @Date: 2021/11/6 15:09
 */
public class _10_2 {
    /**
     * 1. n = 1, res = 1
     * 2. n = 2, res = 2
     * 3. n >= 3, dp[i] = dp[i - 2] + dp[i - 1]
     */
    public int rectCover(int target) {
        if (target <= 2) return target;
        int p = 1, q = 2, res = p + q;
        for (int i = 3; i < target; i++) {
            p = q;
            q = res;
            res = p + q;
        }
        return res;
    }
}
