import common.ListNode;

public class testPrintList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2,new ListNode(4,new ListNode(3)));

        listNode.printList(listNode);
    }
}
