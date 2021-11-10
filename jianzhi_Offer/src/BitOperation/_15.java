package BitOperation;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * @Description: 剑指 Offer 15. 二进制中1的个数
 * @Author: Hypocrite30
 * @Date: 2021/11/10 20:59
 */
public class _15 {
    /**
     * n & (n - 1) 获得最低位的 1，直到 n 为 0，中间穿插计数
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
