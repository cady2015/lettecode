package A_base_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static D_common.CommonUtil.generateRandomArray;
import static D_common.CommonUtil.printArray;

/**
 * 二分查找
 * 题目：
 * 找出有序数组中，>= value 的序列中最左边那个值
 * <p>
 * 时间复杂度：O(N*logN)
 */
public class A5_BS_mostLeft_sortedArr {

    public static int mostLeftNoLessNumIndex(int[] arr, int value) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {  //结束循环的条件：L 与 R 相交 即 R>L
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    // 测试：从左向右遍历，当遇到 大于或者等于value的值 时，则返回下标 i
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            if ((i+1) % 100000 == 0) {
                System.out.println(simpleDateFormat.format(instance.getTime()) + "\talready passed :[" + i + "] test cases");
            }
            int[] arr = generateRandomArray(maxSize, maxValue);
            while (arr .length<2) {
                arr = generateRandomArray(maxSize, maxValue);
            }
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != mostLeftNoLessNumIndex(arr, value)) {
                System.out.print("Arr:");
                printArray(arr);
                System.out.print("target value:");
                System.out.println(value);

                System.out.print("comparation res:");
                System.out.println(test(arr, value));

                System.out.print("your res:");
                System.out.println(mostLeftNoLessNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");


        int[] arr = generateRandomArray(maxSize, maxValue);
        while (arr .length<2) {
            arr = generateRandomArray(maxSize, maxValue);
        }
        int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        Arrays.sort(arr);
        System.out.print("Arr:");
        printArray(arr);
        System.out.print("target value:");
        System.out.println(value);

        System.out.print("comparation res:");
        System.out.println(test(arr, value));

        System.out.print("your res:");
        System.out.println(mostLeftNoLessNumIndex(arr, value));
    }
}
