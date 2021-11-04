package Sort;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * @Description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @Author: Hypocrite30
 * @Date: 2021/11/4 20:36
 */
public class _21 {
    /**
     * 双指针
     * 首尾指针向中间靠拢，i 过滤奇数，遇到偶数停下，j 过滤偶数，遇到奇数停下
     * 交换两数，直到指针相遇
     * 快排思想
     */
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, temp;
        while (i < j) {
            while (i < j && (nums[i] % 2) == 1) i++;
            while (i < j && (nums[j] % 2) == 0) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
