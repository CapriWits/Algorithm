package LinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @Description: 剑指 Offer 06. 从尾到头打印链表
 * @Author: Hypocrite30
 * @Date: 2021/10/22 20:04
 */
public class _6 {
    /**
     * 遍历链表，每个元素顺序压入栈，最后再从栈依次取出即可实现倒序
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int n = stack.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = stack.pop();
        return res;
    }
}
