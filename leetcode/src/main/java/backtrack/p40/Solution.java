package backtrack.p40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getRes(candidates, 0, new ArrayList<>(), target, res);
        return res;
    }

    private void getRes(int[] candidates, int start, ArrayList<Integer> temp, int target, List<List<Integer>> res) {
        if (getSum(temp) == target) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            if (getSum(temp) + candidates[i] > target) {
                continue;
            }

            temp.add(candidates[i]);
            getRes(candidates, i + 1, temp, target, res);
            temp.remove(temp.size() - 1);
        }
    }

    private int getSum(ArrayList<Integer> temp) {
        int sum = 0;
        for (Integer t : temp) {
            sum += t;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum2(candidates, 8);

        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }
}
