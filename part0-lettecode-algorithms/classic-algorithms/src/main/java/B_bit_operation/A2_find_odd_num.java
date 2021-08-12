package B_bit_operation;

/**
 * 题目2：
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印出这种数
 *
 * 思路：将所有数都异或起来，得到的最终结果就是那个奇数个的数值
 *
 * 原理：
 * 1，两个相同的数之间异或必然得到0
 * 2. 异或操作有交换律，因此异或不受数值顺序影响
 *
 */
public class A2_find_odd_num {


    public static void main(String[] args) {
        // 奇数个8，偶数个其他的
        int[] a = {5, 9, 8, 9, 5, 30, 30, 97, 97, 3, 3};
        System.out.println(findOddOne(a));
    }

    /**
     * 找出奇数个的数值
     * @param arr
     */
    private static int findOddOne(int[] arr) {
        int eor =0;
        for(int i : arr){
            eor = eor ^ i;
        }
        return eor;
    }

}
