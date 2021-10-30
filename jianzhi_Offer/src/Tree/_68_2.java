package Tree;

/**
 * 给定一个「二叉树」, 找到该树中两个指定节点的最近公共祖先。
 * @Description: 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * @Author: Hypocrite30
 * @Date: 2021/10/30 14:43
 */
public class _68_2 {
    /**
     * 根为null、p与根重合、q与根重合 三种情况的 LCA 都是 当前 root
     * 递归找左右子树 LCA
     * 左边找不到说明两节点在右子树，同理右边没有找左边
     * 都不为空，则返回当前根节点，就是 LCA
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
