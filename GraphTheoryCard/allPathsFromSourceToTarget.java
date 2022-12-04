import java.util.*;

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    int[][] graph;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        //Time Complexity: O(2^N * N)
        //Space Complexity: O(N)
        
        
        this.graph = graph;
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, path, visited);
        
        return result;
    }
    
    
    private void dfs(int node, List<Integer> path, boolean[] visited) {
          
        
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if (visited[node]) return;
        visited[node] = true;           
        
        for (int neighbor : graph[node]) {
            path.add(neighbor);   
            dfs(neighbor, path, visited);
            path.remove(path.size() - 1);  
            
        }

        visited[node] = false;
        
    }
}