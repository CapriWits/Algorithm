package Sort;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @Description: 剑指 Offer 51. 数组中的逆序对
 * @Author: Hypocrite30
 * @Date: 2021/11/5 21:15
 */
public class _51 {
    private int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        int res = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);
        // merge
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                res += mid - i + 1; // 统计逆数对
            }
        }
        return res;
    }
}
