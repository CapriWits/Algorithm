package Tree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，
 * 树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 * @Description: 剑指 Offer 36. 二叉搜索树与双向链表
 * @Author: Hypocrite30
 * @Date: 2021/10/29 15:01
 */
public class _36 {
    private Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        DFS(root);
        head.left = pre; // 将双向链表最后一个节点也与头关联上
        pre.right = head;
        return head;
    }

    private void DFS(Node cur) {
        if (cur == null) return;
        DFS(cur.left);
        if (pre != null) // 先处理前面结点与当前的连接，为null则设为头
            pre.right = cur;
        else
            head = cur;
        cur.left = pre; // 公共部分是当前节点与前面结点建立连接
        pre = cur;
        DFS(cur.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
