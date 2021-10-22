package LinkedList;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @Description: 剑指 Offer 18. 删除链表节点
 * @Author: Hypocrite30
 * @Date: 2021/10/22 20:29
 */
public class _18_1 {
    /**
     * 双指针，pre 从 head 出发，cur 在 pre 后一个结点
     * 头结点就是目标结点，直接返回 head.next
     * 循环查找时，先让 pre 移动到 cur，cur 再移动到下一个位置
     * 遍历找 val 结点，然后 pre.next = cur.next 跳过结点，达到删除目的
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null)
            pre.next = cur.next;
        return head;
    }
}
