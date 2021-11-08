package DP;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 * @Description: 剑指 Offer 66. 构建乘积数组
 * @Author: Hypocrite30
 * @Date: 2021/11/8 20:56
 */
public class _66 {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0, p = 1; i < a.length; i++) {
            ans[i] = p;
            p *= a[i];
        }
        for (int i = a.length - 1, p = 1; i >= 0; i--) {
            ans[i] *= p;
            p *= a[i];
        }
        return ans;
    }
}
