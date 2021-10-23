package LinkedList;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 * @Author: Hypocrite30
 * @Date: 2021/10/23 19:53
 */
public class _22 {
    /**
     * 先遍历一遍链表，求出长度，再从都走 len - k 步就到倒数第 k 结点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        while (len-- > k) {
            p = p.next;
        }
        return p;
    }

    /**
     * 双指针
     * 快指针先走 k 步，然后快慢指针一起走，快指针走到 null，slow 就到倒数第 k 结点
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k-- > 0)
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
