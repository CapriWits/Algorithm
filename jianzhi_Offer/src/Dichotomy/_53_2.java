package Dichotomy;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @Author: Hypocrite30
 * @Date: 2021/11/2 11:35
 */
public class _53_2 {
    /**
     * 二分
     * 由题，前半截数组索引与值相等，即「nums[i] = i」
     * 后半截数组索引与值不等 「nums[r] != r」
     * 求出 mid 后比较
     * nums[mid] == mid: mid 在前半截，l = mid + 1;
     * nums[mid] != mid: mid 在后半截，r = mid - 1;
     * 循环条件是 l <= r，即相遇时退出，此时 l / r 就是缺失数字
     */
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
