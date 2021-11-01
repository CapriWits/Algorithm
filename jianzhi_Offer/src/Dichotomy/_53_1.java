package Dichotomy;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @Description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @Author: Hypocrite30
 * @Date: 2021/11/1 20:58
 */
public class _53_1 {
    /**
     * 二分
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        int res = 0;
        while (l < nums.length && nums[l++] == target)
            res++;
        return res;
    }
}
