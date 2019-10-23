package hashString.p49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode: 49. 字母异位词分组
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (String str : strs) {
            String s = sort(str);

            if (map.containsKey(s)) {
                res.get(map.get(s)).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                res.add(tmp);
                map.put(s, res.size() - 1);
            }
        }
        return res;
    }

    private String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
