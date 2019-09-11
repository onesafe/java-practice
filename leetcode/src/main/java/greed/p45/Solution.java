package greed.p45;

/**
 * LeetCode 45. 跳跃游戏 II
 */
public class Solution {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int currentMaxIndex = nums[0];
        int preMaxIndex = nums[0];
        int jumpMin = 1;

        for (int i=1; i<nums.length; i++) {
            if (i > currentMaxIndex) {
                jumpMin++;
                currentMaxIndex = preMaxIndex;
            }

            if (preMaxIndex < nums[i] + i) {
                preMaxIndex = nums[i] + i;
            }
        }
        return jumpMin;
    }
}
