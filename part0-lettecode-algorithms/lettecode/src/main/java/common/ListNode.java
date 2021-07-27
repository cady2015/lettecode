package common;


public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static void printList(ListNode head){
            ListNode tail = head;
            while (tail != null){
                System.out.print(tail.val);
                if (tail.next != null){
                    System.out.print(" -> ");
                }else {
                    System.out.println();
                }
                tail = tail.next;
            }
        }
    }