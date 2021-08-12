package A_base_sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static D_common.CommonUtil.generateRandomArray;
import static D_common.CommonUtil.printArray;

/**
 * 二分查找
 * 有序数组中，是否存在一个value，存在则返回true 不存在返回false
 */
public class A4_BSExist {
    public static boolean exists(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;
        boolean exists = false;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] == val) {
                return true;
            } else if (arr[mid] < val) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return arr[L] == val;
    }

    public static boolean test(int[] arr, int val) {
        for (int i : arr) {
            if (i == val){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            if ((i + 1) % 100000 == 0) {
                System.out.println(simpleDateFormat.format(instance.getTime()) + "\talready passed :[" + i + "] test cases");
            }
            int[] arr = generateRandomArray(maxSize, maxValue);
            while (arr.length < 2) {
                arr = generateRandomArray(maxSize, maxValue);
            }
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exists(arr, value)) {
                System.out.print("Arr:");
                printArray(arr);
                System.out.print("target value:");
                System.out.println(value);

                System.out.print("comparation res:");
                System.out.println(test(arr, value));

                System.out.print("your res:");
                System.out.println(exists(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


        int[] arr = generateRandomArray(maxSize, maxValue);
        while (arr.length < 2) {
            arr = generateRandomArray(maxSize, maxValue);
        }
        Arrays.sort(arr);
        int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        System.out.print("Arr:");
        printArray(arr);
        System.out.print("target value:");
        System.out.println(value);

        System.out.print("comparation res:");
        System.out.println(test(arr, value));

        System.out.print("your res:");
        System.out.println(exists(arr, value));
    }

}
