package backtrack.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    private void generate(String item, int left, int right, ArrayList<String> res) {
        if (left == 0 && right == 0) {
            res.add(item);
            return;
        }

        if (left > 0) {
            generate(item + "(", left-1, right, res);
        }

        // 先放左括号
        if (right > left) {
            generate(item + ")", left, right-1, res);
        }
    }

    private void generate0(String item, int n, ArrayList<String> res) {
        if (item.length() == n) {
            res.add(item);
            return;
        }

        generate0(item + "(", n, res);
        generate0(item + ")", n, res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> res = new ArrayList<>();
        s.generate("", 1,1, res);

        for (String i : res) {
            System.out.println(i);
        }
    }
}
