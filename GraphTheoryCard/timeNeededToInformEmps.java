import java.util.*;

class Solution {
    
    class Pair {
        int id, time;
        Pair(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        //Time Complexity: O(n) where n is no. of employees
        //Space Complexity: O(n)
        
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Pair> queue = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            List<Integer> employees = adjList.get(manager[i]);
            employees.add(i);
        }
        
        
        int maxTime = 0;
        queue.add(new Pair(headID, informTime[headID]));
        
        while (!queue.isEmpty()) {
            Pair emp = queue.poll();
            
            maxTime = Math.max(maxTime, emp.time);
            
            for (int subordinate : adjList.get(emp.id)) {
                queue.add(new Pair(subordinate, emp.time + informTime[subordinate]));
            }
        }
        
        
        return maxTime;
        
        
        
        
        
    }
}