package com.llj;

import java.util.Scanner;

/**
 * 老鼠走迷宫问题
 * <p>
 * 1.如何表示方向探索：
 * 2.如何记录路径：使用链表或者数组，这里可以使用数组，然后定义一个bean，每个元素指向自己的前驱，这样从最后一个节点遍历就能获得路径
 * Created by llj on 2019/7/10.
 */
public class A7_Mazing1 {
    static int[][] map = new int[][]{
                    {0, 0, 1, 0, 1},
                    {0, 1, 0, 0, 0},
                    {1, 0, 1, 0, 1},
                    {0, 1, 1, 0, 1},
                    {0, 0, 1, 0, 0}
            };
    static int[][] vis = new int[5][5];
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Node[] q = new Node[20];

    static void bfs() {
        int head = 0;
        int tail = 0;
        q[tail] = new Node(0, 0, -1);//从起始点（0,0）开始搜索
        vis[0][0] = 1;//标记（0,0）已经被访问过
        tail++;
        while (head < tail) {
            boolean flag = false;//标识有没有找到终点
            for (int i = 0; i < 4; i++) {
                int nx = q[head].x + move[i][0];
                int ny = q[head].y + move[i][1];
                if (check(nx, ny)) {
                    vis[nx][ny] = 1;
                    q[tail] = new Node(nx, ny, head);
                    tail++;
                }
                if (nx == 4 && ny == 4) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                print(q[tail - 1]);
                break;
            }
            head++;
        }
    }

    static void print(Node node) {
        if (node.pre == -1) {
            System.out.println("(" + node.x + ", " + node.y + ")");
            return;
        } else {
            print(q[node.pre]);
            System.out.println("(" + node.x + ", " + node.y + ")");
        }
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && vis[x][y] != 1 && map[x][y] != 1;
    }

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        for (int i = 0; i < 5; i++)
//            for (int j = 0; j < 5; j++)
//                map[i][j] = cin.nextInt();
//        for (int i = 0; i < 20; i++)
//            q[i] = new Node();
        bfs();
    }
}

class Node {
    int x, y, pre;//来到此点的出发点

    Node() {
    }

    Node(int x, int y, int pre) {
        this.x = x;
        this.y = y;
        this.pre = pre;
    }
}