package Tree;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @Description: 剑指 Offer 55 - II. 平衡二叉树
 * @Author: Hypocrite30
 * @Date: 2021/10/30 11:26
 */
public class _55_2 {
    /**
     * 求左右子树的深度差值绝对值小于等于 1，且左右子树都为平衡二叉树，则为平衡二叉树
     * Time: O(n^2) - 退化为链表，需要反复调用顶层的 maxDepth Space: O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true; // 顺利搜索到叶子结点，则满足条件
        int res = (int) Math.abs(maxDepth(root.left) - maxDepth(root.right));
        return res <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    /**
     * 上面是自顶向下搜索树高度，会反复调用顶层的 maxDepth，所以采用自底向上方法
     * 选用后序遍历，最后再判断根，实现自底向上。
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 自底向上递归求树高度
     * 如果不是则返回 -1，最终判断平衡二叉树也是按照 -1 标志值来判断
     * 注意：子树不是平衡二叉树，可以直接返回 -1，做剪枝处理
     */
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = recur(root.left);
        if (leftHeight == -1) return -1; // 子树不是平衡二叉树，剪枝
        int rightHeight = recur(root.right);
        if (rightHeight == -1) return -1; // 子树不是平衡二叉树，剪枝
        // 判断加上根节点的整棵树是不是平衡二叉树，是，则根据树高度定义，取子树最高的高度，再加 1「根」，否则返回 -1
        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
