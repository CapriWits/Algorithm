package day03_Array_LinkedList_SkipList.src.class04;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}*/

/* 141. 环形链表 */
public class LinkedListCycle_141 {

    /*
        哈希表
     */
    /*public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }*/

    /*
        快慢指针
            快指针每次走两步，慢指针每次走一步
            如果有环，快指针会困在环里，迟早会与慢指针相遇，判断快慢指针是否相遇就可以了
     */
    /*public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 判断快指针下一步和下两步能不能走和走没走到头，慢指针不需要判断，因为走的路都是快指针走过的，肯定能在
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }*/


}
