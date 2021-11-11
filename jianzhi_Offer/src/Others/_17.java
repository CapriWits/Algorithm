package Others;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * @Description: 剑指 Offer 17. 打印从1到最大的n位数
 * @Author: Hypocrite30
 * @Date: 2021/11/11 16:43
 */
public class _17 {
    int[] res;
    int nine = 0, count = 0, start, n; // nine 为高位 9 的偏移量「从右向左数」，start 为有效数字的偏移量「从左往右数」
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 回溯
     * 需要考虑到大数问题，所以不能迭代直接累加到 10 ^ n - 1,
     * 回溯会出现两个问题：
     * 1. 递归过程，会出现高位 0 的情况。需要 start 作为有效数字的偏移量「从左往右数」
     * 2. 字符串高位 9 需要进位，用 nine 表示最高位 9 偏移量「从右向左数」
     * n - start = nine 说明高位已经加到 9，需要进位，所以 start--
     */
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1; // 默认有效数字最高位只能取到 n - 1，如 n = 3,则取到 999
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start); // 只截取偏移量后面的有效数
            if (!s.equals("0")) res[count++] = Integer.parseInt(s); // 字符串转换为 int 存入结果数组
            if (n - start == nine) start--; // 高位为 9，则有效位 -1，即最高位需进位
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++; // 当前添加的数字为 9，则将最高位 9 偏移量 + 1
            num[x] = i;
            dfs(x + 1);
        }
        nine--; // 回溯时，需要把高位 9 偏移量 -1，下一次遍历还会加到高位 9，到时候还会增 一
    }
}
