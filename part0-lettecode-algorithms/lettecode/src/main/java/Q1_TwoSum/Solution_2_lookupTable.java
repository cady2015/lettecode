package Q1_TwoSum;

import java.util.HashMap;

/**
 * 解决方法2：使用查找表--通过空间换时间  --  时间复杂度 O(n)
 *
 * 思路：
 *  1.开启一个循环，从数组头部遍历至尾部
 *  2.通过一张HashMap保存中间结果，只保存“当前数及其下标”
 *  3.判断条件：如果能够从该HashMap中找到 当前值与target的差值==keySet中的任意一个值 时，将其作为结果进行返回
 * Created by llj on 2019/7/5.
 */
public class Solution_2_lookupTable {
    public int[] twoSum(int[] nums, int target) {
        //使用查找表
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //在已经建立的查找表中寻找是否有满足的元素
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            //使用HashMap中的put方法，如果key已经存在newValue则会覆盖原来的oldValue
            map.put(nums[i], i);

        }
        return res;
    }
}
