package Sort;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @Description: 剑指 Offer 45. 把数组排成最小的数
 * @Author: Hypocrite30
 * @Date: 2021/11/4 20:54
 */
public class _45 {
    /**
     * 内置函数排序
     * 本质是两个字符串比较大小，s1 + s2 > s2 + s1，则把 s1 放在前面
     */
    public String minNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            ss[i] = String.valueOf(nums[i]);
        Arrays.sort(ss, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String s : ss)
            sb.append(s);
        return sb.toString();
    }
}
