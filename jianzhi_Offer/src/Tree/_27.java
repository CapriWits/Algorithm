package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @Description: 剑指 Offer 27. 二叉树的镜像
 * @Author: Hypocrite30
 * @Date: 2021/10/26 20:09
 */
public class _27 {
    /**
     * 递归
     * temp 中间遍历，保存两子树交换的中间结果
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    /**
     * 栈
     * 取栈顶元素，推入左右子节点「顺序无所谓，因为后面都要交换」
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            TreeNode temp = node.left; // swap
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
