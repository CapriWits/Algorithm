package Tree;

/**
 * 给定一个「二叉搜索树」, 找到该树中两个指定节点的最近公共祖先。
 * @Description: 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * @Author: Hypocrite30
 * @Date: 2021/10/30 14:15
 */
public class _68_1 {

    /**
     * 递归
     * Time: O(n) Space: O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) { // 在左树找
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) { // 在右树找
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // 两节点分到两侧，则当前根节点就是 LCA
    }

    /**
     * 迭代
     * 移动根节点向下找，当两节点分布在两侧，则当前根节点就是 LCA
     * Time: O(n) Space: O(1)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) { // 在左树找
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) { // 在右树找
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

}
