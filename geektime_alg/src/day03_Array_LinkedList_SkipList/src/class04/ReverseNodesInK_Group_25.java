package day03_Array_LinkedList_SkipList.src.class04;

/*class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/

// 25. K 个一组翻转链表
public class ReverseNodesInK_Group_25 {

    /*
        迭代
            https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
            需要用到两个指针。pre: 要反转子链表前一个节点，end: 要反转链表的末尾节点
            pre 和 end 先在dummyHead虚拟头节点处触发，end 向前走k步，然后用 nextNode 标记 end.next，用于翻转后接上去
            还需要start = pre.next，即 [start, end] 这一段为需要翻转的子链表
            ListNode reverseList(head) 传入 start，返回翻转链表的头节点，
            然后将前面记录的 nextNode 接到翻转链表的尾部，注：这里的尾节点是翻转前的 start
            最后让 pre 和 end 重新归位，都赋值为 start 即可
     */
    /*public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode nextNode = end.next;
            end.next = null;    // 断链，方便翻转
            pre.next = reverseList(start); // 进行反转，并接上前面已翻转好的链表
            start.next = nextNode;
            pre = start;
            end = start;
        }
        return dummyHead.next;
    }
    private static ListNode reverseList(ListNode head) {
        ListNode dummyHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummyHead;
            dummyHead = head;
            head = temp;
        }
        return dummyHead;
    }*/

    /*
        递归
     */
    /*public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 1; i < k; i++) {   // 先前移动 k - 1 个节点，因为没用dummyHead
            if (tail == null) return head;
            tail = tail.next;
        }
        if (tail == null) return head;  // 进行特判
        ListNode nextNode = tail.next;
        tail.next = null;   // 断链，方便后面翻转
        ListNode newHead = reverseList(head);
        head.next = reverseKGroup(nextNode, k); // 翻转后head就是链表尾
        return newHead;
    }
    private static ListNode reverseList(ListNode head) {
        ListNode dummyHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummyHead;
            dummyHead = head;
            head = temp;
        }
        return dummyHead;
    }*/

}
