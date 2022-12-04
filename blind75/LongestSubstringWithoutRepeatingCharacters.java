package blind75;

import java.util.HashMap;

/**
* Question: Given a string s, find the length of the longest substring without repeating characters.  
*
* Difficulty: Medium
*
* Basic Idea: Will use sliding window approach. Increase i until a character is not repeated. When a character repeats reset the start index to character's previous index + 1
*
**/


class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        
        //Time Complexity: O(n)
        //Space Complexity: O(n)
        //Where n is the length of string s
        
        HashMap<Character, Integer> map = new <Character, Integer> HashMap();
        
        int start = 0;
        int res = 0;
        char c = ' ';
        
        for (int i = 0; i < s.length(); i++) {
            
            c = s.charAt(i);
            
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            
            res = Math.max(res, i - start + 1);
            map.put(c, i);
        }
        
        return res;
        
    
    }
}