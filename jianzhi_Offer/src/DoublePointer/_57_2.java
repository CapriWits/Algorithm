package DoublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列
 * @Description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * @Author: Hypocrite30
 * @Date: 2021/10/20 15:50
 */
public class _57_2 {
    /**
     * 双指针「滑动窗口」，两指针起点是值 1,2，以此去找可行解
     * 双指针都之只能朝前走，不能退后
     * 值大了，说明以当前左指针的值组成的序列只会大于target，左指针往前走，找下一个值为开头的结果
     * 值小了，右指针往前走，扩大值
     */
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if (sum == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if (sum >= target) {
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }
        int[][] ints = res.toArray(new int[0][]); // 将集合强转为参数指定类型
        return ints;
    }
}