package Arrays_Matrix;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Description: 剑指 Offer 04. 二维数组中的查找
 * @Author: Hypocrite30
 * @Date: 2021/10/14 16:47
 */
public class _04 {

    /**
     * 将矩阵逆时针旋转45°，变成二叉搜索树，从右上角开始搜索，
     * target小了，往左边走「j--」，大了，往下面走「i++」
     * 时间O(n + m) 空间O(1)
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length - 1, col = matrix[0].length - 1;
        int i = 0, j = col;
        while (i <= row && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

}
