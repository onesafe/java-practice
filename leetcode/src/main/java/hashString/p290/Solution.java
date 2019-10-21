package hashString.p290;

import java.util.HashMap;

/**
 * LeetCode: 290. 单词规律
 */
public class Solution {

    public static boolean wordPattern(String pattern, String str) {

        if (pattern == null || str == null) {
            return false;
        }

        int pSize = pattern.length();
        String [] strList = str.split(" ");
        int sSize = strList.length;
        if (pSize != sSize) {
            return false;
        }

        HashMap<Character,String> map = new HashMap<>();

        for (int i=0; i<pSize; i++) {
            char tmp = pattern.charAt(i);

            // key 存在
            if (map.containsKey(tmp)) {
                if (!map.get(tmp).equals(strList[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strList[i])) {
                    return false;
                } else {
                    map.put(tmp, strList[i]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = wordPattern("abba", "dog cat cat dog");
        System.out.println(res);
    }
}
