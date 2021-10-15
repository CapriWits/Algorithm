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

public class SwapNodesInPairs_24 {

    /*
        递归
     */
    /*public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }*/

    /*
        迭代
            迭代方法需要三个指针，按顺序为 cur -> mid -> tail -> ...
            原链表：dummyHead -> head(node1) -> node2 -> ...
                    cur          mid            tail
            1. cur -> tail 2. mid -> tail.next 3. tail -> mid，2/3不能换位置，会找不到后续链表的
            最后还要将cur更新，cur = mid，因为mid此时是反转后两节点的后面那个节点
     */
    /*public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode mid = cur.next;
            ListNode tail = cur.next.next;
            cur.next = tail;
            mid.next = tail.next;
            tail.next = mid;
            cur = mid;
        }
        return dummyHead.next;
    }*/

}
