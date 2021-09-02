package G_heap;


import java.util.PriorityQueue;

import static A_base_sort.A1_SelectionSort.swap;

/**
 * 基本的大顶堆
 */
public class S1_BasicMaxHeap {
    private int heapSize;
    private final int limit;
    private int[] heap;

    public S1_BasicMaxHeap(int limit) {
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
        heapify(heap, 0, heapSize);//调整堆顶位置的数
        return max;
    }

    /**
     * 向堆中插入数据，并在插入结束后使堆保持大顶堆
     * ps:当左右孩子相等时，默认左孩子保持最大
     *
     */
    public void heapInsert(int arr[], int index) {
        while (arr[index] > arr[(index - 1) / 2]) { //因为插入之后需要将该值不断上浮，所以使用while循环，停止循环的条件是：不再有父亲节点比自己小了 ，或者已经到达了根节点
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
            // 获取较大孩子下标， 把较大孩子的下标，给largest
            int largest = left + 1 < heapSize && arr[left + 1] < arr[left] ? left : left + 1;
            //index位置与较大孩子进行比较，获取最大下标
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) { //当最大值节点就已经是当前index位置了，停止下沉
                break;
            }
            swap(arr, largest, index); // 否则和较大孩子进行交换
            index = largest;        //下沉，将index更新为较大孩子的下标，继续往下瞅
            left = index * 2 + 1;   //更新左孩子的下标值
        }
    }

    private int peek() {
        return heap[0];
    }

    public static void main(String[] args) {
        // 大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Code02_Heap.MyComparator());
        heap.add(5);
        heap.add(5);
        heap.add(5);
        heap.add(3);
        //  5 , 3
        System.out.println(heap.peek());
        heap.add(7);
        heap.add(0);
        heap.add(7);
        heap.add(0);
        heap.add(7);
        heap.add(0);
        System.out.println(heap.peek());
        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        System.out.println("my max heap");
        S1_BasicMaxHeap heap2 = new S1_BasicMaxHeap(30);
        heap2.push(5);
        heap2.push(5);
        heap2.push(5);
        heap2.push(3);
        //  5 , 3
        System.out.println("peek"+heap2.peek());
        heap2.push(7);
        heap2.push(0);
        heap2.push(7);
        heap2.push(0);
        heap2.push(7);
        heap2.push(0);
        System.out.println("peek"+heap2.peek());
        while (!heap2.isEmpty()) {
            System.out.println("pop:"+heap2.pop());
        }

//
//
//        int value = 1000;
//        int limit = 100;
//        int testTimes = 1000000;
//        for (int i = 0; i < testTimes; i++) {
//            int curLimit = (int) (Math.random() * limit) + 1;
//            S1_BasicMaxHeap my = new S1_BasicMaxHeap(curLimit);
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
//        System.out.println("finish!");
//
    }

}
