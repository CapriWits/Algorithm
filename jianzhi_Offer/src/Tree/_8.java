package Tree;

import java.util.ArrayList;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。下图为一棵有9个节点的二叉树。
 * 树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
 * 牛客：https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e
 * 题解：https://github.com/CyC2018/CS-Notes/blob/master/notes/26.%20%E6%A0%91%E7%9A%84%E5%AD%90%E7%BB%93%E6%9E%84.md
 * @Description: JZ8 二叉树的下一个结点
 * @Author: Hypocrite30
 * @Date: 2021/10/25 19:05
 */
public class _8 {
    /**
     * 暴力法
     * 对整个二叉树中序遍历，记录过程
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        int target = pNode.val;
        while (pNode.next != null) {
            pNode = pNode.next;
        }
        ArrayList<TreeLinkNode> list = new ArrayList<>();
        inorderTraversal(pNode, list);
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (list.get(i).val == target && i + 1 < n)
                return list.get(i + 1);
        }
        return null;
    }

    /**
     * 中序遍历
     * list 保存遍历结果
     */
    public static void inorderTraversal(TreeLinkNode root, ArrayList<TreeLinkNode> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);
    }

    /**
     * 模拟中序遍历
     * 分两种情况：
     * 1. 节点有右子树。相当于作为「根节点」，则找右节点，然后递归找到最下面的左结点返回即可
     * 2. 节点无右子树。肯定要往上找父节点。
     * - 2.1 节点为父节点的左孩子。则它的父亲就是中序遍历的下一个位置，直接返回父亲
     * - 2.2 节点为父节点的右孩子。需要找父亲的父亲。这里的实现放在循环里。
     */
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode p = pNode.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) // 节点为父节点的左孩子
                    return parent;
                pNode = parent; // 记得让当前节点向上移动，继续找父节点
            }
        }
        return null;
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父节点指针

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
