package Stack_Queue_Heap;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @Description: 剑指 Offer 59 - I. 滑动窗口的最大值
 * @Author: Hypocrite30
 * @Date: 2021/10/20 11:43
 */
public class _59 {
    /**
     * 大根堆
     * 滑动窗口向右移动，堆移除窗口左边出去的元素，添加窗口右边进来的元素，堆顶为窗口最大元素
     * Time: O(nk) - 加入堆上浮O(logn)，删除指定元素O(k) Space: O(n) - 堆空间
     * @param nums 数组
     * @param k    滑动窗口大小
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, p = 0;
        if (n == 0 || k < 1 || k > n) return new int[0];
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        for (int i = 0; i < k; i++)
            maxHeap.offer(nums[i]);
        res[p++] = maxHeap.peek();
        for (int i = k; i < n; i++) {
            maxHeap.remove(nums[i - k]);
            maxHeap.offer(nums[i]);
            res[p++] = maxHeap.peek();
        }
        return res;
    }

    /**
     * 单调队列，「非严格递减」，队头是窗口最大元素，依次递减
     * 每次窗口右移，队列小于新元素的元素出队「从队尾出去，因为小的值在队尾」所以需要双端队列
     * 窗口移动首先要判断队首「最大元素」是不是刚才窗口移出的元素，如果正好是，也要让最大元素出队
     * Time: O(n) - 一次遍历 Space: O(k) 队列最多只有 k 个元素
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length, p = 0;
        if (n == 0 || k < 1 || k > n) return new int[0];
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // 双端队列，单调队列
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.offerLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.offerLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

}
