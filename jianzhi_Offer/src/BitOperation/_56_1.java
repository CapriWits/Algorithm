package BitOperation;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @Description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * @Author: Hypocrite30
 * @Date: 2021/11/10 21:09
 */
public class _56_1 {
    /**
     * 异或
     * 如果一个数组只有一个元素只出现一次，其他元素都两两出现，从到到尾异或，结果就是那个唯一元素
     * 因为两个相同数异或结果等于 0,0 与任何结果异或等于数本身
     * 本题有两个唯一出现的数，设为 x, y ，先遍历异或一遍，结果就是 x ^ y，然后拆开
     * 因为两数不等，所以至少有一位肯定有 0 和 1 的差别，从低位到高位找到是哪一位，计为 m
     * 遍历数组，如果 m 位是 0，统一与 x 异或，为 1，与 y 异或，当然两者可以相反
     * 这样就拆成两个数
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int num : nums) {
            n ^= num;
        }
        while ((n & m) == 0) {
            m <<= 1;
        }
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
