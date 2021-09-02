package D_common;

import java.util.Arrays;

public class CommonUtil {
    public static void printListNodes(Node head){
        System.out.print("Head -> ");
        while (head!=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void printDoubleListNodesFromHead(DoubleNode head){
        System.out.print("Head -> ");
        while (head!=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void printDoubleListNodesFromTail(DoubleNode tail){
        System.out.print("Head -> ");
        while (tail!=null){
            System.out.print(tail.val+" -> ");
            tail = tail.last;
        }
        System.out.println("null");
    }
    public static void printArray(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            if (i == 0) {
                System.out.print("[" + inputArr[i]);
            } else if (i == inputArr.length - 1) {
                if (inputArr.length > 1)
                    System.out.print(", ");
                System.out.println(inputArr[i] + "]");
            } else {
                System.out.print(", " + inputArr[i]);
            }

        }
        System.out.println();
    }

    /**
     * 生成随机数组
     */
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() [0,1)
        // Math.random() * N [0,N)
        // (int)(Math.random() * N) [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 直接使用java自带排序函数进行比较
     *
     * @param arr
     */
    public static void javaSort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 判断两个数组是否内容一致
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
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
}
