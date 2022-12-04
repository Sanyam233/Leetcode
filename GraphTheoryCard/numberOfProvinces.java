class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        //Time Complexity: O(N + E)
        //Space Complexity: O(N)
        
        int provinces = 0, n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        
        return provinces;
        
    }
    
    
    private void dfs(int[][] isConnected, boolean[] visited, int idx) {
        
        if (visited[idx]) return;
        
        visited[idx] = true;
        
        for (int i = 0; i < isConnected[idx].length; i++) {
            if (isConnected[idx][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }
}