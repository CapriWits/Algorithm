package day06_Tree.src.class01;

public class FibonacciNumber_509 {

    public int fib(int n) {
        if (n < 2) return n;
        int pre = 0, mid = 1, res = 1;
        for (int i = 2; i <= n; i++) {
            res = pre + mid;
            pre = mid;
            mid = res;
        }
        return res;
    }

}
