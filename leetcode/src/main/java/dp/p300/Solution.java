package dp.p300;

/**
 * LeetCode: 300. 最长上升子序列
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = 1;

        // 最小是1
        int res = 1;

        for (int i=1; i<len; i++) {

            // 最小是1
            dp[i] = 1;
            for (int j=0; j<=i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            if (res < dp[i]) {
                res = dp[i];
            }
        }

        return res;
    }
}
