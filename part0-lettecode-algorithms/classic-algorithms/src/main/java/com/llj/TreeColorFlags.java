package com.llj;

/**
 * 三色旗问题：
 * 三色旗的问题最早由E.W.Dijkstra提出的，他所使用的用语为Dutch Nation Flag（Dijkstra为荷兰人），而多数的作者则使用Three-Color Flag来称之。
 * <p>
 * 假设有一条绳子，上面有红、白、蓝三种颜色的旗子，起初绳子上的旗子的颜色并没有顺序，你希望将之分类并排列为蓝、白、红的顺序，要如何移动次数最少，注意你只能在绳子上进行这个动作，并且一次只能调换两个旗子。
 * <p>
 * 白话文：
 * <p>
 * 有1、2、3三个数，每个数字的个数不定，数字间顺序不定，要求用最少的步数将他改成111222333这种情况，即相同数字挨着，不同数字按顺序排列。
 * <p>
 * <p>
 * 解题思路：
 * 参考快速排序的算法思想，使用3个指针，保证一次遍历就能完成整个数列的排序
 * b
 * \
 * r   w   b   w   w   b   r   b   w   r
 * \                                   \
 * w                                    r
 * <p>
 * 如果排列顺序是b，w，r。我们如下定义这三个指针的意义：
 * b - 永远指向第一个不是b的元素（即从开始位置起，第一个不是b的元素），
 * w - 作为遍历的游标，往下运行，并判断该元素是不是w，如果是不做处理，继续往下运行，如果是b则与b指向的元素交换，
 * 如果是r则与r指向的元素交换。
 * r - 永远指向第一个不是r的元素，不同的是，r是从这个数列的最后开始的，因为我们最终要将r放到后面。
 * 如此一次遍历该数列时，遇到第一个元素如果是b，则w和b继续往下走，如果是w，则b指向该元素，w往下走，如果是r，
 * 则在r的地方找到第一个不是r的元素并交换，以此类推，遇到w继续走，遇到b往前移，遇到r往后移。用图做一个详细说明：
 * Created by Administrator on 2019/7/8.
 */
public class TreeColorFlags {

    public static void main(String[] args) {
        char[] colorFlags = {'r', 'w', 'b', 'w', 'w', 'b', 'r', 'b', 'w', 'r'};
        int wFlag = 0;
        int bFlag = 0;
        int rFlag = colorFlags.length - 1;
        System.out.println("原始排序数列：");
        for (int i = 0; i < colorFlags.length; i++) {
            System.out.print(colorFlags[i]);
        }
        // 定义允许查找的条件：w指针在r指针左边或者重叠
        while (wFlag <= rFlag) {
            //从前向后遍历，wFlag指向白色旗子，则表示当前不需要调换，跳过比较下一个旗子
            if (colorFlags[wFlag] == 'w') {
                wFlag++;
            } else if (colorFlags[wFlag] == 'b') {//如果wFlag指向蓝色旗子，则需要将白色和蓝色调换
                char temp;
                temp = colorFlags[wFlag];
                colorFlags[wFlag] = colorFlags[bFlag];
                colorFlags[bFlag] = temp;
                //调换完成之后，bFlag当前指向蓝色旗子,wFlag指向白色旗子，当前bFlag、wFlag指针需要同时向后移动，进入下一次比较
                bFlag++; 
                wFlag++;
            } else {
                //当rFlag指向的是红色旗子并且rFlag在wFlag后面，则rFlag需要向前移动
                while (wFlag < rFlag && colorFlags[rFlag] == 'r') {
                    rFlag--;
                }
                //当rFlag指向非红色旗子时，将wFlag指向的旗子（红色r）和rFlag指向的旗子（蓝色b或者白色w）进行交换
                char temp;
                temp = colorFlags[wFlag];
                colorFlags[wFlag] = colorFlags[rFlag];
                colorFlags[rFlag] = temp;
                rFlag--;
            }
        }
        System.out.println("\r\n排序后序列：");
        for (int i = 0; i < colorFlags.length; i++) {
            System.out.print(colorFlags[i]);
        }
        System.out.println();
    }

}
