package hashString.p409;

/**
 * LeetCode: 409. 最长回文串
 */
public class Solution {

    public int longestPalindrome(String s) {

        int charMap[] = new int[128];
        int maxLen = 0;
        int flag = 0;

        for (int i=0; i<s.length(); i++) {
            charMap[s.charAt(i)]++;
        }

        for (int c : charMap) {
            if (c % 2 == 0) {
                maxLen += c;
            } else {
                maxLen += c - 1;
                flag = 1;
            }
        }

        return maxLen + flag;
    }
}
