package Others;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
 * 第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * @Description: 剑指 Offer 44. 数字序列中某一位的数字
 * @Author: Hypocrite30
 * @Date: 2021/11/13 12:26
 */
public class _44 {
    /**
     * 数学推导
     * @Reference: https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
