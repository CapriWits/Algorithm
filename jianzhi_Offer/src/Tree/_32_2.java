package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @Description: 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * @Author: Hypocrite30
 * @Date: 2021/10/27 15:09
 */
public class _32_2 {
    /**
     * BFS 层序遍历
     * 需要注意的是，for (int i = 0; i < queue.size(); i++) 这么写会错
     * 因为 循环中会添加元素改变队列的大小，即改变循环的上限
     * 要么用变量保存好队列的大小，要么就倒序循环
     * for (int i = queue.size(); i > queue.size(); i--)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size(); // 这里必须保存 queue 的 size，循环会添加元素，size会改变
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
