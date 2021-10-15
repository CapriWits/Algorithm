package day03_Array_LinkedList_SkipList.src.class03;

public class ContainerWithMostWater_11 {

    /*
        O(n^2)
        暴力法
     */
    /*public int maxArea(int[] a) {
        int res = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int curArea = (j - i) * Math.min(a[i], a[j]); // 面积为长乘宽
                res = Math.max(res, curArea);
            }
        }
        return res;
    }*/

    /*
        O(n)
        边界考虑。两边夹逼
            两边往中间夹逼，下次循环，只让高度较低的往里走，高的不动
            因为最终面积的大小，取决于较矮的那根柱子
     */
    public int maxArea(int[] a) {
        int i = 0, j = a.length - 1, res = 0;
        while (i < j) {
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            res = Math.max(res, (j - i + 1) * minHeight);   // 上面一步i 或 j移动了一步，+1要把宽度补回来
        }
        return res;
    }

}
