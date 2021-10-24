package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * @Description: 剑指 Offer 35. 复杂链表的复制
 * @Author: Hypocrite30
 * @Date: 2021/10/24 20:44
 */
public class _35 {
    /**
     * 本题遇到的问题是
     * 如果遍历链表，头插法复制原链表时，出现当前结点的 random 指向了后面的结点
     * 然而后面的结点还没有遍历到，意味着还没有创建后面结点的复制结点，没法引用
     */

    /**
     * 哈希表 <Node, Node>
     * k - 旧结点，v - 旧结点同值的新节点
     * 第一次遍历链表，创建出每个结点的新结点映射，保存相同的值
     * 第二遍遍历链表，再把每个结点的 random 存入新结点映射中
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 拼接 + 拆分
     * 1.改造原链表。将每个旧结点后面跟上一个新节点，附上相同值。old1 -> new1 -> old2 -> new2 ...
     * 在改造后的链表，新旧链表在一起，就可以找到旧结点的 random 在新链表的映射结点
     * 2.更新新结点的 random 映射。
     * 3.新旧链表拆分
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return head;
        // 1.改造链表
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        // 2.更新新结点 random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                // 旧结点对应 random 结点的下一个节点才是新链表中的 random 映射
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next; // cur 在原链表结点上移动
        }
        // 3.拆分新旧链表
        cur = head.next;
        Node pre = head, newHead = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 手动补一个脱链后的旧链表尾
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
