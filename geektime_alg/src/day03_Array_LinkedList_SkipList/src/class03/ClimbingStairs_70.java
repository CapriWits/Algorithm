package day03_Array_LinkedList_SkipList.src.class03;

public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2, c = 3;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
