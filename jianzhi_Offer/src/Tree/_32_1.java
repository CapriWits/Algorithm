package Tree;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @Description: 剑指 Offer 32 - I. 从上到下打印二叉树
 * @Author: Hypocrite30
 * @Date: 2021/10/27 11:19
 */
public class _32_1 {
    /**
     * BFS 层序遍历
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
        // return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
