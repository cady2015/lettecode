import java.util.HashMap;

class Solution {
    // --  解法1：暴力破解法
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                } else {
                    continue;
                }

            }
        }
        return null;
    }
}


// -- 小结：容易出错的地方：
// 1.数组使用length直接获取长度
// 2.最终外层需要有返回值

class Solution2 {
    // --  解法2：使用空间换时间，将数组转换为HashMap
    //  -- 遍历HashMap，判断是否 keyset.contains(anyvalue)= target - nums[i]的value , 则返回 该值对应的下表，以及当前i值
    //  -- 当未找到之前，先将其保存至Map中，key=nums[i],value=i
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.keySet().contains(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] sums={1,2,45,67,3,9};
        int target=10;
        int[] ints = solution2.twoSum(sums, target);
        for ( int i : ints) {
            System.out.println(i);
        }
    }
}
