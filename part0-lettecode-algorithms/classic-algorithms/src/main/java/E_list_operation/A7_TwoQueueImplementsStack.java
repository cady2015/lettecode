package E_list_operation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 实现思路：
 * 使用2个队列，一个作为data队列，存储入栈数据，另一个作为help队列，辅助出栈
 * 入栈操作：
 * 直接写入data队列
 * 出栈操作（单个元素操作）：
 * 1.将data队列除最后一个入栈元素之外的所有元素，全部入队到help队列中
 * 2.将data队列中仅剩的最后一个元素出队
 * 3.将data队列修改为help队列，help队列修改为data队列，继续步骤1
 */
public class A7_TwoQueueImplementsStack {
    public static class TwoQueueStack<T> {
        private Queue<T> queue;
        private Queue<T> help;

        /**
         * 构造函数
         */
        public TwoQueueStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        /**
         * 入栈操作
         */
        public void push(T value) {
            queue.offer(value);
        }

        /**
         * 出栈操作
         */
        public T poll() {
            if (queue.isEmpty()) {
                throw new RuntimeException("the stack is empty");
            }
            while (queue.size() > 1) { //向help导入数据，直到queue留下最后一个元素
                help.offer(queue.poll());
            }
            T ans = queue.poll();

            Queue<T> tmp = queue;
            queue = help;
            help = tmp;

            return ans;
        }

        /**
         * 获取栈顶值
         */
        public T peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("the stack is empty");
            }
            while (queue.size() > 1) { //向help导入数据，直到queue留下最后一个元素
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);

            //交换引用
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;

            return ans;

        }

        /**
         * 是否为空判断
         */
        public boolean isEmpty() {
            return queue.isEmpty();
        }


        public static void main(String[] args) {
            int testTime = 1000000;
            int maxNum = 1000000;

            TwoQueueStack<Integer> myStack = new TwoQueueStack<>(); //实验组
            Stack<Integer> testStack = new Stack<>(); // 对照组
            for (int i = 0; i < testTime; i++) {
                //每次进来  检测到空就push数据进去
                if (myStack.isEmpty()){
                    if (!testStack.isEmpty()){
                        throw  new RuntimeException("Ops,myStack.isEmpty but! testStack.isEmpty");
                    }else{
                        int num = (int) Math.random() * maxNum;
                        myStack.push(num);
                        testStack.push(num);
                    }
                }else{
                    if(Math.random() <0.25){
                        int num = (int) (Math.random() * maxNum);
                        myStack.push(num);
                        testStack.push(num);
                    }else if(Math.random()<0.5){
                        if (!myStack.peek().equals(testStack.peek())) {
                            System.out.println("Oops");
                        }
                    }else if(Math.random()<0.75){
                        if (!myStack.poll().equals(testStack.pop())) {
                            System.out.println("Oops");
                        }
                    }else{
                        if (myStack.isEmpty() != testStack.isEmpty()) {
                            System.out.println("Oops");
                        }
                    }
                }
            }
            System.out.println("test finish!");
        }
    }
}
