package Others;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @Description: 剑指 Offer 65. 不用加减乘除做加法
 * @Author: Hypocrite30
 * @Date: 2021/11/13 16:23
 */
public class _65 {
    /**
     * 全加器
     * 计算 a + b
     * 进位部分 c = (a & b) << 1
     * 不进位部分 n = (a ^ b)
     * s = a + b = n + c
     * 因为全程不能用加法，所以就判断有无进位，一直循环计算直到无进位，输出无进位部分就是结果
     * java 底层用补码，正负数一样计算
     */
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; // 进位部分
            a ^= b; // a 异或 b 计算不进位部分
            b = c; // b 可以用来作为进位部分的存储
        }
        return a; // 最终只剩下不进位部分
    }
}
