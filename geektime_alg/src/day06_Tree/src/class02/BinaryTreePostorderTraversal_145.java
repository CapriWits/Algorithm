package day06_Tree.src.class02;

import java.util.*;

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

// 145. 二叉树的后序遍历
public class BinaryTreePostorderTraversal_145 {

    /*
        递归
     */
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }*/

    /*
        迭代
            有一定的技巧性。
            在前序遍历的迭代方法中，根 - 左 - 右。所以先处理当前节点，然后 右结点入栈，接着左结点入栈。
            这样保证出栈的顺序就是先左后右。
            在后序遍历中进行调换顺序，先左结点入栈，再右结点入栈，
            保证出来的顺序就是： 根 - 右 - 左 ，这样的顺序整好是 后序遍历的reverse形式。所以最后
            reverse一下就是 左 - 右 - 根。 采用的模板就是前序遍历的迭代版本，最后别忘了翻转结果集合res。
     */
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }*/
}
