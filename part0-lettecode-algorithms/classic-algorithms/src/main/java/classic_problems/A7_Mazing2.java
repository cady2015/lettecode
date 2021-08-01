package classic_problems;

import java.util.Stack;

/**
 * 老鼠走迷宫问题
 * <p>
 * bfs问题： 宽度优先搜索算法（又称广度优先搜索）
 * 1.如何表示方向探索：
 * 2.如何记录路径：使用链表或者数组，这里可以使用数组，然后定义一个bean，每个元素指向自己的前驱，这样从最后一个节点遍历就能获得路径
 * Created by llj on 2019/7/10.
 */
public class A7_Mazing2 {
    static final int ROW_LEN = 5;
    static final int COL_LEN = 5;
    static int[][] map = null;
    static int[][] vis = new int[5][5];
    static Stack<Point> stack = new Stack();
    private static Point MazeEntry;

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Point(Point entry) {
            this.row = entry.row;
            this.col = entry.col;
        }
    }

    /**
     * 初始化迷宫
     */
    private static void init_mazing() {
        map = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 0}
        };
        printMap(map);
    }

    /**
     * 打印迷宫
     */
    private static void printMap(int[][] map) {
        System.out.println("初始化迷宫：");
        for (int i = 0; i < ROW_LEN; i++) {
            for (int j = 0; j < COL_LEN; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 从迷宫的入口开始查找
     */
    private static void path(int[][] map, Point entry) {
        if (null == map) {
            System.out.println("迷宫未初始化。。");
            return;
        }
        //从入口处开始探索，判断当前点是否满足继续走下去的要求
        //需要一个递归辅助函数判断到当前点是否满足要求
        Search(entry);//其中第一个entry表示当前点的位置信息，第二个entry表示入口点的位置信息
        return;
    }

    private static void Search(Point entry) {
        System.out.println("row:" + entry.row + ",col:" + entry.col);

        //1. 首先判断当前点能否落脚，如果当前点不能落脚，直接回溯出函数的调用栈
        if (!canStay(entry)) {
            return;
        }
        //2. 如果能落脚，表示该位置可以走，就对其进行标记表示已经走过
        mark(entry);
        stack.push(entry);
        //3. 判断入口点是否为出口点，如果满足出口点的条件，就说明找到了一条出口，直接退出即可
        if (isExit(entry)) {
            System.out.println("找到一条出路\n");
            return;
        }

        //6. 如果当前点不能落脚，就探测下一个四周点
        Point right = new Point(entry);
        right.col += 1;
        if (canStay(right)) {
            Search(right);
        }

        Point down = new Point(entry);
        down.row += 1;
        if (canStay(down)) {
            Search(down);
        }
        Point left = new Point(entry);
        left.col -= 1;
        if (canStay(left)) {
            Search(left);
        }

        //6. 如果当前点能落脚，就将当前点入栈，并标记，然后判断当前点是否为出口
        //7. 如果四周点都已经探索完，就将当前点出栈，探索其他路径
        if (stack.size() > 0) {
            stack.pop();
        } else {
            System.out.println("弹栈失败！");
        }

    }

    /**
     * 判断是否为出口点
     */
    private static boolean isExit(Point current) {
        //入口不能为出口
        if (current.row == MazeEntry.row && current.col == MazeEntry.col) {
            return false;
        }
        //出口点在边界上，代表找到了出口
        if (current.row == 0 || current.row == ROW_LEN - 1 || current.col == 0 || current.col == COL_LEN - 1) {
            //当前点在边界上,说明是出口点
            return true;
        } else {
            return false;
        }
    }

    /**
     * 标记当前点为已经走过的点
     */
    private static void mark(Point current) {
        vis[current.row][current.col] = 1;
        return;
    }

    /**
     * 判断当前点能否落脚
     */
    private static boolean canStay(Point current) {
        if (current.row < 0 || current.row >= ROW_LEN || current.col < 0 || current.col >= COL_LEN) {
            //当前点的位置在地图之外，所以不能落脚
            return false;
        }

        if (map[current.row][current.col] == 1 && vis[current.row][current.col] != 1) {
            //说明是路，且是未走过的路，说明可以落脚
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        //初始化迷宫
        init_mazing();
        MazeEntry = new Point(0, 1);
        path(map, MazeEntry);

    }


}

