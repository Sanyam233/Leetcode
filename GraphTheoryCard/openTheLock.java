import java.util.*;

class Solution {
    
    private class Node {
        StringBuilder comb;
        int distance;
        
        Node(StringBuilder comb, int distance) {
            this.comb = comb;
            this.distance = distance;
        }
    }
    
    
    public int openLock(String[] deadends, String target) {
        
        //Time Complexity: O(A^2 * N*2 + D) Where A is the no. of digits, N is the no. of wheels, D is the no of deadends
        //Space Complexity: O(A^N + D) 
        
        HashSet<String> seen = new HashSet<>();
        
        for (String deadend : deadends) seen.add(deadend);
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(new StringBuilder("0000"), 0));
        
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            String comb = currNode.comb.toString();
            if (comb.equals(target)) return currNode.distance;
            if (seen.contains(comb)) continue;
            seen.add(comb);
            
            for (int i = 0; i < 4; i++) {
                for (int j = -1; j <= 1; j+=2) {
                    char digit = (char) (((comb.charAt(i) - '0' + j + 10) % 10) + '0');
                    StringBuilder newComb = new StringBuilder(comb);
                    newComb.setCharAt(i, digit);
                    queue.add(new Node(newComb, currNode.distance + 1));
                }
            }   
        }
            
        return -1;
            
        
    }
}