class Solution {
    public int findJudge(int n, int[][] trust) {
        
        //Time Complexity: O(|E| + |V|) Where |E| is no. of edges and |V| is no. of people
        //Space Complexity: O(|V|)
        
        int[] trustCount = new int[n];
        boolean[] trustSomeone = new boolean[n];
        
        for (int[] edge : trust) {
            trustCount[edge[1] - 1]++;
            trustSomeone[edge[0] - 1] = true;
        }
        
        for (int i = 0; i < n; i++) {
            if (!trustSomeone[i] && trustCount[i] == n - 1) {
                return i + 1;
            }
        }
        
        return -1;
    }
}