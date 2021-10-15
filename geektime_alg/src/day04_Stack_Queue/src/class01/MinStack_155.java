package day04_Stack_Queue.src.class01;

import java.util.Deque;
import java.util.LinkedList;

// 155. 最小栈
/*
    不使用辅助栈
        栈内存储的元素为元组，用数组储存，前一个元素为数据的值，后一个元素为
            从当前元祖到下面所有的元组值的最小值
 */
/*public class MinStack_155 {

    private Deque<Integer[]> stack = new LinkedList<Integer[]>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Integer[] {x, x});
        } else {
            stack.push(new Integer[] {x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}*/

/*
    使用辅助栈
        minStack 来保存当前元素及其下面的元素的最小值
 */
public class MinStack_155 {

    Deque<Integer> stack = new LinkedList<Integer>();
    Deque<Integer> minStack = new LinkedList<Integer>() {{
        push(Integer.MAX_VALUE);    // 初始化最小栈里放一个Integer最大值，防止栈空插入时比较大小空指针
    }};

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
