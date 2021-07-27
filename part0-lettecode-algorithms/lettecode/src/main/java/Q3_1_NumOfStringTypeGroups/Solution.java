package Q3_1_NumOfStringTypeGroups;


import java.util.HashSet;

/**
 * 题目：如果2个字符串，所含字符种类完全一样，就算做一类
 * 只由小写字母（a~z）组成的一批字符串
 * 都放在字符类型的数组String[] arr中，返回arr中一共有多少类？
 * <p>
 * 解法1：
 * 使用HashSet存储不重复的字符串
 * 1.使用 boolean[26] 存储是否存在该字符，遍历该字符串，对其数组进行标注
 * 2.从0到26遍历，当该位上的字符出现，则将其转移到Set中
 * 3.输出set的大小
 */
public class Solution {
    public int numOfStringTypeGroups(String[] arr) {
        //1.使用Hashset保存模板类
        HashSet<String> set = new HashSet<>();

        for (String str : arr) {
            // 用来标识出现字符的情况
            boolean[] mark = new boolean[26];
            char[] chars = str.toCharArray();
            // 对字符出现位置进行标识
            for (int i = 0; i < str.length(); i++) {
                mark[chars[i] - 'a'] = true;
            }
            //对字符为True情况进行汇总
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (mark[j]) {
                    sb.append((char) j + 'a');
                }
            }
            set.add(sb.toString());
        }
        // set中包含元素的大小就是
        return set.size();
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] arr = new String[]{"adgbc","dfyyr","adb","adbb","dbc","dbbc"};

        int i = solution.numOfStringTypeGroups(arr);

        System.out.println("num of non duplicate template is:"+i);
    }
}
