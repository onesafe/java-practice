package dp.p322;

/**
 * LeetCode: 322. 零钱兑换
 */
public class Solution {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for (int i=0; i<=amount; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if (i-coin >= 0 && dp[i-coin] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i-coin] + 1) {
                        dp[i] = dp[i-coin] + 1;
                    }
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 4, 7, 9};
        coinChange(coins, 19);
    }
}
