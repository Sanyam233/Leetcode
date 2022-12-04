class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        //Where |E| is no. of edges and |V| is no. of vertices
        //Time Complexity: O(|E| + |V|^2)
        //Space Complexity: O(|E| + |V|^2)
        
        
        int[] count = new int[n];
        int[][] isConnected = new int[n][n];
        
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            isConnected[road[0]][road[1]] = 1;
            isConnected[road[1]][road[0]] = 1;
        }
        
        int rank = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int currRank = count[i] + count[j] - isConnected[i][j];
                rank = Math.max(currRank, rank);
            }
        }
        
        
        return rank;
        
    }
}