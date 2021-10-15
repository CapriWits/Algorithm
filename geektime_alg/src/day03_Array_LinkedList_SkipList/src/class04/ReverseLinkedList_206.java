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

// 206. 反转链表
public class ReverseLinkedList_206 {

    /*
        迭代 O(n) 空间：O(1)
            dummyHead为反转链表的新头节点，初始化为null，
            原链表第一个节点指向dummyHead，即为null，相当于反转链表的末尾，然后dummyHead跑到前面去
            思路：
                原链表让head一直遍历下去，每到一个节点，先用temp记录head.next
                然后head.next指向反转链表新节点dummyHead，实现断链，dummyHead再前移，保持头部位置
                然后head游标回到原来的链表 temp 处，如此迭代下去
     */
    /*public ListNode reverseList(ListNode head) {
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
        递归 O(n) 空间：O(n)
        https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-shuang-zhi-zhen-di-gui-yao-mo-/
     */
    /*public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; // 如果只有一个节点，则直接返回
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }*/

}


