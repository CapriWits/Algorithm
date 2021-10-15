package day03_Array_LinkedList_SkipList.src.class04;

import java.util.*;

public class _3Sum_15 {

    /*
        暴力 O(n^3)
     */
    /*public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();  //利用Set集合实现去重
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> value = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(value);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }*/

    /*
        哈希表
     */
    /*ublic List<List<Integer>> threeSum(int[] nums) {

    }*/

    /*
        排序 + 双指针夹逼  O(n^2)
        https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
            先对数组进行升序排序，然后遍历一遍数组，游标为 i
            1. num[i] = num[i - 1] continue，因为所有组合在num[i - 1]就记录好了，此次组合会重复
            2. num[i] > 0 break，i位置的值都大于0，后面的数都是大于0，加起来不能等于0，后面已经没有可行解了
            3. 设 lo = i + 1, hi = num.length - 1，即 i 右边数组的首位部分，然后进行夹逼，规则如下：
                num[lo] + num[hi] 与 sum = -num[i] 比较
                1) 相等时：为可行解，将结果添加到集合中
                2) 前者大于后者，说明前者应该调小一点，让 hi 往前走
                3) 前者小于后者，说明前者应该调大一点，让 lo 往后走
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {   // 这里采取循环的方式来一直找可行解，直到双指针相遇
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        // 下面两个while 意图是 跳过重复的数，因为重复解是不允许的
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}
