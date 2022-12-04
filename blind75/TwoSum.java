package blind75;

import java.util.HashMap;
/**
* Question: Given an array of integers nums and an integer target, return indices of the two numbers such that     they add up to target. You may assume that each input would have exactly one solution, and you may not use the   same element twice. You can return the answer in any order.
*
* Difficulty: Easy
*
* Basic Idea: Store the nums[i] and it's respective index in a hashmap. If the difference between nums[i] and target appears
  in the map that means nums[i] + difference equals target. Return [map.get(target - nums[i]), i]
*
**/

class TwoSum {
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    //Where n is the length of nums array
    
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            
            if (map.containsKey(remainder)) {
                res[0] = map.get(remainder);
                res[1] = i;
                break;
            }
            
            map.put(nums[i], i);
        }
        
        return res;
    }
}