import java.util.*;

/*
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
You may change 0's to 1's to connect the two islands to form one island.
Return the smallest number of 0's you must flip to connect the two islands.
 */


class Solution {
    
    
    final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int shortestBridge(int[][] grid) {

        //Time Complexity: O(m*n)
        //Space Complexity: O(m*n)

        
        int m = grid.length, n = grid[0].length, marker = -2;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    markIslands(grid, i, j, marker++);
                }
            }
        }
        
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -2) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }        
        
        while (!queue.isEmpty()) {
            int[] corr = queue.poll();
            if (visited[corr[0]][corr[1]]) continue;
            
            visited[corr[0]][corr[1]] = true;
            
            for (int[] dir : DIRECTIONS) {
                int r = corr[0] + dir[0], c = corr[1] + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == -2) continue;
                if (grid[r][c] == -1) return corr[2];
                queue.add(new int[]{r, c, corr[2] + 1});
            }
            
        }
        
        return -1;
        
    }
    
    
    
    private void markIslands(int[][] grid, int i, int j, int marker) {
        int m = grid.length, n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        
        grid[i][j] = marker;
        
        for (int dir[] : DIRECTIONS) {
            markIslands(grid, i + dir[0], j + dir[1], marker);
        }
        
    }
    
}