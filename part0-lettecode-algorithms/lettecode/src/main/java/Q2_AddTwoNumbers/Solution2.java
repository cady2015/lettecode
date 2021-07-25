package Q2_AddTwoNumbers;

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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null){
            return null;
        }
        if(l1 == null){
            l1 = new ListNode(0);
        }
        if(l2 == null){
            l2 = new ListNode(0);
        }
        int rval = l1.val + l2.val;
        if(rval >= 10){ //对进位情况进行处理
            rval = rval % 10;
            if(l1.next != null){
                l1.next.val+=1; // 直接给l1的下一位加1 ，相当于进位操作
            }else{
                l1.next = new ListNode(1); // l1 已经到了尾部，直接将进位值赋给l1新建的尾部节点
            }
        }
        return new ListNode(rval, addTwoNumbers(l1.next, l2.next));
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode.printList(l1);

        ListNode l2 = new ListNode(4,new ListNode(6,new ListNode(5,new ListNode(8))));
        ListNode.printList(l2);

        ListNode listRes = addTwoNumbers(l1, l2);
        ListNode.printList(listRes);
    }
}