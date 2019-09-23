package greed.p452;

import java.util.Arrays;

/**
 * LeetCode 452. 用最少数量的箭引爆气球
 */
public class Solution {

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }

        // 按照右端点排序
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int shootNum = 1;
        int axis = points[0][1];

        for (int i=1; i<points.length; i++) {
            if (axis < points[i][0]) {
                shootNum++;
                axis = points[i][1];
            }
        }

        return shootNum;
    }
}
