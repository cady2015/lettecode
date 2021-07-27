package Q3_1_NumOfStringTypeGroups;


import java.util.HashSet;

/**
 * 题目：如果2个字符串，所含字符种类完全一样，就算做一类
 * 只由小写字母（a~z）组成的一批字符串
 * 都放在字符类型的数组String[] arr中，返回arr中一共有多少类？
 * <p>
 * 解法2：
 * 使用整数类型的位信息标识字符出现的位置，使用位运算对其进行标记
 * 最终求int不重复的个数
 * 使用Hashset输出
 */
public class Solution2 {
    public int numOfStringTypeGroups(String[] arr) {
        //1.使用Hashset保存模板类
        HashSet<Integer> set = new HashSet<>();

        for (String str : arr) {
            // 用来标识出现字符的情况
            int mark = 0;
            char[] chars = str.toCharArray();
            // 对字符出现位置进行标识
            for (int i = 0; i < str.length(); i++) {
                mark |= 1 << (chars[i] - 'a');
            }
            // 标识完成之后，对其put到Set中进行记录
            set.add(mark);
        }
        // set中包含元素的大小就是要返回的模板数量
        return set.size();
    }

    public static void main(String[] args) {

        Solution2 solution = new Solution2();

        String[] arr = new String[]{"adgbc", "dfyyr", "adb", "adbb", "dbc", "dbbc"};

        int i = solution.numOfStringTypeGroups(arr);

        System.out.println("num of non duplicate template is:" + i);
    }
}
