import java.util.*;

class Solution {
    
    
    private class Pair {
        int val, groupColor;
        Pair(int val, int groupColor) {
            this.val = val;
            this.groupColor = groupColor;
        }
    }
    
    List<List<Integer>> adjList = new ArrayList<>();
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        //Time Complexity: O(|E| + |V|)
        //Space Complexity: O(|E| + |V|);
        
        if (n == 1) return true;
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] dislike : dislikes) {
            adjList.get(dislike[0] - 1).add(dislike[1] - 1);
            adjList.get(dislike[1] - 1).add(dislike[0] - 1); 
        }
        
        int[] group = new int[n];
        // Queue<Pair> queue = new ArrayDeque<>();
        
//         for (int i = 0; i < n; i++) {
//             if (group[i] != 0) continue;
//             queue.add(new Pair(i, 1));
//             while (!queue.isEmpty()) {
//                 Pair p = queue.poll();
//                 if (group[p.val] != 0 && group[p.val] != p.groupColor) return false;
//                 group[p.val] = p.groupColor;
                
                
//             }
//         }
        
        for (int i = 0; i < n; i++) {
            if (group[i] == 0 && !dfs(group, i, 1)) return false;
        }
        
        return true;
        
    }
    
    private boolean dfs(int[] group, int i, int color) {
                
        if (group[i] != 0 && group[i] != color) return false;
        if (group[i] != 0) return true;
        group[i] = color;
        
        boolean res = true;
        for (int dislike : adjList.get(i)) {
            res &= dfs(group, dislike, -color);
        }
        
        return res;
        
    }
    

}