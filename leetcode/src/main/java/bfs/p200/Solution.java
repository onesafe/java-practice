package bfs.p200;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeetCode: 200. 岛屿数量
 */
public class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int islandNum = 0;

        if (null == grid || grid.length == 0) {
            return islandNum;
        }

        int row = grid.length;
        int col = grid[0].length;

        char[][] mark = new char[row][col];

        // 将mark数组初始化为0
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                mark[i][j] = 0;
            }
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (mark[i][j]==0 && grid[i][j]=='1') {
                    bfs(mark, grid, i, j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    class Xy {
        int x;
        int y;
        Xy(int x1, int y1) {
            x = x1;
            y = y1;
        }

        private int getX() {
            return this.x;
        }

        private int getY() {
            return this.y;
        }
    }

    private void bfs(char[][] mark, char[][] grid, int x, int y) {
        Queue<Xy> q = new LinkedBlockingQueue<>();
        q.add(new Xy(x, y));
        mark[x][y] = 1;

        while(!q.isEmpty()) {
            Xy tmp = q.poll();
            x = tmp.getX();
            y = tmp.getY();

            for (int i=0; i<4; i++) {
                int newx = dx[i] + x;
                int newy = dy[i] + y;

                if (newx < 0 || newx >= mark.length || newy < 0 || newy >= mark[newx].length) {
                    continue;
                }

                if (mark[newx][newy] == 0 && grid[newx][newy] == '1') {
                    q.add(new Xy(newx, newy));
                    mark[newx][newy] = 1;
                }
            }
        }
    }

    private void dfs(char[][] mark, char[][] grid, int x, int y) {
        mark[x][y] = 1;

        for (int i=0; i<4; i++) {
            int newx = dx[i] + x;
            int newy = dy[i] + y;

            if (newx < 0 || newx >= mark.length || newy < 0 || newy >= mark.length) {
                continue;
            }

            if (mark[newx][newy] == 0 && grid[newx][newy] == '1') {
                dfs(mark, grid, newx, newy);
            }
        }
    }
}
