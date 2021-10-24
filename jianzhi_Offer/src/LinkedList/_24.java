package LinkedList;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @Description: 剑指 Offer 24. 反转链表
 * @Author: Hypocrite30
 * @Date: 2021/10/24 20:00
 */
public class _24 {
    /**
     * 迭代，头插法
     * 1.next 存 head 下一位置
     * 2.head 结点连接到 newHead
     * 3.newHead 向前移动到 head
     * 4.head 回到原链表的 next 位置
     * 循环 1 - 4，最后返回新链表头
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, next;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 递归「不推荐」
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head; // 指回来
        return newHead;
    }

}
