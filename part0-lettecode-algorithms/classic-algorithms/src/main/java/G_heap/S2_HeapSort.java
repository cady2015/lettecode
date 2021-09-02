package G_heap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 使用堆结构完成对数组的排序
 * <p>
 * 思路：
 * 每次从根节点插入新的元素
 * 每次插入新元素之后，尝试让该元素处于最对的位置，让堆保持大根堆的特性
 */
public class S2_HeapSort {

    public static void heapSort(Integer[] arr) {
        //例外情况：arr 长度小于2不用排序， 或者arr是一个空引用
        if (arr == null || arr.length < 2) {
            return;
        }

        //让数组成为一个大顶堆
//        for (int i = 0; i <= arr.length - 1; i++) {
//            heapInsert(arr, i);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        // 交换 堆顶元素和数组尾部元素，并让堆大小（数组长度）减一
        swap(arr, 0, --heapSize);
        // 每完成一次heapify就代表堆调整完，就可以放一个元素到最后
        while (heapSize > 0) { // O(N)
            heapify(arr, 0, heapSize); // O(logN)
            swap(arr, 0, --heapSize); // O(1)
        }
    }

    /**
     * 向堆中插入数据，并在插入结束后使堆保持大顶堆
     * ps:当左右孩子相等时，默认左孩子保持最大
     */
    public static void heapInsert(Integer[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { //因为插入之后需要将该值不断上浮，所以使用while循环，停止循环的条件是：不再有父亲节点比自己小了 ，或者已经到达了根节点
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // for test  创建随机数组
    public static Integer[] generateRandomArray(int maxSize, int maxValue) {
        Integer[] arr = new Integer[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static Integer[] copyArray(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        Integer[] res = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(Integer[] arr1, Integer[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(Integer[] arr) {
        if (arr == null) {
            return;
        }
        for (Integer i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void swap(Integer[] inputArr, int i, int smallerIndex) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[smallerIndex];
        inputArr[smallerIndex] = temp;
    }

    /**
     * 让index到heapsize上的值满足大根堆的特性
     */
    private static void heapify(Integer[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) { //停止遍历条件是即将到达数组最尾部
            // 获取较小孩子下标， 把较小孩子的下标，给minimal
            int minimal = left + 1 < heapSize && arr[left + 1] < arr[left] ? left + 1 : left;
            //index位置与较小孩子进行比较，获取最小孩子下标
            minimal = arr[index] < arr[minimal] ? index : minimal;
            if (minimal == index) { //当最小值节点就已经是当前index位置了，停止下沉
                break;
            }
            swap(arr, minimal, index); // 否则和较小孩子进行交换
            index = minimal;        //下沉，将index更新为较小孩子的下标，继续往下瞅
            left = index * 2 + 1;   //更新左孩子的下标值
        }
    }
    static class CMP implements Comparator<Integer>{
        @Override //可以去掉。作用是检查下面的方法名是不是父类中所有的
        public int compare(Integer a,Integer b){
//        两种都可以，升序排序的话反过来就行
//        return a-b<0?1:-1;
            return b-a;
        }
    }
    public static void javaSort(Integer[] arr) {

        Comparator cmp=new CMP();
        Arrays.sort(arr,cmp);
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

//        int[] arr1 = generateRandomArray(maxSize, maxValue);
//        heapSort(arr1);
//        printArray(arr1);
//
//        int[] arr2 = copyArray(arr1);
//        javaSort(arr2);
//
//        printArray(arr2);
//        if (!isEqual(arr1, arr2)) {
//            succeed = false;
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        for (int i = 0; i < testTime; i++) {
            Integer[] arr1 = generateRandomArray(maxSize, maxValue);
            Integer[] arr2 = copyArray(arr1);
//            printArray(arr1);
//            printArray(arr2);
//            System.out.println("============");
            heapSort(arr1);
            javaSort(arr2);
//            printArray(arr1);
//            printArray(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;

            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
