package trapRainWater;

/**
 * 42. 接雨水
 *
 * @Author: Hypocrite30
 * @Date: 2022/2/23 14:49
 */
public class TrappingRainWater {

    /* 1. 暴力解法。用两个 for 求 [0:i] 和 [i:n-1] 的 l_max 和 r_max */
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l_max = 0, r_max = 0;
            for (int j = i; j >= 0; j--) l_max = Math.max(l_max, height[j]);
            for (int j = i; j < n; j++) r_max = Math.max(r_max, height[j]);
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }

    /* 2. 备忘录记录 */
    public int trap2(int[] height) {
        int n = height.length;
        int res = 0;
        int[] l_max = new int[n], r_max = new int[n];
        for (int i = 0; i < n - 1; i++) l_max[i] = Math.max(height[i], l_max[i + 1]);
        for (int i = n - 1; i > 0; i--) r_max[i] = Math.max(height[i], r_max[i - 1]);
        for (int i = 0; i < n; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    /* 3. 双指针 */
    public int trap3(int[] height) {
        int res = 0;
        int l_max = 0, r_max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            l_max = Math.max(l_max, height[l]);
            r_max = Math.max(r_max, height[r]);
            if (l_max > r_max) {
                res += r_max - height[r];
                r--;
            } else {
                res += l_max - height[l];
                l++;
            }
        }
        return res;
    }
}