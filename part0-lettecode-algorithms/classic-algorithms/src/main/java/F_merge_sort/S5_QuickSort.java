package F_merge_sort;

import D_common.CommonUtil;

import static A_base_sort.A1_SelectionSort.swap;
import static F_merge_sort.S4_Partition.partition;

/**
 * 快排，分三个版本讲
 * 1.0 、 2.0  时间复杂度都为O(N^2)
 * <p>
 * 3.0 时间复杂度为O(NlogN)
 */
public class S5_QuickSort {
    /**
     * 在 arr[L..R] 上进行荷兰国旗问题划分,  num 值是arr[R]
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }

        // (小于区...,less) < (等于区) < (more 大于区)

        int less = L - 1;    //  < 区域右边界（小于区最右边的值）
        int more = R;       //  >区左边界
        int index = L;      //
        while (index < more) { // 当< 区右边界 和 > 区左边界撞上时候，停止循环
            //当 less  == more 则index 跳下一个
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more); // index 所指向的内容和more区域-1的这个值进行交换
            }
        }

        // 因为参考数num必须放在中间位置，所以将R位置和more位置进行交换
        // L...less less+1...more-1   more..........R
        // L...less less+1............more more+1...R
        swap(arr, more, R);

        //返回  less+1,more
        return new int[]{less + 1, more};

    }

    /* 版本1：
        思路：每次都记录1个=num的值，作为中点，然后去递归实现
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return; // 没有排序必要
        }

        process(arr, 0, arr.length - 1);

    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);
        process(arr, L, M - 1);
        process(arr, M + 1, R);
    }

    /* 版本2：
        思路：每次都记录所有=num的值，作为中间区域，然后去递归实现
    */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return; // 没有排序必要
        }
        process2(arr, 0, arr.length - 1);
    }

    // arr[L...R] 排有序，快排2.0方式
    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // [ equalArea[0]  ,  equalArea[1]]
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }


    /* 版本3：
        思路：每次都取随机值作为划分点，其他区域使用递归实现
    */
    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return; // 没有排序必要
        }
        process3(arr, 0, arr.length - 1);
    }

    // arr[L...R] 排有序，快排2.0方式
    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);//加入随机中点
        // [ equalArea[0]  ,  equalArea[1]]
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }

    public static void main(String[] args) {

        int tryTimes = 1000000;

        while (tryTimes-- > 0) {
            int[] randomArray = CommonUtil.generateRandomArray(1000, 100);

            int[] arr2 = CommonUtil.copyArray(randomArray);
            int[] arr3 = CommonUtil.copyArray(randomArray);

            quickSort1(randomArray);
            quickSort2(arr2);
            quickSort3(arr3);

            for (int i = 0; i < randomArray.length; i++) {
                if (arr2[i] != randomArray[i] || arr3[i] != randomArray[i]) {
                    throw new RuntimeException("Oops~~");
                }
            }
        }

        System.out.println("Nice!");
    }
}
