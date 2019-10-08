package backtrack.p473;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 */
public class Solution {

    public boolean makesquare(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum == 0 || sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        for (int num : nums) {
            if (num > target) {
                return false;
            }
        }


        // 从大到小的回溯，效率更高
        Arrays.sort(nums);
        return backtrack(nums.length-1, nums, target, new int[4]);
    }

    private boolean backtrack(int cur, int[] nums, int target, int[] temp) {
        if (cur == -1) {
            return temp[0] == target && temp[1] == target
                    && temp[2] == target && temp[3] == target;
        }

        for (int i=0; i<temp.length; i++) {
            // 4个桶中分别尝试
            if (temp[i] + nums[cur] > target) {
                continue;
            }

            temp[i] += nums[cur];
            if (backtrack(cur-1, nums, target, temp)) {
                return true;
            }
            temp[i] -= nums[cur];
        }

        return false;
    }
}
