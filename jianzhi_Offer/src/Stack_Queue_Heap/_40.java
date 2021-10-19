package Stack_Queue_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 * @Description: 剑指 Offer 40. 最小的k个数
 * @Author: Hypocrite30
 * @Date: 2021/10/16 16:50
 */
public class _40 {
    /**
     * 排序，然后取出前面 k 个元素
     * Time: O(nlogn) Space: O(logn) 排序需要用到的空间
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = arr[i];
        return res;
    }

    /**
     * 维护大根堆，用来装结果
     * 先将数组前 k 插入堆中，然后从 k + 1 位置遍历，如果值小于堆顶「大根」，则堆顶出队，元素插入
     * Time: O(nlogK) Space: O(K) - K为常数
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        int n = arr.length;
        if (k == 0 || n == 0) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x)); // 大根堆
        for (int i = 0; i < k; i++)
            maxHeap.offer(arr[i]);
        for (int i = k; i < n; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++)
            res[i] = maxHeap.poll();
        return res;
    }

    /**
     * 快排思想，切分之后的结果，如果正好是第 k 大的元素，则前面 k - 1 个元素就是需要最小的 k 个数
     * 不需要将所有的数都排完序
     */
    public int[] getLeastNumbers3(int[] a, int k) {
        if (k == 0 || a.length == 0)
            return new int[0];
        return quickSort(a, 0, a.length - 1, k - 1);
    }

    /**
     * 快排，找 k - 1 下标的数及其之前的数构成的数组
     */
    private int[] quickSort(int[] a, int lo, int hi, int k) {
        int j = partition(a, lo, hi);
        if (j == k)
            return Arrays.copyOf(a, j + 1);
        return j > k ? quickSort(a, lo, j - 1, k) : quickSort(a, j + 1, hi, k);
    }

    /**
     * 快排切分
     * 返回下标 j，比 a[j] 小的数放在 j 的左边，大的数放在 j 的右边
     */
    private int partition(int[] a, int lo, int hi) {
        int l = lo, r = hi + 1;
        int pivot = a[lo]; // 切分元素
        while (true) {
            while (++l <= hi && a[l] < pivot) ;
            while (--r >= lo && a[r] > pivot) ;
            if (l >= r) break;
            swap(a, l, r);
        }
        swap(a, lo, r);
        return r;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
