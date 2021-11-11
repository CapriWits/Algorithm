package BitOperation;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @Description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * @Author: Hypocrite30
 * @Date: 2021/11/11 15:39
 */
public class _56_2 {
    /**
     * 统计所有数，同一位的 1 的个数，然后对 3 取余，得到的结果就是该位上 1 的个数
     * 再按照 1 的个数用或运算还原即可
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
