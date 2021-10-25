package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * @Description: 剑指 Offer 52. 两个链表的第一个公共节点
 * @Author: Hypocrite30
 * @Date: 2021/10/25 11:37
 */
public class _52 {
    /**
     * 哈希表，用 Set 去重
     * 第一次从 headA 遍历到链表尾，过程记录结点，第二次从 headB 遍历
     * 遇到重复的元素，直接返回
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = headA;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        p = headB;
        while (p != null) {
            if (set.contains(p))
                return p;
            p = p.next;
        }
        return null;
    }

    /**
     * 双指针
     * p 指针从 A 走，q 从 B 走，两者走到尾，自动切换到另一条链表头
     * 相遇位置就是公共结点，否则走到尾 null
     * 证明：p 走了 a + c, q 走了 b + c, 然后切换链表，最终相遇
     * p 走了 a + c + b, q 走了 b + c + a，相等。没交叉，则会走到尾部，不相遇
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p == q ? p : null;
    }

}
