package Q2_AddTwoNumbers;

import D_common.Node;

/**
 * 2 个逆序的链表，要求从低位开始相加，得出结果也逆序输出，返回值是逆序结果链表的头结点。
 * <p>
 * Example:
 * <p>
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * 解题思路 #
 * 需要注意的是各种进位问题
 * <p>
 * 极端情况，例如
 * <p>
 * Input: (9 -> 9 -> 9 -> 9 -> 9) + (1 -> )
 * Output: 0 -> 0 -> 0 -> 0 -> 0 -> 1
 * <p>
 * <p>
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode() {}
 * *     ListNode(int val) { this.val = val; }
 * *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * * }
 */


public class Solution1 {

    public static Node addTwoNumbers(Node l1, Node l2) {
        // 定义中间变量：
        Node head = null, tail = null;
        // 进位值
        int carry = 0;

        // 循环次数：由最长的链表长度决定，这里对获取更长的链表对象作了简化，只要任意一个节点还未到达最尾部，则继续遍历
        while (l1 != null || l2 != null) {
            // 获取节点当前值：
            int n1 = l1 != null ? l1.val : 0; //当前指向的已经是尾部，则停止遍历，否则将当前节点的值取出
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new Node(sum % 10);
            } else {
                tail.next = new Node(sum % 10);
                tail = tail.next;
            }
            // 计算进位值，如果sum>10 则代表需要进位
            carry = sum / 10;

            // 整体向后移动，用于下次遍历
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //额外情况处理：已经到了最后一步，但是此时还需要进位
        if (carry == 1) {
            tail.next = new Node(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        Node l1 = new Node(2,new Node(4,new Node(3)));
        Node.printList(l1);

        Node l2 = new Node(4,new Node(6,new Node(5)));
        Node.printList(l2);

        Node listRes = addTwoNumbers(l1, l2);
        Node.printList(listRes);
    }
}
