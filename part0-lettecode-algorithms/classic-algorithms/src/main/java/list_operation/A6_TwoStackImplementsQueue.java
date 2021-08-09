package list_operation;

import java.util.Stack;

public class A6_TwoStackImplementsQueue {
    public static class MyQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public MyQueue() {
            this.stackPush = new Stack<Integer>();
            this.stackPop = new Stack<Integer>();
        }

        /*
            push栈向pop栈倒入数据
            1.当需要从pop栈取数时，并且pop栈为空
            2.当push栈已经
         */
        private void pushToPop() {
            if (stackPop.isEmpty()){
                while(!stackPush.isEmpty()){ // StackPush 为空时停止
                    stackPop.push(stackPush.pop());
                }
            }
        }

        /**
         *  每添加一次元素就导过去一次
          * @param val
         */
        public void add (Integer val){
            stackPush.push(val);
            pushToPop();
        }

        /**
         *  从MyQueue取出数据
         * @return
         */
        public int poll() {
            if (stackPush.empty() && stackPop.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPush.empty() && stackPop.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.peek();
        }

    }

    public static void main(String[] args) {
        MyQueue test = new MyQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println("peek:"+test.peek());
        System.out.println("pool:"+test.poll());
        test.add(4);
        System.out.println("peek:"+test.peek());
        System.out.println("pool:"+test.poll());
        test.add(5);
        System.out.println("peek:"+test.peek());
        System.out.println("pool:"+test.poll());


    }
}
