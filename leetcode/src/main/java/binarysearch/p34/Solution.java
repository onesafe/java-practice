package binarysearch.p34;

/**
 * LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = leftBound(nums, target);
        res[1] = rightBound(nums, target);
        return res;
    }

    private int leftBound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || target > nums[mid-1]) {
                    return mid;
                }
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            }
        }
        return -1;
    }

    private int rightBound(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                if (mid == end || target < nums[mid+1]) {
                    return mid;
                }
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
