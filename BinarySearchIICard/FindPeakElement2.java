/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
*/

//My Solution
public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        //Time Complexity: O(m log n)
        //Space Complexity: O(1)
        
        int m = mat.length, n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left)/2;
            
                int top = i > 0 ? mat[i - 1][mid] : -1;
                int bottom = i < m - 1 ? mat[i + 1][mid] : -1;   
                int pre = mid > 0 ? mat[i][mid - 1] : -1;
                int suf = mid < n - 1 ? mat[i][mid + 1] : -1;
                int val = mat[i][mid];
                
                if (val > top && val > bottom && val > pre && val > suf) return new int[] {i, mid};
                
                if (suf >= val && pre <= suf) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                
            }
            
                     
        }
        
        
        return new int[]{};
        
        
        
    }
} 

//Discussion Solution
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        //Time Complexity: O(m log n)
        //Space Complexity: O(1)
        
        int m = mat.length, n = mat[0].length;
        int l = 0, r = n - 1;
        
        while (l <= r) {
            int mid = l + (r - l)/2, maxRow = 0;
            
            //We need to look at upper and lower values to. Picking the row with the max value at mid col is the way to ensure that
            for (int i = 0; i < m; i++) {
                maxRow = mat[i][mid] > mat[maxRow][mid] ? i : maxRow;
            }
            
            
            int left = mid > 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid < n - 1 ? mat[maxRow][mid + 1] : -1;
            
            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) return new int[] {maxRow, mid};
            
            if (left > mat[maxRow][mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return new int[]{};
        
        
    }
}
