package Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * @Description: 剑指 Offer 61. 扑克牌中的顺子
 * @Author: Hypocrite30
 * @Date: 2021/11/13 15:55
 */
public class _61 {
    /**
     * Set
     * 大小王 0，可以为任何数，相当于癞子，直接跳过。
     * 遍历过程找到最大值和最小值，两者差值必须小于 5，则为顺子
     * set 判重，有重复直接 false
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 13;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (set.contains(num)) return false;
            set.add(num);
        }
        return max - min < 5;
    }

    /**
     * 排序
     * joker 统计大小王 0 的数量，然后用数组尾最大值减去非大小王的最小值，小于 5 就是顺子
     * 因为大小王当癞子可以在中间补值，前提是差值小于 5
     * [0, 0, 1, 2, 5] 此时的癞子可以补充为 3, 4，为顺子
     */
    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
                continue;
            }
            if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[joker] < 5;
    }
}
