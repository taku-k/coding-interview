package leetcode;

public class NumberIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int y = 0; y < grid.length; ++y) {
            for (int x = 0; x < grid[0].length; ++x) {
                if (grid[y][x] == '1') {
                    ans++;
                    helper(grid, x, y);
                }
            }
        }
        return ans;
    }

    private void helper(char[][] grid, int x, int y) {
        if (grid[y][x] != '1') return;
        grid[y][x] = '2';
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < grid[0].length && ny >= 0 && ny < grid.length) {
                helper(grid, nx, ny);
            }
        }
    }
}
