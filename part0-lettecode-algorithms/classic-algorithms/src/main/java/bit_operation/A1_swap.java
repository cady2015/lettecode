package bit_operation;

import common.CommonUtil;

public class A1_swap {


    public static void main(String[] args) {
        int[] a = {5, 9, 30, 97, 3};
        swap(a, 1, 1);
        CommonUtil.printArray(a);
    }

    /**
     * 交换 arr数组中x下标和y下标,不借助外部变量
     * todo: 注意：不能使用相同下标进行交换，否则会出现意想不到的结果
     *
     * @param arr
     * @param x
     * @param y
     */
    private static void swap(int[] arr, int x, int y) {
        if (x != y) {
            arr[x] = arr[x] ^ arr[y];
            arr[y] = arr[x] ^ arr[y];
            arr[x] = arr[x] ^ arr[y];
        }
    }

}
