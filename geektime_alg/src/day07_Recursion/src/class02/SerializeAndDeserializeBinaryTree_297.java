package day07_Recursion.src.class02;

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

// 297. 二叉树的序列化与反序列化

/**
 * 序列化时，采用先序遍历，遇到空节点就用 '#' 占位，每一个节点后面都用 ',' 来分割，表示单独的一个节点
 *  不是空节点记录当前节点的值，然后用 ',' 分割
 *
 * 反序列化时，先将String以 ',' 分割，装进队列queue中，然后构建二叉树。
 *  每次从queue中poll一个字符，判断是不是 '#' ，若是，则返回null，否则构建新的节点，该节点左右分别递归构造节点
 *  这样符合构建的String，即先序遍历的顺序
 */
public class SerializeAndDeserializeBinaryTree_297 {

    /*private static final String separator = ",";
    private static final String nullStr = "#";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        BuildString(root, sb);
        return sb.toString();
    }

    public void BuildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(nullStr).append(separator);
        } else {
            sb.append(root.val).append(separator);
            BuildString(root.left, sb);
            BuildString(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(separator)));
        return BuildTree(queue);
    }

    public TreeNode BuildTree(Deque<String> queue) {
        String str = queue.poll();
        if (str.equals(nullStr)) return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = BuildTree(queue);
            node.right = BuildTree(queue);
            return node;
        }
    }*/

}
