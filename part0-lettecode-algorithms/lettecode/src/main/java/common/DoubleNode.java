package common;


public class DoubleNode {
    public int val;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int val) {
        this.val = val;
    }

    public DoubleNode(int val, DoubleNode last, DoubleNode next) {
        this.val = val;
        this.last = last;
        this.next = next;
    }

    public static void printList(DoubleNode head) {
        DoubleNode tail = head;
        while (tail != null) {
            System.out.print(tail.val);
            if (tail.next != null) {
                System.out.print(" -> ");
            } else {
                System.out.println();
            }
            tail = tail.next;
        }
    }
}