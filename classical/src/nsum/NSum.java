package nsum;

import java.util.*;

/**
 * NSum 问题
 *
 * @Author: Hypocrite30
 * @Date: 2022/1/17 13:08
 */
public class NSum {

    /* 1. 2sum，哈希表  */

    /**
     * 2sum 返回结果的数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /* 2. 3sum，第一个数遍历 nums 得到，后面的两个数 就是 target 为 target - nums[i] 的 2sum 问题 */

    /**
     * 3sum，返回值
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }

    /**
     * 在 [0, length - 1] 找 3sum = target 的三元组
     *
     * @param target 目标和
     * @return 三元组
     */
    private List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // 先升序排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 后面相同的数跳过, 不能取到 n - 1，后面数组下标越界
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    /**
     * 在 [start, length -1] 范围找到 2sum =  target 的元组，同时要 2sum 不能重复
     *
     * @param start  起点位置
     * @param target 目标和
     * @return 二元组
     */
    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int l = start, r = n - 1;
        while (l < r) {
            int sum = nums[l] + nums[r], left = nums[l], right = nums[r];
            // 下面的 while 都是为了跳过相同数
            if (sum < target)
                while (l < r && nums[l] == left) l++;
            else if (sum > target)
                while (l < r && nums[r] == right) r--;
            else {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (l < r && nums[l] == left) l++;
                while (l < r && nums[r] == right) r--;
            }
        }
        return res;
    }

    /* 3. 4sum，同上，遍历找到第一个数，剩下的三元组用 threeSum 模板即可，改成范围式的搜索即可 */

    /**
     * 4sum
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 上来就直接升序排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> triples = threeSumTarget2(nums, i + 1, target - nums[i]);
            for (List<Integer> triple : triples) {
                triple.add(nums[i]);
                res.add(triple);
            }
            // 跳过相同的数
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    /**
     * 在 [start, length - 1] 找三元组符合和为 target
     *
     * @param start  起始位置
     * @param target 目标和
     * @return 三元组
     */
    private List<List<Integer>> threeSumTarget2(int[] nums, int start, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过相同数
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    /* 4. NSum 模板，上面例子可以观察，2sum 是双指针夹逼找到二元组，3sum 及以上则递归调用即可 */

    /**
     * nSum
     */
    public List<List<Integer>> nSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, 0);
    }

    /**
     * nSum 的递归模板，n == 2 用双指针夹逼，n >= 3，当前栈遍历找第一个数，后面递归向后找元组，然后累加进结果 返回即可
     * 需注意：由于这是递归模板，所以为了提高性能，在入参之前必须要将数组升序排列
     *
     * @param nums   升序数组
     * @param n      和为 target 的元组维度
     * @param start  起点
     * @param target 目标和
     * @return n元组
     */
    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int length = nums.length;
        // 这里要开空间，后面 foreach 不会空指针
        List<List<Integer>> res = new ArrayList<>();
        // 至少为 2Sum 且 数组大小必须为 size
        if (n < 2 || length < n) return res;
        // 2Sum，双指针夹逼
        if (n == 2) {
            int l = start, r = length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r], left = nums[l], right = nums[r];
                // 指针移动过程，while 控制跳过重复数
                if (sum < target) {
                    while (l < r && nums[l] == left) l++;
                } else if (sum > target) {
                    while (l < r && nums[r] == right) r--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (l < r && nums[l] == left) l++;
                    while (l < r && nums[r] == right) r--;
                }
            }
        } else {
            // 3Sum 以上，当前栈遍历第一个数，后面递归
            for (int i = start; i < length; i++) {
                List<List<Integer>> tmp = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : tmp) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
