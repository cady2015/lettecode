package Q3_LengthOfLongestSubString;

import java.util.HashMap;

/**
 * 解法2：使用HashMap，更少内存占用
 */
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 1;
        for (int right = 0; right < s.length(); right++) {
            // 当前right指向的字符包含在map中，并且该字符所在位置在left右侧，则说明出现重复字符，需要将left移动到right的下一个位置
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
                left = map.get(s.charAt(right)) + 1;
            }
            res = Math.max(res, right - left + 1);
            // map中保存的是当前right指向的字符，以及字符在字符串s中对应的位置
            // s.charAt(right) 的理解 ： 当前right指向的字符
            map.put(s.charAt(right), right);
        }
        return res;
    }
}