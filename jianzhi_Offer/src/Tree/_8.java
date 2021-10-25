package Tree;

/**
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。下图为一棵有9个节点的二叉树。
 * 树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
 * 牛客：https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e
 * @Description: JZ8 二叉树的下一个结点
 * @Author: Hypocrite30
 * @Date: 2021/10/25 19:05
 */
public class _8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

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
