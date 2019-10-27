package dp.p120;

import java.util.List;

/**
 * LeetCode: 120. 三角形最小路径和
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[][] dp = new int[len][len];

        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);


        for (int i=1; i<len; i++) {
            for (int j=0; j<=i; j++) {
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else {
                    if (dp[i-1][j-1] > dp[i-1][j]) {
                        dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                    } else {
                        dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                    }
                }
            }
        }

        int minRes = Integer.MAX_VALUE;
        for (int i=0; i<len; i++) {
            if (minRes > dp[len-1][i]) {
                minRes = dp[len-1][i];
            }
        }
        return minRes;
    }
}
