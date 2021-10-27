package Tree;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @Description: 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @Author: Hypocrite30
 * @Date: 2021/10/27 15:33
 */
public class _32_3 {
    /**
     * BFS 层序遍历
     * 要想对不同行进行不同操作，有几种方法
     * 1.双端队列。偶数行 addLast() 奇数行 addFirst() - 实现倒序
     * 2.判断奇数行，则翻转中间存储 list, Collections.reverse|(list);
     * 3.设置标志位，每次存储完取反即可。 mark = !mark;
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int n = queue.size(); // 这里必须保存 queue 的 size，循环会添加元素，size会改变
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0)
                    list.addLast(node.val);
                else
                    list.addFirst(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
