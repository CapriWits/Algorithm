package Stack_Queue_Heap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @Description: 剑指 Offer 30. 包含min函数的栈
 * @Author: Hypocrite30
 * @Date: 2021/10/16 16:02
 */
public class _30 {
    /**
     * 维护两个栈，数据栈 和 最小值栈
     * 最小栈存当前数据栈中最所有元素的最小值，所以肯定是递减的「非严格」
     * 每次 push 判断最小栈元素是否为空，空直接插入，不空与最小栈栈顶元素比较，小的入栈
     */
    class MinStack {
        Deque<Integer> dataStack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();

        public MinStack() {
        }

        public void push(int x) {
            dataStack.push(x);
            minStack.push(minStack.isEmpty() ? x : Math.min(minStack.peek(), x));
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}

