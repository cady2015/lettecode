package C_classic_problems;

/**
 * 题目：使用冒泡排序将下列数组由小到大排列：
 * int[] a = {6,5,4,3,2,1};

 * 每完成一次外循环，最大数将出现在最末尾，
 * 内外循环的边界条件参数：
 *  i<a.length - 1 :
 *      如果排序数组的长度为n，总共需要冒出的最大数个数为n-1，则需要排序的趟数为：n-1
 *  j<a.lenth -1 -i:
 *      当进入下一次外循环时，不需要对末尾进行再一次排序，因此，内循环中可以不将末尾数字加入排序比较流程，因此 j<a.lenth -i-1
 * Created by llj on 2019/7/7.
 */
public class A3_BubbleSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1, 8, 9, 40, 922, 924, 638, 9931, 41, 363};

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
