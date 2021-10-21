package DoublePointer;


/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * @Description: 剑指 Offer 58 - I. 翻转单词顺序
 * @Author: Hypocrite30
 * @Date: 2021/10/21 19:49
 */
public class _58_1 {
    /**
     * API
     * trim去掉首位空格，正则表达式分割单词
     * ss 为分割好的单词数组，从后向前遍历，然后追加一个空格
     * 在最后 return 要 trim 把最后一个单词后面的空格去掉
     */
    public String reverseWords(String s) {
        String[] ss = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = ss.length;
        for (int i = n - 1; i >= 0; i--) {
            sb.append(ss[i]).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Test
     */
    public static void main(String[] args) {
        System.out.println(new _58_1().reverseWords("  hello world "));
    }
}
