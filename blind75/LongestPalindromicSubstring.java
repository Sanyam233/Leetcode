package blind75;
/**
* Question: Given a string s, return the longest palindromic substring in s.
*
* Difficulty: Medium
*
* Basic Idea: Expand both left and right on every index until s.charAt(i - x) == s.charAt(i + x). 
  Update the res if the length of new palindromic substring is greater than the previous one
*
**/


class LongestPalindromicSubstring {

    private int isPalindrome(String s, int i, int j) {
        
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        return j - i - 1;
        
    }
    
    public String longestPalindrome(String s) {

        //Time Complexity: O(n^2)
        //Space Complexity: O(1)
        
        int globalMax = 0, l = 0, r = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int length1 = isPalindrome(s, i, i + 1);
            int length2 = isPalindrome(s, i, i);
            
            int localMax = Math.max(length1, length2);
            
            if (localMax > globalMax) {
                globalMax = localMax;
                l = i - (globalMax-1)/2;
                r = i + (globalMax/2);
            }
            
        }
        
        return s.substring(l, r + 1);
    }
}