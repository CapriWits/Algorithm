package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * @Description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * @Author: Hypocrite30
 * @Date: 2021/10/28 11:52
 */
public class _34 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backTrack(root, target, new ArrayList<>());
        return res;
    }

    /**
     * 回溯法
     */
    private void backTrack(TreeNode root, int target, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        backTrack(root.left, target, path);
        backTrack(root.right, target, path);
        path.remove(path.size() - 1); // 最后回溯
    }
}
