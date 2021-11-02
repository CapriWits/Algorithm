package DivideConquer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。
 * @Description: 剑指 Offer 16. 数值的整数次方
 * @Author: Hypocrite30
 * @Date: 2021/11/2 11:59
 */
public class _16 {
    /**
     * n % 2 == 0: x ^ n = x ^ (n / 2) * x ^ (n / 2)
     * n % 2 == 1: x ^ n = x ^ (n / 2) * x ^ (n / 2) * x
     * Time: O(logN) - 指数每次都减半 Space: O(1)
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = 1.0;
        long b = n; // Integer.MIN_VALUE = -2 ^ 32，取绝对值会越界，用 long 存
        if (b < 0) { // 保证指数 b 为整数，做出的调整是将 x 取倒数
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if (b % 2 == 1) // 幂不为偶数，先把这个额外的 x 乘到结果中
                res *= x;
            x *= x;
            b >>= 1; // b 迟早会减到 0，此时 x 无论到多大，0 次方都会使之变成 1，最终只剩下累乘下来的 res * 1
        }
        return res;
    }

    /**
     * 递归实现
     * Time: O(logN) - 指数每次都减半 Space: O(n) - 栈消耗
     */
    public double myPow2(double x, int n) {
        boolean isNegative = false;
        long b = n;
        if (b < 0) {
            b = -b;
            isNegative = true;
        }
        double res = pow(x, b);
        return isNegative ? 1 / res : res;
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double res = pow(x, n / 2);
        res = res * res;
        if (n % 2 == 1) res *= x;
        return res;
    }
}
