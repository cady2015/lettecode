package E_list_operation;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用双端链表实现栈和队列
 * <p>
 * 目的：
 * 了解栈和队列的特性
 * 栈：从头结点写入，从头结点取出
 * 队列：从头节点写入，从尾结点取出
 * 熟练掌握链表添加节点和移除节点的操作
 */
public class A3_DoubleEndsListToStackAndQueue {
    public static class Node<T> {
        public T val;
        public Node next;
        public Node last;

        public Node(T val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(T value) {
            this.val = value;
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

    /**
     * 构建双端队列
     */
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromBottom(T value) {
            Node<T> cur = new Node<T>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.last = cur;
                tail = cur;
            }
        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next; // 注意顺序，顺序不对很容易出现空指针异常
                cur.next = null;
                head.last = null;
            }
            return cur.val;
        }

        public T popFromBottom() {
            if (tail == null) {
                return null;
            }
            Node<T> cur = tail;
            if (tail != head) {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            } else {
                head = null;
                tail = null;
            }
            return cur.val;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }


    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }


    public static void main(String[] args) {
        final int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 1000000;

        for (int i = 0; i < testTimes; i++) {
            int randNum = (int) (Math.random() * value);
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            int j = 0;
//            System.out.println("start test myQueue...");
            while (j++ < oneTestDataNum) {
                if (myStack.isEmpty()) {
                    myStack.push(randNum);
                    stack.push(randNum);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(randNum);
                        stack.push(randNum);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops! some thing went wrong In myStack!");
                            throw new RuntimeException();
                        }
                    }
                }
            }

            int j2 = 0;
//            System.out.println("start test myQueue...");
            while (j2++ <oneTestDataNum) {
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!  something went wrong In myQueue! ");
                            throw new RuntimeException();
                        }
                    }
                }
            }
        }
        System.out.println("finished!" );
    }
}
