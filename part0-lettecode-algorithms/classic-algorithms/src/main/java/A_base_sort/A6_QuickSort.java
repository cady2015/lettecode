package A_base_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static D_common.CommonUtil.copyArray;
import static D_common.CommonUtil.generateRandomArray;

/**
 * 快速排序---未完
 * Created by llj on 2019/7/8.
 */
public class A6_QuickSort {

    public static int[] quickSort(int[] a, int left, int right) {
        int temp;
        //定义递归的返回条件
        if (left > right) {
            return a;
        }
        temp = a[left]; //temp中存的就是基准数
        int i = left;
        int j = right;
        while (i < j) { //顺序很重要，要先从右边开始找
            while (a[j] >= temp && i <= j && j != left) {
                j--;
            }
            while (a[i] <= temp && i <= j && i != right) {
                i++;
            }
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //当i==j时，将基准数归位
        a[left] = a[j];
        a[j] = temp;
        quickSort(a, left, j - 1);
        quickSort(a, j + 1, right);
        return a;
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            if ((i + 1) % 100000 == 0) {
                System.out.println(simpleDateFormat.format(instance.getTime()) + "\talready passed :[" + i + "] test cases");
            }
            int[] arr = generateRandomArray(maxSize, maxValue);
            while (arr.length < 2) {
                arr = generateRandomArray(maxSize, maxValue);
            }

            int[] copyArray = copyArray(arr);
            Arrays.sort(copyArray);
            int[] ints = quickSort(arr, 0, arr.length - 1);
            boolean error_occured = false;
            for (int j =0;j< ints.length;j++) {
                if (ints[j]!=copyArray[j]){
                    System.out.println("Oops!");
                    break;
                }
            }
            if (error_occured!=false){
                System.out.println("Fucking fucked");
                break;
            }
        }

        System.out.println("Congrants");
    }
}
