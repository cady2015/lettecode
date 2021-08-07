package common;


public class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(Node head) {
        Node tail = head;
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