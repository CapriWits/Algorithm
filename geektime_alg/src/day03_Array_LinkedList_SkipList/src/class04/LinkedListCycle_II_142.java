package day03_Array_LinkedList_SkipList.src.class04;

import java.util.HashSet;
import java.util.Set;

/*class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}*/

// 142. 环形链表 II
public class LinkedListCycle_II_142 {

    /*
        哈希表
            遍历链表，途中用哈希表记录，每到下一个节点就查一次哈希表，如果存在重复节点，直接返回即可
     */
    /*public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }*/

    /*
        快慢双指针
            https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
            需要用到两次快慢指针，总体思路是 第一次让快慢指针相遇，并让慢指针别动记录相遇点
            第二次，让快指针回到起点处，然后让快指针和慢指针以相同的速度前进，直到它们相遇，则相遇点就是环的起点。
            上面的链接有详细证明，这里的证明来自：
            https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything
            评论区的简单证明：
            Assume :
            the distance from head to the start of the loop is x1
            the distance from the start of the loop to the point fast and slow meet is x2
            the distance from the point fast and slow meet to the start of the loop is x3
            1. What is the distance fast moved? 2. What is the distance slow moved? 3. And their relationship?
            1. x1 + x2 + x3 + x2
            2. x1 + x2
            3. x1 + x2 + x3 + x2 = 2 (x1 + x2) 快指针走的距离是慢指针的两倍
     */
    /*public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null; // 让下面的快指针有的走
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        fast = head;
        // 第二次快慢指针前进，速度是一样的
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }*/


}
