package classic_problems;

/**
 *
 * 杨辉三角特点：
    各行的第一个数都是1
    各行的最后一个数都是1
    从第3行起，除上面指出的第一个数和最后一个数外，其余各数是上一行同列和前一列两个数之和。
            可以表示为：a[ i ][ j ] = a[ i-1 ][ j ] + a[ i-1 ][ j-1 ]
 * Created by llj on 2019/7/7.
 */
public class A4_YanghuiTriangle {

    public static void main(String[] args) {
        int n = 10;
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            int m = 0;
            //打印行前空格
            for (; m < n - i; m++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                if (0 == j || i == j) {
                    a[i][j] = 1;
                }else{
                    a[i][j] = a[i-1][j]+a[i-1][j-1];
                }
                System.out.print(a[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
