package greed.p376;

/**
 * LeetCode 376. 摆动序列
 */
public class Solution {

    private static final int BEGIN = 0;
    private static final int UP = 1;
    private static final int DOWN = 2;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int state = BEGIN;
        int maxLentgh = 1;

        for (int i=1; i<nums.length; i++) {
            switch (state) {
                case BEGIN:
                    if (nums[i-1] < nums[i]) {
                        state = UP;
                        maxLentgh++;
                    } else if (nums[i-1] > nums[i]) {
                        state = DOWN;
                        maxLentgh++;
                    }
                    break;
                case UP:
                    if (nums[i-1] > nums[i]) {
                        state = DOWN;
                        maxLentgh++;
                    }
                    break;
                case DOWN:
                    if (nums[i-1] < nums[i]) {
                        state = UP;
                        maxLentgh++;
                    }
                    break;
                default:
                    break;
            }
        }
        return maxLentgh;
    }
}
