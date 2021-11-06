package DP;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * @Description: 剑指 Offer 42. 连续子数组的最大和
 * @Author: Hypocrite30
 * @Date: 2021/11/6 16:21
 */
public class _42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int preSum = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            preSum = Math.max(num, preSum + num);
            res = Math.max(res, preSum);
        }
        return res;
    }
}
