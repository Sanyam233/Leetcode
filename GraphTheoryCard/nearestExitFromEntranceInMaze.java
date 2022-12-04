import java.util.*;

/*
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */

class Solution {
    
    
    final int[][] DIRECTIONS = new int[][]{{0,1}, {1, 0}, {-1, 0}, {0, -1}};
    
    
    class Pair {
        int x, y, distance;
        
        Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    
    
    public int nearestExit(char[][] maze, int[] entrance) {
        
        //Time Complexity: O(m*n)
        //Space Complexity: O(m*n)
        
        
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(entrance[0], entrance[1], 0));
        
        while (!queue.isEmpty()) {
            Pair corr = queue.poll();
            if (visited[corr.x][corr.y]) continue;
            visited[corr.x][corr.y] = true;
            
            if ((corr.x != entrance[0] || corr.y != entrance[1]) && (corr.x == 0 || corr.y == 0 || corr.x == m - 1 || corr.y == n - 1)) return corr.distance;
            
            for (int dir[] : DIRECTIONS) {
                int r = corr.x + dir[0], c = corr.y + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || maze[r][c] == '+') continue;
                queue.add(new Pair(r, c, corr.distance + 1));
            }
            
        }
        
          
        return -1;
        
    }
}