package com.llj;

/**
 *   快速排序---未完
 * Created by llj on 2019/7/8.
 */
public class A6_QuickSort {

    public static int[] quickSort(int[] a,int left,int right){
        int temp;
        //定义递归的返回条件
        if (left>right){
            return a;
        }
        temp = a[left]; //temp中存的就是基准数
        int i= left;
        int j = right;
        while (i!=j){ //顺序很重要，要先从右边开始找
            while (a[j]>=temp && i<=j){
                j--;
            }
            while (a[i]<=temp && i<=j){
                i++;
            }
            if (i<j){
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //将基准数归位
        a[left] = a[i];
        a[i] = temp;
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);

        return null;
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,2,5,7,4,1,6,9,8};

        System.out.println("Before sort:");
        for (int i:arr){
            System.out.print(i);
        }
        System.out.println("\r\nAfter sort:");

        int[] ints = quickSort(arr,1, args.length-1);

        for (int i:ints){
            System.out.print(i);
        }
    }
}
