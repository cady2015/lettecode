package list_operation;

import common.CommonUtil;
import common.Node;

/**
 * 功能：从一个单向链表中删除指定值
 */
public class A2_DeleteGivenValueFromList {

    /**
     * 从一个指定head 的链表中，删除所有节点value值=val的
     *
     * @param head 链表的头节点
     * @param val  要删除的值
     * @return
     */
    public static Node deleteGivenValue(Node head, int val) {

        /**
         *  先来到不是value值的该节点，作为新的 header
         *  换header操作只发生一次
         */
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }

        Node cur = head;
        Node pre = head;

        while (cur != null) {
            /**
             *  当前cur 值与target值相等，则说明找到了，需要继续寻找，则pre调到下一个节点，cur跳到下一个节点
             *  cur 跳到下一个节点，pre指向cur的下一个节点
             */
            if (cur.val == val) {
                pre.next = cur.next;
            } else { // 没找到，则pre跳到cur的位置
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    public static void main(String[] args) {

        Node head = new Node(1, new Node(2, new Node(3, new Node(4))));

        int targetVal = 3;

        System.out.println("Initial list :");

        CommonUtil.printListNodes(head);

        Node newHead = deleteGivenValue(head, 3);

        System.out.println("After deleted target val:" + targetVal);
        CommonUtil.printListNodes(newHead);
    }

}
