package Others;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，
 * 则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * @Description: 剑指 Offer 67. 把字符串转换成整数
 * @Author: Hypocrite30
 * @Date: 2021/11/13 16:58
 */
public class _67 {
    /**
     * 模拟
     * 先清空首尾空格
     * 用一个变量存正负符号，如果，没有符号，则循环起点从 0 下标开始而不是 1
     * 循环中 一旦遇到非数字部分，直接跳出，返回结果
     * res 累加过程是 自身扩大十倍 再加上当前位的 int 值「ascii 转 int」
     * 越界判断：
     * 因为 res 每次在低位加上数字需要扩大十倍，32 位 int 不能越界
     * res 在达到 2147483647「2 ^ 31 - 1」 / 10 = 214748364，所以下一个数不能超过 7，否则越界
     */
    public int strToInt(String str) {
        char[] s = str.trim().toCharArray();
        if (s.length == 0) return 0;
        int res = 0, bound = Integer.MAX_VALUE / 10;
        int idx = 1, sign = 1;
        if (s[0] == '-')
            sign = -1;
        else if (s[0] != '+') // 这个串没有符号位，从 0 下标开始
            idx = 0;
        for (int i = idx; i < s.length; i++) {
            if (s[i] < '0' || s[i] > '9') break; // 一旦遇到非数字部分，直接跳出，返回结果
            if (res > bound || (res == bound && s[i] > '7'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s[i] - '0');
        }
        return sign * res;
    }
}
