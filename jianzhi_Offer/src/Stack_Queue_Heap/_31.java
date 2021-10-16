package Stack_Queue_Heap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * @Description: 剑指 Offer 31. 栈的压入、弹出序列
 * @Author: Hypocrite30
 * @Date: 2021/10/16 16:23
 */
public class _31 {
    /**
     * 模拟
     * 用一个栈模拟入栈出栈过程，入栈直接 push，然后循环判断 栈顶元素 == 弹出数组第一个元素?
     * 相等，模拟出栈，轮到下个出栈的元素判断「outIdx++」，此过程循环，直到不需要出栈顺序不对应
     * 下个顺换入栈后继续判断
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int outIdx = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[outIdx]) {
                stack.pop();
                outIdx++;
            }
        }
        return stack.isEmpty();
    }
}
