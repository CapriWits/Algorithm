package day07_Recursion.src.class02;

import java.util.Deque;
import java.util.LinkedList;

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}*/

// 98. 验证二叉搜索树
public class ValidateBinarySearchTree_98 {

    /*
        递归解法
     */
    /*public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTRecursion(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return isValidBSTRecursion(root.left, lower, root.val) && isValidBSTRecursion(root.right, root.val, upper);
    }*/

    /*
        中序遍历
            结果是递增的
     */
    /*public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        long preVal = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= preVal) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }*/

}
