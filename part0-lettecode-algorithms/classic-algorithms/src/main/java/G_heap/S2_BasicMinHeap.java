package G_heap;


import java.util.PriorityQueue;

import static A_base_sort.A1_SelectionSort.swap;

/**
 * 基本的小根堆
 */
public class S2_BasicMinHeap {
    private int heapSize;
    private final int limit;
    private int[] heap;

    public S2_BasicMinHeap(int limit) {
        this.limit = limit;
        this.heap = new int[limit];
        this.heapSize = 0;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == limit;
    }

    /**
     * 向堆中添加一个元素
     * @param value
     */
    public void push(int value) {
        if (heapSize == limit) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value; //每次都是添加到数组末尾
        // value  heapSize
        heapInsert(heap, heapSize++);
    }


    /**
     * 返回大顶堆中的最大值
     *
     * @return
     */
    public int pop() {
        int max = heap[0];
        swap(heap, 0, --heapSize); //交换完之后，堆大小减一
        heapify(heap, 0, heapSize);//调整堆顶位置的数,从0位置开始
        return max;
    }

    /**
     * 向堆中插入数据，并在插入结束后使堆保持大顶堆
     * ps:当左右孩子相等时，默认左孩子保持最大
     *
     */
    public void heapInsert(int arr[], int index) {
        while (arr[index] < arr[(index - 1) / 2]) { //因为插入之后需要将小值不断上浮，所以使用while循环，停止循环的条件是：不再有父亲节点比自己大了 ，或者已经到达了根节点
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 从index往下看，当前节点值如果比孩子小就下沉
     * 直到不能再比孩子节点小/没有孩子
     */
    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) { //停止遍历条件是即将到达数组最尾部
            // 获取较小孩子下标， 把较小孩子的下标，给minimal
            int minimal = left + 1 < heapSize && arr[left + 1] < arr[left] ? left + 1: left ;
            //index位置与较小孩子进行比较，获取最小孩子下标
            minimal = arr[index] < arr[minimal]  ? index : minimal;
            if (minimal == index) { //当最小值节点就已经是当前index位置了，停止下沉
                break;
            }
            swap(arr, minimal, index); // 否则和较小孩子进行交换
            index = minimal;        //下沉，将index更新为较小孩子的下标，继续往下瞅
            left = index * 2 + 1;   //更新左孩子的下标值
        }
    }
    private int peek() {
        return heap[0];
    }

    public static void main(String[] args) {
        // 小根堆
        System.out.println("my Min Heap");
        S2_BasicMinHeap heap2 = new S2_BasicMinHeap(30);
        heap2.push(5);
        heap2.push(5);
        heap2.push(5);
        heap2.push(3);
        //  5 , 3
        System.out.println("peek"+heap2.peek());
        heap2.push(7);
        heap2.push(1);
        heap2.push(7);
        heap2.push(3);
        heap2.push(7);
        heap2.push(6);
        System.out.println("peek"+heap2.peek());
        while (!heap2.isEmpty()) {
            System.out.println("pop:"+heap2.pop());
        }

//
//        int value = 1000;
//        int limit = 100;
//        int testTimes = 1000000;
//        for (int i = 0; i < testTimes; i++) {
//            int curLimit = (int) (Math.random() * limit) + 1;
//            S2_BasicMinHeap my = new S2_BasicMinHeap(curLimit);
//            Code02_Heap.RightMaxHeap test = new Code02_Heap.RightMaxHeap(curLimit);
//            int curOpTimes = (int) (Math.random() * limit);
//            for (int j = 0; j < curOpTimes; j++) {
//                if (my.isEmpty() != test.isEmpty()) {
//                    throw new RuntimeException("Oops!");
//                }
//                if (my.isFull() != test.isFull()) {
//                    throw new RuntimeException("Oops!");
//                }
//                if (my.isEmpty()) {
//                    int curValue = (int) (Math.random() * value);
//                    my.push(curValue);
//                    test.push(curValue);
//                } else if (my.isFull()) {
//                    if (my.pop() != test.pop()) {
//                        throw new RuntimeException("Oops!");
//                    }
//                } else {
//                    if (Math.random() < 0.5) {
//                        int curValue = (int) (Math.random() * value);
//                        my.push(curValue);
//                        test.push(curValue);
//                    } else {
//                        if (my.pop() != test.pop()) {
//                            throw new RuntimeException("Oops!");
//                        }
//                    }
//                }
//            }
//        }
        System.out.println("finish!");

    }


}
