package day04_Stack_Queue.src.class02;

import java.util.*;

// 84. 柱状图中最大的矩形
public class LargestRectangleInHistogram_84 {

    /*
        暴力
            对高进行枚举，以当前为中心，向两边遍历，直到找到比当前高小的坐标，即可确定宽，
            长 * 宽 即可得到当前面积，更新结果即可。
     */
    /*public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        for (int mid = 0; mid < n; mid++) {
            int curHeigth = heights[mid];
            int l = mid, r = mid;
            while (l - 1 >= 0 && heights[l - 1] >= curHeigth) l--;
            while (r + 1 < n && heights[r + 1] >= curHeigth) r++;
            res = Math.max(res, (r - l + 1) * curHeigth);
        }
        return res;
    }*/

    /*
        单调栈
            https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
            从左向右，和从右向左遍历一遍数组，找到每个矩形为中心的左右边界
            单调栈是递增的，遇到递减情况，应该将大于的弹栈出来

            加上原数组两侧加上哨兵 0 ，则在循环中不需要判空
     */
    /*public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newHeights[i + 1] = heights[i];
        }
        n += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.addLast(0);   // 放入哨兵，循环不用做非空判断
        int res = 0;
        for (int i = 1; i < n; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }*/

}
