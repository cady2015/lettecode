package com.llj;

/**
 * Created by llj on 2019/7/6.
 */
public class A2_HannoTower {
    public static void main(String[] args) {
        hanno(4,'A','B','C');
    }

    public static void hanno(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move sheet " + n + " from " + A + " to " + C);
        } else {
            //A->B  A->C  B->C
            hanno(n-1,A,C,B);
            System.out.println("Move sheet " + n + " from " + A + " to " + C);
            hanno(n-1,B,A,C);
        }
    }
}
