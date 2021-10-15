package day04_Stack_Queue.src.class02;

import java.util.Deque;
import java.util.LinkedList;

//20. 有效的括号
public class ValidParentheses_20 {

    /*
        栈
            遍历字符串，遇到左括号，push，遇到右括号，与peek进行匹配
     */
    /*public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) return false;
        final Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }*/

    /*
        栈（不用哈希表）
            用一种巧妙的思想，如果遇到前括号，就把相应的后括号push入栈，在遇到后括号时，
            就可以匹配栈里是否与当前字符 “相同” ，用到pop，不仅可以拿出来比较，还可以清除stack
     */
    /*public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (Character c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }*/

}
