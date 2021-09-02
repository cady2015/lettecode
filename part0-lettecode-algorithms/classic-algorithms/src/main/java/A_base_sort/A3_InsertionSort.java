package A_base_sort;

import static A_base_sort.A1_SelectionSort.swap;
import static D_common.CommonUtil.*;
import static D_common.CommonUtil.printArray;

/**
 * 插入排序
 *
 * 时间复杂度：最差情况下是O(n^2)
 */
public class A3_InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ n
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 ; j--){
                if (arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                }else{
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            javaSort(arr2);
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
        insertionSort(arr);
        printArray(arr);
    }

}
