package list_operation;

import common.CommonUtil;

/**
 * 使用数组实现一个队列
 * <p>
 * 思路：
 * 1.使用size来记录 活跃区间的大小
 * 2.使用push_index 和 pop_index 来记录 入栈和出栈的开始位置
 * 3.功能方法：
 * 构造函数
 * push 入栈
 * pop 出栈
 */
public class A4_RindArray {
    public static class MyQueue {

        private int[] arr;
        private int pushi;//end  队尾  用于写数
        private int polli;//begin 队头 用于取数
        private int size;
        private int limit;// 队列长度限制

        /**
         * 构造函数
         *
         * @param limit 队列长度的限制
         */
        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        /**
         * 向队列中放数
         *
         * @param value
         */
        public void push(int value) {
            if (size == limit) { //每次操作都检查队列大小是否超过了limit限制
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        /**
         * 从队列中取数
         *
         * @return
         */
        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了！");
            }
            size--;
            int value = arr[polli];
            polli = nextIndex(polli);
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 获取下一个索引位置
        private int nextIndex(int pushi) {
            int nextIndex = pushi < limit-1 ? pushi + 1 : 0;
            return nextIndex;
        }
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(6);
        int[] push_arr1 = {1, 2, 3, 4, 5, 6};
        for (int m : push_arr1) {
            myQueue.push(m);
        }

        int pull_nums = 4;
        while (pull_nums-- > 0) {
            System.out.println("pulled:"+myQueue.pop());
        }

        int[] push_arr2 = {7,8,9,10};
        for (int m : push_arr2) {
            myQueue.push(m);
        }

        CommonUtil.printArray(myQueue.arr);
    }


}
