/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 */

class Solution {
    
    final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] seen;
    boolean atBoundary = false;
    
    public int numEnclaves(int[][] grid) {
        
        //Time Complexity: O(m*n)
        //Space Complexity: O(m*n)
        
        
        int enclaves = 0, m = grid.length, n = grid[0].length;
        this.seen = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    atBoundary = false;
                    int ret = dfs(grid, i, j);
                    if (!atBoundary) enclaves += ret;
                }
            }
        }
         
        
        return enclaves;
         
    }
    
    
    private int dfs(int[][] grid, int i, int j) {
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            atBoundary = true;
            return 0;
        }
        
        if (grid[i][j] == 0 || seen[i][j]) return 0;
        
        seen[i][j] = true;
        
        int enclaves = 1;
        for (int[] dir : DIRECTIONS) {
            enclaves += dfs(grid, i + dir[0], j + dir[1]);
        }
        
        return enclaves;
        
    }
    
}