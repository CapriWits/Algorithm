package Tree;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @Description: 剑指 Offer 28. 对称的二叉树
 * @Author: Hypocrite30
 * @Date: 2021/10/27 10:13
 */
public class _28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recursion(root.left, root.right);
    }

    /**
     * 1.左右子树「同时」到叶子结点，满足镜像
     * 2.左右子树有一个到叶子 或 值不同，不满足镜像
     * 3.根据对称轴，左树左子树和右树右孩子，左树右子树和右树左子树
     */
    private boolean recursion(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recursion(L.left, R.right) && recursion(L.right, R.left);
    }
}
