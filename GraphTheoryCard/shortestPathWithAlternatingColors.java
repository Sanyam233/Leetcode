class Solution {
    
    
    class Pair {
        int val, dist;
        boolean isRed;
        Pair(int val, boolean isRed, int dist) {
            this.val = val;
            this.isRed = isRed;
            this.dist = dist;
        }
    }
    
    
    List<List<Integer>> redAdjList = new ArrayList<>();
    List<List<Integer>> blueAdjList = new ArrayList<>(); 
    int[] res;
    boolean[][] visited;
    
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        //Time Complexity: O(Er + Eb) //Where E is the No. of Edges
        //Space Complexity: O(Er + Eb) //Where E is the No. of Edges
        
        this.res = new int[n];
        this.visited = new boolean[2][n];
        
        Arrays.fill(res, Integer.MAX_VALUE);

        
        for (int i = 0; i < n; i++) {
            redAdjList.add(new ArrayList<>());
            blueAdjList.add(new ArrayList<>());
            
        }
        
        for (int[] edge : redEdges) {
            redAdjList.get(edge[0]).add(edge[1]);
        }
        
        for (int[] edge : blueEdges) {
            blueAdjList.get(edge[0]).add(edge[1]);
        }   
        
        bfs();
        
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        
        return res;
        
        
    }
    
    
    private void bfs() {
        
        Queue<Pair> queue = new ArrayDeque<>();
        //0: Red, 1: Blue
        queue.add(new Pair(0, true, 0));
        queue.add(new Pair(0, false, 0));
        
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            if (visited[node.isRed ? 0 : 1][node.val]) continue;
            
            visited[node.isRed ? 0 : 1][node.val] = true;
            res[node.val] = Math.min(node.dist, res[node.val]);
            
            List<Integer> adjList = node.isRed ? redAdjList.get(node.val) : blueAdjList.get(node.val);
            
            for (int neighbor : adjList) {
                queue.add(new Pair(neighbor, !node.isRed, node.dist + 1));
            }
            
        }
        
        
    }
    
    
    
}