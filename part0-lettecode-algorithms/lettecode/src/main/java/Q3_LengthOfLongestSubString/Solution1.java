package Q3_LengthOfLongestSubString;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中 “不含有重复字符“ 的 最长子串 的长度
 * <p>
 * 解题思路：
 * 1.滑动窗口
 * 从第一个字符开始遍历，直到遇到重复字符，中间变量归位，开始遍历第二个字符
 * <p>
 * 2.如何判断子串重复了？
 * 使用HashSet
 * 什么时候决定向右移动？-- 当当前值不包含在Hashset中
 * 什么时候决定不移动，转向下一个？ -- 当当前值包含在HashSet
 */
public class Solution1 {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<Character>();
        // 1.滑动窗口思想，使用左右指针，来确定滑动窗口
        // 右指针（为什么是1？ 是因为还没指向任何一个字符，当给rp+1时就开始工作）
        int rp = -1;
        // 中间值
        int ans = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                hashSet.remove(s.charAt(i - 1));
            }
            // 当rp指针还没到最尾部，并且rp指针指向字符的下一个字符没有包含在hashset中时，当不满足2者其中任意一个条件时就退出
            while (rp + 1 < s.length() && !hashSet.contains(s.charAt(rp + 1))) {
                // 更新hashset
                hashSet.add(s.charAt(rp + 1));
                // 不断地移动右指针
                ++rp;
            }

            ans  =  Math.max(ans,rp-i+1);
        }


        return ans;
    }


    public static void main(String[] args) {
        String s=  "2335446576789869454545566789999942323"; //86945
//        String s = "abcabcbb";
        System.out.println("Length of max substring: " + lengthOfLongestSubstring(s));
    }
}
