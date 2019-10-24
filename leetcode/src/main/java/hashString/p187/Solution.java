package hashString.p187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode: 187. 重复的DNA序列
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }

        HashMap<String, Integer> mMap = new HashMap<>();

        int i=0;
        int j=10;
        while (j<=s.length()) {
            String tmp = s.substring(i, j);
            int count = mMap.getOrDefault(tmp, 0);
            mMap.put(tmp, count+1);

            if (count == 1) {
                res.add(tmp);
            }

            i++;
            j++;
        }
        return res;
    }
}
