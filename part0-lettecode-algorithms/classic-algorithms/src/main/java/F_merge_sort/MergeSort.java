package F_merge_sort;

import D_common.CommonUtil;

/**
 * 归并排序算法
 * 1.使用递归方式实现
 * 2.使用非递归方式实现
 */
public class MergeSort {

    /**
     * 1.使用递归方式
     * 思路：
     * a.使用二分的方式不断将区间切分，首先切分为2部分： L~M M+1~R
     * b.继续切分，直到小范围内局部有序
     * c.借用辅助空间，在merge小范围时，进行比较、排序、回写
     * d.重复c这一步，直到所有的都merge完
     */
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int L = 0;
        int R = arr.length - 1;

        process(arr, L, R);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int MID = (L + R) / 2;
        //先处理左子树，让左子树有序
        process(arr, L, MID);
        //再处理右子树，让右子树有序
        process(arr, MID + 1, R);

        //合并左右子树结果
        merge(arr, L, MID, R);
    }

    /**
     * 将左右子树进行合并
     *
     * @param arr
     * @param L
     * @param MID
     * @param R
     */
    private static void merge(int[] arr, int L, int MID, int R) {
        //创建help数组，长度为 R - L + 1
        int[] help = new int[R - L + 1];

        //指定比较指针位置
        int i = 0;
        int p1 = L;
        int p2 = MID + 1;

        // p1 p2 2个指针都不越界，就继续比较，写入,只有被拷贝进去那一边才进行指针右移
        while (p1 <= MID && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //总有一个指针越界，考虑剩下数据的处理
        // p2 越界,拷贝p1剩余的数据
        while (p1 <= MID) {
            help[i++] = arr[p1++];
        }
        // p1 越界,拷贝p2剩余的数据
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        // 将help的值全部覆盖回去,范围是 L~R 等同于 L ~ L+help.len -1
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    /**
     * 实现方式2：mergeSort非递归方式
     * 0.1-1 有序
     * 1.2-2有序
     * 2.4-4有序
     * 3.8-8 有序
     * <p>
     * 直到x+x > 数组最大长度
     * <p>
     * 注意：不能超过int极限
     * 应对方法：在mergeSize即将超过int 最大值之前，直接beak跳出 既满足计算要求，又能防止溢出
     */
    public static void mergeSort2(int[] arr) {
        if (arr == null) {
            return;
        }

        int N = arr.length;
        //每次归并的步长
        int mergeSize = 1;  // 当前有序的 左组长度
        while (mergeSize < N) { //在mergeSize大于N之前始终执行  时间复杂度是logN
            // 从当前左组的第一个位置开始，先让左右组之间有序
            int L = 0;
            while (L < N) { // 让L一直扫描到右侧N
                if (mergeSize >= N - 1) { // 跳出条件：mergeSize>=N-1
                    break;
                }
                int M = L + mergeSize - 1;

                // L..M  M+1..R
                int R = M + Math.min(mergeSize, N - (M + 1));
                merge(arr,L,M,R);
                L= R+1;
            }
            //防止溢出
            if(mergeSize>N/2){
                break;
            }
            mergeSize <<= 1; //乘以2
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        //simple test
        int[] arr = {5, 3, 6, 8, 2, 12, 87, 81, 33, 22, 9, 7, 48, 1};
        System.out.println("Before:");
        CommonUtil.printArray(arr);
//        mergeSort1(arr);
        mergeSort2(arr);
        System.out.println("After:");
        CommonUtil.printArray(arr);

        // data checker
    }
}
