package day06_Tree.src.class02;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

//590. N叉树的后序遍历
public class N_aryTreePostorderTraversal_590 {

    /*
        递归
     */
   /* public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }*/

   /*
        迭代
    */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            for (Node child : root.children) {
                stack.push(child);
            }
        }
        Collections.reverse(res);
        return res;
    }


}
