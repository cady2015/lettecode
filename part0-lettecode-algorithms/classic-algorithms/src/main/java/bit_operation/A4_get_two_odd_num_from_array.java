package bit_operation;

import common.CommonUtil;

import java.util.Arrays;

/**
 * 题目：
 * 一个数组中有2种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印出这种数
 * <p>
 * 思路：
 * 1.将所有数都异或起来，得到res
 * 2.获取res最右边的1，得到eor'
 * 3.将数组中每个值都与其中的eor'进行位与，如果位与结果不是0，则说明找到了其中一个数
 * 4.使用eor ^ eor' 得到另外一个数
 */
public class A4_get_two_odd_num_from_array {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 3, 3, 3, 3, 6, 6, 4, 8, 1, 1, 9};
        CommonUtil.printArray(getTwoOddNumFromArray(arr));
    }

    /**
     * 找出数组中出现奇数次的2个数值，对应的实际值
     * 思路：
     * 假设 两个奇数值分别为 a,b
     * 1. 先将所有的值异或起来，留下了 a^b
     * 2. 然后任意取出其中的一位（取最右边一位1），与a^b 的结果进行异或，如果异或结果不等于0，则说明其中该位上该数为0;  如果异或结果等于0，则说明该数该位上为1
     * 如何获取a: 确定了a所有位上的1，就能知道a的值就是所有的1相或的结果
     * 如何获取b: b = (a^b)^a
     */
    private static int[] getTwoOddNumFromArray(int[] arr) {
        int[] res = new int[2];
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        int rightOne = eor & ((~eor) + 1);

        int eor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) == rightOne) {
                eor2 ^= arr[i];
            }
        }

        res[0] = eor2;
        res[1] = eor2 ^ eor;
        Arrays.sort(res);
        return res;
    }

}
