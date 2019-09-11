package greed.p55;

/**
 * LeetCode 55. 跳跃游戏
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int[] index = new int[nums.length];

        int jump = 0;
        int maxIndex = nums[0];

        while (jump < nums.length && jump <= maxIndex) {
            index[jump] = jump + nums[jump];
            if (maxIndex < index[jump]) {
                maxIndex = index[jump];
            }
            jump++;
        }

        return jump == nums.length;
    }
}
