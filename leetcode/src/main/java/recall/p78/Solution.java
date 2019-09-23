package recall.p78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
public class Solution {

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        bt(nums, 0, item, result);
        return result;
    }

    private void bt(int[] nums, int i, List<Integer> item, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(item);
            return;
        }

        // 注意浅拷贝和深拷贝的问题
        ArrayList<Integer> tmp = new ArrayList<>(item);

        bt(nums, i + 1, tmp, result);
        item.add(nums[i]);
        bt(nums, i + 1, item, result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

        Solution s = new Solution();
        List<List<Integer>> res = s.subsets(nums);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }
}
