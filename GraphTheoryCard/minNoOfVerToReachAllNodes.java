import java.util.*;

public class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        //Time Complexity: O(E + V) Where E is no. of edges
        //Space Complexity: O(V) Where V is no. of vertices
   
        boolean[] canBeVisited = new boolean[n];
        
        for (List<Integer> edge : edges) {
            canBeVisited[edge.get(1)] = true;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!canBeVisited[i]) res.add(i);
        }
        
        return res;
    }

}
