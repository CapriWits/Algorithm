package Dichotomy;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为 1。
 * @Description: 剑指 Offer 11. 旋转数组的最小数字
 * @Author: Hypocrite30
 * @Date: 2021/11/1 16:44
 */
public class _11 {
    /**
     * 二分
     * 前面一段是非递减，后一段也是非递减，且后一段第一个元素为最小值，待查找
     * mid > j: mid 在前一段，i 移动到 mid + 1
     * mid < j: mid 在后一段，j 移动到 mid
     * mid = j: 左段与右段是一样高度，舍弃 j 位置，j向前移动，下一个循环判断
     * 注：mid 与 i 比较没有意义，无法分辨在哪一段，所以只跟 j 比即可
     */
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) {
                j = mid;
            } else {
                j--;
            }
        }
        return numbers[i];
    }
}
