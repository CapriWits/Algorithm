package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @Description: 剑指 Offer 55 - I. 二叉树的深度
 * @Author: Hypocrite30
 * @Date: 2021/10/30 11:14
 */
public class _55_1 {
    /**
     * DFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    /**
     * BFS
     * 就是层序遍历，一直BFS往下走，每一层都用 queue 存起来，能走下去计数器就递增，直到走到头
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> list = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) list.offer(node.left);
                if (node.right != null) list.offer(node.right);
            }
            queue = list;
            res++;
        }
        return res;
    }
}
