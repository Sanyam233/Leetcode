import java.util.*;

class Solution {
    
    List<Integer> result = new ArrayList<>();
    int[] color; //WHITE: 0, GREY: 1, BLACK: 2
    int[][] graph;
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        this.color = new int[n];
        this.graph = graph;
        
        for (int i = 0; i < n; i++) {
            if (dfs(i)) result.add(i);;
        }
       
        return result; 
        
    }
    
    
    private boolean dfs(int node) {
        
        if (color[node] > 0) return color[node] == 2;
        
        color[node] = 1; //mark the node as visited
        
        boolean isSafeNode = true;
        for (int neighbor : graph[node]) {
            isSafeNode &= dfs(neighbor);
        }
        
        if (isSafeNode) color[node] = 2;
        return isSafeNode;
        
    }
    
}