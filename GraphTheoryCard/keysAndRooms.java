import java.util.List;


class Solution {
    
    List<List<Integer>> rooms;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        //Time Complexity: O(N + E) Where N is no of rooms and E is no of keys
        //Space Complexity: O(N) 
        
        this.rooms = rooms;
        boolean[] visited = new boolean[rooms.size()];
        dfs(visited, 0);
        
        boolean canVisit = true;
        
        for (boolean val : visited) canVisit = canVisit & val;
        
        return canVisit;
        
    }
    
    
    private void dfs(boolean[] visited, int room) {
        
        if (visited[room]) return;
        
        visited[room] = true;
        
        for (int r : rooms.get(room)) {
            dfs(visited, r);
        }
        
    }
    
}