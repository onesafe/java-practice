package binarysearch.p315;


import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 */
public class Solution {

    private int[] counter;

    // 下标数组
    private int[] indexes;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;

        if (len == 0) {
            return res;
        }

        counter = new int[len];
        indexes = new int[len];

        for (int i=0; i<len; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, len-1);

        for (int i=0; i<len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        //辅助数组
        int []tmp = new int[nums.length];

        int p1 = left;
        int p2 = mid + 1;
        int k = left;

        int []tmpIndex = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            tmpIndex[i] = indexes[i];
        }

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                indexes[k] = tmpIndex[p1];
                counter[indexes[k]] += p2 - mid - 1;
                tmp[k++] = nums[p1++];
            } else {
                indexes[k] = tmpIndex[p2];
                tmp[k++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            indexes[k] = tmpIndex[p1];
            counter[indexes[k]] += p2 - mid - 1;
            tmp[k++] = nums[p1++];
        }

        while (p2 <= right) {
            indexes[k] = tmpIndex[p2];
            tmp[k++] = nums[p2++];
        }

        for (int i=left; i<=right; i++) {
            nums[i] = tmp[i];
        }
    }

    private void mergeSort(int[] nums, int start, int end) {

        //当子序列中只有一个元素时结束递归
        if (start < end) {
            int mid = (start + end) / 2;
            //对左侧子序列进行递归排序
            mergeSort(nums, start, mid);

            //对右侧子序列进行递归排序
            mergeSort(nums, mid+1, end);

            // 合并
            // 如果索引数组有序，就没有必要再继续计算了
            if (nums[mid] > nums[mid+1]) {
                merge(nums, start, mid, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        Solution solution = new Solution();
        List<Integer> countSmaller = solution.countSmaller(nums);
        System.out.println(countSmaller);
    }
}
