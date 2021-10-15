package Arrays_Matrix;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @Description: 剑指 Offer 29. 顺时针打印矩阵
 * @Author: Hypocrite30
 * @Date: 2021/10/15 17:12
 */
public class _29 {
    /**
     * 模拟
     * r1 r2 c1 c2: 表示上下左右边界
     * 上下方向的打印都没有太大问题，重点是向左和向上
     * 出现只有一行，或只有一列，那就会来回打印同一行/列数据，所以做特判
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[]{};
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1, x = 0;
        int[] res = new int[(r2 + 1) * (c2 + 1)];
        while (r1 <= r2 && c1 <= c2) {
            for (int j = c1; j <= c2; j++) // 左上到右上
                res[x++] = matrix[r1][j];
            for (int i = r1 + 1; i <= r2; i++) // 右上到右下
                res[x++] = matrix[i][c2];
            // 下面都要做特殊判断，防止重复打印
            if (r1 != r2) {
                for (int j = c2 - 1; j >= c1; j--) // 右下到左下
                    res[x++] = matrix[r2][j];
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) // 左下到左上，这里的 i 不能等于 r1，第一步打印过左上角元素了
                    res[x++] = matrix[i][c1];
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
