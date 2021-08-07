package list_operation;

import common.CommonUtil;
import common.DoubleNode;
import common.Node;

// 链表反转
public class A1_ReverseLinkedList {


    /**
     * 单链表反转
     *
     * @param head
     */
    public static Node ReverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 1.让next 保存第二个节点引用
            next = head.next;
            // 2.让head指向的节点指向null
            head.next = pre;
            // 3.让pre 指向head所指的位置
            pre = head;
            // 4.让head挪到下一个节点
            head = next;
        }
        return pre;
    }

    /**
     * 双向链表反转
     *
     * @param head
     */
    public static DoubleNode ReverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {


        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));
        System.out.println("Before reversed:");
        CommonUtil.printListNodes(head);

        Node reversedHead = ReverseList(head);
        System.out.println("After reversed:");
        CommonUtil.printListNodes(reversedHead);

        DoubleNode head2 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);
        DoubleNode tail = n4;

        head2.next = n2;
        n2.last = head2;
        n2.next = n3;
        n3.last = n2;
        n3.next = n4;
        n4.last = n3;
        System.out.println("DoubleList -- Before reversed:");
        CommonUtil.printDoubleListNodesFromHead(head2);
        System.out.println("DoubleList -- Before reversed: print from tail");
        CommonUtil.printDoubleListNodesFromTail(tail);
        DoubleNode newReversedHead
                = ReverseDoubleList(head2);
        System.out.println("DoubleList -- After reversed:");
        CommonUtil.printDoubleListNodesFromHead(newReversedHead);
    }

}
