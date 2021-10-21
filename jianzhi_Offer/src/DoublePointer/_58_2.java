package DoublePointer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * @Description: 剑指 Offer 58 - II. 左旋转字符串
 * @Author: Hypocrite30
 * @Date: 2021/10/21 20:30
 */
public class _58_2 {
    /**
     * 拷贝字符串，[k, n - 1] + [0, k - 1]
     */
    public String reverseLeftWords(String s, int k) {
        char[] ss = s.toCharArray();
        char[] res = new char[s.length()];
        System.arraycopy(ss, k, res, 0, s.length() - k);
        System.arraycopy(ss, 0, res, s.length() - k, k);
        return new String(res);
    }

    /**
     * 拷贝字符串也可以用双指针来实现，也是先从 k 索引开始，再倒回来
     */
    public String reverseLeftWords2(String s, int k) {
        char[] res = new char[s.length()];
        int i = k, j = -1;
        while (++j < s.length()) {
            res[j] = s.charAt(i);
            i = (i + 1) % s.length();
        }
        return new String(res);
    }

    /**
     * Test
     */
    public static void main(String[] args) {
        System.out.println(new _58_2().reverseLeftWords2("abcdefg", 3));
    }
}
