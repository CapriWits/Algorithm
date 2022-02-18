package throwEggs;

/**
 * 887. 鸡蛋掉落
 *
 * @Author: Hypocrite30
 * @Date: 2022/1/19 13:25
 */
public class ThrowEggs {

    /* 1. 直接DP：TLE */
    /*private Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;
        String key = k + "-" + n;
        if (memo.containsKey(key)) return memo.get(key);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res,
                    Math.max(dp(k - 1, i - 1),
                            dp(k, n - i)) + 1);
        }
        memo.put(key, res);
        return res;
    }*/

    /* 2. DP + 二分 */
   /* private Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private int dp(int k, int n) {
        if (n == 0) return 0;
        if (k == 1) return n;
        String key = k + "-" + n;
        if (memo.containsKey(key)) return memo.get(key);
        int res = Integer.MAX_VALUE;
        int l = 1, r = n;
        // l == r 表示楼层只剩 1 层了，也要判断当前状况鸡蛋是否破碎
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int broken = dp(k - 1, mid - 1);
            int unBroken = dp(k, n - mid);
            if (broken > unBroken) {
                r = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                l = mid + 1;
                res = Math.min(res, unBroken + 1);
            }
        }
        memo.put(key, res);
        return res;
    }*/

    /* 3.状态转换 */
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int i = new ThrowEggs().superEggDrop(2, 100);
        System.out.println(i);
    }
}
