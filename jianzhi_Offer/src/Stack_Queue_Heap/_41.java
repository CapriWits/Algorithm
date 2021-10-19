package Stack_Queue_Heap;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * @Description: 剑指 Offer 41. 数据流中的中位数
 * @Author: Hypocrite30
 * @Date: 2021/10/19 16:32
 */
public class _41 {
    /**
     * 维护两个堆，大根堆存前半截，小根堆存后半截，则两堆堆顶就是中间两个元素
     * 总数量为偶数，则加入到右堆中，但是右堆所有元素都大于左堆，所以需要借助左堆「大根堆」
     * 筛选出最大的元素，然后再把大根堆堆顶加入到右堆中。同理，奇数个借右堆筛选最小的，加入左堆
     */
    class MedianFinder {
        private PriorityQueue<Integer> right = new PriorityQueue<>(); // 右堆，小根堆
        private PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> (y - x)); // 左堆，大根堆
        private int n = 0; // 两堆的总元素个数

        public void addNum(int num) {
            if (n % 2 == 0) {
                left.offer(num);
                right.offer(left.poll());
            } else {
                right.offer(num);
                left.offer(right.poll());
            }
            n++;
        }

        public double findMedian() {
            return n % 2 == 0 ? (left.peek() + right.peek()) / 2.0 : right.peek();
        }
    }
}
