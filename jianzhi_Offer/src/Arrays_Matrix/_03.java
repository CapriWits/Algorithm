package Arrays_Matrix;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * @Description: 剑指 Offer 03. 数组中重复的数字
 * @Author: Hypocrite30
 * @Date: 2021/10/14 16:03
 */
public class _03 {
    /**
     * 打表
     * Time: O(n) Space: O(n)
     */
    public int findRepeatNumber(int[] nums) {
        int n = nums.length, res = 0;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (cnt[nums[i]] == 0) {
                cnt[nums[i]]++;
            } else {
                res = nums[i];
                break;
            }
        }
        return res;
    }

    /**
     * 「所有数字都在 0～n-1 的范围内」 -> 索引 - 值 => 一对多
     * <p>
     * 时间O(n) 空间O(1)
     */
    public int findRepeatNumber2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) { // 一直交换，直到当前索引与值相等再移动 i
                if (nums[nums[i]] == nums[i]) { // 待交换的位置与本值相同，说明重复
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    /**
     * 交换两索引对应的值
     * @param nums 数组
     * @param i    索引
     * @param j    索引
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
