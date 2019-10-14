package binarysearch;

/**
 * 归并排序
 */
public class MergeSort {

    private static void merge(int[] nums, int left, int mid, int right) {
        //辅助数组
        int []tmp = new int[nums.length];

        int p1 = left;
        int p2 = mid + 1;
        int k = left;

        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                tmp[k++] = nums[p1++];
            } else {
                tmp[k++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            tmp[k++] = nums[p1++];
        }

        while (p2 <= right) {
            tmp[k++] = nums[p2++];
        }

        for (int i=left; i<=right; i++) {
            nums[i] = tmp[i];
        }
    }

    private static void mergeSort(int[] nums, int start, int end) {

        //当子序列中只有一个元素时结束递归
        if (start < end) {
            int mid = (start + end) / 2;
            //对左侧子序列进行递归排序
            mergeSort(nums, start, mid);

            //对右侧子序列进行递归排序
            mergeSort(nums, mid+1, end);

            // 合并
            if (nums[mid] > nums[mid+1]) {
                merge(nums, start, mid, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int n : a) {
            System.out.print(n + " ");
        }
    }
}
