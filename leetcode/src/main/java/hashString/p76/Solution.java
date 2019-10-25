package hashString.p76;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 76. 最小覆盖子串
 */
public class Solution {

    public String minWindow(String s, String t) {
        int[] mapSs = new int[128];
        int[] mapTt = new int[128];
        String result = "";
        List<Character> tList = new ArrayList<>();

        for (int i=0; i<t.length(); i++) {
            mapTt[t.charAt(i)]++;
            tList.add(t.charAt(i));
        }

        int windowBegin = 0;

        for (int windowEnd=0; windowEnd<s.length(); windowEnd++) {
            mapSs[s.charAt(windowEnd)]++;

            while (windowBegin < windowEnd) {
                char c = s.charAt(windowBegin);
                if (mapTt[c] == 0) {
                    windowBegin++;
                } else if (mapSs[c] > mapTt[c]) {
                    mapSs[c]--;
                    windowBegin++;
                } else {
                    break;
                }
            }

            if (isWindowOk(mapSs, mapTt, tList)) {
                int windowLen = windowEnd - windowBegin + 1;
                if ("".equals(result) || result.length() > windowLen) {
                    result = s.substring(windowBegin, windowEnd+1);
                }
            }
        }
        return result;
    }

    private boolean isWindowOk(int[] mapSs, int[] mapTt, List<Character> t) {
        for (Character c : t) {
            if (mapSs[c] < mapTt[c]) {
                return false;
            }
        }
        return true;
    }
}
