package Stack_Queue_Heap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 * @Author: Hypocrite30
 * @Date: 2021/10/16 15:47
 */
public class _09 {
    /**
     * 维护两个栈
     * 入栈 push 到 in 里面
     * 出栈判断 out 空不空，空了就从 in 里面拿值，要弹出所有元素，弹出后下一次弹出「out.pop」就是队列顺序
     */
    class CQueue {
        Deque<Integer> in = new ArrayDeque();
        Deque<Integer> out = new ArrayDeque();

        public CQueue() {
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            // 输出栈空，把输入栈全部元素都装进输出栈
            if (out.isEmpty()) {
                while (!in.isEmpty())
                    out.push(in.pop());
            }
            if (out.isEmpty()) {
                return -1;
            } else {
                return out.pop();
            }
        }
    }
}