package DoublePointer;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * @Description: 剑指 Offer 57. 和为s的两个数字
 * @Author: Hypocrite30
 * @Date: 2021/10/20 15:35
 */
public class _57_1 {
    /**
     * 双指针
     * 左右指针起点在数组两侧，每次遍历判断当前和与目标大小差距，小了，让左指针往后挪，大了，右指针往前挪
     * Time: O(n) Space: O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int curSum = nums[i] + nums[j];
            if (curSum == target)
                return new int[]{nums[i], nums[j]};
            else if (curSum < target)
                i++;
            else
                j--;
        }
        return new int[0];
    }
}
