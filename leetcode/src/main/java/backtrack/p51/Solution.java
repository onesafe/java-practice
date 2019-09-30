package backtrack.p51;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[][] mark = new int[n][n];
        char[][] location = new char[n][n];

        // 初始化mark数组和location数组
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                mark[i][j] = 0;
                location[i][j] = '.';
            }
        }

        backtrack(0, n, location, res, mark);
        return res;
    }


    private void backtrack(int k, int n, char[][] location, List<List<String>> res, int[][] mark) {
        if (k == n) {
            res.add(construct(location));
            return;
        }

        for (int i=0; i<n; i++) {
            if (mark[k][i] == 0) {
                int[][] tmpMark = new int[n][n];
                arrayCopy(mark, tmpMark);

                location[k][i] = 'Q';
                putDownTheQueue(k, i, mark);
                backtrack(k+1, n, location, res, mark);
                arrayCopy(tmpMark, mark);
                location[k][i] = '.';
            }
        }
    }

    private void putDownTheQueue(int x, int y, int[][] mark) {
        // 方向数组
        final int dx[] = {-1, 1, 0, 0, -1, -1, 1, 1};
        final int dy[] = {0, 0, -1, 1, -1, 1, -1, 1};

        mark[x][y] = 1;

        // 8个方向，每个方向向外延伸
        for (int i=1; i<mark.length; i++) {
            for (int j=0; j<8; j++) {
                int new_x = i*dx[j] + x;
                int new_y = i*dy[j] + y;
                if (new_x >= 0 && new_x < mark.length && new_y >= 0 && new_y < mark.length) {
                    mark[new_x][new_y] = 1;
                }
            }
        }
    }

    private void arrayCopy(int[][] mark, int[][] tmp) {
        for (int i=0; i<mark.length; i++) {
            for (int j=0; j<mark[i].length; j++) {
                tmp[i][j] = mark[i][j];
            }
        }
    }

    private List<String> construct(char[][] location) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < location.length; i++) {
            String s = new String(location[i]);
            temp.add(s);
        }
        return temp;
    }
}
