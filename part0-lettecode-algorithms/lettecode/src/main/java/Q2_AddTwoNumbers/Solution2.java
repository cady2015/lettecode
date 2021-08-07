package Q2_AddTwoNumbers;

import common.Node;

/**
 *
 * 两数相加--链表版本
 *
 * 解法2：使用递归
 *
 * 递归关键点：
 * 1.进入条件：当前位完成相加操作
 * 2.跳出递归条件：当两链表都到了尾部
 *
 *
 */

class Solution2 {
    public static Node addTwoNumbers(Node l1, Node l2) {
        if(l1 == null && l2 ==null){
            return null;
        }
        if(l1 == null){
            l1 = new Node(0);
        }
        if(l2 == null){
            l2 = new Node(0);
        }
        int rval = l1.val + l2.val;
        if(rval >= 10){ //对进位情况进行处理
            rval = rval % 10;
            if(l1.next != null){
                l1.next.val+=1; // 直接给l1的下一位加1 ，相当于进位操作
            }else{
                l1.next = new Node(1); // l1 已经到了尾部，直接将进位值赋给l1新建的尾部节点
            }
        }
        return new Node(rval, addTwoNumbers(l1.next, l2.next));
    }
    public static void main(String[] args) {
        Node l1 = new Node(2,new Node(4,new Node(3)));
        Node.printList(l1);

        Node l2 = new Node(4,new Node(6,new Node(5,new Node(8))));
        Node.printList(l2);

        Node listRes = addTwoNumbers(l1, l2);
        Node.printList(listRes);
    }
}