package day07_Recursion.src.class02;

// 70. 爬楼梯
public class ClimbingStairs_70 {

    /*
        迭代
            用滚动数组，提高效率
     */
    /*public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2, c = 3;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }*/

    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
