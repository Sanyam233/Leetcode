import java.util.*;
class Solution {
    
    HashMap<Integer, List<Integer>> prereqs;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //Time Complexity: O(V + E)
        //Space Complexity: O(V + E)
        
        this.prereqs = new HashMap<>();
        
        for (int[] prereq : prerequisites) {
            List<Integer> reqs = prereqs.getOrDefault(prereq[1], new ArrayList<>());
            reqs.add(prereq[0]);
            prereqs.put(prereq[1], reqs);
        }
        
        //0: Not visited    1:Is pre-req    2: Seen
        int[] state = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, state)) return false;
        }
        
        return true;
        
        
    }
    
    
    private boolean dfs(int course, int[] state) {
        
        if (state[course] > 0) return state[course] == 2;
        
        state[course] = 1;
        
        for (int prereq : this.prereqs.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(prereq, state)) return false;
        }
        
        state[course] = 2;
        return true;
    }
    
}