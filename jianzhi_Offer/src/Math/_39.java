package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Description: 剑指 Offer 39. 数组中出现次数超过一半的数字
 * @Author: Hypocrite30
 * @Date: 2021/11/9 20:21
 */
public class _39 {
    /**
     * 摩尔投票法
     * 设超过半数的数称为「众数」
     * 遍历数组，如果遇到众数，票数 +1，其他数 票数 -1
     * 遍历过程中，如果遇到票数为 0，则从当前数到前面的数之间，众数占一半。可以缩小范围，不考虑前面，只考虑后面部分
     * 起始票数为 0，众数 x = 0
     * 遍历数组，如果当前票数为 0，假设当前 num 为众数
     * 接着判断当前值是不是众数，是则投 +1 票，否则投 -1 票
     * 最终假设的众数就是众数
     */
    public int majorityElement(int[] nums) {
        int x = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) x = num;
            vote += num == x ? 1 : -1;
        }
        return x;
    }

    /**
     * 哈希表存元素值与出现次数的映射关系
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        Map.Entry<Integer, Integer> res = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (res == null || entry.getValue() > res.getValue())
                res = entry;
        }
        return res.getKey();
    }
}
