package Arrays_Matrix;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Description: 剑指 Offer 05. 替换空格
 * @Author: Hypocrite30
 * @Date: 2021/10/14 17:25
 */
public class _05 {

    /**
     * 法一：Time (O^2) 暴力，遇到一个空格，把后面的全部挪两位，补上字符
     * 但后面的子串会被反复挪动，所以一开始就可以扩大三倍数组，然后遇到空格直接插值，降为O(n)
     */

    /**
     * Api，注：replaceAll 和 replace 都可以替换所有符合条件的字符，区别在于前者可以用正则表达式匹配
     */
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 可以开一个三倍长字符数组，但没必要，如果空格不多，会多出很多空间
     * 先遍历一遍，遇到空格在字符串末尾追加两个字符「这里选用空格」
     * p 原字符串末尾指针，q 改造后字符串末尾指针
     * 遍历开始都从末尾向前遍历，p 遇到空格，q 向前覆盖插入三个字符，没遇到，则直接补上 p 位置字符
     * Time: O(n) Space: O(n)
     */
    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int p = s.length() - 1; // 原字符串末尾下标
        for (int i = 0; i <= p; i++) {
            if (s.charAt(i) == ' ') // 遇到一个空格就在末尾加两个空格
                sb.append("  ");
        }
        int q = sb.length() - 1; // 改造后的字符串末尾
        while (p >= 0 && q >= p) {
            char ch = s.charAt(p);
            if (ch != ' ')
                sb.setCharAt(q--, ch);
            else {
                sb.setCharAt(q--, '0');
                sb.setCharAt(q--, '2');
                sb.setCharAt(q--, '%');
            }
            p--;
        }
        return sb.toString(); // StringBuilder new String(value, 0, count) 会截取长度的字符串返回
    }

    /**
     * Test
     * @param args
     */
    public static void main(String[] args) {
        String s = new _05().replaceSpace2(" 1 2 ");
        System.out.println(s);
    }
}
