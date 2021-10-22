package LinkedList;

import java.util.List;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 牛客 Link: https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef
 * @Description: JZ76 删除链表中重复的结点
 * @Author: Hypocrite30
 * @Date: 2021/10/22 20:55
 */
public class _18_2 {
    /**
     * 指针遍历，判断当前位置和下一个位置是否重复「值相等」，就继续遍历直到找非重复元素
     */
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy.next;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 递归法
     */
    private ListNode deleteDuplication2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val == head.next.val) { // 遇到重复结点
            ListNode next = head.next;
            while (next != null && next.val == head.val)
                next = next.next;
            return deleteDuplication(next); // 当前头结点是重复的，不能返回头结点，以下一个非重复结点递归结果作为返回
        } else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }
}
