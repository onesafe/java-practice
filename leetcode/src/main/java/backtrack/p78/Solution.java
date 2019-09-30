package backtrack.p78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getAns(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
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
