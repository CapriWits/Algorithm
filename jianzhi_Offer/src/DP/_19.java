package DP;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'
 * 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但与"aa.a"和"ab*a"均不匹配。
 * @Description: 剑指 Offer 19. 正则表达式匹配
 * @Author: Hypocrite30
 * @Date: 2021/11/12 19:59
 */
public class _19 {
    /**
     * dp
     * @Reference: https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zhu-xing-xiang-xi-jiang-jie-you-qian-ru-shen-by-je/
     * @param s 原串
     * @param p 模式串
     */
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 分为空正则和非空正则，空正则，只有空串可以匹配「i==0」其他不能匹配
                if (j == 0) {
                    f[i][j] = i == 0;
                } else { // 非空正则，按照当前模式串是否为 *
                    if (p.charAt(j - 1) != '*') {
                        // 当前原串和模式串匹配，或者模式串为「.」则是否匹配取决于 f[i - 1][j - 1]
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else { // 当前模式串为 * 下面两种情况满足一个即可，所以用或运算
                        if (j >= 2) { // p[j - 2] + * 出现 0 次，相当于不存在，直接看 f[i][j - 2]
                            f[i][j] |= f[i][j - 2];
                        }
                        // p[j - 2] + * 出现 1 次以上，则这个模式串可以向后匹配很多原串
                        // 前提是 原串最后一个字符与 * 前面字符匹配「j - 2」 或者 p[j-2] 为 「.」，则都可以匹配任何字符
                        // 满足条件，则结果取决于原串前面是否匹配，就与 i - 1 没关系了「因为后面都能匹配」，所以原串向前移 f[i-1][j]
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
