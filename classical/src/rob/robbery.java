package rob;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍
 * 198. 打家劫舍
 * 213. 打家劫舍 II
 *
 * @Author: Hypocrite30
 * @Date: 2022/1/15 19:52
 */
public class robbery {
    /* 1.房子在一排，max(dp[i-1], dp[i-2] + num[i]) */

    /**
     * 房子在一排
     */
    public int rob_1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

    /**
     * 房子在一排，空间降为 O(1)
     */
    public int rob_1_1(int[] nums) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    /* 2.房子是环形, ①首位不抢，②首抢尾不抢，③尾抢首不抢，三者求最大，而①肯定没有②③大，所以只比较[0,n-2]和[1,n-1] */

    /**
     * 房子环形
     */
    public int rob_2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob_2_range(nums, 0, n - 2), rob_2_range(nums, 1, n - 1));
    }

    /**
     * DP 解决一排房屋的打家劫舍问题
     */
    private int rob_2_range(int[] nums, int start, int end) {
        int dp_i_1 = 0, dp_i_2 = 0, dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    /* 3.房屋是二叉树 */

    /**
     * DFS 后序遍历
     */
    private Map<TreeNode, Integer> T = new HashMap<>(); // 选择
    private Map<TreeNode, Integer> F = new HashMap<>(); // 不选择

    public int rob_3(TreeNode root) {
        dfs(root);
        return Math.max(T.getOrDefault(root, 0), F.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        T.put(root, root.val + F.getOrDefault(root.left, 0) + F.getOrDefault(root.right, 0));
        F.put(root, Math.max(T.getOrDefault(root.left, 0), F.getOrDefault(root.left, 0)) +
                Math.max(T.getOrDefault(root.right, 0), F.getOrDefault(root.right, 0)));
    }

    /**
     * 空间降为 O(1)，但递归还是消耗栈空间 O(n)
     */
    public int rob_3_1(TreeNode root) {
        int[] res = dfs2(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * DFS 后序搜索，返回的数组 0: 不选，1：选
     */
    private int[] dfs2(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] l = dfs2(root.left);
        int[] r = dfs2(root.right);
        int T = root.val + l[0] + r[0];
        int F = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{F, T};
    }


    private class TreeNode {
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
    }
}
