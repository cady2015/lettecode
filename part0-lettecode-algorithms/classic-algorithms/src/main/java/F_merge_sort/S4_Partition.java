package F_merge_sort;

import static A_base_sort.A1_SelectionSort.swap;

/**
 * 经典Netherland -- 荷兰三色旗问题  扩展
 */
public class S4_Partition {

    /**
     * 要求：
     * 将输入的数组，按照给定的num值进行分组,划分为2组，从左到右依次为<=num  ,>num
     * 返回=num区域左右边界下标
     * arr[R] 的另外一个含义
     *
     * @param arr
     * @return int  index of num start
     */
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;   // < 区左边界
        int index = L;          // index 遍历开始位置
        while (index < R) { //index 从左向右遍历，当index遍历值<=R时，停止遍历
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R); //当所有遍历完成之后，
        return lessEqual;
    }

    /**
     * 在 arr[L..R] 上进行荷兰国旗问题划分,  num 值是arr[R]
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] nethelandsFlag(int[] arr, int L, int R) {
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


    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 6, 3};  // 期望输出结果： (1,2)(3,3)(6)

//        int[] ints = nethelandsFlag(arr, 0, arr.length - 1);
//
//        System.out.println("less:");
//        for (int i = 0; i < ints[0]; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("\nequal:");
//        for (int i = ints[0]; i <= ints[1]; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("\nmore:");
//        for (int i = ints[1] + 1; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("");

        int[] arr = {3, 10, 2, 6, 9};
        int index = partition(arr, 0, arr.length - 1);

        System.out.println("less + equal:");
        for (int i = 0; i <= index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nmore:");
        for (int i = index+1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
