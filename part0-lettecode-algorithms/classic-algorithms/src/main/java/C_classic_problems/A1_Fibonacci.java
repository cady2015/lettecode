package C_classic_problems;

/**
 * 斐波那契数列
 * Created by llj on 2019/7/6.
 */
public class A1_Fibonacci {

    /**
     * 假设一个数列满足如下规则：
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
     * 89, 144, 233，377，610，987，1597，2584，4181，6765
     * <p>
     * 请推导出其公式，并问：第23个数是多少？
     * <p>
     *
     * 公式推导：
     * f(1) = 1; f(2) = 1; f(3) = 2; f(4) = f(3)+ f(2) = f(4-1)+f(4-2)
     * 最后推导出公式： f(n) = f(n-1) + f(n-2) n>=1
     */
    public static long jump(long n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return (jump(n - 1) + jump(n - 2));
    }

    public static void main(String[] args) {
        long fun = jump(23);
        System.out.println(fun);
    }

}
