class Solution {
    
    final int[] DIRECTIONS = new int[]{1, -1};
    
    public boolean canReach(int[] arr, int start) {
        //Time Complexity: O(N)
        //Space Complexiyt: O(N)
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if (arr[idx] == 0) return true;
            visited[idx] = true;
            
            for (int dir : DIRECTIONS) {
                int newIdx = idx + (dir*arr[idx]);
                if (newIdx < 0 || newIdx >= n || visited[newIdx]) continue;
                queue.add(newIdx);
            }
            
        }
        
        return false;
        
        
    }
    
    //DFS
    private boolean dfs(int[] arr, int curr, boolean[] visited) {
        
        if (curr < 0 || curr >= arr.length || visited[curr]) return false;
        if (arr[curr] == 0) return true;
        
        visited[curr] = true;
        
        if (dfs(arr, curr + arr[curr], visited) || dfs(arr, curr - arr[curr], visited)) {
            return true;
        };
        
        return false;
        
    }
}