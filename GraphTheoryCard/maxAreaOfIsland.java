/*
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.
 */

class Solution {
    
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        
        //Time Complexity: O(m*n)
        //Space Complexity: O(1)
        
        int m = grid.length, n = grid[0].length, res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, explore(grid, i, j));
                }
            }
        }
        
        return res;
    }
    
    private int explore(int[][] grid, int i, int j) {
        
        int m = grid.length, n = grid[0].length;
        grid[i][j] = 0;
        
        int count = 1;
        for (int[] dir : directions) {
            int r = i + dir[0], c = j + dir[1];
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1) continue;
            count += explore(grid, r, c);
        }
        

        return count;
        
    }
}