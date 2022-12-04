class Solution {
    public int maxDistance(int[][] grid) {
        
        //Time Complexity: O(n^2)
        //Space Complexity: O(n^2)
        
        
        int n = grid.length, res = 0;
        boolean hasWater = false, hasLand = false;
        
        int[][] distance = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hasLand = true;
                    continue;
                }
                hasWater = true;
                int d1 = Integer.MAX_VALUE - 1000, d2 = Integer.MAX_VALUE - 1000;
                if (i > 0) d1 = distance[i - 1][j] + 1;
                if (j > 0) d2 = distance[i][j - 1] + 1;
                distance[i][j] = Math.min(d1, d2);
            }
        }
        
        if (!hasWater || !hasLand) return -1;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) continue;
                int d1 = Integer.MAX_VALUE - 1000, d2 = Integer.MAX_VALUE - 1000;
                if (i < n - 1) d1 = distance[i + 1][j] + 1;
                if (j < n - 1) d2 = distance[i][j + 1] + 1;
                distance[i][j] = Math.min(d1, Math.min(d2, distance[i][j]));
                res = Math.max(res, distance[i][j]);
            }
        }        
        
        return res;
        
    }
}