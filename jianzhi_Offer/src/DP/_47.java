package DP;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * @Description: 剑指 Offer 47. 礼物的最大价值
 * @Author: Hypocrite30
 * @Date: 2021/11/7 11:42
 */
public class _47 {
    /**
     * 1. j = 0: dp[i][0] = dp[i - 1][0] + grid[i][0];
     * 2. i = 0: dp[0][j] = dp[0][j - 1] + grid[0][j];
     * 3. i != 0 && j != 0: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
     * 为了省空间，直接修改原数组 grid，先修改第一行和第一列，然后再丛上到下修改下面的数组
     * 这样不会影响到后面的判断，保留修改之后的结果
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++)
            grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < n; j++)
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
