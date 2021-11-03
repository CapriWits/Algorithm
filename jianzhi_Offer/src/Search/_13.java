package Search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * @Description: 剑指 Offer 13. 机器人的运动范围
 * @Author: Hypocrite30
 * @Date: 2021/11/3 20:37
 */
public class _13 {

    /**
     * BFS
     * 因为起点在左上角，所以只需要搜索右边和下边即可
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        int res = 1;
        int[] dx = new int[]{0, 1}; // 只有右和下两个方向
        int[] dy = new int[]{1, 0};
        boolean[][] isVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || isVisited[nextX][nextY] || getSum(nextX) + getSum(nextY) > k)
                    continue;
                queue.offer(new int[]{nextX, nextY});
                isVisited[nextX][nextY] = true;
                res++;
            }
        }
        return res;
    }

    private int cnt = 0;

    /**
     * DFS
     */
    public int movingCount2(int m, int n, int k) {
        DFS(m, n, k, 0, 0, new boolean[m][n]);
        return cnt;
    }

    private void DFS(int m, int n, int k, int x, int y, boolean[][] isVisited) {
        if (x < 0 || y < 0 || x >= m || y >= n || isVisited[x][y] || getSum(x) + getSum(y) > k) {
            return;
        }
        isVisited[x][y] = true;
        cnt++;
        DFS(m, n, k, x + 1, y, isVisited);
        DFS(m, n, k, x, y + 1, isVisited);
    }

    /**
     * 求 x 所有数位之和
     */
    private int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
