package A_base_sort;

import static D_common.CommonUtil.*;

/**
 * 选择排序
 *
 * 时间复杂度：O(n^2)
 *
 * 注意事项：
 * 1.外层循环到 inputArr.length - 1 就行
 * 2.内层循环需要设置一个变量用于临时存储当前一趟比较的最小值下标
 */
public class A1_SelectionSort {
    /**
     * @param inputArr
     */
    public static void selectionSort(int[] inputArr) {
        //数组为空情况
        if (inputArr == null || inputArr.length < 2) {
            return;
        }

        // 外层循环主体，对数组进行遍历  一共2层循环
        for (int i = 0; i < inputArr.length - 1; i++) {
            //内循环操作：从i+1开始，找到比inputArr[i]更小的值，如果有则进行交换
            int minIndex = i;
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[j] < inputArr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(inputArr, i, minIndex);
        }

//        printArray(inputArr);
    }


    public static void swap(int[] inputArr, int i, int smallerIndex) {
        int temp = inputArr[i];
        inputArr[i] = inputArr[smallerIndex];
        inputArr[smallerIndex] = temp;
    }


    public static void main(String[] args) {
//        int[] arr = {10,9,8,7,6,5,4,3,2,1};
//        printArray(arr);
//        selectionSort(arr);


        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
