package Tree;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点。
 * @Description: 剑指 Offer 54. 二叉搜索树的第k大节点
 * @Author: Hypocrite30
 * @Date: 2021/10/30 10:58
 */
public class _54 {
    private int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k; // 计数器k作为形参不能作用于其他函数，所以要用成员变量。
        inorder(root);
        return res;
    }

    /**
     * 中序遍历的倒序，先搜索右子树，再根，再左子树
     */
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        if (k == 0) return;
        if (--k == 0)
            res = root.val;
        inorder(root.left);
    }
}
