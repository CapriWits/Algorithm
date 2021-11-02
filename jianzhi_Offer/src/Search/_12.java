package Search;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * @Description: 剑指 Offer 12. 矩阵中的路径
 * @Author: Hypocrite30
 * @Date: 2021/11/2 20:08
 */
public class _12 {
    /**
     * DFS
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (DFS(board, words, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, char[] words, int i, int j, int cur, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) // 越界
            return false;
        if (board[i][j] != words[cur]) // 不等，剪枝
            return false;
        if (cur == words.length - 1) // 相等，且搜索到最后一位，符合
            return true;
        visited[i][j] = true;
        boolean res = DFS(board, words, i - 1, j, cur + 1, visited) ||
                DFS(board, words, i + 1, j, cur + 1, visited) ||
                DFS(board, words, i, j - 1, cur + 1, visited) ||
                DFS(board, words, i, j + 1, cur + 1, visited);
        visited[i][j] = false;
        return res;
    }
}
