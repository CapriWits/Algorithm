package day07_Recursion.src.class02;

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}*/

// 236. 二叉树的最近公共祖先
public class LowestCommonAncestorofaBinaryTree_236 {

    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;  // 到叶子结点，没找到，返回root，就是返回null
        if (root == p || root == q) return root;    // 递归下去碰到了 p q，祖先就是自己本身，即当前root位置
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right; // 左没找到 p q 在右侧，公共祖先就在右侧
        if (right == null) return left; // 右没找到 p q 在左侧
        return root;   // p q 在二叉树异侧，根节点就是p q 公共祖先
    }*/

}
