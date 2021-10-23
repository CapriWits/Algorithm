package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。
 * 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * @Description: 剑指 Offer II 022. 链表中环的入口节点
 * @Author: Hypocrite30
 * @Date: 2021/10/23 20:18
 */
public class _23 {
    /**
     * 遍历过程将结点存到 Set 去重，遇到重复就是环的入口
     * Time: O(n) Space: O(n)
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return head;
            else
                set.add(head);
        }
        return null;
    }

    /**
     * 快慢指针
     * 设在起点到环入口长度为 a,入口到快慢指针相遇点长度为 b「顺时针」,相遇点到入口长度为 c「顺时针」
     * 快指针与慢指针同时从 head 出发，快指针比慢指针速度快一倍，两者相遇时，假设快指针只在环里走了一整圈
     * 则 2(a + b) = a + b + c + b -> a = c，此时 slow 还在相遇点，让 head 和 slow 同速度前进
     * 相遇的位置就是入口，因为 a = c「也可以让 fast 回起点」
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // 相遇
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

}
