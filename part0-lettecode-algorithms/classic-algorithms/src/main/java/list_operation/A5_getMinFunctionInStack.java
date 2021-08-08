package list_operation;

import java.util.Stack;

/**
 * 除过创建一个栈之外，需要这个栈提供获取栈中最小值的功能
 * 实现方式1.创建一个栈，用来保存最小值，每变化一次都会对该栈中同步记录最小值
 * 实现方式2.这个伴随栈并非每次都进行操作，只有遇到比栈顶小或者相等的值才能被push进去
 */
public class A5_getMinFunctionInStack {

    public static class MyStack1 {

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        /**
         * 构造方法
         */
        MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int value) {
            if (stackMin .isEmpty()) {
                stackMin.push(value);
            } else if (value <= this.getMin()) {
                stackMin.push(value);
            }
            stackData.push(value);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is already empty ! ");
            } else {
                if (stackData.peek() <= stackMin.peek()) {
                    int val = stackData.pop();
                    stackMin.pop();
                    return val;
                } else {
                    int val = stackData.pop();
                    return val;
                }
            }
        }

        public int getMin() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackMin.peek();
        }
    }


    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(1);
        System.out.println("current min:" + myStack1.getMin());
        myStack1.push(2);
        System.out.println("current min:" + myStack1.getMin());
        myStack1.push(4);
        System.out.println("current min:" + myStack1.getMin());
        myStack1.push(3);
        System.out.println("current min:" + myStack1.getMin());
        myStack1.push(90);
        System.out.println("current min:" + myStack1.getMin());
        myStack1.push(6);
        System.out.println("current min:" + myStack1.getMin());

        int pop = myStack1.pop();
        System.out.println("poped:" + pop);
        int pop2 = myStack1.pop();
        System.out.println("poped:" + pop2);
        int pop3 = myStack1.pop();
        System.out.println("poped:" + pop3);

        System.out.println("current min:" + myStack1.getMin());
    }

}
