package bit_operation;

/**
 * 题目3：
 * 获取一个数二进制值中最右边的1
 *
 * 思路： a & a取反加一
 */
public class A3_get_right_one {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(getRightOne(x));
    }

    /**
     * 找出奇数个的数值
     * @param num
     */
    private static int getRightOne(int  num) {
        return num & ((~num)+1);
    }

}
