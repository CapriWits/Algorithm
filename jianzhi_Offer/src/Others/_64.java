package Others;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Description: 剑指 Offer 64. 求1+2+…+n
 * @Author: Hypocrite30
 * @Date: 2021/11/13 16:19
 */
public class _64 {
    /**
     * 与逻辑
     * 在递归到 n = 1 时，逻辑短路，不会判断后面表达式，即不会继续递归
     */
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
