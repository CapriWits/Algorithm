package day07_Recursion.src.class02;

import java.util.*;

// 22. 括号生成
public class GenerateParentheses_22 {

    /*
        递归来增加左括号和右括号，并记录左括号和右括号个数，
        递归终止条件使左右括号的个数都为n。
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, res, "");
        return res;
    }

    private void generate(int left, int right, int n, List<String> res, String curString) {
        if (left == n && right == n) {
            res.add(curString.toString());
            return;
        }

        if (left < n)
            generate(left + 1, right, n, res, curString + '(');
        if (left > right)   // 左括号个数必须要大于右括号才能添加右括号
            generate(left,  right + 1, n, res, curString + ')');
    }

}
