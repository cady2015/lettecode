package F_merge_sort;

import D_common.CommonUtil;

/**
 * 求数组小和
 *
 * 小和的定义：一个数组中，一个数左边比它小的数的总和叫做数的小和
 * 所有小和累加，叫做数组小和
 *举例：
 *
 */
public class S2_SmallSum {

    public static void smallSum1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int L = 0;
        int R = arr.length - 1;

        int finalSmallSum = process(arr, L, R);
        System.out.println("finalSmallSum: "+finalSmallSum);

    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) { //只有一个元素，没有右边元素，因此返回0
            return 0;
        }

        int MID = (L + R) / 2;
        // 最终整个数组的小和 = 左子树小和 + 右子树小和 + 合并左右子树时产生的小和
        return process(arr, L, MID)
                + process(arr, MID + 1, R)
                + merge(arr, L, MID, R);


    }

    private static int merge(int[] arr, int L, int MID, int R) {
        //创建help数组，长度为 R - L + 1
        int[] help = new int[R - L + 1];

        //指定比较指针位置
        int i = 0;
        int p1 = L;
        int p2 = MID + 1;
        int res=0;
        // p1 p2 2个指针都不越界，就继续比较，写入,只有被拷贝进去那一边才进行指针右移
        while (p1 <= MID && p2 <= R) {
            res +=  arr[p1] < arr[p2] ? (R -p2 +1)*arr[p1]:0;     //如果右子树中存在 arr[p2]>arr[p1],那么 arr[p2]右侧的就一定都大于arr[p1],因此就能一次算出arr[p1]对应右子树中小和 = (R -p2 +1)+arr[p1]
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];  // 当左子树值小于右子树当前值时，只拷贝左子树值，否则剩余情况全部拷贝右子树值
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
        return res;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //simple test
//        int[] arr = {5, 3, 6, 8, 2, 12, 87, 81, 33, 22, 9, 7, 48, 1};
        int[] arr = {1,3,4,2,5};
        System.out.println("Before:");
        CommonUtil.printArray(arr);
//        mergeSort1(arr);
        smallSum1(arr);
        System.out.println("After:");
        CommonUtil.printArray(arr);

        // data checker
    }
}
